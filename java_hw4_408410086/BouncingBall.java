import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;

import javax.swing.JPanel;


public final class BouncingBall implements Runnable {

	Random rand = new Random();
	JPanel drawArea;
	Color color = new Color(rand.nextInt(256), rand.nextInt(256), rand.nextInt(256));
	int radius = rand.nextInt(30)+30;
	int dx;
	int dy;
	int postion_x = rand.nextInt(500);
	int postion_y = rand.nextInt(350);
	public BouncingBall(JPanel drawArea) {
		this.drawArea = drawArea;
		dx = 2;
		dy = 2;
	}

	public void first_blueball(Graphics grah) {
		grah.setColor(Color.BLUE);
		grah.fillOval(postion_x, postion_y, 2*radius, 2*radius);
	}
	
	public void draw(Graphics grah) {
		grah.setColor(color);
		grah.fillOval(postion_x, postion_y, 2*radius, 2*radius);
	}
	
	@Override
	public void run() {

		int x = postion_x + radius;
		int y = postion_y + radius;

		if (x < radius ) {
			dx = -dx;
		}
		else if (x + radius > 1000){
			dx = -dx;
		}
		if (y < radius ) {
			dy = -dy;
		}
		else if(y + radius > 750){
			dy = -dy;
		}
		
		postion_x += dx;
		postion_y += dy;
		
	}	
}