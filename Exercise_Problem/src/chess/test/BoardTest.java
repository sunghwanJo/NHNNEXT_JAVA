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
		board = Board.createBoard();
		board.initialize();
		blackPawn = Piece.createBlack(Piece.Type.PAWN);
		whitePawn = Piece.createWhite(Piece.Type.PAWN);
	}
	
	public void testBoard(){
	}
	
	public void testCreate(){		
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
	
		assertEquals(32, board.getPieceNumbers() );
		
	}

	public void testBoardShape(){
		
		System.out.print(board.printBoard());
		String blankRank = StringUtil.appendNewLine("........");
		System.out.println(StringUtil.appendNewLine("rnbqkbnr") +
				StringUtil.appendNewLine("pppppppp") +
				blankRank + blankRank + blankRank + blankRank +
				StringUtil.appendNewLine("PPPPPPPP") +
				StringUtil.appendNewLine("RNBQKBNR"));
	}
	
	public void testCountPieceWithType(){
		
	}
}
