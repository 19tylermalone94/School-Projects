package week3;
/*Malone, Tyler
 * CMIS 141/A481
 * 07/19/2022
 */

import java.util.Scanner;//import Scanner to collect user input

public class MaloneTyler_Asgn2 {

	public static void main(String[] args) {
		Scanner myObj = new Scanner(System.in);//initialize Scanner object
		
		//initialize variables. The values will be reassigned from within the While loop.
		String numInputString;
		int num1 = 0;
		int num2 = 0;
		String operator = "";
		
		//This while loop uses try/catch and if/else to re-prompt user upon invalid input, and prevent termination due to error.
		while(true) {
			try {
				System.out.println("Enter two integer numbers between 200 and 1000 separated by a space: ");
				numInputString = myObj.nextLine();//receive user input as a string	
				String[] numInputArr = numInputString.split(" ");//split the string at the location of a 'space' into an array
				num1 = Integer.parseInt(numInputArr[0]);//assign the integer value of first array string to num1
				num2 = Integer.parseInt(numInputArr[1]);//assign the integer value of second array string to num2
				if (numInputArr.length > 2) {//prevents user from entering more than two numbers
					System.out.println("!!!Enter exactly two numbers!!!");
					continue;
				}else if (num1 < 200 || num1 > 1000 || num2 < 200 || num2 > 1000) {//restricts user input to numbers between 200 and 1000
					System.out.println("!!!Only numbers between 200 and 1000!!!");
					continue;
				}else {	
					while(true) {//this while loop re-prompts user upon invalid operator input
						System.out.println("Enter one of the following mathematical operators: + - * /");
						operator = myObj.nextLine();
						switch (operator) {//this switch statement outputs the calculation based on which operator the user chooses
						case "+":
							System.out.println(num1 + " + " + num2 + " = " + (num1+num2));
							break;
						case "-":
							System.out.println(num1 + " - " + num2 + " = " + (num1-num2));
							break;
						case "*":
							System.out.println(num1 + " * " + num2 + " = " + (num1*num2));
							break;
						case "/":
							System.out.println(num1 + " / " + num2 + " = " + ((double)num1/(double)num2));//the 'double' is used to prevent integer division
							break;
						default:
							System.out.println("!!!Invalid operator!!!");
							continue;
						} break;
					} 
				} break;
				
			} catch (ArrayIndexOutOfBoundsException e) {//this catch prevents error if user enters less than two numbers
				System.out.println("!!!Enter exactly two numbers!!!");
				continue;
			} catch (NumberFormatException e) {//this catch prevents error if user enters alpha characters
				System.out.println("!!!Enter whole numerical values only!!!");
				continue;
			}
		} myObj.close();//close scanner object
	}
}
