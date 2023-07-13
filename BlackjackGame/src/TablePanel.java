


import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridLayout;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class TablePanel extends JPanel {
	
	JLabel dealerScore;
	JLabel userScore;
	CardPanel dealerCards;
	CardPanel userCards;
	Blackjack blackjack;
	
	public TablePanel(Blackjack blackjack) {
		
		this.setLayout(new GridLayout(4, 1));
		this.blackjack = blackjack;

	}
	
	public void addCardsToTable() {
		
		dealerScore = new JLabel();
		dealerScore.setText("Dealer: ?");
		dealerScore.setHorizontalAlignment(JLabel.CENTER);
		dealerScore.setForeground(Color.white);
		
		userScore = new JLabel();
		userScore.setText("You: " + blackjack.getBestHand(blackjack.getUserHand()));
		userScore.setHorizontalAlignment(JLabel.CENTER);
		userScore.setForeground(Color.white);

		userCards = new CardPanel(CardPanel.Hand.USER, blackjack);
		userCards.setBackground((new Color(0, 0, 0, 0)));
		
		//We show only one dealer card.
		
		dealerCards = new CardPanel(CardPanel.Hand.HOUSE, blackjack);
		dealerCards.setBackground((new Color(0, 0, 0, 0)));
		
		this.userCards.setOpaque(false);
		this.dealerCards.setOpaque(false);
		
		this.add(dealerScore);
		this.add(dealerCards);
		this.add(userCards);
		this.add(userScore);
		
	}
	
	public void updateTable() {
		//Dealer score remains unchanged (unless the game is over).
		
		userScore.setText("You: " + blackjack.getBestHand(blackjack.getUserHand()));
		
		userCards.addCard(blackjack.getUserHand().get(blackjack.getUserHand().size()-1));
	
	}
	
	@Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        
		Graphics2D g2D = (Graphics2D) g;
		
        GradientPaint gradient = new GradientPaint(this.getParent().getWidth()/2, this.getParent().getHeight() / 10, new Color(0x01330d), 
        		this.getParent().getWidth()/2, this.getParent().getHeight() / 2 + 180, new Color(0x015916));

        g2D.setPaint(gradient);
        
        g2D.fillRoundRect(20, this.getParent().getHeight() / 10, this.getParent().getWidth()/2 + 290, this.getParent().getHeight()/2 + 235, 35, 35);
        
        g2D.setPaint(Color.orange);
        for (int i = 0; i < 2; i++) {
            g2D.drawRoundRect(20 + i, this.getParent().getHeight() / 10 + i, this.getParent().getWidth()/2 + 290 - 2 * i, this.getParent().getHeight()/2 + 235 - 2 * i, 35, 35);
        }

        
    }
	
	public void showHouseHand() {
		this.remove(dealerCards);
		
		dealerCards = new CardPanel(CardPanel.Hand.HOUSE_END, blackjack);
		dealerCards.setBackground(new Color(0, 0, 0, 0));
		dealerCards.setOpaque(false);
		dealerScore.setText("Dealer: " + blackjack.getBestHand(blackjack.getHouseHand()));
		
		this.add(dealerCards, 1);
		
	}
	
}
