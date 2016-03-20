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

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        String boomStr = br.readLine();
        int length = input.length();
        boolean[] removes = new boolean[length+1];
        int boomLength = boomStr.length();
        Stack<Pair> stack = new Stack<Pair>();
        char current;
        String result;

        if(boomStr.length() == 1){ //폭발 문자열이 1이면 그냥 replace
            result = input.replace(boomStr, "");
        }else {
            for(int i=0;i<length;i++){
                current = input.charAt(i);
                if(current == boomStr.charAt(0)){ //폭발 문자열의 0번째 문자와 현재 문자가 같으면
                    stack.push(new Pair(i, 0));
                }else{
                    if(!stack.empty()){//폭발문자열의 0번째 문자와 현재문자가 다르지만, stack이 채워져있으면
                        Pair pair = stack.peek();//stack에 채워질 다음 폭발 문자열 index
                        if(current == boomStr.charAt(pair.boomIndex+1)){ //stack에 채워질 다음 폭발 문자열 index가 폭발문자열의 마지막 index라면
                            stack.push(new Pair(i, pair.boomIndex+1));

                            if(pair.boomIndex+1 == boomLength-1){
                                for(int j=0;j<boomLength;j++){
                                    removes[stack.pop().strIndex] = true;
                                }
                            }
                        }else{
                            while(!stack.empty()){
                                stack.pop();
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
        result = result.length()==0? "FRULA" : result;
        System.out.println(result);
    }

}
