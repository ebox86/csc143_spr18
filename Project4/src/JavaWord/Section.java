package JavaWord;

import java.io.Serializable;
import JavaWord.Paragraph.ParaStyle;

/**
 * Defines a Section of a Java Word Document
 * @author evankoh
 * @version csc143
 */
public class Section implements Serializable {

	private static final long serialVersionUID = 4093682289256006360L;
	private DoublyLinkedList<Paragraph> dll;
	
	/**
	 * Default Constructor - Builds a new Section object
	 */
	public Section() {
		dll = new DoublyLinkedList<Paragraph>();
	}
	
	/**
	 * Adds a new paragraph to the Section
	 * @param paragraph
	 */
	public void addParagraph(Paragraph paragraph) {
		if(paragraph.getContent(). contains("\n")) {
			String[] lines = paragraph.getContent().split("\n");
			for(int i = 0; i < lines.length; i++) {
				dll.addAtEnd(new Paragraph(lines[i], Paragraph.ParaStyle.List_Bulleted));
			}
		} else {
			dll.addAtEnd(paragraph);
		}
	}
	
	/**
	 * Gets a count of the number of paragraphs in the Section
	 * @return
	 */
	public int getParagraphCount() {
		return dll.size();
	}

	/**
	 * Returns an HTML representation of the current Section's paragraphs
	 * @return the string of HTML data
	 */
	public String toHtml() {
		String html = "\n";
		for(Paragraph p : dll) {
			if(p.getStyle() == ParaStyle.valueOf("List_Bulleted")) {
				html += "" + p.toHtml() + "\n";
			} else {
				html += p.toHtml() + "\n";
			}
		}
		return html + "";
	}
}