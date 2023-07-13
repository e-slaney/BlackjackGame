


import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class GameFrame extends JFrame implements ActionListener{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	TablePanel gamePanel;
	ChoicePanel choicePanel;
	Blackjack blackjack;
	
	public GameFrame(Blackjack blackjack) {
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(1400, 840);
		this.setLayout(new BorderLayout());
		this.setResizable(false);
		this.blackjack = blackjack;
		
		gamePanel = new TablePanel(blackjack);
		gamePanel.setPreferredSize(new Dimension((3 * this.getWidth())/4-20, this.getHeight()));
		gamePanel.setBackground(Color.GRAY);
		
		choicePanel = new ChoicePanel(blackjack);
		choicePanel.setPreferredSize(new Dimension(this.getWidth()/4, this.getHeight()));
		choicePanel.setBackground(new Color(0x5c0005));
		
		choicePanel.hitButton.addActionListener(this);
		choicePanel.standButton.addActionListener(this);
		choicePanel.playButton.addActionListener(this);
		choicePanel.interior.setOpaque(false);
		
		JPanel topBorder = new JPanel();
		topBorder.setBackground(new Color(0x4a2511));
		JPanel leftBorder = new JPanel();
		leftBorder.setBackground(new Color(0x4a2511));
		JPanel rightBorder = new JPanel();
		rightBorder.setBackground(new Color(0x4a2511));
		JPanel bottomBorder = new JPanel();
		bottomBorder.setBackground(new Color(0x4a2511));

		JPanel interiorPanel = new JPanel();
		
		this.add(topBorder, BorderLayout.NORTH);
		this.add(leftBorder, BorderLayout.WEST);
		this.add(rightBorder, BorderLayout.EAST);
		this.add(bottomBorder, BorderLayout.SOUTH);

		
		interiorPanel.setLayout(new BorderLayout());
		interiorPanel.add(gamePanel, BorderLayout.WEST);
		interiorPanel.add(choicePanel, BorderLayout.EAST);
		
		this.add(interiorPanel);
		
		this.setVisible(true);
		
	}
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// If the hit button is selected, hit the user's deck.
		
		if(e.getSource() == choicePanel.hitButton) {
			blackjack.hit();
			gamePanel.updateTable();
			choicePanel.interior.setOpaque(false);
			if(blackjack.checkBust(blackjack.getUserHand())) {
				JOptionPane.showMessageDialog(null, "You busted, you lose");
				choicePanel.hitButton.setEnabled(false);
				choicePanel.standButton.setEnabled(false);
				choicePanel.playButton.setEnabled(true);

			}
		}

		if(e.getSource() == choicePanel.standButton) {
			//If we stand, we should change the house's cards to show its hand.
			if(blackjack.stand()) {
				//If true, this means we won! we should update the score on the table and lock the other buttons.
				gamePanel.showHouseHand();
				JOptionPane.showMessageDialog(null, "Congratulations! You've won $" + blackjack.getWager());
			} else {
				JOptionPane.showMessageDialog(null, "You lost! You lost $" + blackjack.getWager());
				gamePanel.showHouseHand();
			}
			choicePanel.hitButton.setEnabled(false);
			choicePanel.standButton.setEnabled(false);
			choicePanel.playButton.setEnabled(true);
		}
		
		if(e.getSource() == choicePanel.playButton) {
			choicePanel.hitButton.setEnabled(true);
			choicePanel.standButton.setEnabled(true);
			choicePanel.playButton.setEnabled(false);
			playGame();
		}
		
	}	
	
	public void playGame() {
		gamePanel.remove(gamePanel.dealerScore);
		gamePanel.remove(gamePanel.dealerCards);
		gamePanel.remove(gamePanel.userCards);
		gamePanel.remove(gamePanel.userScore);
		blackjack.reset();
		int playingGame = JOptionPane.showConfirmDialog(null, "Would you like to play Blackjack?", "Play Blackjack!", JOptionPane.YES_NO_OPTION);
		if(playingGame == JOptionPane.YES_OPTION) {
			try {
				String amt = JOptionPane.showInputDialog(null, "Please input the amount of money you would like to wager");
				if(amt == null) {
					//If they cancel, just break and lock buttons.
					//lock buttons
				}
				blackjack.setWager(Double.parseDouble(amt));
				this.gamePanel.addCardsToTable();
				this.choicePanel.updateCash();
			} catch (Exception e) {
				JOptionPane.showMessageDialog(null, "You must use a valid input value.");
			}
			
			if(blackjack.getUserHand().size() == 2 && blackjack.getBestHand(blackjack.getUserHand()) == 21) {
				blackjack.stand();
				JOptionPane.showMessageDialog(null, "You have a true Blackjack! Congrats! You Win!");
				this.choicePanel.updateCash();
			}
			
		} else {
			this.choicePanel.hitButton.setEnabled(false);
			this.choicePanel.standButton.setEnabled(false);
			this.choicePanel.playButton.setEnabled(true);
		}
	}
	
}
