package backjoon.string.alphabet;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * Created by jojoldu@gmail.com on 2016-02-20.
 */
/*
    알파벳 소문자로만 이루어진 단어 S가 주어진다.
    이 때, 각 알파벳이 단어에 몇 개가 포함되어 있는지 구하는 프로그램을 작성하시오.
 */
public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        int length = input.length();
        int[] result = new int[26];
        Arrays.fill(result, 0);

        for(int i=0;i<length;i++){
            result[input.charAt(i)-97]++;
        }
        for(int i=0;i<result.length;i++){
            System.out.print(result[i]+" ");
        }
    }
}
