public class NumError
{
	public static void main(String[] args)
	{
		float x = 0;
		
		for(int i=0;i<10;i++)
			x+=0.2;
		
		System.out.println(x);
		System.out.println(0.2f+0.2f+0.2f+0.2f+0.2f+0.2f+0.2f+0.2f+0.2f+0.2f);
		System.out.println(0.1d+0.1d+0.1d+0.1d+0.1d+0.1d+0.1d+0.1d+0.1d+0.1d);
	}
}
