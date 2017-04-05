//package szimulatorApp;

import java.util.Random;
import java.util.List;
import java.util.ArrayList;

import szallas.*;
import gimnazium.osztaly.Gimnazista;
import gimnazium.osztaly.Osztalyfonok;

public class Osztalykirandulas
{
	public static void main(String args[])
	{
		if(3!=args.length)
		{
			System.out.println("Inditasi hiba: harom parameter szukseges.");
			return;
		}
		
		int osztalyfonokszam = Integer.parseInt(args[0]);
		int gimnazistaszam = Integer.parseInt(args[1]);
		int szobakszama = Integer.parseInt(args[2]);
		
		kirandulas(osztalyfonokszam, gimnazistaszam, szobakszama);
	}
	
	private static void kirandulas(int osztalyfonokszam, int gimnazistaszam, int szobakszama)
	{
		int napok = 0;
		
		if(szobakszama<2)
		{
			System.out.println("Nincs elég szoba!");
			return;
		}
		
		Random veletlengenerator = new Random();
		List<Osztalyfonok> osztalyfonokok = new ArrayList<Osztalyfonok>(osztalyfonokszam);
		List<Szoba> szobak = new ArrayList<Szoba>(szobakszama);
		List<Gimnazista> gimnazistak = new ArrayList<Gimnazista>(gimnazistaszam);
		
		for(int i=0;i<osztalyfonokszam;i++)
			osztalyfonokok.add(new Osztalyfonok());
		
		for(int i=0;i<szobakszama;i++)
		{
			int szam = veletlengenerator.nextInt(Szoba.MAXFEROHELYEK-1)+1;
			//System.out.println(szam);
			Szoba szoba = Szoba.foglal(szam, veletlengenerator.nextBoolean());
			szobak.add(szoba);
		}
		
		for(int i=0;i<gimnazistaszam;i++)
			gimnazistak.add(new Gimnazista());
		
		//System.out.println(gimnazistak.size());
		//System.out.println(szobak.size());
		//System.out.println(osztalyfonokok.size());
		//for(Gimnazista gyerek : gimnazistak)
		//	System.out.println(gyerek.toString());
		/*for (Szoba szoba : szobak)
		{
			System.out.printf("Szoba meret: %d\n", szoba.osszferohely());
			System.out.printf("Szoba lakok: %d\n", szoba.lakokSzama());
			if(szoba.fiu())
				System.out.println("Fiu szoba.\n");
			else
				System.out.println("Lany szoba.\n");
			//for (Gimnazista gyerek : szoba.lakokListaja())
			//	System.out.println(gyerek);
		}*/
		
		feltolt(szobak, gimnazistak);
		
		//System.out.println(gimnazistak.size());
		//System.out.println(szobak.size());
		//System.out.println(osztalyfonokok.size());
		
		for (Szoba szoba : szobak)
		{
			System.out.printf("Szoba meret: %d\n", szoba.osszferohely());
			System.out.printf("Szoba lakok: %d\n", szoba.lakokSzama());
			if(szoba.fiu())
				System.out.println("Fiu szoba.\n");
			else
				System.out.println("Lany szoba.\n");
			//for (Gimnazista gyerek : szoba.lakokListaja())
			//	System.out.println(gyerek);
		}
		
		while(kovetkezoSzoba(szobak, osztalyfonokok)){napok++;}
		
		System.out.printf("Az osztalykirandulas %d napig tartott.\n", napok);
		System.out.printf("Az osztalyfonokok ennyi figyelmeztetot osztottak ki:\n");
		for (Osztalyfonok osztfonok : osztalyfonokok)
			System.out.printf("%d.:\t%d\n", osztalyfonokok.indexOf(osztfonok), osztfonok.osszesKiosztottFigyelmeztetesekSzama());
	}
	
	public static void feltolt(List<Szoba> szobak, List<Gimnazista> gimnazistak)
	{
		Random veletlengenerator = new Random();
		int szamlalo = 0;
		
		while(!gimnazistak.isEmpty())
		{	
			int diakelszallasolni = veletlengenerator.nextInt(gimnazistak.size());
			int szobaszam = veletlengenerator.nextInt(szobak.size());
			
			//System.out.printf("%d. gyereket probaljuk eltenni..\n", diakelszallasolni);
			
			Gimnazista gimis = gimnazistak.get(diakelszallasolni);
			
			if(szobak.get(szobaszam).elszallasol(gimis))
				gimnazistak.remove(diakelszallasolni);
		}
	}
	
	public static boolean kovetkezoSzoba(List<Szoba> szobak, List<Osztalyfonok> osztalyfonokok)
	{	
		boolean ures = true;
		
		for (Szoba szoba : szobak)
		{
			ures |= !(szoba.lakokListaja().isEmpty());
			
			for (Osztalyfonok osztfonok : osztalyfonokok)
			{
				osztfonok.ellenoriz(szoba);
				if(1000<osztfonok.osszesKiosztottFigyelmeztetesekSzama())
					return false;
			}
		}
		
		//if(!ures)
		//	System.out.println("False.");
		
		return ures;
	}
}
