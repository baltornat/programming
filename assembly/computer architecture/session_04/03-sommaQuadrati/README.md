# Somma quadrati

*nome del file sorgente: sommaQuadrati.asm*

Si scriva il codice che calcola la somma dei primi N-1 numeri elevati al quadrato. Nel caso in cui l’i-esimo numero da aggiungere sia multiplo del valore iniziale della somma, si termini il ciclo for.

		V=<intero inserito dall’utente>;
		N=<intero inserito dall’utente>;

		Sum = V;
		for (i=1; i<N; i++)
		{
		If ((i*i)%V==0){
			print «break»;
			break;
		}

		Sum+=i*i;
		}
		print Sum
