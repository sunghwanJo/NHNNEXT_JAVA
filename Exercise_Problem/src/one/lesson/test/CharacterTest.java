package one.lesson.test;

import junit.framework.TestCase;

public class CharacterTest extends TestCase{
	
	public void testWhitespace(){
		assertTrue(Character.isWhitespace('\n'));
		assertTrue(Character.isWhitespace('\t'));
		assertTrue(Character.isWhitespace(' '));
		assertTrue(Character.isWhitespace('\f'));	
	}
	
	public void testCheckIdentifier(){
		assertFalse(Character.isJavaIdentifierPart('^'));
		assertFalse(Character.isJavaIdentifierPart('+'));
		assertFalse(Character.isJavaIdentifierPart('-'));
		assertFalse(Character.isJavaIdentifierPart('%'));
		assertFalse(Character.isJavaIdentifierPart('*'));
		
		assertTrue(Character.isJavaIdentifierPart('a'));
		assertTrue(Character.isJavaIdentifierPart('$'));
		assertTrue(Character.isJavaIdentifierPart('1'));
		
	}
	
	
}
