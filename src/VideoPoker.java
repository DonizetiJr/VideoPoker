import java.util.Collections;
import java.util.Stack;

public class VideoPoker {

	/**
	* @author Edylson T. 5248962
	* Donizeti Jr. 9393882
	*/
	
    public static void main(String[] args) {
    	Stack<Card> deck = new Stack<Card>();
    	
    	for (Card.Suit s : Card.Suit.values()) {
    		for (Card.Rank r : Card.Rank.values()) {
    			deck.push(new Card(r, s));
    		}
    	}
    	
    	Collections.shuffle(deck);
    	
    	Pocket pocket = new Pocket();
    	
    	int aposta;
    	Card hand[] = new Card[5];
    	
    	do {
    		System.out.print("Digite o valor de sua aposta: ");
    		aposta = EntradaTeclado.leInt();
    		
    		
    	} while ();
    	
    	
    }
}
