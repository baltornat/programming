package it.ppalmisano.gennaio;

import java.util.*;

public class Civilta{
	private String nome;
	private ArrayList<Citta> citta;
	private int tesoro;
	private ArrayList<Risorsa> stock;

	public Civilta(String nome){
		this.nome = nome;
		this.tesoro = 0;
		this.citta = new ArrayList<Citta>();
		this.stock = new ArrayList<Risorsa>();
	}

	public Citta fondaCitta(String nome, Risorsa risorsa){
		Citta nuovaCitta = new Citta(nome, risorsa);
		citta.add(nuovaCitta);
		return nuovaCitta;
	}

	public void rimuoviCitta(Citta c){
		if(citta.contains(c))
			citta.remove(c);
	}

	public void aggiungiCitta(Citta c){
		citta.add(c);
	}

	public int getTesoro(){
		return tesoro;
	}

	public void aggiungiRisorsa(Risorsa r){
		stock.add(r);
	}

	public void rimuoviRisorsa(Risorsa r){
		if(stock.contains(r))
			stock.remove(r);
	}

	public void aggiungiDenaro(int d){
		tesoro += d;
	}

	public void faiProdurre(){
		for(int i = 0; i < citta.size(); i++)
			aggiungiRisorsa(citta.get(i).produci());
	}

	public boolean possiede(Risorsa r){
		return stock.contains(r);
	}

	public boolean vendiRisorseA(Civilta altra){
		boolean scambio = false;
		for(int i = 0; i < stock.size(); i++){
			Risorsa r = stock.get(i);
			if(!altra.possiede(r)){
				rimuoviRisorsa(r);
				altra.aggiungiRisorsa(r);
				aggiungiDenaro(r.getPrezzo());
				altra.aggiungiDenaro(-r.getPrezzo());
				scambio = true;
			}
		}
		return scambio;
	}

	public Citta menoCostosa(){
		int min = Integer.MAX_VALUE;
		Citta povera = null;
		for(int i = 0; i < citta.size(); i++){
			Citta c = citta.get(i);
			if(c.getPrezzoRisorsa() < min){
				min = c.getPrezzoRisorsa();
				povera = c;
			}
		}
		return povera;
	}

	@Override
	public String toString(){
		return nome;
	}

	@Override
	public int hashCode(){
		return nome.length() * 569 + tesoro * 997;
	}

	@Override
	public boolean equals(Object x){
		if(!(x instanceof Civilta))
			return false;
		else{
			Civilta y = (Civilta)x;
			return nome.equals(y.nome);
		}
	}
}
