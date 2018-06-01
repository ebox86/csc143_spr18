package Fractal;

import java.awt.Color;

/**
 * Helper class for a circle
 * @author evankoh
 * @version csc143
 */
public class Circle{
		private int x, y, radius;
		private Color c;
		
		/**
		 * Helper constructor which creates a new circle
		 * @param x
		 * @param y
		 * @param c
		 * @param rad
		 */
		Circle(int x, int y, Color c, int rad){
			this.x = x;
			this.y = y;
			this.radius = rad;
			this.c = c;
		}

		/**
		 * Returns x coordinate
		 * @return
		 */
		public int getX() {
			return x;
		}

		/**
		 * Sets x coordinate 
		 * @param x
		 */
		public void setX(int x) {
			this.x = x;
		}

		/**
		 * Gets Y coordinate 
		 * @return
		 */
		public int getY() {
			return y;
		}

		/**
		 * Sets y coordinate
		 * @param y
		 */
		public void setY(int y) {
			this.y = y;
		}

		/**
		 * Gets the radius 
		 * @return
		 */
		public int getRadius() {
			return radius;
		}

		/**
		 * sets the radius
		 * @param radius
		 */
		public void setRadius(int radius) {
			this.radius = radius;
		}

		/**
		 * Gets the color
		 * @return
		 */
		public Color getC() {
			return c;
		}

		/**
		 * Sets the color
		 * @param c
		 */
		public void setC(Color c) {
			this.c = c;
		}
	}