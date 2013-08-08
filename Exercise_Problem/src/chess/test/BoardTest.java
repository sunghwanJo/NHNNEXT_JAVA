package chess.test;

import util.StringUtil;
import chess.board.Board;
import chess.pieces.Piece;
import junit.framework.TestCase;

public class BoardTest extends TestCase{

	private Board board;

	Piece blackPawn;
	Piece whitePawn;
	
	public void setUp(){
		board = new Board();

		blackPawn = Piece.create(Piece.Color.BLACK, Character.toUpperCase(Piece.PAWN_REPRESENTATION), Piece.Type.PAWN);
		whitePawn = Piece.create(Piece.Color.WHITE, Piece.PAWN_REPRESENTATION, Piece.Type.PAWN);
	}
	
	public void testBoard(){

		board.enroll(blackPawn);
		assertEquals(board.getUnitNumbers(), 1);
		assertEquals(board.getUnit(0), blackPawn);
		
		board.enroll(whitePawn);
		assertEquals(board.getUnitNumbers(), 2);
		assertEquals(board.getUnit(1), whitePawn);
		
		assertEquals(board.getUnit(0).getName(), 'P');
		assertEquals(board.getUnit(1).getName(), 'p');
		//board.enroll(new Integer("7"));
	}
	
	public void testCreate(){
		board.initialize();
		
		assertEquals(whitePawn.getColor(), Piece.Color.WHITE);	
		assertEquals(blackPawn.getColor(), Piece.Color.BLACK);
		
		assertTrue(whitePawn.isWhite());
		assertTrue(blackPawn.isBlack());
		
		StringBuilder buffer = new StringBuilder();
		
		for(Piece pawn : board.horseLists[1]){
			buffer.append(pawn.getName());
		}
		
		assertEquals("pppppppp", buffer.toString());
				
		buffer.replace(0, buffer.toString().length(), "");
		
		for(Piece pawn : board.horseLists[6]){
			buffer.append(pawn.getName());
		}
		assertEquals("PPPPPPPP", buffer.toString());

		assertEquals(32, board.getUnitNumbers() );
		String blankRank = StringUtil.appendNewLine("........");
		assertEquals(StringUtil.appendNewLine("rnbqkbnr") +
				StringUtil.appendNewLine("pppppppp") +
				blankRank + blankRank + blankRank + blankRank +
				StringUtil.appendNewLine("PPPPPPPP") +
				StringUtil.appendNewLine("RNBQKBNR"),
				board.printBoard());
		
	}

	public void testBoardShape(){
		board.initialize();
		System.out.print(board.printBoard());
		String blankRank = StringUtil.appendNewLine("........");
		System.out.println(StringUtil.appendNewLine("rnbqkbnr") +
				StringUtil.appendNewLine("pppppppp") +
				blankRank + blankRank + blankRank + blankRank +
				StringUtil.appendNewLine("PPPPPPPP") +
				StringUtil.appendNewLine("RNBQKBNR"));
	}
}
