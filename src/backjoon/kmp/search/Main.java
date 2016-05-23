package backjoon.kmp.search;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by jojoldu@zuminternet.com on 2016-05-16.
 */

/**
 * https://www.acmicpc.net/problem/1786
 */
public class Main {

    private static List<Integer> result = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String t = br.readLine();
        String p = br.readLine();
        match(t, p);
        System.out.println(result.size());
        for(int i : result){
            System.out.println(i);
        }
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

    private static void match(String t, String p){

        int[] pi = getPi(p);
        int n = t.length();
        int m = p.length();
        int i = 0; //전체 문자열 index
        int j = 0; //찾으려는 문자 패턴의 index

        while(i<n){
            if(j==-1 || (t.charAt(i) == p.charAt(j))){
                i++;
                j++;
            }else{
                j = pi[j];
            }

            if(j == m){
                j=pi[j];
                result.add(i-m+1); //index가 아닌 위치를 리턴시켜야하므로 +1 한다
            }
        }
    }
}
