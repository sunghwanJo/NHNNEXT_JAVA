package chess.test;

import junit.framework.TestCase;
import chess.pieces.Piece;

public class PieceTest extends TestCase{
	
	public void testCreate(){
		verifyCreation(Piece.createWhite(Piece.Type.PAWN), Piece.createBlack(Piece.Type.PAWN), Piece.Type.PAWN, 
				Piece.PAWN_REPRESENTATION);
		verifyCreation(Piece.createWhite(Piece.Type.ROOK), Piece.createBlack(Piece.Type.ROOK), Piece.Type.ROOK, 
				Piece.ROOK_REPRESENTATION);
		verifyCreation(Piece.createWhite(Piece.Type.KNIGHT), Piece.createBlack(Piece.Type.KNIGHT), Piece.Type.KNIGHT, 
				Piece.KNIGHT_REPRESENTATION);
		verifyCreation(Piece.createWhite(Piece.Type.BISHOP), Piece.createBlack(Piece.Type.BISHOP), Piece.Type.BISHOP, 
				Piece.BISHOP_REPRESENTATION);
		verifyCreation(Piece.createWhite(Piece.Type.QUEEN), Piece.createBlack(Piece.Type.QUEEN), Piece.Type.QUEEN, 
				Piece.QUEEN_REPRESENTATION);
		verifyCreation(Piece.createWhite(Piece.Type.KING), Piece.createBlack(Piece.Type.KING), Piece.Type.KING, 
				Piece.KING_REPRESENTATION);
		Piece blank = Piece.noPiece();
		assertEquals('.', blank.getRepresentation());
		assertEquals(Piece.Type.NO_PIECE, blank.getType());
	}
	
	private void verifyCreation(Piece whitePiece, Piece blackPiece, Piece.Type type, char representation){
		assertTrue(whitePiece.isWhite());
		assertEquals(type, whitePiece.getType());
		assertEquals(representation, whitePiece.getRepresentation());
		assertTrue(blackPiece.isBlack());
		assertEquals(type, blackPiece.getType());
		assertEquals(Character.toUpperCase(representation), blackPiece.getRepresentation());
	}
	
}
