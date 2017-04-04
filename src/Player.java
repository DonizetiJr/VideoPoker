import java.util.Stack;

public class Player {
	private List<Card> hand;
	private Pocket pocket;
	
	public Player() {
		this(5);
	}
	
	public Player(int handSize){
		this.hand = new Card[handSize];
		this.pocket = new Pocket();
	}
	
	public int bet(int betValue) {
		
	}
	
	public String showHand() {
		
	}
	
	public Card pullCard(Stack<Card> deck) {
		deck.pop();
	}
	
	public Card dropCard(int cardPos) {
		return hand[cardPos];
	}
	
}
