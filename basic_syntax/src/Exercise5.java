/*
 * Enter any decimal number as an input and count the number of bits set to one
 */
import java.util.Scanner;
public class Exercise5 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n, count = 0;
		String x = "";
		Scanner scanner = new Scanner(System.in);
		System.out.print("Please enter any decimal number: ");
		n = scanner.nextInt();
		
		while(n>0) {
			int a = n % 2;
			x = a + x;
			n = n / 2;
		}
		
		int j = x.length();
		for(int i = 0; i < j; i++) {
			if(x.charAt(i) == '1') {
				count++;
			}
		}
		
		System.out.println("No. of 1's are: " + count);
		scanner.close();

	}

}
