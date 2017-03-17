import java.io.FileReader;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;

public class ReadFile
{
	public static void main(String[] args)
	{
		if(1 != args.length)
		{
			new IllegalArgumentException("Invalid argument amount!");
			
			return;
		}
		
		try
		{
			BufferedReader in = new BufferedReader(new FileReader(args[0]));
			
			String line = null;
			
			while(null != (line = in.readLine()))
			{
				System.out.println(line);
			}
		}
		catch(FileNotFoundException e)
		{
			e.printStackTrace();
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
		
	}
}
