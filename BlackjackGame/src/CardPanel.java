import java.awt.FlowLayout;
import java.net.URL;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class CardPanel extends JPanel {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Blackjack blackjack;
	
	public enum Hand {
		HOUSE,
		USER,
		HOUSE_END
	}
	
	ArrayList<JLabel> cards;
	
	public CardPanel(Hand hand, Blackjack blackjack) {
		this.cards = new ArrayList<>();
		this.setBlackjack(blackjack);
		
		if(hand == Hand.HOUSE) {
			for(int i = 0; i < blackjack.getHouseHand().size(); i++) {
				if(i == 0) {
					JLabel tempLabel = new JLabel();
					URL imageFile = CardPanel.class.getResource(blackjack.getHouseHand().get(i).getPath());
					tempLabel.setIcon(new ImageIcon(imageFile));
					cards.add(tempLabel);
				} else {
					JLabel tempLabel = new JLabel();
					URL imageFile = CardPanel.class.getResource("card back red.png");
					tempLabel.setIcon(new ImageIcon(imageFile));
					cards.add(tempLabel);
				}
			}
		} else if(hand == Hand.USER){
			for(Card card: blackjack.getUserHand()) {
				JLabel tempLabel = new JLabel();
				URL imageFile = CardPanel.class.getResource(card.getPath());
				tempLabel.setIcon(new ImageIcon(imageFile));
				cards.add(tempLabel);
			}
		} else {
			for(Card card: blackjack.getHouseHand()) {
				JLabel tempLabel = new JLabel();
				URL imageFile = CardPanel.class.getResource(card.getPath());
				tempLabel.setIcon(new ImageIcon(imageFile));
				cards.add(tempLabel);
			}
		}
		this.setLayout(new FlowLayout());
		
		for(int i = 0; i < cards.size(); i++) {
			this.add(cards.get(i));
		}
		
	}
	
	
	public void addCard(Card card) {
		JLabel label = new JLabel();
		label.setIcon(new ImageIcon(getClass().getClassLoader().getResource(card.getPath())));
		cards.add(label);
		this.add(label);
		this.setOpaque(false);
	}


	public Blackjack getBlackjack() {
		return blackjack;
	}


	public void setBlackjack(Blackjack blackjack) {
		this.blackjack = blackjack;
	}

}
