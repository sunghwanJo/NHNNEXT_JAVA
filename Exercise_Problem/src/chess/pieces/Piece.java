package chess.pieces;
/**
 * 
 * @author josunghwan
 *
 */
public class Piece {
	private String color;
	private String name;

	
	public static final String BLACK="black";
	public static final String WHITE="white";
	public static final String BLANK="blank";

	static int numberOfWhitePieces=0;
	static int numberOfBlackPieces=0;
	
	
	private Piece(){
		this.color = Piece.WHITE;
	}
	
	private Piece(String color, String name){
		this.color =color;
		this.name = name;
	}
	
	public static Piece create(String color, String name){
		if(color == Piece.BLACK){
			numberOfBlackPieces++;
		}else if(color == Piece.WHITE){
			numberOfWhitePieces++;
		}
		
		return new Piece(color, name);
	}

	public String getName() {
		return name;
	}

	public String getColor() {
		return color;
	}

	public boolean isWhite() {
		if(this.color == WHITE)
			return true;
		return false;
	}

	public boolean isBlack() {
		if(this.color == BLACK)
			return true;
		return false;
	}
	
	
	
}
