package commandline;

import java.sql.SQLException;

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


//		boolean writeGameLogsToFile = false; // Should we write game logs to file?
//		if (args[0].equalsIgnoreCase("true")) writeGameLogsToFile=true; // Command line selection
		
		// State
		boolean userWantsToQuit = false; // flag to check whether the user wants to quit the application
		
		// Loop until the user wants to exit the game
		while (!userWantsToQuit) {

			TopTrumpsModel model = new TopTrumpsModel();
			TopTrumpsController controller = new TopTrumpsController(model);
			controller.play();
			userWantsToQuit=true; // use this when the user wants to exit the game
			
		}


	}

}