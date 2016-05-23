package backjoon.string.dial;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by jojoldu@gmail.com on 2016-02-20.
 */
/*
    https://www.acmicpc.net/problem/5622
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        int length = input.length();
        int[] scope = {64, 67, 70, 73, 76, 79, 83, 86, 90};
        int result=0;
        int c;
        for(int i=0;i<length;i++){
            c = input.charAt(i);
            for(int j=0;j<scope.length-1;j++){
                if(c > scope[j] && c<=scope[j+1]){
                    result+=j+3;
                }
            }
        }
        System.out.println(result);
    }
}
