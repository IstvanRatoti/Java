class CelsToFahr2
{
	public static void main(String[] agrs)
	{
		String line = System.console().readLine();
		double num = 0;
		
		try
		{
			num = Double.parseDouble(line);
		}
		catch(Exception e)
		{
			System.err.println("Error!" + e);
		}
		
		double C = (num-32) * 5 / 9;
		
		System.out.println("Answer: " + C);
	}
}
