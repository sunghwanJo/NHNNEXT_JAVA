package chess.test;

import junit.framework.TestSuite;


public class AllTests{
	public static TestSuite suite(){
		TestSuite suite = new TestSuite();
		
		suite.addTestSuite(BoardTest.class);
		suite.addTestSuite(CharacterTest.class);
		suite.addTestSuite(UtilTest.class);
		
		return suite;
	}
}
