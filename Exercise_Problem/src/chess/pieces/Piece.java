package chess.pieces;
/**
 * 
 * @author josunghwan
 *
 */
public class Piece {

	
	public enum Color {WHITE, BLACK, BLANK};
	public enum Type {PAWN, ROOK, KNIGHT, BISHOP, QUEEN, KING, NO_PIECE};
	
	private Color color;
	private char name;
	private Type type; 
	
	public static final char PAWN_REPRESENTATION = 'p';
	public static final char ROOK_REPRESENTATION = 'r';
	public static final char KNIGHT_REPRESENTATION = 'k';
	public static final char BISHOP_REPRESENTATION = 'b';
	public static final char QUEEN_REPRESENTATION = 'q';
	public static final char KING_REPRESENTATION = 'k';
	public static final char BLANK_REPRESENTATION = '.';
	
	static int numberOfWhitePieces=0;
	static int numberOfBlackPieces=0;
	
	
	private Piece(){
		this.color = Color.WHITE;
	}
	
	private Piece(Color color, char name, Type type){
		this.color =color;
		this.name = name;
		this.type = type;
	}
	
	public static Piece create(Color color, char name, Type type){
		if(color == Color.BLACK){
			numberOfBlackPieces++;
		}else if(color == Color.WHITE){
			numberOfWhitePieces++;
		}
		
		return new Piece(color, name, type);
	}

	public char getName() {
		return name;
	}

	public Color getColor() {
		return color;
	}

	public boolean isWhite() {
		if(this.color == Color.WHITE)
			return true;
		return false;
	}

	public boolean isBlack() {
		if(this.color == Color.BLACK)
			return true;
		return false;
	}

	public static Piece noPiece() {
		return new Piece(Color.BLANK, BLANK_REPRESENTATION, Type.NO_PIECE );
	}

	public char getRepresentation() {
		return this.name;
	}

	public Type getType() {
		return this.type;
	}
	
	public static Piece createWhite(Type type){
		if(type == Type.PAWN)
			return createWhitePawn();
		else if(type == Type.BISHOP)
			return createWhiteBishop();
		else if(type == Type.KING)
			return createWhiteKing();
		else if(type == Type.QUEEN)
			return createWhiteQueen();
		else if(type == Type.ROOK)
			return createWhiteRook();
		else if(type == Type.KNIGHT)
			return createWhiteKnight();
		
		return Piece.noPiece();
	}
	
	public static Piece createBlack(Type type){
		if(type == Type.PAWN)
			return createBlackPawn();
		else if(type == Type.BISHOP)
			return createBlackBishop();
		else if(type == Type.KING)
			return createBlackKing();
		else if(type == Type.QUEEN)
			return createBlackQueen();
		else if(type == Type.ROOK)
			return createBlackRook();
		else if(type == Type.KNIGHT)
			return createBlackKnight();
		
		return Piece.noPiece();
	}
	public static Piece createWhitePawn() {
		return new Piece(Color.WHITE, PAWN_REPRESENTATION, Type.PAWN);
	}

	public static Piece createBlackPawn() {
		return new Piece(Color.BLACK, Character.toUpperCase(PAWN_REPRESENTATION), Type.PAWN);
	}
	
	public static Piece createWhiteRook() {
		return new Piece(Color.WHITE, ROOK_REPRESENTATION, Type.ROOK);
	}

	public static Piece createBlackRook() {
		return new Piece(Color.BLACK, Character.toUpperCase(ROOK_REPRESENTATION), Type.ROOK);
	}	

	public static Piece createWhiteKnight() {
		return new Piece(Color.WHITE, KNIGHT_REPRESENTATION, Type.KNIGHT);
	}

	public static Piece createBlackKnight() {
		return new Piece(Color.BLACK, Character.toUpperCase(KNIGHT_REPRESENTATION), Type.KNIGHT);
	}	

	public static Piece createWhiteBishop() {
		return new Piece(Color.WHITE, BISHOP_REPRESENTATION, Type.BISHOP);
	}

	public static Piece createBlackBishop() {
		return new Piece(Color.BLACK, Character.toUpperCase(BISHOP_REPRESENTATION), Type.BISHOP);
	}
	
	public static Piece createWhiteQueen() {
		return new Piece(Color.WHITE, QUEEN_REPRESENTATION, Type.QUEEN);
	}

	public static Piece createBlackQueen() {
		return new Piece(Color.BLACK, Character.toUpperCase(QUEEN_REPRESENTATION), Type.QUEEN);
	}
	
	public static Piece createWhiteKing() {
		return new Piece(Color.WHITE, KING_REPRESENTATION, Type.KING);
	}

	public static Piece createBlackKing() {
		return new Piece(Color.BLACK, Character.toUpperCase(KING_REPRESENTATION), Type.KING);
	}
}
