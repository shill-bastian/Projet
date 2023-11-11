package matrice;


import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JPanel;
public class panneau extends JPanel {
 public boolean redessiner=false;
	public panneau() {
		// TODO Auto-generated constructor stub
	}
	public void paintComponent(Graphics g)
	{
		//dessin des deux matrices
		g.drawLine(30,50+50,50,15+50);
		g.drawLine(30, 50+50, 30,150+50);
		g.drawLine(30, 150+50, 50, 180+50);
		g.drawLine(100,15+50, 120 , 50+50);
		g.drawLine(120, 50+50, 120, 150+50);
		g.drawLine(120, 150+50,100 ,180+50);
		 // dessin signe multi
		g.drawLine(140, 75+50, 155, 100+50);
		g.drawLine(140, 100+50, 155, 75+50);
		

		g.drawLine(175,50+50,195,15+50);
		g.drawLine(175, 50+50, 175,150+50);
		g.drawLine(175, 150+50, 195, 180+50);
		g.drawLine(245,15+50, 265, 50+50);
		g.drawLine(265, 50+50, 265, 150+50);
		g.drawLine(265, 150+50,245 ,180+50);
		
      //dessin egal
		   g.drawLine(275,125,290,125);
		   g.drawLine(275, 150, 290, 150);
		   
		   //matrice resultat
		g.setColor(Color.black);
		   g.drawLine(30+280,50+50,50+280,15+50);
			g.drawLine(30+280, 50+50, 30+280,150+50);
			g.drawLine(30+280, 150+50, 50+280, 180+50);
			g.drawLine(100+320,15+50, 120+320 , 50+50);
			g.drawLine(120+320, 50+50, 120+320, 150+50);
			g.drawLine(120+320, 150+50,100+320 ,180+50);
			
			
		}
	}



