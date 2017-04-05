package gimnazium.osztaly;

import java.util.Random;
import java.util.List;
import java.util.ArrayList;
import java.util.Iterator;

import szallas.*;
import gimnazium.osztaly.*;

public class Osztalyfonok
{
	private int figyelmeztetesek;
	
	public Osztalyfonok()
	{
		this.figyelmeztetesek = 0;
	}
	
	public int osszesKiosztottFigyelmeztetesekSzama()
	{
		return this.figyelmeztetesek;
	}
	
	public void ellenoriz(Szoba szoba)
	{
		int hazakuldott = 0;
		Random veletlengenerator = new Random();
		List<Gimnazista> lakok = szoba.lakokListaja();
		Gimnazista[] lista = new Gimnazista[lakok.size()];
		lakok.toArray(lista);
		
		for(int i=0;i<lista.length;i++)
		{
			int szam = veletlengenerator.nextInt(5);
			
			lista[i].foglalkoztat(szam);
			figyelmeztetesek+=szam;
			if(lista[i].hazakuldheto())
			{
				//System.out.println("Hazakuldes.");
				szoba.felszabadit(i-hazakuldott);
				hazakuldott++;
			}
		}
	}
}
