package gimnazium.osztaly;

import java.util.Random;

public class Gimnazista
{
	private boolean fiu;
	private int figyelmeztetesek;
	
	public Gimnazista()
	{
		Random veletlengenerator = new Random();
		this.fiu = veletlengenerator.nextBoolean();
		this.figyelmeztetesek = 0;
	}
	
	@Override
	public boolean equals(Object obj)
	{
		if(obj instanceof Gimnazista)
		{
			Gimnazista gimis = (Gimnazista )obj;
			
			if((gimis.fiu() == this.fiu())&&(gimis.figyelmeztetesek==this.figyelmeztetesek))
				return true;
			else
				return false;
		}
		
		return false;
	}
	
	@Override
	public String toString()
	{
		String nem;
		
		if(this.fiu)
			nem = "Fiu ";
		else
			nem = "Lany ";
		
		return nem + this.figyelmeztetesek + " figyelmeztetessel.";
	}
	
	public boolean fiu()
	{
		return fiu;
	}
	
	public Gimnazista foglalkoztat(int figyelmeztetesekSzama)
	{
		this.figyelmeztetesek += figyelmeztetesekSzama;
		
		return this;
	}
	
	public int osszesFigyelmeztetesekSzama()
	{
		return this.figyelmeztetesek;
	}
	
	public boolean hazakuldheto()
	{
		if(99<figyelmeztetesek)
			return true;
		
		return false;
	}
}
