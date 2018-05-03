package drawingApp;

import java.io.Serializable;

/**
 * drawingApp -- used to draw shapes to the canvas
 * @author evankoh
 * @version csc143
 */
public class Shape implements Serializable {
	
	private static final long serialVersionUID = 9064162150981715910L;
	private String name;
	private ArrayList<Point> points;
	
	/**
	 * Constructs new shape object with a name
	 * @param the name of the shape
	 */
	public Shape(String name) {
        setName(name);
        points = new ArrayList<Point>();
	}
    
	/**
	 * Sets the name of the shape
	 * @param the name of the shape
	 */
    public void setName(String name) {
        this.name = name;
    }
    
    /**
     * Adds a point (x, y coor) to the shape's arrayList of points
     * @param the point to add
     */
	public void addPoint(Point point) {
		points.add(point);
	}
	
	/**
	 * Rotates a shape given an angle measurement in degrees
	 * @param the angle measurement in degrees
	 */
	public void rotate(int angle) {
		for(Point p1: points) {
			//TRANSLATE TO ORIGIN
			double x1 = p1.getX() - 50.0;
			double y1 = p1.getY() - 50.0;
		
			//APPLY ROTATION
			double temp_x1 = x1 * Math.cos(Math.toRadians(angle)) - y1 * Math.sin(Math.toRadians(angle));
			double temp_y1 = x1 * Math.sin(Math.toRadians(angle)) + y1 * Math.cos(Math.toRadians(angle));
		
			//TRANSLATE BACK
			p1.setPoint(temp_x1 + 50.0, temp_y1 + 50.0);
		}
	}
	
	/**
	 * Returns the name of the shape
	 * @return name of shape
	 */
	public String getName() {
		return name;
	}

	/**
	 * Returns an arraylist of all points in the shape
	 * @return the arrayList
	 */
	public ArrayList<Point> getPoints() {
		return points;
	}
}
