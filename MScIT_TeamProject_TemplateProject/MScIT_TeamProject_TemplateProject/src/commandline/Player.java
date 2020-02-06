package commandline;
import java.util.ArrayList;

public class Player {
//	private String name;
	protected ArrayList<Deck> cardsArray = new ArrayList<Deck>();
	private int roundsWon;
	public Player() {
//		this.name = name;
//		cardsArray = new ArrayList<Deck>();
	}
	public ArrayList<Deck> getCardsArray() {
		return cardsArray;
	}
	public int getRoundsWon() {
		return roundsWon;
	}
	public void addRound() {
		roundsWon++;
	}
	public void setCardsArray(ArrayList<Deck> cardsArray) {
		this.cardsArray = cardsArray;
	}

//	protected int roundsWons;
//	protected ArrayList<Card> cardsArray = new ArrayList<Card>();

	


//	public String getPlayerStatus() {
//		return playerStatus;
//	}

	
//	attributes of the player class
//	protected String playerStatus;	

}