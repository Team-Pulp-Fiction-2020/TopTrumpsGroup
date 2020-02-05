package commandline;
import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DatabaseConnection {
//variables declared for data retrieved from database
 private int gamesPlayed = 0;
 private int computerWins = 0;
 private int humanWins = 0;
 private int avgDraws = 0;
 private int longestGame = 0;

public DatabaseConnection() throws SQLException {
	
  //load the JDBC driver
  try {
   Class.forName("org.postgresql.Driver");

  } catch (ClassNotFoundException e) {
   System.out.println(" Could not find JBDC driver.");
   e.printStackTrace();
   return;
  }
  // try catch exception
  //the driver is loaded...
  System.out.println("Postgresql Driver found.");
  //proceed with a database connection
  Connection connection = null;
  // connect to the yacata.dcs.gla.ac.uk server, on port:5432
  
  //list of sql statements for querying the database
  String sql1 = "SELECT COUNT(GameID) AS Total_No_Games FROM Games;";
  String sql2 = "SELECT COUNT (Winner) AS Computer_Wins FROM Games WHERE Winner > 0;";
  String sql3 = "SELECT COUNT (Winner) AS Human_Wins FROM Games WHERE Winner = 0;";
  String sql4 = "SELECT AVG(Draws) AS Avg_No_Draws FROM Games;";
  String sql5 = "SELECT MAX(no_of_rounds) AS Top_No_Rounds FROM Games;";


  try {
   connection = DriverManager.getConnection("jdbc:postgresql://yacata.dcs.gla.ac.uk:5432/",
    "m_19_2474073k", "2474073k");
  } catch (SQLException e) {
   System.out.println("Connection failed!");
   e.printStackTrace();
   return;
  }
  //try catch exception
  //connection to the database is done!

  if (connection != null) {
   try {
    System.out.println("Controlling your database!");
    
    //sql statements created and executed, results returned and variables set -
    //one for each sql statement
    Statement statement1 = connection.createStatement();
    ResultSet resultGamesPlayed = statement1.executeQuery(sql1);
    while(resultGamesPlayed.next()) {
    	gamesPlayed = resultGamesPlayed.getInt(1);
    }
    Statement statement2 = connection.createStatement();
    ResultSet resultComputerWins = statement2.executeQuery(sql2);
    while(resultComputerWins.next()) {
        computerWins = resultComputerWins.getInt(2);
    }
    Statement statement3 = connection.createStatement();
    ResultSet resultHumanWins = statement3.executeQuery(sql3);
    while(resultHumanWins.next()) {
        humanWins = resultHumanWins.getInt(2);
    }
    Statement statement4 = connection.createStatement();
    ResultSet resultAvgDraws = statement4.executeQuery(sql4);
    while(resultAvgDraws.next()) {
        avgDraws = resultAvgDraws.getInt(3);
    }
    Statement statement5 = connection.createStatement();
    ResultSet resultLongestGame = statement5.executeQuery(sql5);
    while(resultLongestGame.next()) {
        computerWins = resultLongestGame.getInt(4);
    }
 
    //do not forget to close the connection to your database!

    connection.close();

   } catch (SQLException e) {
    e.printStackTrace();
   } // try catch exception
  } else {
   System.out.println("Failed to establish connection.");
  }
  //if-else
  
 }
	//getters so that other parts of the system can retrieve the data
	public int getGamesPlayed() {
		return gamesPlayed;
	}
	public int getComputerWins() {
		return computerWins;
	}
	public int getHumanWins() {
		return humanWins;
	}
	public int getAvgDraws() {
		return avgDraws;
	}
	public int getLongestGame() {
		return longestGame;
	}

}