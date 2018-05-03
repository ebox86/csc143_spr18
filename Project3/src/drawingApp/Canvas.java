package drawingApp;

/**
 * Canvas - 
 * @author evankoh
 * @version csc143
 */
public class Canvas {
	
	private int width;
	private int height;
	private int red;
	private int green;
	private int blue;
	
	/**
	 * Canvas class to build a new canvas
	 */
	public Canvas(){
	}

	/**
	 * adds new fields based passed string key/value pairs
	 * @param keyValue to be parsed
	 */
	public void addField(String[] keyValue) {
		String key = keyValue[0];
		int value = Integer.parseInt(keyValue[1]);
		switch(key){
		case "width":
				this.setWidth(value);
				break;
		case "height":
			this.setHeight(value);
			break;
		case "red":
			this.setRed(value);
			break;
		case "green":
			this.setGreen(value);
			break;
		case "blue":
			this.setBlue(value);
			break;
	}
		
	}

	/*
	 * setters -- all private
	 */
	private void setBlue(int value) {
		this.red = value;
	}

	private void setGreen(int value) {
		this.green = value;	
	}

	private void setRed(int value) {
		this.red = value;
	}

	private void setHeight(int value) {
		this.height = value;
	}

	private void setWidth(int value) {
		this.width = value;	
	}
	
	/*
	 * getters 
	 */
	public int getWidth() {
		return width;
	}

	public int getHeight() {
		return height;
	}

	public int getRed() {
		return red;
	}

	public int getGreen() {
		return green;
	}

	public int getBlue() {
		return blue;
	}
}
