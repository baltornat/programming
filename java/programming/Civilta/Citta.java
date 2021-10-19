package it.ppalmisano.gennaio;

public class Citta{
	private String nome;
	private Risorsa risorsa;

	public Citta(String nome, Risorsa r){
		this.nome = nome;
		this.risorsa = r;
	}

	public int getPrezzoRisorsa(){
		return risorsa.getPrezzo();
	}

	public Risorsa produci(){
		return risorsa;
	}

	@Override
	public String toString(){
		return nome;
	}

	@Override
	public int hashCode(){
		return nome.length() * 569 + risorsa.hashCode();
	}

	@Override
	public boolean equals(Object x){
		if(!(x instanceof Citta))
			return false;
		else{
			Citta y = (Citta)x;
			return nome.equals(y.nome);
		}
	}
}
