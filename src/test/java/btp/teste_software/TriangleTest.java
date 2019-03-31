package btp.teste_software;

import java.util.ArrayList;

import org.junit.Test;
import junit.framework.TestCase;

public class TriangleTest extends TestCase {
	
	@Test
	public void testOfGetPerimeter() {
		assertEquals(25,new Triangle(10,5,10).getPerimeter());
		assertEquals(-1,new Triangle(0,1,2).getPerimeter());
	}
	
	@Test
	public void testOfgetArea() {
		assertEquals(6.0, new Triangle(3,4,5).getArea());
		assertEquals(-1.0, new Triangle(0,1,-1).getArea());		
	}
	
	@Test
	public void testOfClassify(){
		assertEquals("impossible", new Triangle(0,1,2).classify());
		assertEquals("isosceles", new Triangle(5,5,2).classify());
		assertEquals("equilateral", new Triangle(7,7,7).classify());
		assertEquals("right-angled", new Triangle(3,4,5).classify());
		assertEquals("scalene", new Triangle(7,9,14).classify());
	}
	
	@Test
	public void testOfIsIsosceles() {
		assertEquals(true, new Triangle(5,5,2).isIsosceles());
		assertEquals(false, new Triangle(5,7,2).isIsosceles());
	}
	
	@Test
	public void testImpossibleWithZero() {
		String args[] = {"0", "1", "2"};
		ArrayList<String> actual = Triangle.main(args);
		assertEquals("Type: impossible", actual.get(0));
		assertEquals("Triangle sides: 0,1,2", actual.get(1));
		assertEquals("Area: -1.0", actual.get(2));
		assertEquals("Perimeter: -1", actual.get(3));
	}
	
	@Test
	public void testImpossibleWithLinesTooBig() {
		String args[] = {"2", "1", "100"};
		ArrayList<String> actual = Triangle.main(args);
		assertEquals("Type: impossible", actual.get(0));
		assertEquals("Triangle sides: 2,1,100", actual.get(1));
		assertEquals("Area: -1.0", actual.get(2));
		assertEquals("Perimeter: -1", actual.get(3));
	}
	
	@Test
	public void testIsosceles() {
		String args[] = {"5", "5", "2"};
		ArrayList<String> actual = Triangle.main(args);
		assertEquals("Type: isosceles", actual.get(0));
		assertEquals("Triangle sides: 5,5,2", actual.get(1));
		assertEquals("Area: 4.898979485566356", actual.get(2));
		assertEquals("Perimeter: 12", actual.get(3));
	}
	
	@Test
	public void testEquilateral() {
		String args[] = {"7", "7", "7"};
		ArrayList<String> actual = Triangle.main(args);
		assertEquals("Type: equilateral", actual.get(0));
		assertEquals("Triangle sides: 7,7,7", actual.get(1));
		assertEquals("Area: 16.431676725154983", actual.get(2));
		assertEquals("Perimeter: 21", actual.get(3));
	}
	
	@Test
	public void testRightAngled() {
		String args[] = {"3", "4", "5"};
		ArrayList<String> actual = Triangle.main(args);
		assertEquals("Type: right-angled", actual.get(0));
		assertEquals("Triangle sides: 3,4,5", actual.get(1));
		assertEquals("Area: 6.0", actual.get(2));
		assertEquals("Perimeter: 12", actual.get(3));
	}
	
	@Test
	public void testScalene() {
		String args[] = {"13", "9", "14"};
		ArrayList<String> actual = Triangle.main(args);
		assertEquals("Type: scalene", actual.get(0));
		assertEquals("Triangle sides: 13,9,14", actual.get(1));
		assertEquals("Area: 56.92099788303083", actual.get(2));
		assertEquals("Perimeter: 36", actual.get(3));
	}
		
	
	@Test
	public void testCatch() {
		String args[] = {"1", "3"};
		ArrayList<String> actual = Triangle.main(args);
		assertEquals("Usage: java Quadrangle <side1:int> <side2:int> <side3:int>", actual.get(0));
	}
}
