//package commandline;
//import java.io.FileNotFoundException;
//import java.io.FileReader;
//import java.io.IOException;
//import java.util.Scanner;
////import java.util.Arrays;
//
//
//public class Card {
//	// Constructor including all the variables of the card
//	public Card(String name, int size, int speed, int range, int firepower, int cargo) {
//		this.name = name;
//		this.size = size;
//		this.speed = speed;
//		this.range = range;
//		this.firepower = firepower;
//		this.cargo = cargo;
//		
//		}
//
//	// Method to fill the ship Array of all 40 slots via fileIO upload
//	public static Card[] shipArrayFill() {
//		// Array of number of cards within the deck
//		Card shipArray[] = new Card[40];
//		// Integer for number of ships, used to cycle array later
//		int nShips = 0;
//		
//		// Opening filereader
//		FileReader fr = null;
//		try {
//			
//			// Reading the path to the file in question
//			fr = new FileReader("C:\\Users\\atrai\\TeamProject\\Workspace\\MScIT_TeamProject_TemplateProject\\MScIT_TeamProject_TemplateProject/TopTrumpsCsv.csv");			// Scanner to read through the file
//			Scanner s = new Scanner(fr);
//			// Loops until there are no more lines in the file
//			while(s.hasNextLine()) {
//				// Cycles through each line
//				String line = s.nextLine();
//				// Splits via comma (file is csv, each field deliminated by comma)
//				String[] shipData = line.split(",");
//				// Putting the ship details into the newly created array
//				String shipName = shipData[0];
//				int shipSize = Integer.parseInt(shipData[1]);
//				int shipSpeed = Integer.parseInt(shipData[2]);
//				int shipRange = Integer.parseInt(shipData[3]);
//				int shipFirepower = Integer.parseInt(shipData[4]);
//				int shipCargo = Integer.parseInt(shipData[5]);
//				// Cycles array, puts the variables of the ship into the actual array
//				shipArray[nShips++] = new Card(shipName, shipSize, shipSpeed, shipRange, shipFirepower, shipCargo);
//				
//				
//			}
//			// Catches exception if file isn't found
//		}catch(FileNotFoundException e) {
//			e.printStackTrace();
//			// Close filereader
//		}finally {
//			try {
//				fr.close();
//				// Displays error message/details if ioexception
//			}catch(IOException e) {
//				e.printStackTrace();
//			}
//		}
//		// If statement to print each ship in the array
//		if(nShips>0) {
//			for(int i=0; i<nShips; i++) {
//			}
//		}
//		return shipArray;
//		
//		
//	
//	}
//	// ToString to format and print the array
//	public String toString() {
//		return "Name: " + name + "\n Size: " + size + "\n Speed: " + speed + "\n Range: " + range + "\n Firepower: " +  firepower + "\n Cargo: " + cargo;
//		
//	}
//	// Global variables
//	String name;
//	int size;
//	int speed;
//	int range;
//	int firepower;
//	int cargo;
//	
//	
//	public String getName() {
//		return name;
//	}
//
//	public int getSize() {
//		return size;
//	}
//
//	public int getSpeed() {
//		return speed;
//	}
//
//	public int getRange() {
//		return range;
//	}
//
//	public int getFirepower() {
//		return firepower;
//	}
//
//	public int getCargo() {
//		return cargo;
//	}
//	
//	
//
//}
