package encrypt;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by dwlee on 2015-11-27.
 */
public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int caseCount = Integer.parseInt(br.readLine());

        for(int i=0;i<caseCount;i++){
            char[] input = br.readLine().toCharArray();
            char[] result = new char[input.length];
            int even = 0, odd = (input.length%2 == 0)? input.length/2 : input.length/2+1;

            for(int j=0;j<input.length;j++){
                if(j%2 == 0){
                    result[even++] = input[j];
                }else{
                    result[odd++] = input[j];
                }
            }

            System.out.println(new String(result));
        }
    }
}
