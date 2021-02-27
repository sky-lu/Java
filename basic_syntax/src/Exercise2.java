/*
 *Enter any integer number as an input and the reverse the given number 
 */

import java.util.Scanner;


public class Exercise2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		
		System.out.print("Please enter an interger number: ");
		String str = scanner.next();
		StringBuilder sb = new StringBuilder(str);
		sb.reverse();
		
		System.out.println("The reversed number is " + sb);
		scanner.close();
		

	}

}
