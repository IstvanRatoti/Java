package szimulatorApp.gimnazium.osztaly;

import java.util.Random;

public class Gimnazista
{
	private boolean fiu;
	
	public Gimnazista()
	{
		Random veletlengenerator = new Random(12345678);
		this.fiu = veletlengenerator.nextBoolean();
	}
	
	public boolean fiu()
	{
		return fiu;
	}
}
