import java.io.Console;

class Hello2
{	
		public static void main(String[] args)
		{
			String line = System.console().readLine();
			
			System.out.println("Hello," + line + "!");
		}
}
