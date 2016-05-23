package backjoon.dp.makeone;

/**
 * Created by jojoldu@zuminternet.com on 2016-05-23.
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * https://www.acmicpc.net/problem/1463
 */
public class Main {

    private static int[] list;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        list = new int[n + 1];
        Arrays.fill(list, -1);
        System.out.println(makeToOne(n));
    }

    /**
     * @param n
     * @return
     */
    private static int makeToOne(int n) {
        if (n == 1) {
            return 0;
        }
        if(list[n] > 0){
            return list[n];
        }

        list[n] = makeToOne(n - 1)+1;

        if (n % 3 == 0) {
            int count = makeToOne(n / 3) + 1;
            if(count < list[n]){
                list[n] = count;
            }
        }

        if (n % 2 == 0) {
            int count =  makeToOne(n / 2) + 1;
            if(count < list[n]){
                list[n] = count;
            }
        }

        return list[n];

    }
}
