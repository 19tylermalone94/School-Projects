import java.util.Scanner;
import java.util.InputMismatchException;

public class MaloneTyler_Asgn6 {
	
	static int MAX_SCORE = 1000;
	static int MIN_SCORE = 400;
	
	static int winner(int[] scores) {
		int max = MIN_SCORE;
		int winnerIndex = 0;
		for (int i = 0; i < scores.length; i++) {
			if (scores[i] > max) {
				max = scores[i];
				winnerIndex = i;
			}
		}
		
		return winnerIndex;
	}
	
	static int loser(int[] scores) {
		int min = MAX_SCORE;
		int loserIndex = 0;
		for (int i = 0; i < scores.length; i++) {
			if (scores[i] < min) {
				min = scores[i];
				loserIndex = i;
			}
		}
		
		return loserIndex;
	}
	
	public static void main(String[] args) {
		int numTeams;
		String[] teamNames;
		int[] teamScores;
		
		while (true) {
			try {
				Scanner scan = new Scanner(System.in);
				System.out.println("How many teams do you want to enter: ");
				numTeams = scan.nextInt();
				scan.nextLine();
				teamNames = new String[numTeams];
				teamScores = new int[numTeams];
				for (int i = 0; i < numTeams; i++) {
					System.out.println("Team " + (i+1) + ": ");
					System.out.println("     Enter team's name: ");
					teamNames[i] = scan.nextLine();
					while (true) {
						try {
							System.out.println("     Enter team's score (400-1000): ");
							int score = scan.nextInt();
							scan.nextLine();
							if (score < MIN_SCORE || score > MAX_SCORE) {
								System.out.println("Invalid score");
								System.out.println();
							} else {
								teamScores[i] = score;
								break;
							}
							
						} catch (InputMismatchException e) {
							System.out.println("Enter a numerical value please!");
							System.out.println();
							scan.nextLine();
						}
					}					
				} 
				scan.close();
				break;
			} catch (InputMismatchException e) {
				System.out.println("Enter a numerical value please!");
				System.out.println();
			}
		}
		
		for (int i = 0; i < numTeams; i++) {
			System.out.println(teamNames[i] + " ==> " + teamScores[i]);
		}
		int winnerIndex = winner(teamScores);
		int loserIndex = loser(teamScores);
		System.out.println(teamNames[winnerIndex] + " had the highest score == > " + teamScores[winnerIndex]);
		System.out.println(teamNames[loserIndex] + " had the lowest score == > " + teamScores[loserIndex]);
	}

}
