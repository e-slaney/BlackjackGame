import java.util.ArrayList;

public class Blackjack {

	private Deck deck;
	private double userMoney;
	private ArrayList<Card> userHand = new ArrayList<Card>();
	private ArrayList<Card> houseHand = new ArrayList<Card>();
	private double currWager;

	//Blackjack constructor instantiates a game board with a deck, user hand, dealer hand, and takes in an
	//argument for the amount of money the user has to spend.
	public Blackjack(double startingCash) {
		this.deck = new Deck();
		this.deck.shuffle();
		this.userMoney = startingCash;
		this.userHand.add(this.deck.dealCard());
		this.userHand.add(this.deck.dealCard());
		this.houseHand.add(this.deck.dealCard());
		this.houseHand.add(this.deck.dealCard());
		this.currWager = 0;
	}

	public void setWager(double wager) {
		this.currWager = wager;
		if(this.userMoney - currWager < 0) {
			System.out.println("Cannot wager more money than you have!");
			throw new IllegalArgumentException();
		} else {
			this.userMoney-=currWager;
		}
	}

	public void hit() {
		this.userHand.add(this.deck.dealCard());
		int houseBestHand = getBestHand(houseHand);
		int userBestHand = getBestHand(userHand);
	}

	//Returns true if you won, false if you lost.
	public boolean stand() {
		int userBestHand = getBestHand(userHand);
		int houseBestHand = getBestHand(houseHand);
		while(houseBestHand < 17) {
			houseHand.add(this.deck.dealCard());
			houseBestHand = getBestHand(houseHand);
		}
		
		if(userBestHand > houseBestHand || checkBust(this.houseHand) || (userBestHand == 21 && this.userHand.size() == 2)) {
			this.userMoney+=currWager*2;
			return true;
		} else {
			return false;
		}
	}
	
	public double getWager() {
		return this.currWager;
	}

	public int getBestHand(ArrayList<Card> hand) {
		int count = 0;
		int altCount = 0;
		//Counts the value of each card in a given user's hand, creates two values for whether an ACE is present
		for(Card curr: hand) {
			switch (curr.getRank()) {
			case ACE: 
				count += 1;
				altCount += 11;
				break;
			case TWO:
				count += 2;
				altCount += 2;
				break;
			case THREE:
				count += 3;
				altCount += 3;
				break;
			case FOUR:
				count += 4;
				altCount += 4;
				break;
			case FIVE:
				count += 5;
				altCount += 5;
				break;
			case SIX:
				count += 6;
				altCount += 6;
				break;
			case SEVEN:
				count += 7;
				altCount += 7;
				break;
			case EIGHT:
				count += 8;
				altCount += 8;
				break;
			case NINE:
				count += 9;
				altCount += 9;
				break;
			case TEN:
				count += 10;
				altCount += 10;
				break;
			case JACK:
				count += 10;
				altCount += 10;
				break;
			case QUEEN:
				count += 10;
				altCount += 10;
				break;
			case KING:
				count += 10;
				altCount += 10;
				break;
			}
		}
		
		//Takes care of if an ace is a high or low
		if(count > 21 && altCount > 21) {
			return count > altCount ? count : altCount;
		} else if(count > 21 && altCount <= 21) {
			return altCount;
		} else if(count <= 21 && altCount > 21) {
			return count;
		} else {
			return count > altCount ? count : altCount;
		}


	}

	public boolean checkBust(ArrayList<Card> hand) {
		int count = 0;
		for(Card curr: hand) {
			switch (curr.getRank()) {
			case ACE: 
				count += 1;
				break;
			case TWO:
				count += 2;
				break;
			case THREE:
				count += 3;
				break;
			case FOUR:
				count += 4;
				break;
			case FIVE:
				count += 5;
				break;
			case SIX:
				count += 6;
				break;
			case SEVEN:
				count += 7;
				break;
			case EIGHT:
				count += 8;
				break;
			case NINE:
				count += 9;
				break;
			case TEN:
				count += 10;
				break;
			case JACK:
				count += 10;
				break;
			case QUEEN:
				count += 10;
				break;
			case KING:
				count += 10;
				break;
			}
		}

		return count > 21;

	}

	public ArrayList<Card> getUserHand() {
		return this.userHand;
	}
	
	public ArrayList<Card> getHouseHand() {
		return this.houseHand;
	}

	public void printUserHand() {
		System.out.println("Your hand:" + this.userHand);
	}

	public void printHouseHand() {
		System.out.println("House hand:" + this.houseHand);
	}

	public int deckSize() {
		return this.deck.getDeckSize();
	}

	public double getUserMoney() {
		return this.userMoney;
	}


	public void reset() {
		this.deck = new Deck();
		this.deck.shuffle();
		this.userHand = new ArrayList<Card>();
		this.houseHand = new ArrayList<Card>();

		this.userHand.add(this.deck.dealCard());
		this.userHand.add(this.deck.dealCard());
		this.houseHand.add(this.deck.dealCard());
		this.houseHand.add(this.deck.dealCard());

	}


}