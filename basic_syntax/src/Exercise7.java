/*
 * Enter the grade of student as input, read a grade, and then display the equivalent description
 */
import java.util.Scanner;
public class Exercise7 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		System.out.print("Enter grade of the student: ");
		char ch = scanner.next().charAt(0);
		if(ch == 'a' || ch == 'A') {
			System.out.println("Student has got marks above 80 out of 100.");
		}else if(ch == 'b' || ch == 'B') {
			System.out.println("Student has got marks above 60 but less than equal 80 out of 100.");
		}else if(ch == 'c' || ch == 'C') {
			System.out.println("Student has got marks above 40 but less than equal 60 out of 100.");
		}else {
			System.out.println("Student has failed.");
		}
		scanner.close();

	}

}
