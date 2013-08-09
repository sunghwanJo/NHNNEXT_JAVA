package chess.pieces;

import java.util.EnumMap;
import java.util.Map;

/**
 * 
 * @author josunghwan
 *
 */
public class Piece {

	public static enum Color {WHITE, BLACK, BLANK};
	public static enum Type {PAWN, ROOK, KNIGHT, BISHOP, QUEEN, KING, NO_PIECE};
	
	private Map<Piece.Type, Double> pieceMap = null;
	
	private Color color;
	private char representChar;
	private Type type; 
	
	public static final char PAWN_REPRESENTATION = 'p';
	public static final char ROOK_REPRESENTATION = 'r';
	public static final char KNIGHT_REPRESENTATION = 'n';
	public static final char BISHOP_REPRESENTATION = 'b';
	public static final char QUEEN_REPRESENTATION = 'q';
	public static final char KING_REPRESENTATION = 'k';
	public static final char BLANK_REPRESENTATION = '.';
	
	static int numberOfWhitePieces=0;
	static int numberOfBlackPieces=0;
	
	private Piece(){
		
	}
	
	private Piece(Color color, char representChar, Type type){
		this.color =color;
		this.representChar = representChar;
		this.type = type;
	}

	private Map<Piece.Type, Double> getPieceMap(){
		if(pieceMap == null)
			loadPieceMap();
		return pieceMap;
		
	}
	
	private void loadPieceMap(){
		pieceMap = new EnumMap<Piece.Type, Double>(Piece.Type.class);
		pieceMap.put(Type.PAWN, new Double(1.0));
		pieceMap.put(Type.ROOK, new Double(5.0));
		pieceMap.put(Type.KNIGHT, new Double(2.5));
		pieceMap.put(Type.BISHOP, new Double(3.0));
		pieceMap.put(Type.QUEEN, new Double(9.0));
		pieceMap.put(Type.KING, new Double(100.0));
		
	}
	
	private static Piece create(Color color, char representChar, Type type){
		if(color == Color.BLACK){
			numberOfBlackPieces++;
		}else if(color == Color.WHITE){
			numberOfWhitePieces++;
		}
		
		return new Piece(color, representChar, type);
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
		return this.representChar;
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
	private static Piece createWhitePawn() {
		return Piece.create(Color.WHITE, PAWN_REPRESENTATION, Type.PAWN);
	}

	private static Piece createBlackPawn() {
		return Piece.create(Color.BLACK, Character.toUpperCase(PAWN_REPRESENTATION), Type.PAWN);
	}
	
	private static Piece createWhiteRook() {
		return Piece.create(Color.WHITE, ROOK_REPRESENTATION, Type.ROOK);
	}

	private static Piece createBlackRook() {
		return Piece.create(Color.BLACK, Character.toUpperCase(ROOK_REPRESENTATION), Type.ROOK);
	}	

	private static Piece createWhiteKnight() {
		return Piece.create(Color.WHITE, KNIGHT_REPRESENTATION, Type.KNIGHT);
	}

	private static Piece createBlackKnight() {
		return Piece.create(Color.BLACK, Character.toUpperCase(KNIGHT_REPRESENTATION), Type.KNIGHT);
	}	

	private static Piece createWhiteBishop() {
		return Piece.create(Color.WHITE, BISHOP_REPRESENTATION, Type.BISHOP);
	}

	private static Piece createBlackBishop() {
		return Piece.create(Color.BLACK, Character.toUpperCase(BISHOP_REPRESENTATION), Type.BISHOP);
	}
	
	private static Piece createWhiteQueen() {
		return Piece.create(Color.WHITE, QUEEN_REPRESENTATION, Type.QUEEN);
	}

	private static Piece createBlackQueen() {
		return Piece.create(Color.BLACK, Character.toUpperCase(QUEEN_REPRESENTATION), Type.QUEEN);
	}
	
	private static Piece createWhiteKing() {
		return Piece.create(Color.WHITE, KING_REPRESENTATION, Type.KING);
	}

	private static Piece createBlackKing() {
		return Piece.create(Color.BLACK, Character.toUpperCase(KING_REPRESENTATION), Type.KING);
	}
}
