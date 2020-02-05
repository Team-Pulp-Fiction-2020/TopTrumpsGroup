package commandline;
import java.util.ArrayList;

public class Player {
	
//	attributes of the player class
	protected String playerStatus;

	public ArrayList<Card> getCardsArray() {
		return cardsArray;
	}

	public void setCardsArray(ArrayList<Card> cardsArray) {
		this.cardsArray = cardsArray;
	}

	protected int roundsWons;
	protected ArrayList<Card> cardsArray = new ArrayList<Card>();

	
	public Player() {
		
	}

	public String getPlayerStatus() {
		return playerStatus;
	}

	public int getRoundsWons() {
		return roundsWons;
	}

	public void addRound() {
		roundsWons++;
	}

}
