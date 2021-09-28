package mx.ipn.upiicsa.segsw.labicla.util;

import java.io.IOException;
import java.io.Writer;
import java.util.Base64;
import java.util.Date;
import java.util.Random;

/**
 * 
 * @author Guillermo E. Martinez Barriga
 *
 */

public class Utility 
{
	public static boolean containsAnEmptyValue(String... values)
	{
		for(String value:values)
		{
			if(value == null || value.trim().isEmpty())
			{
				return true;
			}
		}
		return false;
		
	}
	public static void main(String[] args)
	{
		System.out.println(containsAnEmptyValue("A  ", "", "B"));
		
	}

}
