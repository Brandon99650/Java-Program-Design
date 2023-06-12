import java.awt.*;
import javax.swing.*;
import java.util.ArrayList;
import java.util.List;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class BouncingBallPanel extends JPanel
{
	public final List<BouncingBall> balls = new ArrayList<>();
	public final Timer times = new Timer(2, e->drawBalls());

	public BouncingBallPanel()
	{
		times.start();	
		addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (balls.size() < 100) {
					balls.add(new BouncingBall(BouncingBallPanel.this));
				}
			}
		});
	}
	
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        for (BouncingBall b: balls) {
        	//first ball must be a blue ball
			if(b == balls.get(0)) {
        		b.first_blueball(g);
        	}else {
        		b.draw(g);
        	}
        }
	}
    
	public void drawBalls()
	{
		 for (BouncingBall b : balls) {
			 b.run();
		 }
		repaint();
	}
}