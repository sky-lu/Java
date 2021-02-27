/*
 * Enter any integer number as an input and convert a given number of days in terms of Years, Weeks & Days ?
 */

import java.util.Scanner;
public class Exercise6 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		System.out.print("Please enter any integer number: ");
		int num = scanner.nextInt();
		int year = num / 365;
		int week = (num % 365) / 7;
		int day = (num % 365) % 7;
		
		System.out.println("No. of years: " + year);
		System.out.println("No. of weeks: " + week);
		System.out.println("No. of days: " + day);
		scanner.close();

	}

}
