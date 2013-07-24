package one.lesson.pieces;

public class Pawn {
	private String color;
	public char printedChar;
	
	public static final String BLACK="black";
	public static final String WHITE="white";
	/**
	 * @author josunghwan
	 */
	public Pawn(){
		this.color = Pawn.WHITE;
		this.printedChar = 'p';
	}
	
	/**
	 * @author josunghwan
	 * @param color
	 */
	public Pawn(String color){
		this.color =color;
		if(color == Pawn.BLACK){
			this.printedChar = 'P';
		}else{
			this.printedChar = 'p';
		}
		
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
