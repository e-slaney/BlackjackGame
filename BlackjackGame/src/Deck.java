import java.util.Iterator;
import java.util.ArrayList;

public class Deck implements Iterable<Card>{
	
	//Deck is a linear array of 52 cards.
	private ArrayList<Card> deck = new ArrayList<Card>();
	
	//Deck constructor takes no parameters and instantiates a deck of 52 cards
	//by iterating over the card enums.
	public Deck() {
		
		for(Card.Suit suit: Card.Suit.values()) {
			for(Card.Rank rank: Card.Rank.values()) {
				this.deck.add(new Card(rank, suit));
			}
		}
		
	}
	
	public void shuffle() {
		int currIndex = this.deck.size(), randomIndex;
		Card temp;
		
		while(currIndex != 0) {
			randomIndex = (int) Math.floor(Math.random() *  currIndex);
			currIndex--;
			
			temp = this.deck.get(currIndex);
			this.deck.set(currIndex, this.deck.get(randomIndex));
			this.deck.set(randomIndex, temp);
		}
	}
	
	public Card dealCard() {
		return this.deck.remove(0);
	}
	
	public class myDeckIterator implements Iterator<Card> {
		
		private int count = 0;
		
		public boolean hasNext() {
			
			return count < 52;
			
		}
		
		public Card next() {
						
			return deck.get(count);
			
		}
		
	}
	
	public Iterator<Card> iterator() {
		
		return new myDeckIterator();
	
	}
	
	public int getDeckSize() {
		return this.deck.size();
	}
	
	public String toString() {
		
		return this.deck.toString();
		
	}
	
}