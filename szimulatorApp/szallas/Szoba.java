package szallas;

import java.util.List;
import java.util.ArrayList;

import gimnazium.osztaly.*;

public class Szoba
{
	public static final int MAXFEROHELYEK = 9;
	
	private List<Gimnazista> lakok;
	private int ferohelyek;
	private boolean fiuszoba;
	
	private Szoba(int ferohelyek, boolean fiuszoba)
	{
		this.lakok = new ArrayList<Gimnazista>();
		this.ferohelyek = ferohelyek;
		this.fiuszoba = fiuszoba;
	}
	
	public static Szoba foglal(int ferohelyek, boolean fiuszoba)
	{
		Szoba szoba;
		
		if((ferohelyek>=MAXFEROHELYEK)||(0>=ferohelyek))
		{
			System.out.println("Null szoba!");
			szoba = null;
		}
		else
			szoba = new Szoba(ferohelyek, fiuszoba);
		
		return szoba;
	}
	
	public List<Gimnazista> lakokListaja()
	{
		return this.lakok;
	}
	
	public boolean fiu()
	{
		return this.fiuszoba;
	}
	
	public int lakokSzama()
	{
		return lakok.size();
	}
	
	public int osszferohely()
	{
		return this.ferohelyek;
	}
	
	public int szabadferohely()
	{
		return (this.ferohelyek - this.lakokSzama());
	}
	
	public boolean elszallasol(Gimnazista lako)
	{
		if(!(lako.fiu()^this.fiu())&&(this.szabadferohely()>0))
		{
			lakok.add(lako);
			return true;
		}
		
		return false;
	}
	
	public Gimnazista lako(int hely)
	{
		return lakok.get(hely);
	}
	
	public void felszabadit(int hely)
	{
		lakok.remove(hely);
	}
}
