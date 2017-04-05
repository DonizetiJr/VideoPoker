
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Player {
    private int maxHandSize;
	private ArrayList<Card> hand;
	private Pocket pocket;

	public Player() {
		this(5);
	}

	public Player(int handSize){
        this.maxHandSize = handSize;
		this.hand = new ArrayList<Card>(handSize);
		this.pocket = new Pocket();
	}

    public int getMaxHandSize() {
        return this.maxHandSize;
    }

	public void bet(int betValue) {
        this.pocket.wage(betValue);
	}

	public String showHand() {
        String r = "";
        String[][] str = new String[this.hand.size()][];

        // Break all the cards into lines and group them (horizontally)
        // in a single string
        for (int i = 0; i < this.hand.size(); i++ ) {
            str[i] = this.hand.get(i).toString().split("\\n");
        }

        for (int i = 0; i < this.hand.size(); i++) {
            r += i;
            r += "          ";
        }

        r += "\n";

        // str[0].length = Number of lines
        for (int i = 0; i < str[0].length; i++) {
            for (int j = 0; j < this.hand.size(); j++) {
              	r += str[j][i];
            }

            r += '\n';
        }

        r += '\n';

        return r;
	}

	public Card pullCard(Stack<Card> deck) throws HandOverflowException {
        if (this.hand.size() == this.maxHandSize)
            throw new HandOverflowException("Limite de cartas em mão atingido. LADRÃO! LADRÃO!");

		Card pull = deck.pop();
        this.hand.add(pull);

        return pull;
	}

    public void pullCardsBatch(Stack<Card> deck, int n) {
        try {
            for (int i = 0; i < n; i++) {
                pullCard(deck);
            }
        } catch (HandOverflowException e) {
            System.out.println(e.getMessage());
        }
    }

	public Card dropCard(int cardPos) {
		return this.hand.remove(cardPos);
	}

}
