
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import Card.Rank;

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
	
	private int verifyHand() {
		int[] ranks = new int[13];
		int[] suits = new int[4];
		int sequence = 0;
		boolean equalSuits = false;
		
		for (Card c : this.hand) {
			ranks[c.getValue().ordinal()]++;
			suits[c.getSuit().ordinal()]++;
		}
		
		for (int rankFreq : ranks) {
			if (rankFreq == 0)
				sequence = 0;
			sequence++;
			
			if (sequence == 5) break;
		}
		
		for (int suitFreq : suits)
			if (suitFreq == 5)
				equalSuits = true;
		
		if (equalSuits) {
			if (sequence == 5) {
				if (ranks[Card.Rank.ACE.ordinal()] == 1)
					return 200;
				else
					return 100;
			}
			
			return 10;
		}
		
		if (sequence == 5)
			return 5;
		
		int pair = 0;
		int triple = 0;
		for (int i = 0; i < ranks.length; i++) {
			if (ranks[i] == 4)
				return 50;
			
			if (ranks[i] == 2) pair++;
			if (ranks[i] == 3) triple++;
		}
		
		if (triple == 1)
			if (pair == 1)
				return 20;
			else
				return 2;
		
		if (pair == 2)
			return 1;
		
		return 0;
	}
	
	public void receiveCredits(int credits) {
		this.pocket.winCredits();
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
