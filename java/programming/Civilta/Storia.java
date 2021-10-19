package it.ppalmisano.gennaio;

import java.util.*;

public class Storia{
	private ArrayList<Civilta> civilta;

	public Storia(ArrayList<Civilta> civilta){
		this.civilta = civilta;
	}

	public void commercia(){
		boolean venduta = false;
		for(int i = 0; i < civilta.size(); i++){
			Civilta c = civilta.get(i);
			for(int j = 0; j < civilta.size(); j++){
				Civilta k = civilta.get(j);
				if(!c.equals(k))
					if(c.vendiRisorseA(k));
						break;
			}
		}
	}

	public Civilta piuRicca(){
		int max = Integer.MIN_VALUE;
		Civilta ricca = null;
		for(int i = 0; i < civilta.size(); i++){
			Civilta c = civilta.get(i);
			if(c.getTesoro() > max){
				max = c.getTesoro();
				ricca = c;
			}
		}
		return ricca;
	}

	public Civilta piuPovera(){
		int min = Integer.MAX_VALUE;
		Civilta povera = null;
		for(int i = 0; i < civilta.size(); i++){
			Civilta c = civilta.get(i);
			if(c.getTesoro() < min){
				min = c.getTesoro();
				povera = c;
			}
		}
		return povera;
	}

	public Civilta evolvi(int n){
		for(int i = 0; i < n; i++){
			for(int j = 0; j < civilta.size(); j++){
				Civilta c = civilta.get(j);
				c.faiProdurre();
			}
			commercia();
		}
		return piuRicca();
	}

	public void conquista(){
		Civilta cr = piuRicca();
		Civilta cp = piuPovera();
		if(cp.getTesoro() != cr.getTesoro()){
			Citta conquistata = cp.menoCostosa();
			cp.rimuoviCitta(conquistata);
			cr.aggiungiCitta(conquistata);
		}
	}

}
