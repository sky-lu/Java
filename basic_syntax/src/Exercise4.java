/*
 * Enter any character as an input and check if a given character is vowel or consonant
 */

import java.util.Scanner;
public class Exercise4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		System.out.print("Please enter any character : ");
		char ch = scanner.next().charAt(0);
		
		if(ch=='a' || ch=='e' || ch=='o' || ch=='i' || ch=='u' || ch=='A' || ch=='E' || ch=='O' || ch=='I' || ch=='U') {
			System.out.println("Entered character " + ch + " is vowel.");
		}else if((ch>='a' && ch<='z')||(ch>='A' && ch<='Z')){
			System.out.println("Entered character " + ch + " is consonant.");
		}else {
			System.out.println("Invalide character!");
		}
		
		scanner.close();

	}

}
