package one.lesson.pieces;

public class Pawn {
	private String color;
	
	/**
	 * @author josunghwan
	 */
	Pawn(){
		this.color = Color.WHITE;
	}
	
	/**
	 * @author josunghwan
	 * @param color
	 */
	Pawn(String color){
		this.color =color;
	}
	
	/**
	 * @author josunghwan
	 * @return String
	 */
	public String getColor() {
		return color;
	}
	
	/**
	 * @author josunghwan
	 * @param color
	 */
	public void setColor(String color) {
		this.color = color;
	}
	
	
	
}
