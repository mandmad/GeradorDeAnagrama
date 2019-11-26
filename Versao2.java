
import java.util.*;
import java.io.*;
import java.net.*;

public class Main
{
	public static void main(String[] args) throws IOException
	{
    File f = new File("palavras.txt");
		Scanner sc = new Scanner(f);

		HashMap<String, ArrayList<String>> map =  new HashMap<String, ArrayList<String>>();

		while( sc.hasNextLine() )
		{
			String word = sc.nextLine();
			String sortedWord = sortString(word);

			ArrayList<String> anagrams = map.get( sortedWord ); 

			if( anagrams == null ) anagrams = new ArrayList<String>();

			anagrams.add(word);
			map.put(sortedWord, anagrams);
		}
		System.out.println(map.get(sortString("VERMELHO")));  

	}
	private static String sortString( String w )
	{
		char[] ch = w.toCharArray();
		Arrays.sort(ch);
		return new String(ch);
	}
}
