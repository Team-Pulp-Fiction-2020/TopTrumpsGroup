package commandline;

import java.sql.SQLException;

public class TopTrumpsView {
	private TopTrumpsModel model;
	private TopTrumpsController controller;
	public TopTrumpsView(TopTrumpsModel model, TopTrumpsController controller) {
		this.model=model;
		this.controller=controller;
	}
	public void choosePlayOrStats() {
		System.out.println("\nDo you want to see past results or play a game?\n\t\t"
				+ "1: Print Game Statistics\n\t\t2: Play Game\n"
				+ "Enter the number for your selection:");
	}
	public void printStats() throws SQLException {
			final DatabaseConnection connection = new DatabaseConnection();
			System.out.println( "\n\n\nGame Statistics:\n"
				+ "\t\t\tNumber of Games: " + connection.getGamesPlayed()
				+ "\n\t\tNumber of Human Wins: " + connection.getHumanWins()
				+ "\n\t\tNumber of AI Wins: " + connection.getComputerWins()
				+ "\n\t\tAverage Number of Draws: " + connection.getAvgDraws()
				+ "\n\t\tLongest Game: " + connection.getLongestGame());	
	}
	public void checkInput() {
		System.out.println("\t\t**INVALID INPUT**. \nPlease make an appropriate selection:");
	}
	public void choosePlayers() {
		System.out.println("How many players are there? (2-5)");
	}
	public void startGame() {
		System.out.println("Game Start!");
	}
	public void playRound() {
		System.out.println("Round " + model.getNoOfRounds() + "\nRound " + model.getNoOfRounds() + ":Players have drawn their cards!\n"
				+ "You drew\n" + model.showCard(0) + "\nThere are " + model.getHandSize() + " in your deck");
	}
	public void humanChooseCat() {
		System.out.println("It is your turn to select a category, the categories are:"
				+ "\n\t\t1: Size\n\t\t2: Speed\n\t\t3: Range\n\t\t4: Firepower\n\t\t5: Cargo"
				+ "\nPlease enter the number of your chosen category: ");
	}
	public void draw() {
		System.out.println("This round was a draw! \nThere are "
				/*+ model.getComPile()*/ + " cards in the common pile.");
		//method to return size of comPile needed
	}
	public void humanWin() {
		System.out.println("You won this round!\n"
				+ "The winning card was:\n" + model.showCard(0));
	}
	public void AIWin() {
		System.out.println("Player " + (model.getWinnerOfRound() + 1) 
				+ " has won this round!\n The winning card was:\n" + model.showCard(model.getWinnerOfRound())
				+ "\n The winning category was: ");
				if(model.getTrump() == 0) {
					System.out.print("Size");
				}else if(model.getTrump() == 1) {
					System.out.println("Speed");
				}else if(model.getTrump() == 2) {
					System.out.println("Range");
				}else if(model.getTrump() == 3) {
					System.out.println("Firepower");
				}else if(model.getTrump() == 4) {
					System.out.println("Cargo");
				}
	}
}