package btp.teste_software;

import java.util.Arrays;

public class TrianglesSmaller {

	private int side1, side2, side3;
	private static final String P_EQUILATERAL = "equilateral";
	private static final String P_ISOSCELES = "isosceles";
	private static final String P_RIGHTANGLED = "right-angled";
	private static final String P_SCALENE = "scalene";
	private static final String P_IMPOSSIBLE = "impossible";

	public TrianglesSmaller(int s1, int s2, int s3) {
		side1 = s1;
		side2 = s2;
		side3 = s3;
	}

	public String classify() {
		if (side1 <= 0 || side2 <= 0 || side3 <= 0) {
			return P_IMPOSSIBLE;
		}
		// Avoid the buffer overflow by this trick: a+b<c -> a<c-b
		if (!(side1 > side3 - side2 && side1 > side2 - side3 && side2 > side1 - side3)) {
			return P_IMPOSSIBLE;
		}
		if (side1 == side2) {
			if (side2 == side3) {
				return P_EQUILATERAL;
			} else {
				return P_ISOSCELES;
			}
		}

		int[] sides = new int[] { side1, side2, side3 };
		Arrays.sort(sides); // ascending array
		if (sides[2] == Math.sqrt((long) sides[0] * sides[0] + (long) sides[1] * sides[1])) {

			return P_RIGHTANGLED;
		}
		return P_SCALENE;
	}
}
