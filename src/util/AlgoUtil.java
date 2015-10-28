package util;

/**
 * @author jojoldu@zuminternet.com
 *
 */

public class AlgoUtil {
	
	private static final int CHAR_SIZE = 26;
	private static final int CHAR_START = 97;

	public static String getString(int start, int size){
		int scope = (int)(Math.random()*size) + start;
		
		if(scope>size){
			scope -= size;
		}
		
		StringBuilder sb = new StringBuilder();
		
		for(int i=0; i<scope; i++){
			sb.append(( char)((Math.random()*CHAR_SIZE)+CHAR_START));
		}

		return sb.toString();
	}

	public static int getRandomNum (int start, int end ){
		return ( int)(Math. random()*end) + start;
	}
}
