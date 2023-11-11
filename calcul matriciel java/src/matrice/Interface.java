package matrice;


import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Dimension;
import java.awt.BorderLayout;
import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.BorderFactory;
public class Interface extends JFrame {
	
	private JPanel pan_fenetre = new JPanel();
	
	private panneau pan_matrice_double= new panneau();//affichage de deux matrices pour le calcul

	
	private JPanel pan_bouton= new JPanel();
	private JButton bouton_egal= new JButton("==");
	private JButton bouton_reset = new JButton("RESET");
    private JPanel pan_label= new JPanel();
	private JLabel label= new JLabel("Entrez les elements de vos matrices");
    private int  a, b,c,d;// elements matrics resultante
    //Les zone de texte pour les deux matrices a operation
	private JTextField z1= new JTextField();
	private JTextField z2= new JTextField();
	private JTextField z3= new JTextField();
	private JTextField z4= new JTextField();
	private JTextField z5= new JTextField();
	private JTextField z6= new JTextField();
	private JTextField z7= new JTextField();
	private JTextField z8= new JTextField();
	private JTextField tab_zone []={z1,z2,z3,z4,z5,z6,z7,z8};
	
	//les zones de textes pour la matrice resultats  qui seront inmodifiables
	private JTextField z9= new JTextField();
	private JTextField z10= new JTextField();
	private JTextField z11= new JTextField();
	private JTextField z12= new JTextField();
    JTextField tab_zone_resultat[]={z9,z10,z11,z12};
    
	public Interface() {
		// TODO Auto-generated constructor stub
		
		this.setTitle("produit_Matriciel");
		this.setSize(490, 500);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setContentPane(pan_fenetre);
		this.gestion_composants();
		// ce les zone de texte s ecoute eux meme
		for(int i=0; i<8;i++){
		tab_zone[i].addKeyListener(new ecouteur_clavier());
		
		}
		bouton_reset.addActionListener(new ecouteur_reset());
	    bouton_egal.addActionListener(new ecouteur_bouton());
		this.setVisible(true);
		
			
		
	}
 
	private void  gestion_composants(){
		
		  // on rend inmodifiable la matrice resultat
		
	     for(int i=0 ;i<4;i++)
	     {
	    	 tab_zone_resultat[i].setEditable(false);
	    	 
	     }
		//le label
		
		Font police = new Font("verdana", Font.BOLD, 15);	
		label.setFont(police);
		
		label.setHorizontalAlignment(JLabel.CENTER);
		label.setPreferredSize(new Dimension(350,50));
		
		pan_label.add(label);//ajout du label a son conteneur
		pan_label.setBackground(Color.orange); //couleur du conteneur
		//panneau des matrices
		 
		
		//bouton egal et reset
		bouton_egal.setBackground(Color.orange);//couleur
        bouton_egal.setPreferredSize(new Dimension(50, 50));	
        pan_bouton.add(bouton_egal);
        bouton_egal.setBorder(BorderFactory.createLoweredBevelBorder());
        
        pan_bouton.setBackground(Color.green);
        pan_bouton.add(bouton_reset);
        bouton_reset.setPreferredSize(new Dimension(100, 50));	
        bouton_reset.setBackground(Color.orange);//couleur
        bouton_reset.setBorder(BorderFactory.createLoweredBevelBorder());
		//ajout des composants
       
          
              // dans le panneau des matrices doubles
        pan_matrice_double.setLayout(null);
        pan_matrice_double.add(z1);
        z1.setBounds(35, 50+50, 30,30);
        pan_matrice_double.add(z2);
        z2.setBounds(85, 50+50,30,30);
        
        pan_matrice_double.add(z3);
        z3.setBounds(35, 120+50,30,30);
        
        pan_matrice_double.add(z4);
        z4.setBounds(85, 120+50,30,30);
        
        
        pan_matrice_double.add(z5);
        z5.setBounds(180, 50+50,30,30);
        
        pan_matrice_double.add(z6);
        z6.setBounds(230, 50+50,30,30);
        
        pan_matrice_double.add(z7);
        z7.setBounds(180, 120+50,30,30);
        
        pan_matrice_double.add(z8);
        z8.setBounds(230, 120+50,30,30);
        
        
   
        pan_matrice_double.add(z9);
        z9.setBounds(315, 100, 45,30);
        pan_matrice_double.add(z10);
        z10.setBounds(390, 100,45,30);
       
        pan_matrice_double.add(z11);
        z11.setBounds(315, 170,45,30);
       
        pan_matrice_double.add(z12);
        z12.setBounds(390, 170,45,30);
       
    
      
       
        this.setLayout(new BorderLayout());
        pan_fenetre.add(pan_label, BorderLayout.NORTH);
        pan_fenetre.add(pan_matrice_double, BorderLayout.CENTER);
        pan_fenetre.add(pan_bouton, BorderLayout.SOUTH);
        
	}
	class ecouteur_bouton implements ActionListener{
		
		public void actionPerformed(ActionEvent ae)
		{ 
			// si aumoins une des case est vide on affiche un message
			if(z1.getText().equals(""))
			{
				 label.setText("entrez tous les elements");
		
		}
			else	if(z2.getText().equals(""))
			{
				 label.setText("entrez tous les elements");
		
		}
			else if(z3.getText().equals(""))
			{
				 label.setText("entrez tous les elements");
		
		}
			else	if(z4.getText().equals(""))
			{
				 label.setText("entrez tous les elements");
		
		}
			else if(z5.getText().equals(""))
			{
				 label.setText("entrez tous les elements");
		
		}
			else if(z6.getText().equals(""))
			{
				 label.setText("entrez tous les elements");
		
		}
			else if(z7.getText().equals(""))
			{
				 label.setText("entrez tous les elements");
		
		}
			else if(z8.getText().equals(""))
			{
				
		    label.setText("entrez tous les elements");
	
	     	}
		   else{
		     for(int i=0;i<8;i++)
		     {
		    	 tab_zone[i].setEditable(false);
		     }
		   label.setText("RESULTAT ");
	       calcul_produit();		
	    
		   z9.setText(String.valueOf(a));
		   z10.setText(String.valueOf(b));
		   z11.setText(String.valueOf(c));
		   z12.setText(String.valueOf(d));
		
		   
		}
		
	}
		
	}
	class ecouteur_reset implements ActionListener
	{
		public void actionPerformed(ActionEvent ae)
		{  
			//on efface le contenu de toutes les cases
			for(int i=0; i<8;i++){
			  tab_zone[i].setText("");
			  tab_zone[i].setEditable(true);
			}
		  for(int i=0 ;i<4;i++)
		  {
			  tab_zone_resultat[i].setText("");
		  }
		  
		  
	      
	       label.setText("entrez les elements de vos matrices");
		}
	}
     class ecouteur_clavier implements KeyListener {
    	 public void keyReleased(KeyEvent k)
    	 {   
    		  if(est_unChiffre(k.getKeyChar())==false ){
    		    	 for(int i=0 ;i<8; i++)
    			     tab_zone[i].setText(tab_zone[i].getText().replace(String.valueOf(k.getKeyChar()),""));       
    		 }
    	
    	
    	 }
  public boolean est_unChiffre(char carac){
    		  try{  
    			  Integer.parseInt(String.valueOf(carac));
    		  }catch(NumberFormatException n)
    		  {
    			  return false;
    		  }
    		  return true;
    	  }
    	 public void keyPressed(KeyEvent k)
    	 {
    		 
    	 }
    	 public void keyTyped(KeyEvent k)
    	 {
    		 
    	 }
    	 
     }
	 private void calcul_produit()
	 {
		 a= Integer.parseInt(z1.getText())*Integer.parseInt(z5.getText())+Integer.parseInt(z2.getText())*Integer.parseInt(z7.getText());
		 
		 b=Integer.parseInt(z1.getText())*Integer.parseInt(z6.getText())+Integer.parseInt(z2.getText())*Integer.parseInt(z8.getText());

		 c=Integer.parseInt(z3.getText())*Integer.parseInt(z5.getText())+Integer.parseInt(z4.getText())*Integer.parseInt(z7.getText());

		 d=Integer.parseInt(z3.getText())*Integer.parseInt(z6.getText())+Integer.parseInt(z4.getText())*Integer.parseInt(z8.getText());
	 }
	
	
	
	 
		 
	 
		 
	 }
