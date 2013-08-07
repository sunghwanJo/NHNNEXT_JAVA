package chess.test;

import util.StringUtil;
import junit.framework.TestCase;

public class UtilTest extends TestCase{
	
	public void testNewLine(){
		assertEquals(System.getProperty("line.separator"), StringUtil.NEWLINE);
	}
}
