package com.powertype.Security_app.Service;

import com.powertype.Security_app.Controllers.AuthenticationRequest;
import com.powertype.Security_app.Controllers.AuthenticationResponse;
import com.powertype.Security_app.Controllers.RegisterRequest;
import com.powertype.Security_app.Repository.TokenRepository;
import com.powertype.Security_app.Repository.UserRepository;
import com.powertype.Security_app.token.Token;
import com.powertype.Security_app.token.TokenType;
import com.powertype.Security_app.user.Role.Role;
import com.powertype.Security_app.user.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthenticationService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private JwtService jwtService;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private TokenRepository tokenRepository;
    public AuthenticationResponse register( RegisterRequest request) {
        var user= User.builder()
                .firstname(request.getFirstname())
                .lastname(request.getLastname())
                .email(request.getEmail())
                .password( passwordEncoder.encode(request.getPassword()))
                .role(Role.USER)
                .build();
        userRepository.save(user);
        var jwtToken = jwtService.generateToken(user);

        saveUserToken(user, jwtToken);
        return AuthenticationResponse.builder()
                .token(jwtToken)
                .build();
    }

    private void revokeAllUserTokens(User user)
    {
        var validUserTokens = tokenRepository.findAllValidTokensByUser(user.getId());
        if(validUserTokens.isEmpty())
        {
            return;
        }
        else {
              validUserTokens.forEach( token -> {
                  token.setRevoked(true);
                  token.setExpired(true);
              });
        }

    }


    private void saveUserToken(User user, String jwtToken) {
        var token = Token.builder()
                .user(user)
                .token(jwtToken)
                .revoked(false)
                .expired(false)
                .tokenType(TokenType.BEARER)
                .build();
        tokenRepository.save(token);
    }


    public AuthenticationResponse authenticate( AuthenticationRequest request) {
       authenticationManager.authenticate( new UsernamePasswordAuthenticationToken(
                request.getEmail(),
                request.getPassword()
                )
        );

          var user = userRepository.findByEmail(request.getEmail()).orElseThrow();
          var jwtToken = jwtService.generateToken(user);
          revokeAllUserTokens(user);
          saveUserToken(user, jwtToken);
        return AuthenticationResponse.builder()
                .token(jwtToken)
                .build();

    }

}
