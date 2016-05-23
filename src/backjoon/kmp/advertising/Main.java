package backjoon.kmp.advertising;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by jojoldu@zuminternet.com on 2016-05-03.
 */
/*
    https://www.acmicpc.net/problem/1305

    테스트케이스
    6
    aabaaa
    입력시 결과는 aaba: 4

    6
    baaaba
    입력시 결과는 baaa: 4

    5
    aaaaa
    입력시 결과는 a: 1

    8
    abaabaab
    입력시 결과는 aba: 3



 */
public class Main {

    private static int line;
    private static String base;
    private static int[] pi;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        line = Integer.parseInt(br.readLine());
        base = br.readLine();
        pi =  getPi(base);
        System.out.println(line - pi[line]);
    }

    /**
     * i는 접미부의 위치, j는 접두부의 위치
     * string[i] == string[j] 이면 i++, j++, pi[i] = j
     * string[i] != string[j] 이면 j = pi[j] (pi[j] 는 구간 0~ㅓ-1의 접두부의 위치를 가지고 있다.)
     *
     */
    private static int[] getPi(String p){
        int m = p.length();
        int[] pi = new int[m+1];
        int i=0, j=-1;
        pi[0] = -1;

        while(i<m) {
            if(j == -1 || (p.charAt(i) == p.charAt(j))){
                i++;
                j++;
                pi[i] = j;
            }else {
                j = pi[j];
            }
        }

        return pi;
    }
}
