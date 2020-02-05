package commandline;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Top Trumps command line application
 */
public class TopTrumpsCLIApplication {

	/**
	 * This main method is called by TopTrumps.java when the user specifies that they want to run in
	 * command line mode. The contents of args[0] is whether we should write game logs to a file.
 	 * @param args
	 * @throws SQLException 
	 */
	public static void main(String[] args) throws SQLException {
//		final DatabaseConnection connection = new DatabaseConnection();
		Scanner scanner = new Scanner(System.in);

//		boolean writeGameLogsToFile = false; // Should we write game logs to file?
//		if (args[0].equalsIgnoreCase("true")) writeGameLogsToFile=true; // Command line selection
		
		// State
		boolean userWantsToQuit = false; // flag to check whether the user wants to quit the application
		
		// Loop until the user wants to exit the game
		while (!userWantsToQuit) {

			// ----------------------------------------------------
			// Add your game logic here based on the requirements
			// ----------------------------------------------------
			
			Scanner humanSelect = new Scanner(System.in); // Create a Scanner object
			Scanner humanSelect2 = new Scanner(System.in); // Create a Scanner object
			Scanner humanSelect3 = new Scanner(System.in); // Create a Scanner object

			System.out.println(
					"Do you want to see past results or play game?\n1: Print same statistics \n2:Play game \nEnter the number for your selections");
			int h = humanSelect.nextInt();
			if (h == 1) {
				// call statistics
				System.out.println("Called statistics");
			} else if (h == 2) { // play game
				System.out.println("Please select the number of players between 2 and 5");
				int h3 = humanSelect3.nextInt();
				
				PlayGame play = new PlayGame(h3);
				//}
				play.deal();
				System.out.println("Game start!");
				
				do {
					System.out.println("Round: " + play.getNoOfRounds());
					System.out.println("Players have drawn their cards.");

					if (play.getPlayersArrayList().get(0).getCardsArray().isEmpty()==false ){
						System.out.println(play.showCard());
					}
					
					if (play.getWinnerOfRound() == 0) {
						System.out.println(
								"\nPlease select a category:\n1. Size\n2. Speed\n3. Range\n4. Firepower\n5. Cargo");
						int h2 = humanSelect.nextInt();
						if (h2 < 1 || h2 > 5) {
							System.out.println("Please enter either 1, 2, 3, 4 or 5");
						} else if (h2 == 1) {
							play.setTrump(0);
						} else if (h2 == 2) {
							play.setTrump(1);
						} else if (h2 == 3) {
							play.setTrump(2);
						} else if (h2 == 4) {
							play.setTrump(3);
						} else if (h2 == 5) {
							play.setTrump(4);
						}
					} else {
						play.aiPick(play.getPlayersArrayList().get(play.getWinnerOfRound()));
					}
					play.checkRound();
//					play.getPlayersArrayList();
//					System.out.print(play.getPlayersArrayList().get(play.getWinnerOfRound()).getCardsArray().get(0).toString());


					ComPile compile = new ComPile();
					System.out.print("There are cards cards Compile" + compile.getComPileSize());
					if (play.getWinnerOfRound() >= 0) {
						play.setPrevWinRound(play.getWinnerOfRound());
					}
					if (play.getWinnerOfRound() == -1) {
						play.setWinnerofRound(play.getPrevWinRound());
					}
				} while (play.gameWon() == false);
				System.out.println("Game over! Player "+ play.getGameWinner()+ " has won the game.\nNo of draws : "
				+play.getNoOfDraws());
				for(int i =0; i<play.getNoOfPlayers();i++) {
					System.out.println("Player "+(i+1)+ " has won "+play.getPlayersArrayList().get(i).getRoundsWons()+" rounds.");
				}
				play.gameOver();
				humanSelect.close();
				humanSelect2.close();
				humanSelect3.close();
			} else {
				System.out.println("Please select either 1 or 2.");
			}	
			
			
			
			} 
			userWantsToQuit=true; // use this when the user wants to exit the game
			
		}


	}

