
import java.util.Arrays;
import java.util.Collections;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 
 * @author Edylson T. & Donizeti Jr.
 * Classe representa o jogador de poker, manipulando seus
 * créditos, baralho e cartas em mão.
 *
 */
public class Player {
    private int maxHandSize;
	private ArrayList<Card> hand;
	private Pocket pocket;

	/*
	 * Construtor padrão, onde o player começa com 5 cartas em sua mão.
	 */
	public Player() {
		this(5);
	}

	/*
	 * Inicia a mão do jogador com n cartas.
	 */
	public Player(int handSize){
        this.maxHandSize = handSize;
		this.hand = new ArrayList<Card>(handSize);
		this.pocket = new Pocket();
	}

	/*
	 * Retorna o limite de cartas na mão.
	 */
    public int getMaxHandSize() {
        return this.maxHandSize;
    }

    /*
     * Aposta um número de créditos.
     */
	public void bet(int betValue) {
        this.pocket.wage(betValue);
	}
	
	/*
	 * Retorna o número de créditos do jogador.
	 */
	public int getCredits() {
		return this.pocket.getNCredits();
	}
	
	/*
	 * Verifica o numero de combinações na mão do jogador
	 * e retorna um valor a ser multiplicado como recompensa.
	 */
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
	
	/*
	 * Recebe créditos correspondente às combinações da sua mao.
	 * Caso não haja combinações, perde a quantidade de créditos apostada.
	 */
	public void receiveCredits() {
		int combNum = verifyHand();
		if (combNum == 0) {
			this.pocket.loseCredits();
		} else {
			this.pocket.winCredits(combNum);
		}
	}

	/*
	 * Retorna uma String contendo o visual das cartas em sua mão.
	 */
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

	/*
	 * Puxa uma carta do baralho.
	 */
	public Card pullCard(Stack<Card> deck) throws HandOverflowException {
        if (this.hand.size() == this.maxHandSize)
            throw new HandOverflowException("Limite de cartas em mão atingido. LADRÃO! LADRÃO!");

		Card pull = deck.pop();
        this.hand.add(pull);

        return pull;
	}

	/*
	 * Puxa quantidade n de cartas do baralho.
	 */
    public void pullCardsBatch(Stack<Card> deck, int n) {
        try {
            for (int i = 0; i < n; i++) {
                pullCard(deck);
            }
        } catch (HandOverflowException e) {
            System.out.println(e.getMessage());
        }
    }

    /*
     * Descarta uma carta em mão.
     */
	public Card dropCard(int cardPos) {
		return this.hand.remove(cardPos);
	}

	/*
	 * Descarta n cartas da mão do jogador pela sua;s posições.
	 */
    public void dropCardsBatch(String cardsPos) {
        Integer[] positions;

        if (!cardsPos.isEmpty()) {
            String[] str = cardsPos.split(" ");
            positions = new Integer[str.length];

            for (int i = 0; i < str.length; i++)
                positions[i] = new Integer(str[i]);

            Arrays.sort(positions, Collections.reverseOrder());

            for (Integer pos : positions)
                dropCard(pos.intValue());
        }
    }

    /*
     * Troca as cartas que serão substituídas.
     */
    public void switchCards(String cardsPos, Stack<Card> deck) {
        dropCardsBatch(cardsPos);
        pullCardsBatch(deck, cardsPos.split(" ").length);
    }
}
