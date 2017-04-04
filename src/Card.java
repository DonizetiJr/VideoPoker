/**
* @author Edylson T. & Donizeti Jr.
*/
public class Card {
    protected enum Rank {
        DEUCE(" 2"), THREE(" 3"), FOUR(" 4"), FIVE(" 5"),
        SIX(" 6"), SEVEN(" 7"), EIGHT(" 8"), NINE(" 9"), TEN("10"),
        JACK(" J"), QUEEN(" Q"), KING(" K"), ACE(" A");

        private String symbol;

        Rank(String symb) {
            this.symbol = symb;
        }

        String getSymbol() {
            return this.symbol;
        }
    }

    protected enum Suit {
        HEARTS('♥'), DIAMONDS('♦'), SPADES('♠'), CLUBS('♣');

        private char symbol;

        Suit(char symb) {
            this.symbol = symb;
        }

        char getSymbol() {
            return this.symbol;
        }
    }

    private Rank rank;
    private Suit suit;

    public Card(Rank rank, Suit suit) {
        this.rank = rank;
        this.suit = suit;
    }

    public Rank getValue() {
        return this.rank;
    }

    public Suit getSuit() {
        return this.suit;
    }

    @Override
    public String toString() {
        String str = "";

        str += "+-------+\n";
        str += "| *     |\n";
        str += "|       |\n";
        str += "|  ..   |\n";
        str += "|       |\n";
        str += "|     * |\n";
        str += "+-------+\n";

        str = str.replace('*', this.suit.getSymbol());
        str = str.replace("..", this.rank.getSymbol());

        return str;
    }
}
