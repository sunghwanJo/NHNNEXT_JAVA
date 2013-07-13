package one.lesson.test;

import junit.framework.TestSuite;
import one.lesson.pieces.PawnTest;

public class AllTests{
	public static TestSuite suite(){
		TestSuite suite = new TestSuite();
		
		suite.addTestSuite(PawnTest.class);
		
		return suite;
	}
}
