package backjun.allsearch.calculatedate;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by jojoldu@zuminternet.com on 2016-03-07.
 */
/*
    https://www.acmicpc.net/problem/1476
 */
public class Main {
    private static int E_SIZE = 15;
    private static int S_SIZE = 28;
    private static int M_SIZE = 19;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] inputs = br.readLine().split(" ");
        int[] years = new int[3];

        for(int i=0;i<inputs.length;i++){
            years[i] = Integer.parseInt(inputs[i]);
        }

        int e=0,s=0,m=0;
        int result = 0;
        while(true){
            if(e == years[0] && s == years[1] && m == years[2]){
                break;
            }
            e++;
            s++;
            m++;

            if(e > E_SIZE){
                e = 1;
            }
            if(s > S_SIZE){
                s = 1;
            }
            if(m > M_SIZE){
                m = 1;
            }

            result++;
        }

        System.out.println(result);
    }

}
