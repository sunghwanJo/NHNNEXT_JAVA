package one.lesson;

import junit.framework.TestCase;

public class PawnTest extends TestCase{
	/*
	 * Test Method 규칙
	 * 1. 메소드는 public으로 선언되어야 한다
	 * 2. 메소드는 값을 반환하지 않는다 (void)
	 * 3. 메소드의 이름은 소문자 test로 시작
	 * 4. 인수를 받지 않는다
	 */

	public void testCreate(){
		Pawn pawn = new Pawn();
		
		pawn.setColor(Color.WHITE);
		assertEquals(pawn.getColor(), Color.WHITE);
		
		Pawn pawn2 = new Pawn(Color.BLACK);
		assertEquals(pawn2.getColor(), Color.BLACK);
		
	}
	
	public void testBoard(){
		Board board = new Board();
		Pawn blackPawn = new Pawn(Color.BLACK);
		Pawn whitePawn = new Pawn(Color.WHITE);
		
		board.enroll(blackPawn);
		assertEquals(board.getUnitNumbers(), 1);
		assertEquals(board.getUnit(0).getColor(), Color.BLACK);
		
		board.enroll(whitePawn);
		assertEquals(board.getUnitNumbers(), 2);
		assertEquals(board.getUnit(1).getColor(), Color.WHITE);
	}
}
