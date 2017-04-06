
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Stack;

public class VideoPoker {

	/**
	* @author Edylson T. 5248962
	* Donizeti Jr. 9393882
	*/

	/**
	 * A main roda um jogo de poker, multiplicando a aposta
	 * do jogador dependendo do número de combinações conquistada.
	 */

	public static void main(String[] args) {
		// A Stack representa um baralho de cartas
		Stack<Card> deck = new Stack<Card>();
		
        Player player = new Player();
    	for (Card.Suit s : Card.Suit.values()) {
    		for (Card.Rank r : Card.Rank.values()) {
    			deck.push(new Card(r, s));
    		}
    	}
    	Collections.shuffle(deck);

    	// Loop do jogo, que ocorre enquanto o jogador possuir créditos
    	// para apostar ou acabarem as cartas do baralho.
        while (player.getCredits() > 0 && deck.size() > 0) {
            try {
            	player.pullCardsBatch(deck, player.getMaxHandSize());
                System.out.println(player.showHand());
            	
            	System.out.println("Digite sua aposta:");
            	int aposta = EntradaTeclado.leInt();
            	player.bet(aposta);
            	
                System.out.println("Digite as cartas que deseja trocar");
                String str = EntradaTeclado.leString();

                player.switchCards(str, deck);
                System.out.println(player.showHand());
                
                
                player.receiveCredits();
                System.out.println("Dinheiro: " + player.getCredits());
                
                
                player.dropCardsBatch("0 1 2 3 4");
                
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
