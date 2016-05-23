package backjoon.dp.numbersum;

/**
 * Created by jojoldu@zuminternet.com on 2016-05-23.
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * https://www.acmicpc.net/problem/9095
 */
public class Main {

    private static int[] memory;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCase = Integer.parseInt(br.readLine());

        for(int i=0;i<testCase;i++){
            int input = Integer.parseInt(br.readLine());
            memory = new int[input+1];
            Arrays.fill(memory, -1);
            System.out.println(makeSum(input));
        }
    }

    private static int makeSum(int n){
        if(n < 1){
            return 0;
        }

        if(memory[n] > 0){
            return memory[n];
        }

        if(n == 1){
            memory[n] = 1;
            return memory[n];
        }
        if(n == 2){
            memory[n] = 2;
            return memory[n];
        }
        if(n == 3){
            memory[n] = 4;
            return memory[n];
        }

        return makeSum(n-1) + makeSum(n-2) + makeSum(n-3);
    }
}
