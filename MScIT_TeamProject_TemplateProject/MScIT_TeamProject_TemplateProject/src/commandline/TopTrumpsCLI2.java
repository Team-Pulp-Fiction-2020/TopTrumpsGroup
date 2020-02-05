package commandline;

import java.sql.SQLException;
import java.util.Random;
import java.util.Scanner;

/**
 * Top Trumps command line application
 */
public class TopTrumpsCLI2 {

	/**
	 * This main method is called by TopTrumps.java when the user specifies that they want to run in
	 * command line mode. The contents of args[0] is whether we should write game logs to a file.
 	 * @param args
	 * @throws SQLException 
	 */
	public static void main(String[] args) throws SQLException {
//		final DatabaseConnection connection = new DatabaseConnection();
		Scanner scanner = new Scanner(System.in);

		boolean writeGameLogsToFile = false; // Should we write game logs to file?
//		if (args[0].equalsIgnoreCase("true")) writeGameLogsToFile=true; // Command line selection
		
		// State
		boolean userWantsToQuit = false; // flag to check whether the user wants to quit the application
		
		// Loop until the user wants to exit the game
		while (!userWantsToQuit) {

			// ----------------------------------------------------
			// Add your game logic here based on the requirements
			// ----------------------------------------------------
			
			System.out.println("\nDo you want to see past results or play a game?\n\t\t"
					+ "1: Print Game Statistics\n\t\t2: Play Game\n"
					+ "Enter the number for your selection:");
			int playerInput = scanner.nextInt();
			while(!(playerInput == 1) && !(playerInput == 2)) {
				System.out.println("Please enter either '1' or '2'");
			}
//			if (playerInput == 1) {
//				System.out.println("\n\n\nGame Statistics:\n"
//						+ "\t\t\tNumber of Games: " + connection.getGamesPlayed()
//						+ "\n\t\tNumber of Human Wins: " + connection.getHumanWins()
//						+ "\n\t\tNumber of AI Wins: " + connection.getComputerWins()
//						+ "\n\t\tAverage Number of Draws: " + connection.getAvgDraws()
//						+ "\n\t\tLongest Game: " + connection.getLongestGame());
//			}
			if (playerInput == 2) {
				System.out.println("How many players are there? (2-5)");
				int noPlayers = scanner.nextInt();
				while(!(noPlayers > 2) && !(noPlayers < 5)) {
					System.out.println("Please enter either '2', '3', '4' or '5'");
				}
//				View view = new View(noPlayers);
				System.out.println("Game Start");
				PlayGame play = new PlayGame(noPlayers);
				
				
				play.deal(); 

				int round = 1;
//				play.askHuman();
//				play.checkRound();
				do	 {
					System.out.print("Round " + round + "\nRound " + round + ": Players have drawn their cards \nYou drew "+ play.getPlayersArrayList().get(0).cardsArray.get(0).toString() + "\nYou have " +  play.getPlayersArrayList().get(0).cardsArray.size() + " cards in your deck\n");

					
					if(play.getWinnerOfRound() == 0) {
						System.out.println("It is your turn to select a category, the categories are:\n\t1: Size \n\t2:Speed\n\t3:Range\n\t4:Firepower\n\t5:Cargo");
					}
					play.nextRound();
				
					System.out.println("test");
					play.checkRound();
					play.removePlayer();
//					view.roundCounter(play.getNoOfRounds());
					round++;

					if (play.getWinnerOfRound()>=0) {
						play.setPrevWinRound(play.getWinnerOfRound());
					}
				} 
				while (play.gameWon() == false);
				System.out.println(play.gameOver());
				userWantsToQuit=true; // use this when the user wants to exit the game
			
		}


	}

}
}