public class Card {

	private Rank rank;
	private Suit suit;
	
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
	}
	
	//getRank() returns the rank of the given Card object.
	public Rank getRank() {
		return this.rank;
	}
	
	//getSuit() returns the suit of the given Card object.
	public Suit getSuit() {
		return this.suit;
	}
	
	public String toString() {
		return this.rank + " of " + this.suit;
	}
	
}