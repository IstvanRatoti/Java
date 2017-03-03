public class C
{
	String str;
	int num;
	
	public C(String str, int num)
	{
		this.str = str;
		this.num = num;
	}
	
	public void m(int i)
	{
		num = i;
		i = str.length();
	}

	public static void main(String[] args)
	{
		String str = args[1];
		int len = Integer.MAX_VALUE;
		int num = str.length();
		
		C obj = new C(str, num);
		obj.m(num/2);
	}
}
