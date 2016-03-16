package backjun.stack.boomstr;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

/**
 * Created by jojoldu@zuminternet.com on 2016-03-14.
 */

/*
    https://www.acmicpc.net/problem/9935
 */
public class Main {

    static class Pair{
        int strIndex;
        int boomIndex;

        public Pair(int strIndex, int boomIndex) {
            this.strIndex = strIndex;
            this.boomIndex = boomIndex;
        }
    }

    private static boolean[] removes;
    private static int boomLength;
    private static Stack<Pair> stack = new Stack<Pair>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        String boomStr = br.readLine();
        int length = input.length();
        removes = new boolean[length+1];
        boomLength = boomStr.length();
        char c;
        String result;

        if(boomStr.length() == 1){ //폭발 문자열이 1이면 그냥 replace
            result = input.replace(boomStr, "");
        }else{
            for(int i=0;i<length;i++){
                c = input.charAt(i);
                if(c == boomStr.charAt(0)){ //폭발 문자열의 0번째 문자와 현재 문자가 같으면
                    stack.push(new Pair(i, 0));
                }else{
                    if(!stack.empty()){//폭발문자열의 0번째 문자와 현재문자가 다르지만, stack이 채워져있으면
                        int boomIndex = stack.peek().boomIndex+1; //stack의 폭발문자열 index + 1
                        /*

                         */
                        if(boomIndex == boomLength-1){
                            stack.push(new Pair(i, 0));

                            if(boomStr.charAt(boomIndex) == c){
                                popAllBoomStr(true);
                            }else{
                                popAllBoomStr(false);
                            }
                        }else{
                            if(boomStr.charAt(boomIndex) == c){
                                stack.push(new Pair(i, boomIndex));
                            }
                        }

                    }
                }
            }
            StringBuilder sb = new StringBuilder();
            for(int i=0;i<length;i++){
                if(!removes[i]){
                    sb.append(input.charAt(i));
                }
            }
            result = sb.toString();
        }
        System.out.println("".equals(result)? "FRULA" : result);
    }

    private static void popAllBoomStr(boolean flag){
        for(int i=0;i<boomLength;i++){
            removes[stack.pop().strIndex] = flag;
        }
    }
}
