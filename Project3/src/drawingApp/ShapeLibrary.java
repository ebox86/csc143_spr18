package drawingApp;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.nio.file.Path;
import java.nio.file.Paths;

import drawingApp.Shape;

/**
 * ShapeLibrary -- used to store the shape objects in an Array
 * @author evankoh
 *
 */
public class ShapeLibrary {

	private ArrayList<Shape> ShpArray = new ArrayList<Shape>();
	
	public ShapeLibrary() {
		Path path = Paths.get(System.getProperty("user.dir") + "/src/shapes");
		System.out.println(path);
		File directory = new File(path.toAbsolutePath().toString());
		File[] shapes = directory.listFiles();
       
        for (File file : shapes) {
      
	        try {
	            FileInputStream shapeFile = new FileInputStream(file);
	            ObjectInputStream in = new ObjectInputStream(shapeFile);
	            ShpArray.add((Shape)in.readObject());
	            in.close();
	        } catch (FileNotFoundException e) {
	            System.out.println("File Not Found!");
	        } catch (IOException e) {
	            e.printStackTrace();
	        } catch (ClassNotFoundException e) {
	            System.out.println(e);
	        }
        }
	}

	public ArrayList<Shape> getShapeArray() {
		return ShpArray;
	}
}
