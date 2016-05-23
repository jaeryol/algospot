package backjoon.kmp.cubeditor;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by jojoldu@zuminternet.com on 2016-05-02.
 */
/*
    https://www.acmicpc.net/problem/1701
 */
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        int lcp = 0;
        String[] suffixArray = getSuffixArray(input);
        Arrays.sort(suffixArray);

        for(int i=0;i<suffixArray.length-1;i++){
            int current = getLcp(suffixArray[i], suffixArray[i+1]);
            if(current > lcp){
                lcp = current;
            }
        }

        System.out.println(lcp);
    }

    //접미사 배열
    private static String[] getSuffixArray(String input){
        String[] suffixArray = new String[input.length()];
        for(int i=0;i<input.length();i++){
            suffixArray[i] = input.substring(i,input.length());
        }
        return suffixArray;
    }

    //LCP : 가장긴 공통 접두사
    private static int getLcp(String str1, String str2){
        int length = str1.length() > str2.length()? str2.length() : str1.length();
        int lcpLength = length;

        for(int i=0;i<length;i++){
            if(str1.charAt(i) != str2.charAt(i)){
                lcpLength = i;
                break;
            }
        }
        return lcpLength;
    }
}
