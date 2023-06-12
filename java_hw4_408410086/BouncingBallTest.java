import javax.swing.JFrame;

public class BouncingBallTest
{
	public static void main(String[] args)
	{
		JFrame ball = new JFrame("BouncingBall");
		ball.add(new BouncingBallPanel());
		ball.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		ball.setSize(1000,750);
		ball.setVisible(true);
	}
}
