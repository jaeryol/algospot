/* 
 * Copyright (C) Zuminternet, Inc - All Rights Reserved
 * Unauthorized copying of this file, via any medium is strictly prohibited
 * Proprietary and confidential
 * Written by Lee DongUk, jojoldu@zuminternet.com, 2015. 10. 28.
 */
package allergy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author jojoldu@zuminternet.com
 *
 */
public class Main {
	
	private static final int START_CHAR = 97;
	private static String[] friends;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int caseCount = Integer.parseInt(br.readLine());
		
		for(int i=0;i<caseCount;i++){
			String friAndCook = br.readLine();
			int friendsCount = Integer.parseInt(friAndCook.split(" ")[0]);
			int cooksCount = Integer.parseInt(friAndCook.split(" ")[1]);
			friends = br.readLine().split(" ");
			
			for(int j=0;j<cooksCount;j++){
				
			}
		}

		
		
	}
}
