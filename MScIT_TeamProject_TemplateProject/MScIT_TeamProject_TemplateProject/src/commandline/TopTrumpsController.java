package commandline;

import java.sql.SQLException;
import java.util.Scanner;

public class TopTrumpsController {
	private TopTrumpsModel model;
	private TopTrumpsView view;

	public TopTrumpsController(TopTrumpsModel model) {
		this.model = model;
		this.view = new TopTrumpsView(model, this);
	}

	public void play() throws SQLException {
		Scanner scanner = new Scanner(System.in);
		int noPlayers = 0;
		
		view.choosePlayOrStats();
		int playerInput = scanner.nextInt();
		//address while statements
		while (!(playerInput == 1) && !(playerInput == 2)) {
			view.checkInput();
		}
		if (playerInput == 1) {
			view.printStats();
		}
		if (playerInput == 2) {
			view.choosePlayers();
			noPlayers = scanner.nextInt();
			//check
			while (!(noPlayers >= 2) && !(noPlayers <= 5)) {
				view.checkInput();
			}
			view.startGame();
			model.setNoOfPlayers(noPlayers);
		do {
				model.deal();
				view.playRound();
				if(model.getWinnerOfRound() == 0) {
					view.humanChooseCat();
					int category = scanner.nextInt();
					//check
					while(!(category>=1) && !(category<=5)) {
						view.checkInput();
					}
					model.setTrump(category);
				}
			}while (model.gameWon() == false);
		}
		else {
			model.aiPick(model.getPlayersArrayList().get(model.getWinnerOfRound()));
		}
		model.checkRound();
		if(model.getWinnerOfRound() == -1) {
			view.draw();
			model.setWinnerofRound(model.getPrevWinRound());
		}
		else if(model.getWinnerOfRound() == 0) {
			view.humanWin();
			model.setPrevWinRound(model.getWinnerOfRound());
		}
		else {
			view.AIWin();
			model.setPrevWinRound(model.getWinnerOfRound());
		}
	}
}
