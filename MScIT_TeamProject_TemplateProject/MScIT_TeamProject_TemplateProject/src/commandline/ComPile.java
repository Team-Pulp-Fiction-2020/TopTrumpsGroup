package commandline;
import java.util.ArrayList;

public class ComPile {
	// create arrayList for the cards
	ArrayList <Deck> comPile = new ArrayList<Deck>();
	
	// method to take in an arrayList and add it to the comPile arrayList
	public void addCards(ArrayList al) {
			comPile.addAll(al);
	}
	
	// method to remove cards from the comPile and return the comPileTemp
	// which is a copy of the comPile
	public ArrayList<Deck> removeCards (){
		ArrayList <Deck> comPileTemp = new ArrayList<Deck>();
		for(int i = 0; i<comPile.size(); i++) {
			comPileTemp.addAll(comPile);
			comPile.clear();
		}
		return comPileTemp;
	}

	public int getComPileSize() {
		return comPile.size();
	}

	public void setComPile(ArrayList<Deck> comPile) {
		this.comPile = comPile;
	}
	
}