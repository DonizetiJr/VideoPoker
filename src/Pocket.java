public class Pocket {

/**
* @author Edylson T. & Donizeti Jr.
* Esta classe é usada para o gerenciamento dos
* créditos que cada jogador possui ou aposta.
*/

	private int ncredits;
	private int creditsWagered;

	/**
	 * Cada jogo inicia com o jogador recebendo uma quantidade fixa de créditos
	 * (200 créditos).
	 */
    public Pocket() {
    	this.ncredits = 200;
    	this.creditsWagered = 0;
    }

    public int getNCredits() {
    	return this.ncredits;
    }

    public int getCreditsWagered() {
    	return this.creditsWagered;
    }

    /**
     * Cada rodada inicia com o jogador apostando um certo número de créditos,
     * maior que zero e menor ou igual ao número de créditos que possui.
     * @throws IllegalArgumentException Caso a aposta seja inválida ou exceda a
     * quantidade que o jogador já possui.
     */
    public void wage(int credits) {
    	if (credits  < 0) {
    		throw new IllegalArgumentException("Número de créditos inválido.");

    	} else if(credits > this.ncredits) {
    		throw new IllegalArgumentException("Número de cŕeditos maior excedido.");

    	} else {
    		this.creditsWagered = credits;
    	}
    }

    /**
     * Através de combinações das cartas, o jogador pode multiplicar por
     * diferentes valores a quantidade de créditos apostada.
     * @param arrangement representa o tipo de combinação que premiará o jogador
     */
    public void winCredits(int arrangement) {
    	this.ncredits += this.creditsWagered * arrangement;
    }

    public void loseCredits(int credits) {
    	this.ncredits -= credits;
    }
}
