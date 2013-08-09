package chess.test;

import util.StringUtil;
import chess.board.Board;
import chess.pieces.Piece;
import junit.framework.TestCase;

public class BoardTest extends TestCase{

	private Board board;

	/**
	 * BoardTest에서 사용될 board 초기화
	 * initialize() 테스트 함수
	 */
	public void setUp(){
		board = Board.createBoard();
		board.initialize();
	}
	
	public void testBoard(){
	}
	
	/**
	 *  Board에서 Pawn들의 위치 확인 테스트 함수
	 */
	public void testCreate(){		
		
		StringBuilder buffer = new StringBuilder();
		
		for(Piece pawn : board.horseLists[1]){
			buffer.append(pawn.getRepresentation());
		}
		
		assertEquals("pppppppp", buffer.toString());
				
		buffer.replace(0, buffer.toString().length(), "");
		
		for(Piece pawn : board.horseLists[6]){
			buffer.append(pawn.getRepresentation());
		}
		assertEquals("PPPPPPPP", buffer.toString());
	
		assertEquals(32, board.getPieceNumbers() );
		
	}
	/**
	 *	Board의 현재 모양을 출력하는 Board.printBoard 테스트 함수  
	 */
	public void testBoardShape(){
		
		//System.out.print(board.printBoard());
		String blankRank = StringUtil.appendNewLine("........");
		
		assertEquals(StringUtil.appendNewLine("rnbqkbnr") +
				StringUtil.appendNewLine("pppppppp") +
				blankRank + blankRank + blankRank + blankRank +
				StringUtil.appendNewLine("PPPPPPPP") +
				StringUtil.appendNewLine("RNBQKBNR"),
				board.printBoard());
				
	}
	/**
	 * Piece의 Color와 Type을 통해 개수를 구하는 함수 테스
	 */
	public void testCountPieceWithType(){
		assertEquals(board.getCountPieces(Piece.Color.WHITE, Piece.Type.PAWN), 8);
		assertEquals(board.getCountPieces(Piece.Color.WHITE, Piece.Type.ROOK), 2);
		assertEquals(board.getCountPieces(Piece.Color.WHITE, Piece.Type.KNIGHT), 2);
		assertEquals(board.getCountPieces(Piece.Color.WHITE, Piece.Type.BISHOP), 2);
		assertEquals(board.getCountPieces(Piece.Color.WHITE, Piece.Type.QUEEN), 1);
		assertEquals(board.getCountPieces(Piece.Color.WHITE, Piece.Type.KING), 1);
		
		assertEquals(board.getCountPieces(Piece.Color.BLACK, Piece.Type.PAWN), 8);
		assertEquals(board.getCountPieces(Piece.Color.BLACK, Piece.Type.ROOK), 2);
		assertEquals(board.getCountPieces(Piece.Color.BLACK, Piece.Type.KNIGHT), 2);
		assertEquals(board.getCountPieces(Piece.Color.BLACK, Piece.Type.BISHOP), 2);
		assertEquals(board.getCountPieces(Piece.Color.BLACK, Piece.Type.QUEEN), 1);
		assertEquals(board.getCountPieces(Piece.Color.BLACK, Piece.Type.KING), 1);
	}
	
	public void testGetPieceWithPosition(){
		//System.out.println(board.getPieceWithPosition("a8").getRepresentation());
		
		assertEquals(board.getPieceWithPosition("a8").getRepresentation(), 'r');
		assertEquals(board.getPieceWithPosition("a7").getRepresentation(), 'p');
		assertEquals(board.getPieceWithPosition("a1").getRepresentation(), 'R');
		assertEquals(board.getPieceWithPosition("a2").getRepresentation(), 'P');
	}
	
	public void testSetPieceWithPosition(){
		Board board2 = Board.createBoard();
		
		
		board2.setPieceWithPosition(Piece.createWhite(Piece.Type.ROOK), "c5");
		assertEquals(board2.getPieceWithPosition("c5").getRepresentation(), 'r');
		
		board2.setPieceWithPosition(Piece.createWhite(Piece.Type.PAWN), "d6");
		assertEquals(board2.getPieceWithPosition("d6").getRepresentation(), 'p');
		
		board2.setPieceWithPosition(Piece.createBlack(Piece.Type.ROOK), "g3");
		assertEquals(board2.getPieceWithPosition("g3").getRepresentation(), 'R');
		
		board2.setPieceWithPosition(Piece.createBlack(Piece.Type.KNIGHT), "h4");
		assertEquals(board2.getPieceWithPosition("h4").getRepresentation(), 'N');
		
	
	}
}
