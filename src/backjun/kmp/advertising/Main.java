package backjun.kmp.advertising;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

/**
 * Created by jojoldu@zuminternet.com on 2016-05-03.
 */
/*
    https://www.acmicpc.net/problem/1305
    6
    aabaaa
    입력시 결과는 aaba 즉,4

    6
    baaaba
    입력시 결과는 baaa 즉,4

    5
    aaaaa
    입력시 결과는 a 즉,1

    접두사배열과 접미사배열을 차례로 비교해서 동일 index에서 접두사와 접미사가 같으면
    전체 길이 -index

 */
public class Main {

    private static String[] prefixArray;
    private static String[] suffixArray;
    private static int line;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        line = Integer.parseInt(br.readLine());
        String current = br.readLine();
        prefixArray = getPrefixArray(current);
        suffixArray = getSuffixArray(current);
        int result = line;
        boolean boundary = false;

        for(int i=0;i<line-1;i++){
            if(prefixArray[i].equals(suffixArray[i])){
                boundary = true;
            }else{
                if(boundary){
                    boundary = false;
                    result = line - i;
                    break;
                }
            }
        }
        if(boundary){
            System.out.println(1);
        }else{
            System.out.println(result);
        }
    }

    //접두사 배열
    private static String[] getPrefixArray(String input){
        String[] prefixArray = new String[input.length()];
        for(int i=0;i<input.length();i++){
            prefixArray[i] = input.substring(0,i+1);
        }
        return prefixArray;
    }

    //접미사 배열
    private static String[] getSuffixArray(String input){
        String[] suffixArray = new String[input.length()];
        for(int i=0;i<input.length();i++){
            suffixArray[i] = input.substring(input.length()-(i+1), input.length());
        }
        return suffixArray;
    }
}
