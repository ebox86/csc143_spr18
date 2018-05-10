package JavaWord;

import java.io.Serializable;

/**
 * Defines a Paragraph of a Java Word Document
 * @author evankoh
 * @version csc143
 */
public class Paragraph implements Serializable {

	private static final long serialVersionUID = 224503122406182014L;
	private String content;
	private ParaStyle style;
	
	/**
	 * Constructs a new Paragraph object with a String
	 * @param string
	 */
	public Paragraph(String string) {
		this.content = string;
	}
	
	/**
	 * Constructs a new Paragraph object with a String and a paragraph Style
	 * @param string
	 * @param style
	 */
	public Paragraph(String string, ParaStyle style) {
		this.content = string;
		this.style = style;
	}

	/**
	 * Returns the string representation of the paragraph
	 * @return - the content of the paragraph
	 */
	public String getContent() {
		return content;
	}
	
	/**
	 * Returns the style, if defined, of the paragraph
	 * @return - Enum value of the style
	 */
	public ParaStyle getStyle() {
		return style;
	}
	
	/**
	 * Enumeration to hold the possible HTML tags supported as paragraphs
	 * @author evankoh
	 * 
	 */
	public enum ParaStyle {
		Heading_1, Heading_2, Heading_3, Heading_4, List_Bulleted, Div
	}
	
	/**
	 * Returns an HTML representation of the paragraph, optionally configured via the Paragraph Style
	 * @return - the content of the paragraph as formatted for display in HTML
	 */
	public String toHtml() {
		String tmpStyle = "";
		String tmpAttribute = "";
		if(style == ParaStyle.Heading_1) {
			tmpStyle = "h1";
		} else if(style == ParaStyle.Heading_2) {
			tmpStyle = "h2";
		} else if(style == ParaStyle.Heading_3) {
			tmpStyle = "h3";
		} else if(style == ParaStyle.Heading_4) {
			tmpStyle = "h4";
		} else if(style == ParaStyle.List_Bulleted) {
			tmpStyle = "li";
		} else {
			tmpStyle = "p";
			tmpAttribute = "style=\"text-align:left\"";
		}
		if(tmpStyle == "li") {
			return "<" + tmpStyle + " " + tmpAttribute + ">" + content + "</" + tmpStyle + ">";
		} else {
			return "<" + tmpStyle + " " + tmpAttribute + ">\n" + content + "\n</" + tmpStyle + ">";
		}
	}
}
