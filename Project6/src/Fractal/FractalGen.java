package Fractal;
import java.awt.Color;
import java.awt.Shape;
import java.awt.geom.Ellipse2D;

import javax.swing.JFrame;

import Fractal.ArrayList;

/**
 * Class to generate Fractal Data
 * @author evankoh
 * @version csc143
 */
public class FractalGen  implements Subject {

	private ArrayList<Circle> gen = new ArrayList<Circle>();
	private ArrayList<FractalDisplay> displays = new ArrayList<FractalDisplay>();
	private int depth;
	private double ratio;
	private JFrame frame;
	private Color cactus;
	private Color pear;
	private int angle;
	

	/**
	 * Generates Fractal Data
	 * @param depth - recursion depth
	 * @param ratio - ratio of parent to child
	 * @param cactusColor - color of cactus node
	 * @param pearColor - color of pear node
	 * @param drawFrame - the frame used to draw on
	 */
	public FractalGen(int depth, int ratio, Color cactusColor, Color pearColor, JFrame drawFrame) {
		this.ratio = (float)ratio/100.0;
		this.depth = depth;
		this.cactus = cactusColor;
		this.pear = pearColor;
		this.frame = drawFrame;
		this.angle = 45;
		int radius = (int) (drawFrame.getWidth()/2*this.ratio);
		Circle c = new Circle(drawFrame.getWidth()/2, drawFrame.getHeight()/2, cactus, radius);
		gen.add(c);
		generate(0, c, angle);
		System.out.println(gen.size());
		for(Circle circ : gen) {
			drawFrame.setVisible(true);
			FractalDisplay fg = new FractalDisplay(circ, drawFrame);
			attach(fg);
		}
		drawFrame.repaint();
	}
	
	/*
	 * private method to generate all 
	 */
	private void generate(int currentDepth, Circle parent, int currentAngle) {
		if(currentDepth > depth) {
			return;
		} else {
			Color drawColor = this.cactus;
			if (currentDepth == depth) {
				drawColor = this.pear;
			} 
			//Commented out extra credit
			// TODO add GUI interface for angle
			int childRadius = (int) (this.ratio * parent.getRadius());
			int c1x = (int) (parent.getX() + ((parent.getRadius() * Math.cos(Math.PI * (currentAngle)/180.0)) + childRadius * Math.cos(Math.PI * currentAngle/180.0)));
			int c1y = (int) (parent.getY() - ((parent.getRadius() * Math.sin(Math.PI * (currentAngle)/180.0)) + childRadius * Math.sin(Math.PI * currentAngle/180.0)));
			int c2x = (int) (parent.getX() + ((parent.getRadius() * Math.cos(Math.PI * (90 + currentAngle)/180.0)) + childRadius * Math.cos(Math.PI * (90 + currentAngle)/180.0)));
			int c2y = (int) (parent.getY() - ((parent.getRadius() * Math.sin(Math.PI * (currentAngle+90.0)/180.0)) + childRadius * Math.sin(Math.PI * (currentAngle+90.0)/180.0)));
			Circle child1 = new Circle(c1x, c1y, drawColor, (int) (childRadius));
			gen.add(child1);
			Circle child2 = new Circle(c2x, c2y, drawColor, (int) (childRadius));
			gen.add(child2);
			generate(currentDepth + 1, child1, this.angle);
			generate(currentDepth + 1, child2, this.angle);
		}
		
	}
	

	/**
	 * Attaches an observer
	 */
	@Override
	public void attach(Observer obs) {
		displays.add((FractalDisplay) obs);
		this.frame.add((FractalDisplay) obs);
	}

	/**
	 * Detaches observer from subject
	 */
	@Override
	public void detach(Observer obs) {
		displays.remove(displays.indexOf((FractalDisplay) obs));
		this.frame.remove((FractalDisplay) obs);
	}

	/**
	 * notifies all observers of changes
	 */
	@Override
	public void notifyAllObservers() {
		for(FractalDisplay display : displays) {
			display.update();
		}
	}

	/**
	 * returns the state of how many fractals are being generated
	 */
	@Override
	public int getState() {
		return gen.size();
	}
	
	
	
}
