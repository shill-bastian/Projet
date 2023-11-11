package matrice;
import java.awt.Graphics;
import javax.swing.JPanel;

public class pan extends JPanel{
		public void paintComponent(Graphics g)
		{
			
			g.drawLine(30+80,50+50,50+80,15+50);
			g.drawLine(30+80, 50+50, 30+80,150+50);
			g.drawLine(30+80, 150+50, 50+80, 180+50);
			g.drawLine(100+80,15+50, 120+80 , 50+50);
			g.drawLine(120+80, 50+50, 120+80, 150+50);
			g.drawLine(120+80, 150+50,100+80 ,180+50);
			
			
		}

	}

