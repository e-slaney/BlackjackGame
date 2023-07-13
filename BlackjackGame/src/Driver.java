import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.util.Scanner;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import javax.swing.BoxLayout;
import javax.swing.JButton;


public class Driver {

	public static void main(String[] args) {

		/*
		 * GUI Build
		 */
		
		boolean userBust;
		Scanner scanner = new Scanner(System.in);
		String input;
		//Active Game Loop	
		
		Blackjack game = new Blackjack(1000.00);
		GameFrame frame = new GameFrame(game);
		
		int playingGame = JOptionPane.showConfirmDialog(null, "Would you like to play Blackjack?", "Play Blackjack!", JOptionPane.YES_NO_OPTION);
		if(playingGame == JOptionPane.YES_OPTION) {
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
