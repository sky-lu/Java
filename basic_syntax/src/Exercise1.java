/*
 * Enter any three integer numbers as an input and find the biggest of three numbers and sort them?
 */

import java.util.Scanner;

public class Exercise1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		System.out.print("Please enter three different integer numbers: ");
		int num1 = scanner.nextInt();
		int num2 = scanner.nextInt();
		int num3 = scanner.nextInt();
		
		// Bubble sort
		if (num1 > num2) {
			//swap two numbers
			int temp = num1;
			num1 = num2;
			num2 = temp;
		}
		if (num2 > num3) {
			int temp = num2;
			num2 = num3;
			num3 = temp;
		}
		if (num1 > num2) {
			int temp = num1;
			num1 = num2;
			num2 = temp;
		}
		
		System.out.println("The biggest of three numbers is " + num3);
		System.out.println("The sorted numbers are " + num1 + " " + num2 + " " + num3);
		scanner.close();

	}

}
