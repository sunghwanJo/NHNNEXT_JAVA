package one.lesson.test;

import one.lesson.chess.Board;
import one.lesson.pieces.Pawn;
import junit.framework.TestCase;

public class PawnTest extends TestCase{
	/*
	 * Test Method 규칙
	 * 1. 메소드는 public으로 선언되어야 한다
	 * 2. 메소드는 값을 반환하지 않는다 (void)
	 * 3. 메소드의 이름은 소문자 test로 시작
	 * 4. 인수를 받지 않는다
	 */
	Board board;
	Pawn blackPawn;
	Pawn whitePawn;
	
	public void setUp(){
		board = new Board();
		blackPawn = new Pawn(Pawn.BLACK);
		whitePawn = new Pawn(Pawn.WHITE);
	}
	
	public void testBoard(){

		board.enroll(blackPawn);
		assertEquals(board.getUnitNumbers(), 1);
		assertEquals(board.getUnit(0), blackPawn);
		
		board.enroll(whitePawn);
		assertEquals(board.getUnitNumbers(), 2);
		assertEquals(board.getUnit(1), whitePawn);
		
		assertEquals(board.getUnit(0).printedChar, 'P');
		assertEquals(board.getUnit(1).printedChar, 'p');
		//board.enroll(new Integer("7"));
	}
	
	public void testCreate(){
		board.initialize();
		
		whitePawn.setColor(Pawn.WHITE);
		assertEquals(whitePawn.getColor(), Pawn.WHITE);	
		assertEquals(blackPawn.getColor(), Pawn.BLACK);	
		
		StringBuilder buffer = new StringBuilder();
		
		for(Pawn pawn : board.horseLists[1]){
			buffer.append(pawn.printedChar);
		}
		
		assertEquals("pppppppp", buffer.toString());
				
		buffer.replace(0, buffer.toString().length(), "");
		
		for(Pawn pawn : board.horseLists[6]){
			buffer.append(pawn.printedChar);
		}
		assertEquals("PPPPPPPP", buffer.toString());

	}

	public void testBoardShape(){
		board.initialize();
		board.printBoard();
	}
}
