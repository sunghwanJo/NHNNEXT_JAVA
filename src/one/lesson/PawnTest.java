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
		final String BLACK = "black";
		final String WHITE = "white";
		
		Pawn pawn = new Pawn();
		
		pawn.setColor(WHITE);
		assertEquals(pawn.getColor(), WHITE);
		
		Pawn pawn2 = new Pawn(BLACK);
		assertEquals(pawn2.getColor(), BLACK);
		
	}
	
	public void testBoard(){
		Board board = new Board();

	}
}
