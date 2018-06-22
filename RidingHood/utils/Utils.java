package RidingHood.utils;

import java.io.BufferedReader;
import java.io.*;
import java.io.IOException;

public class Utils 
{
	public static String LoadFileAsString(String path)
	{
		StringBuilder builder = new StringBuilder();
		try
		{
			BufferedReader br = new BufferedReader(new InputStreamReader(Utils.class.getResourceAsStream("/"+path)));
			String line;
			while((line = br.readLine()) != null)
				builder.append(line+"\n");
			br.close();
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
		return builder.toString();
	}
	public static int parseInt(String number)
	{
		try {return Integer.parseInt(number);}
		catch(NumberFormatException e)
		{
			e.printStackTrace();
			return 0;
		}
	}
}
