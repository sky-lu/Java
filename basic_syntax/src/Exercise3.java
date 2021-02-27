/*
 * Enter any decimal number as an input and convert the number to binary
 */

import java.util.Scanner;

public class Exercise3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		System.out.print("Please enter any decimal number: ");
		int num = scanner.nextInt();
		String bin = Integer.toBinaryString(num);
		System.out.println(bin);
		scanner.close();

	}

}
