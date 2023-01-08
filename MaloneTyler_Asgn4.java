package week5;

import java.util.Scanner;

public class MaloneTyler_Asgn4 {

  	public static void main(String[] args) {

	//Triangle pattern
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter an integer value: ");
		int rows = scan.nextInt();
		scan.nextLine();
		for (int i = 1; i <= rows; ++i) {
			for (int j = 1; j <= i; ++j) {
				System.out.print(j + " ");
			}
      			System.out.println();
    		}

	//Rectangle pattern
		System.out.println("Enter another integer value: ");
		int n = scan.nextInt();
		scan.nextLine();
		int arraySize = n * 2 - 1;//set the length of each row
		int[][] result = new int[arraySize][arraySize];//make two-dimensional array (n number of arrays each with n elements)

		for(int i = 0; i < arraySize; i++){
			for(int j = 0; j < arraySize; j++){
				//each subarray will be a new row
				result[i][j] = Math.max(Math.abs(i-arraySize/2),Math.abs(j-arraySize/2))+1;

			}
		}

		//this prints each subarray in order
		for(int i = 0; i < arraySize; i++){
			for(int j = 0; j < arraySize; j++){
				System.out.print(result[i][j]);
			}
			System.out.println();
		}
	}
}
