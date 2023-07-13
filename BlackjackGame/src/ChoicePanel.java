


import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridLayout;



import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class ChoicePanel extends JPanel{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	JButton hitButton;
	JButton standButton;
	JButton playButton;
	JLabel cashLabel;
	JLabel wageredLabel;
	Blackjack blackjack;
	JPanel interior;
	
	public ChoicePanel(Blackjack blackjack) {
				
		this.blackjack = blackjack;
		this.setLayout(new FlowLayout());
		
		interior = new JPanel();
		interior.setLayout(new GridLayout(6,1, 10, 10));
		hitButton = new JButton("   HIT!   ");
		standButton = new JButton("   STAND!   ");
		hitButton.setFocusable(false);
		standButton.setFocusable(false);
		interior.setBackground(new Color(0, 0, 0, 0));
		
		cashLabel = new JLabel();
		cashLabel.setText("   Remaining Cash: $" + blackjack.getUserMoney() + "   ");	
		cashLabel.setForeground(Color.white);
		
		wageredLabel = new JLabel();
		wageredLabel.setText("   Amount Wagered: $" + blackjack.getWager());
		wageredLabel.setForeground(Color.white);
		
		playButton = new JButton("   Play New Game!");
		playButton.setEnabled(false);
		playButton.setFocusable(false);
				
		hitButton.setPreferredSize(new Dimension(35, 70));
		interior.add(new JLabel());
		interior.add(cashLabel);
		interior.add(hitButton);
		interior.add(standButton);
		interior.add(wageredLabel);
		interior.add(playButton);
		
		this.add(interior);
		
		
	}
	
	public void updateCash() {
		cashLabel.setText("    Remaining Cash: $" + blackjack.getUserMoney() + "   ");
		wageredLabel.setText("   Amount Wagered: $" + blackjack.getWager() + "   ");
	}
	
	@Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        
		Graphics2D g2D = (Graphics2D) g;
		
        GradientPaint gradient = new GradientPaint(this.getParent().getWidth()/2, 0, new Color(0x660000), 
        		this.getParent().getWidth()/2, this.getParent().getHeight(), new Color(0x360102));

        g2D.setPaint(gradient);
        
        g2D.fillRect(0, 0, this.getParent().getWidth(), this.getParent().getHeight());
        
    }
	
}
