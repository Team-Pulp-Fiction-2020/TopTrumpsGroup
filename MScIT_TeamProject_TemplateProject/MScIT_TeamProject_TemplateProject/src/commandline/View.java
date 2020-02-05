package commandline;

public class View {
	
	int noOfPlayers;
	private PlayGame play;
	
	public View(int noOfPlayers) {
		play = new PlayGame(noOfPlayers);
//		this.noOfPlayers = noOfPlayers;
	}
	
	
	public void roundCounter(int round) {
		System.out.print("Round " + round + "\nRound " + round + ": Players have drawn their cards \nYou drew "+ play.getPlayersArrayList().get(0).cardsArray.get(0).toString() + play.getPlayersArrayList().get(0).cardsArray.size());
//		String rounds = "Round " + round + "\nRound " + round + ": Players have drawn their cards \nYou drew "+ play.getPlayersArrayList().get(0).cardsArray.get(0).toString() + play.getPlayersArrayList().get(0).cardsArray.size();
//		String rounds2 = "" + play.getPlayersArrayList().get(0).cardsArray.size();
				//		System.out.println("Round " + round);
//		System.out.println("Player " + (i + 1) + " : " + playersArrayList.get(i).cardsArray.get(0).toString());
//		System.out.println(playersArrayList.get(i).cardsArray.size());
		
//		System.out.println("Round " + round + ": Players have drawn their cards");
//		System.out.println("You drew " + play.getTrump());
//		return rounds;
		
	}

}
