import java.util.Iterator;

public class Deck implements Iterable<Card>{
	
	//Deck is a linear array of 52 cards.
	private Card[] deck = new Card[52];
	
	//Deck constructor takes no parameters and instantiates a deck of 52 cards
	//by iterating over the card enums.
	public Deck() {
		
		int i = 0;
		for(Card.Suit suit: Card.Suit.values()) {
			for(Card.Rank rank: Card.Rank.values()) {
				deck[i++] = new Card(rank, suit);
			}
		}
		
	}
	
	public void shuffle() {
		
	}
	
	public class myDeckIterator implements Iterator<Card> {
		
		private int count = 0;
		
		public boolean hasNext() {
			
			return count < 52;
			
		}
		
		public Card next() {
						
			return deck[count++];
			
		}
		
	}
	
	public Iterator<Card> iterator() {
		
		return new myDeckIterator();
	
	}
	
	public String toString() {
		
		return this.deck.toString();
		
	}
	
}