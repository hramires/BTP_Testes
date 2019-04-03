package btp.teste_software;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class TrianglesSmallerTest {
	
	@Test
	public void classifyTest(){
		assertEquals(new TrianglesSmaller(5,5,6).classify(), "equilateral");
	}
	
}
