package backjun.dp.fibonacci;

/**
 * Created by jojoldu@zuminternet.com on 2016-05-23.
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * https://www.acmicpc.net/problem/1003
 */
public class Main {
    private static int zeroCount = 0;
    private static int oneCount = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCase = Integer.parseInt(br.readLine());

        for(int i=0;i<testCase;i++){
            int input = Integer.parseInt(br.readLine());
            zeroCount = 0;
            oneCount = 0;
            fibonacci(input);
            System.out.println(zeroCount+" "+oneCount);
        }
    }

    private static int fibonacci(int n){
        if(n == 0){
            zeroCount++;
            return 0;
        }else if(n == 1){
            oneCount++;
            return 1;
        }else{
            return fibonacci(n-1) + fibonacci(n-2);
        }
    }
}
