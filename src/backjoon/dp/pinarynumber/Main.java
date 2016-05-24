package backjoon.dp.pinarynumber;

/**
 * Created by jojoldu@zuminternet.com on 2016-05-24.
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * https://www.acmicpc.net/problem/2193
 */
public class Main {

    private static long[] memory;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int input = Integer.parseInt(br.readLine());

        memory = new long[input + 1];
        memory[1] = 1;

        for (int i = 2; i <= input; i++) {
            if(i==2){
                memory[2] = 1;
            }else{
                memory[i] = memory[i-1] + memory[i-2];
            }
        }
        System.out.println(memory[input]);
    }
}
