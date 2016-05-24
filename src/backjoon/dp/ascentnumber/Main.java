package backjoon.dp.ascentnumber;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by jojoldu@zuminternet.com on 2016-05-24.
 */
/*
    https://www.acmicpc.net/problem/11057
 */
public class Main {

    private static int mod = 10007;
    private static int size;
    private static long[][] memory;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        size = Integer.parseInt(br.readLine());
        memory = new long[size+1][10];

        //초기값 셋팅 (size 1일 경우 i-1 의 값이 없으므로 무조건 0이 나오므로 예외처리함)
        for(int i=0;i<=9;i++){
            memory[1][i] = 1;
        }

        /**
         * memory[i][j] 는 숫자중 i번째 값이 j일때 나올수 있는 오름수의 모든 가지수를 나타냄
         * 이 값은 memory[i-1][0] ~ memory[i-1][j]의 모든 가지수의 합과 동일하다.
         */
        for(int i=2;i<=size;i++){
            for(int j=0;j<=9;j++){
                memory[i][j] = 0;
                for(int k=0;k<=j;k++){
                    memory[i][j] += memory[i-1][k];
                }
                memory[i][j] %= mod;
            }
        }

        long result = 0;
        for(int i=0;i<=9;i++){
            result += memory[size][i];
        }
        System.out.println(result % mod);
    }

}
