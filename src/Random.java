import java.util.Calendar;

public class Random {
	private long p = 2147483648l;
	private long m = 843314861;
	private long a = 453816693;
	
	private long xi = 1023;
	
	// Construtor que usa uma semente aleatória, adquerida usando o método Calendar.getTimeInMillis().
	public Random() {
		xi = Calendar.getInstance().getTimeInMillis();
	}
	
	//Construtor que permite criar o gerador, especificando o valor inicial da semente.
	public Random(int k) {
		xi = k;
	}
	
	// Permite alterar a semente de geração de números aleatórios. 
	public void setSemente(int seed) {
		xi = seed;
	}
	
	// Retorna um valor inteiro no intervalo (0,max[
	public int getIntRand(int max) {	
		double tmp = max * getRand();
		return (int)tmp;
	}
	
	// Retorna um número aleatório no intervalo (0,1[
	public double getRand() {
		
		xi = (a + m*xi) % p;
		double d = xi;
		return d / p;
	}
}
