package drawingApp;

import java.awt.Color;
import java.awt.Polygon;
import java.awt.geom.AffineTransform;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * Drawing -- used to create drawing objects, or shapes, for use on the canvas
 * @author evankoh
 * @version csc143
 *
 */
public class Drawing {
	
	private ShapeLibrary shapeLib;
	private ArrayList<DrawInstruction> instructions;
	private CanvasInstruction canvas;
	
	/**
	 * Constructs a new Drawing object
	 * @param shapeLib - the shape library containing the base shape polygons used for the drawing
	 * @param the scanner input for the drawing instructions and canvas instructions
	 * @throws FileNotFoundException if the file passed is not found
	 */
	public Drawing(ShapeLibrary shapeLib, File file) throws FileNotFoundException {
		this.shapeLib = shapeLib;
		Scanner sc;
		try {
			sc = new Scanner(file);
			canvas = CanvasInstruction.readFromFile(sc);
			instructions = new ArrayList<DrawInstruction>();
			while (sc.hasNextLine()) {
				DrawInstruction drawInst = DrawInstruction.readFromFile(sc);
				instructions.add(drawInst);
	        }
	        sc.close();
		} catch (FileNotFoundException e) {
			throw new FileNotFoundException();
		}
		this.shapeLib = shapeLib;
	}

	/**
	 * draws the object to the canvas
	 */
	public void draw() {
		DrawingPanel panel = new DrawingPanel();
		panel.setBackground(canvas.getColorSolid());
		panel.setHeight(canvas.getHeight());
		panel.setWidth(canvas.getWidth());

		for(DrawInstruction instruction : instructions) {
			Shape shape = getShapeByName(instruction.getShapeName());
			int repeats = instruction.getRepeats();
			Color c = instruction.getColor();
			boolean f = instruction.getFilled();
			int oX = instruction.getRepeatOffsetX();
			int oY = instruction.getRepeatOffsetY();
			int sX = instruction.getStartingX();
			int sY = instruction.getStartingY();
			int scale = instruction.getScalePercent();
			int rotateAngle = instruction.getRepeatRotate();
			int repOffX = 0, repOffY = 0;
			for(int i = 0; i < repeats; i++) {
				Polygon p = new Polygon();
				if (rotateAngle > 0)
					shape.rotate(rotateAngle);
				for(Point point : shape.getPoints()) {
					p.addPoint(repOffX + sX + ((int)point.getX() * scale / 100),repOffY + sY + ((int)point.getY() * scale/100));
				}
				repOffX += oX;
				repOffY += oY;
				panel.getGraphics().setColor(c);
				panel.getGraphics().drawPolygon(p);
				if(f){
					panel.getGraphics().fill(p);
				}
			}
		}
	}
	
	/*
	 * returns the name of the shape
	 */
	private Shape getShapeByName(String name) {
		for(Shape shape : shapeLib.getShapeArray()) {
			if(shape.getName().equals(name)) {
				return shape;
			}
		}
		return null;
	}
}
