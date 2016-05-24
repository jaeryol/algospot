package backjoon.dp.easystairs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by jojoldu@zuminternet.com on 2016-05-24.
 */

/*
    https://www.acmicpc.net/problem/10844
 */
public class Main {
    private static long[][] memory;
    private static long divider = 1000000000L;

    /**
     * 10억으로 나누어햐 하므로 10억 이상의 수를 담을 수 있도록 long 타입의 배열 선언 필요
     * @param args
     * @throws IOException
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int size = Integer.parseInt(br.readLine());
        memory = new long[size+1][10];

        //시작 포인트는 1~9사이만 허용 (0으론 시작x, 중간엔 들어갈수 있음)
        for(int i=1; i<=9; i++){
            memory[1][i] = 1;
        }

        for(int i=2; i<=size;i++){
            for(int j=0;j<=9;j++){
                memory[i][j] = 0;
                if(j-1 >= 0){
                    memory[i][j] += memory[i-1][j-1];
                }
                if(j+1 <= 9){
                    memory[i][j] += memory[i-1][j+1];
                }
                memory[i][j] %= divider;
            }
        }

        long result = 0;
        for(int i=0;i<=9;i++){
            result += memory[size][i];
        }

        System.out.println(result%divider);
    }

}
