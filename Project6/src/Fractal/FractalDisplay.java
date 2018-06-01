package Fractal;

import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 * Displays the fractals on a JFrame
 * @author evankoh
 *
 */
public class FractalDisplay extends JPanel implements Observer  {

	private static final long serialVersionUID = 94803093202984088L;
	private Circle c;
	private JFrame frame;
	
	
	/**
	 * Sets up the jFrame and draws circle
	 * @param circle
	 * @param frame
	 */
	public FractalDisplay(Circle circle, JFrame frame) {
		this.c = circle;
		this.frame = frame;
		this.setVisible(true);
		//this.setBackground(Color.BLACK);
	}
	

	@Override
	public void update() {
		frame.repaint();
	}

    @Override
    public void paintComponent(Graphics g) {
        //super.paintComponent(g);
        g.setColor(c.getC());
        g.fillOval(c.getX() - c.getRadius(), c.getY() - c.getRadius(), c.getRadius()*2, c.getRadius()*2);
 
    }
}
