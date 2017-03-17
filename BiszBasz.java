 public class BiszBasz
 {
	public static void main(String args[])
	{
		for(int i=1;i<=100;i++)
		{
			if(0==(i%15))
			{
				System.out.println("BiszBasz");
			}
			else if(0==(i%3))
			{
				System.out.println("Bisz");
			}
			else if(0==(i%5))
			{
				System.out.println("Basz");
			}
			else
			{
				System.out.println(i);
			}
		}
	}
 }
 