package drawingApp;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

public class Main {
    
	private ShapeLibrary shapeLibrary;
	private static Drawing drawing1;
	private static Drawing drawing2;
	private static Drawing drawing3;
	private static Drawing drawing4;
	private static Drawing drawing5;
	private static Drawing drawing6;
	private static Drawing drawing7;
	
	/**
	 * Main class for drawing app
	 * @param args
	 */
    public static void main(String[] args) {
    	/*
    	Utility utility = new Utility();
    	try {
			utility.createShapeLib();
		} catch (IOException e) {
			e.printStackTrace();
		}
		*/
    	Path folderPath = Paths.get(".");
    	String path = folderPath.toAbsolutePath().toString() + "/src/";
        ShapeLibrary shapeLib  = new ShapeLibrary();
        try {
			drawing1 = new Drawing(shapeLib, new File(path + "Instruct-Simple.txt"));
	        drawing2 = new Drawing(shapeLib, new File(path + "Instruct-Rand.txt"));
	        drawing3 = new Drawing(shapeLib, new File(path + "Instruct-RepeatOffset.txt"));
	        drawing4 = new Drawing(shapeLib, new File(path + "Instruct-Gradient.txt"));
	        drawing5 = new Drawing(shapeLib, new File(path + "Instruct-Rotate.txt"));
	        // These two are user created and include the 2 shapes that were added
	        // Both 'Rhombus' and 'Trapezoid' are new shapes
	        drawing6 = new Drawing(shapeLib, new File(path + "Instruct-user_created1.txt"));
	        drawing7 = new Drawing(shapeLib, new File(path + "Instruct-user_created2.txt"));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

        /*
         * Draws the above loaded drawing instructions
         */
        drawing5.draw();
        drawing4.draw();
        drawing3.draw();
        drawing2.draw();
        drawing1.draw();
        drawing6.draw();
        drawing7.draw();
    }
}
