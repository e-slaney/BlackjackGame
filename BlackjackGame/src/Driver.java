import javax.swing.JOptionPane;

public class Driver {

	public static void main(String[] args) {

		/*
		 * GUI Build
		 */
		
		Blackjack game = new Blackjack(10000.00);
		GameFrame frame = new GameFrame(game);
		
		int playingGame = JOptionPane.showConfirmDialog(null, "Would you like to play Blackjack?", "Play Blackjack!", JOptionPane.YES_NO_OPTION);
		if(playingGame == JOptionPane.YES_OPTION) {
			while(true) {
				try {
					String amt = JOptionPane.showInputDialog(null, "Please input the amount of money you would like to wager");
					if(amt == null) {
						//If they cancel, just break and lock buttons.
						//lock buttons
					}
					game.setWager(Double.parseDouble(amt));
					frame.gamePanel.addCardsToTable();
					frame.choicePanel.updateCash();
				} catch (Exception e) {
					JOptionPane.showMessageDialog(null, "You must use a valid input value.");
					continue;
				}
				break;
			}
			
			if(game.getUserHand().size() == 2 && game.getBestHand(game.getUserHand()) == 21) {
				game.stand();
				JOptionPane.showMessageDialog(null, "You have a true Blackjack! Congrats! You Win!");
				frame.choicePanel.updateCash();
			}
			
		} else {
			frame.choicePanel.hitButton.setEnabled(false);
			frame.choicePanel.standButton.setEnabled(false);
			frame.choicePanel.playButton.setEnabled(true);
		}
	}

}
