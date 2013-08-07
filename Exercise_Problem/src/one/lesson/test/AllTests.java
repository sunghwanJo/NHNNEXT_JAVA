package one.lesson.test;

import junit.framework.TestSuite;


public class AllTests{
	public static TestSuite suite(){
		TestSuite suite = new TestSuite();
		
		suite.addTestSuite(PawnTest.class);
		suite.addTestSuite(CharacterTest.class);
		
		return suite;
	}
}
