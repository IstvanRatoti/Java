//package rational;

public class Rational
{
	private int numerator;
	private int denominator;
	
	public Rational(int numerator, int denominator) throws NullDivisionException, IllegalArgumentException
	{
		if(Integer.MIN_VALUE == numerator || Integer.MIN_VALUE == denominator)
			throw new IllegalArgumentException("Out of range!");
		else if(Integer.MAX_VALUE == numerator || Integer.MAX_VALUE == denominator)
			throw new IllegalArgumentException("Out of range!");
		else if (0 == denominator)
			throw new NullDivisionException();
		else if (denominator < 0)
		{
			this.numerator = -1*numerator;
			this.denominator = -1*denominator;
		}
		else
		{
			this.numerator = numerator;
			this.denominator = denominator;
		}
	}
	
	public static Rational zero() throws NullDivisionException, IllegalArgumentException
	{
		return new Rational(0, 1);
	}
	
	public void multiplyWith(Rational other)
	{
		this.numerator *= other.numerator;
		this.denominator *= other.denominator;
	}
	
	public Rational times(Rational other) throws NullDivisionException
	{
		return new Rational(this.numerator*other.numerator,
							this.denominator*other.denominator);
	}
	
	@Override
	public String toString()
	{
		return new String(numerator + "/" + denominator);
	}
	
	public static void main(String[] args)
	{
		try
		{
			System.out.println(zero().toString());
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
}
