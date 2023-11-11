package com.powertype.Security_app.Config;

import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

public class Gen_key {
    public   static  String generate() throws NoSuchAlgorithmException {
        // generateur de cle;
        KeyGenerator keyGenerator =KeyGenerator.getInstance("AES");
        //taille de la cle
        keyGenerator.init(256);

        //generer la cle
        SecretKey secretKey= keyGenerator.generateKey();

        //representation Binaire;
        byte[] keyBytes = secretKey.getEncoded();

        // representation en chiane de caractere
        String key = Base64.getEncoder().encodeToString(keyBytes);
        return  key;
    }
}
