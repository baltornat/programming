package it.ppalmisano.gennaio;

public class Risorsa{
	private String nome;
	private int prezzo;

	public Risorsa(String nome, int prezzo){
		this.nome = nome;
		this.prezzo = prezzo;
	}

	public int getPrezzo(){
		return prezzo;
	}

	@Override
	public String toString(){
		return nome;
	}

	@Override
	public int hashCode(){
		return nome.hashCode();
	}

	@Override
	public boolean equals(Object x){
		if(!(x instanceof Risorsa))
			return false;
		else{
			Risorsa y = (Risorsa)x;
			return nome.equals(y.nome);
		}
	}
}
