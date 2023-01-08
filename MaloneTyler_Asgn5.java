
import java.util.Scanner;
import java.util.InputMismatchException;
import java.text.DecimalFormat;

public class MaloneTyler_Asgn5 {


	public static void main_menu() {
		System.out.println();
		System.out.println("1 -- Convert cubic feet to U.S. bushels");
		System.out.println("2 -- Convert miles to kilometers");
		System.out.println("3 -- Determine graduation title with honors");
		System.out.println("9 -- Exit program");
		System.out.println();
	}

	public static double miles_to_kilometers(double miles) {
		double kilometers = miles * 1.60934;
		return(kilometers);
	}

	public static double cubic_ft_to_bushels(double feetCubed) {
		double bushels = feetCubed * 0.803564;
		return(bushels);
	}

	public static String grad_title(double gpa) {
		String honors = "Congratulations, you have graduated ";
		String noHonors = "You did not graduate with honors.";

		if (gpa >= 4.0) return honors + "Summa Cum Laude!";
		if (gpa >= 3.8) return honors + "Magna Cum Laude!";
		if (gpa >= 3.5) return honors + "Cum Laude!";
		return noHonors;
	}

	public static final DecimalFormat df = new DecimalFormat("0.000");
	public static void main(String[] args) {

		while (true) {
			try {
				Scanner scan = new Scanner(System.in);
				main_menu();
				int userChoice = scan.nextInt();
				scan.nextLine();
				if (userChoice == 1) {
					System.out.println("Enter cubic feet ==> ");
					double cubicFeet = scan.nextDouble();
					scan.nextLine();
					System.out.println();
					System.out.println(cubicFeet + " is equal to " + df.format(cubic_ft_to_bushels(cubicFeet)) + " bushels.");
				} else if (userChoice == 2) {
					System.out.println("Enter miles ==> ");
					double miles = scan.nextDouble();
					scan.nextLine();
					System.out.println();
					System.out.println(miles + " miles is equal to " + df.format(miles_to_kilometers(miles)) + " kilometers.");
				} else if (userChoice == 3) {
					System.out.println("Enter GPA ==> ");
					double gpa = scan.nextDouble();
					scan.nextLine();
					System.out.println();
					System.out.println(grad_title(gpa));
				} else if (userChoice == 9) {
					System.out.println("Thank you for using this program.");
					System.out.println();
					break;
				}
			} catch (InputMismatchException e) {
				System.out.println("Invalid input! returning to menu.");
			}
		}
	}

}
