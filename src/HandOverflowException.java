/**
 * 
 * @author Edylson T. & Donizeti Jr.
 *
 */

/*
 * Exception personalizada para quando o jogador excede a quantidade de cartas na mão.
 */
public class HandOverflowException extends Exception {
    public HandOverflowException() {
        super();
    }

    public HandOverflowException(String message) {
        super(message);
    }
}
