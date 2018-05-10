package JavaWord;

import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/**
 * Created a new Document object as part of the Java Word application
 * @author evankoh
 * @version csc143
 *
 */
public class Document implements Serializable {

	private static final long serialVersionUID = -7804500709728499238L;
	private static Document instance = null;
	private boolean isOpen;
	private String name;
	private DoublyLinkedList<Section> dll = new DoublyLinkedList<Section>();

	static {
		instance = new Document();
	}

	/*
	 * Default Constructor -- never used because singleton
	 */
	private Document() {

	}

	/**
	 * Adds a section to the document
	 * 
	 * @param sect
	 */
	public void addSection(Section sect) {
		dll.addAtEnd(sect);
	}

	/**
	 * Creates a new Document
	 * 
	 * @param string
	 *            - the name of the new Document
	 */
	public void newDoc(String string) {
		this.name = string;
		this.isOpen = true;

	}

	/**
	 * Saves the current document
	 */
	public void save() {
		try {
			FileOutputStream fileOut = new FileOutputStream(this.name + ".wpd");
			ObjectOutputStream out = new ObjectOutputStream(fileOut);
			out.writeObject(this);
			out.close();
		} catch (IOException e) {
			System.out.println("Something went terribly wrong! " + e);
		}
	}

	/**
	 * Opens a saved Document file
	 * 
	 * @param docName
	 *            - the name of the Document to open
	 */
	public void open(String docName) {
		if (!isOpen) {
			try {
				FileInputStream docFile = new FileInputStream(docName + ".wpd");
				ObjectInputStream in = new ObjectInputStream(docFile);
				Document newDoc = (Document) in.readObject();
				this.dll = newDoc.dll;
				this.name = newDoc.name;
				this.isOpen = true;
				in.close();
			} catch (FileNotFoundException e) {
				System.out.println("Something went terribly wrong!");
			} catch (IOException e) {
				System.out.println("Something went terribly wrong!");
			} catch (ClassNotFoundException e) {
				System.out.println("Something went terribly wrong!");
			}
		}
	}

	/**
	 * Saves the current Document as an HTML file to the local filesystem
	 */
	public void saveToHtml(){
		String html = "<!DOCTYPE html>\n<html>\n<body>";
		for(Section s : dll) {
			html += s.toHtml();
		}
		html += "</body>\n</html>";
		BufferedWriter writer;
		try {
			writer = new BufferedWriter(new FileWriter(this.name + ".html"));
			writer.write(html);
			writer.close();
		} catch (IOException e) {
			System.out.print("Count not write HTML file!");
		}
	}

	/**
	 * closes a currently open document
	 */
	public void close() {
		if (isOpen) {
			dll.clear();
			name = "";
			isOpen = false;
		}
	}

	/**
	 * Returns the current name of the document
	 * @return - the name of the document
	 */
	public String getName() {
		return this.name;
	}
	
	/**
	 * Returns instance of the current Document object
	 * @return
	 */
	public static Document getInstance() {
		return instance;
	}

}
