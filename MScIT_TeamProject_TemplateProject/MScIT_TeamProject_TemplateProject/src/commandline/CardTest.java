package commandline;

public class CardTest {
	public static void main(String[] args) {
		Card card;
//		Card shipArray[] = new Card[40];
		Card shipArray[] = Card.shipArrayFill();
		Card.shipArrayFill();
		for(int i = 0; i < shipArray.length; i++) {
			System.out.println(shipArray[i]);
		}
	}

}
