
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Stack;

public class VideoPoker {

	/**
	* @author Edylson T. 5248962
	* Donizeti Jr. 9393882
	*/

    public static void main(String[] args) {
    	Stack<Card> deck = new Stack<Card>();
        Player player = new Player();
    	for (Card.Suit s : Card.Suit.values()) {
    		for (Card.Rank r : Card.Rank.values()) {
    			deck.push(new Card(r, s));
    		}
    	}
    	Collections.shuffle(deck);

        player.pullCardsBatch(deck, player.getMaxHandSize());
        System.out.println(player.showHand());

        while (true) {
            try {
                System.out.println("Digite as cartas que deseja trocar");
                String str = EntradaTeclado.leString();

                player.switchCards(str, deck);
                System.out.println(player.showHand());
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
