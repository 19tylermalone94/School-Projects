package week5;

import java.util.Scanner;
import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.HashMap;
import java.util.Map;

public class MaloneTyler_Project1 {

	//this method returns the sub average of each assignment type
	public static double sub_avg(double[] grades) {
		double sum = 0;
		int numGrades = grades.length;
		for (int i = 0; i < numGrades; i++) {
			sum += grades[i];
		}
		double avg = sum / numGrades;
		return avg;
	}

	//this method calculates total average when given all sub averages and grade weights
	public static double total_avg(double[] subAvg, double[] weight) {
		double totalAvg = 0;
		int numGrades = subAvg.length;
		for (int i = 0; i < numGrades; i++) {
			totalAvg += (subAvg[i] * weight[i]);
		}
		return totalAvg;
	}

	//this method is used to get the grades of an assignment type
	public static double[] grade_getter(String asgnType, int numAsgn) {
		double[] grades = new double[numAsgn];
		while(true) {
			try {
				Scanner scan = new Scanner(System.in);
				System.out.println("Enter " + numAsgn + " " + asgnType + " grades separated by a space: ");
				//assemble grades into a list
				for(int i = 0; i < numAsgn; i++) {
					grades[i] = scan.nextDouble();
				}
				scan.nextLine();
				System.out.println(Arrays.toString(grades));
				System.out.println("Is this correct? y/n: ");
				String response = scan.nextLine();
				while (!response.equalsIgnoreCase("y") && !response.equalsIgnoreCase("n")) {
					System.out.println("invalid option, try again");
					System.out.println(Arrays.toString(grades));
					System.out.println("Is this correct? y/n: ");
					response = scan.nextLine();
				}
				if (response.equalsIgnoreCase("y"))
					break;

			}
			//catch invalid input types
			catch (InputMismatchException e) {
				System.out.println("invalid input");
			}
		}
		return grades;
	}

	public static void main(String[] args) {
		//the number of grade types can be changed here
		int numGradeTypes = 4;
		//the number of each grade type can be changed here
		int numDiscussions = 5, numAssignments = 5, numProjects = 2, numQuizes = 5;//numNewType = 5
		//the weight of each grade type (Disc, Asgn, Proj, Quiz) can be changed here
		double[] gradeWeight = {.1, .5, .3, .1};//add a new weight if you add grade type

		while(true) {
			Scanner scan = new Scanner(System.in);
			System.out.println("Enter student name: ");
			String studentName = scan.nextLine();

			//map is used to assemble sub averages into a list
			Map<Integer, double[]> map = new HashMap<>();
			map.put(1, grade_getter("Discussion", numDiscussions));
			map.put(2, grade_getter("Assignment", numAssignments));
			map.put(3, grade_getter("Project", numProjects));
			map.put(4, grade_getter("Quiz", numQuizes));
			//map.put(5, grade_getter("New Type", numType));

			//assemble sub averages into a list
			double[] subAvg = new double[numGradeTypes];
			for (int i = 0; i < numGradeTypes; i++) {
				subAvg[i] = sub_avg(map.get(i+1));
			}
			//call the total_avg method
			double totalAvg = total_avg(subAvg, gradeWeight);
			String letterGrade = new String();

			//determine letter grade equivalent
			if(totalAvg >= 90) {
				letterGrade = "A";
			}else if(totalAvg >= 80) {
				letterGrade = "B";
			}else if(totalAvg >= 70) {
				letterGrade = "C";
			}else if(totalAvg >= 60) {
				letterGrade = "D";
			}else {
				letterGrade = "F";
			}
			//display output to user
			System.out.println();
			System.out.println("Student Name: " + studentName);
			System.out.println("Average: " + totalAvg);
			System.out.println("Grade: "+ letterGrade);
			System.out.println();

			//allow user to choose to add another student
			System.out.println("Would you like to enter another student's info? y/n: ");
			String response = scan.nextLine();
			while(!response.equalsIgnoreCase("y") && !response.equalsIgnoreCase("n")) {
				System.out.println("invalid option, try again");
				System.out.println("Would you like to enter another student's info? y/n: ");
				response = scan.nextLine();
			}
			if (response.equalsIgnoreCase("n")) {
				break;
			}
		}
	}
}
