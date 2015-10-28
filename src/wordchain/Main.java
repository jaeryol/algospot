package wordchain;

/**
 * @author jojoldu@zuminternet.com
 *
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import util.AlgoUtil;

public class Main {

	public static String IMPOSSIBLE_PRINT = "IMPOSSIBLE";
	public static boolean allPass;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader( new InputStreamReader(System.in ));
		int caseCount = Integer. parseInt(br.readLine());
		String[] words;

		for( int i=0; i< caseCount; i++){
			//int wordCount = Integer.parseInt(br.readLine());
			int wordCount = AlgoUtil. getRandomNum(1, 100);
			System. out.println( wordCount);
			words = new String[ wordCount];
			allPass= false;

			for( int j=0; j< wordCount; j++){
				words[j] = AlgoUtil.getString(2, 10);
				System. out.println( words[ j]);
			}

			search(words, new ArrayList<String>());
			if(!allPass){
				System. out.println( IMPOSSIBLE_PRINT);
			}
		}

		br.close();
	}

	public static void search(String[] words, List<String> prints){
		int size = prints.size();
		if( words.length == size){
			allPass= true;

			for( int i=0; i< size; i++){
				System. out.print(( i< size-1)? prints.get( i) + " " : prints.get(i ));
			}

			System. out.println();
		}

		boolean flag = false;
		for( int i=0; i< words.length; i++){
			String word = words[ i];

			if(! "".equals( word)){

				if(size>0){
					String print = prints.get(size-1);
					int printLength = print.length();

					if( print.charAt(printLength-1) == word.charAt(0)){
						prints.add( word);
						words[i] = "";
						search(words, prints);
					}
				}else{
					prints.add( word);
					words[i] = "";
					search(words, prints);
				}

			}
		}
	}
}
