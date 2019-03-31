package btp.teste_software;

import java.util.ArrayList;
import java.util.Arrays;
/*
 * @author Mikko Rusama, SoberIT
 * @version 26.8.2004
 */
public class Triangle {
	private int side1, side2, side3;
	private static final String P_EQUILATERAL = "equilateral";
	private static final String P_ISOSCELES   = "isosceles";
	private static final String P_RIGHTANGLED = "right-angled";
	private static final String P_SCALENE     = "scalene";
	private static final String P_IMPOSSIBLE  = "impossible";

	
	public Triangle(int s1, int s2, int s3){
		side1 = s1;
		side2 = s2;
		side3 = s3;
	}

	public Triangle setSideLengths(int s1, int s2, int s3){
		side1 = s1;
		side2 = s2;
		side3 = s3;
		return this;
	}

	public String getSideLengths(){
		return side1 + "," + side2 + "," + side3;
	}

	public int getPerimeter(){ 
		if (! isImpossible()){
			return side1 + side2 + side3;
		}
		return -1;
	}

	public double getArea(){
		if (!isImpossible()){
			return Math.sqrt(getPerimeter()
			/ 2
			* (getPerimeter() / 2 - side1)
			* (getPerimeter() / 2 - side2)
			* (getPerimeter() / 2 - side3));
		}
		return -1;
	}

	public String classify(){
		if (isImpossible())	{
			return P_IMPOSSIBLE;
		}
		if (side1 == side2)	{
			if (side2 == side3)
			{
				return P_EQUILATERAL;
			}
			else{
				return P_ISOSCELES;
			}
		}
		if (isRightAngled()){
			return P_RIGHTANGLED;
		}
		return P_SCALENE;
	}

	public boolean isIsosceles(){
		if (side1 == side2 || side2 == side3 || side1 == side3){
			return true;
		}
		return false;
	}

	public boolean isEquilateral(){
		if (side1 == side2 && side2 == side3){
			return true;
		}
		return false;
	}

	public boolean isRightAngled(){
		int[] sides = new int[] { side1, side2, side3 };
		Arrays.sort(sides); //ascending array
		return sides[2]
			== Math.sqrt((long) sides[0] * sides[0] + (long) sides[1] * sides[1]);
	}

	public boolean isScalene(){
		if (isRightAngled()){
			return false;
		}
		if (side1 != side2 && side1 != side3 && side2 != side3)
		{
			return true;
		}

		return false;
	}

	public boolean isImpossible()
	{
		if (side1 <= 0 || side2 <= 0 || side3 <= 0)
		{
			return true;
		}
		//Avoid the buffer overflow by this trick: a+b<c -> a<c-b
		if (!(side1>side3-side2 && side1>side2-side3 && side2>side1-side3)){
			return true;
		}
		return false;
	}

	public static ArrayList<String> main(String[] args)
	{
		
		ArrayList<String> returnString = new ArrayList<String>();
		
		Triangle triangle = null;
		try
		{
			triangle = new Triangle(
					Integer.parseInt(args[0]),
					Integer.parseInt(args[1]),
					Integer.parseInt(args[2]));
		}
		catch (Exception e)
		{
			returnString.add(
				"Usage: java Quadrangle <side1:int> <side2:int> <side3:int>");
			return returnString;
		}
		returnString.add("Type: " + triangle.classify());
		returnString.add("Triangle sides: " + triangle.getSideLengths());
		returnString.add("Area: " + triangle.getArea());
		returnString.add("Perimeter: " + triangle.getPerimeter());
		
		return returnString;
	}

}