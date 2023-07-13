public class Card {

	private Rank rank;
	private Suit suit;
	private String path;

	//Enum for card rank.
	public enum Rank {
		ACE,
		TWO,
		THREE,
		FOUR,
		FIVE,
		SIX,
		SEVEN,
		EIGHT,
		NINE,
		TEN,
		JACK,
		QUEEN,
		KING
	}

	//Enum for card suit.
	public enum Suit {
		HEARTS,
		SPADES,
		CLUBS,
		DIAMONDS
	}

	//Card constructor instantiates a Card object by taking two parameters of type
	//enum, rank and suit.
	public Card(Rank rank, Suit suit) {
		this.rank = rank;
		this.suit = suit;
		String num = "";
		switch(rank) {
		case ACE:
			num = "ace";
			break;
		case TWO:
			num = "2";
			break;
		case THREE:
			num = "3";
			break;
		case FOUR:
			num = "4";
			break;
		case FIVE:
			num = "5";
			break;
		case SIX:
			num = "6";
			break;
		case SEVEN:
			num = "7";
			break;
		case EIGHT:
			num = "8";
			break;
		case NINE:
			num = "9";
			break;
		case TEN:
			num = "10";
			break;
		case JACK:
			num = "jack";
			break;
		case QUEEN:
			num = "queen";
			break;
		case KING:
			num = "king";
			break;
		default:
			break;
		}

		this.path = "" + num + "_of_" + this.suit.toString().toLowerCase() + ".png";

	}

	//getRank() returns the rank of the given Card object.
	public Rank getRank() {
		return this.rank;
	}

	//getSuit() returns the suit of the given Card object.
	public Suit getSuit() {
		return this.suit;
	}
	
	public String getPath() {
		return this.path;
	}

	public String toString() {
		return this.rank + " of " + this.suit;
	}

}