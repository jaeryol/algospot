package backjun.stack.boomstr;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

/**
 * Created by jojoldu@zuminternet.com on 2016-03-14.
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
        Stack<Pair> stack = new Stack<Pair>();
        int length = input.length();
        int boomLength = boomStr.length();
        char c;
        String result;

        if(boomStr.length() == 1){ //폭발 문자열이 1이면 그냥 replace
            result = input.replace(boomStr, "");

        }else{
            for(int i=0;i<length;i++){
                c = boomStr.charAt(i);
                if(c == boomStr.charAt(0)){ //폭발 문자열의 0번째 문자와 현재 문자가 같으면
                    stack.push(new Pair(i, 0));

                }else{

                    if(!stack.empty()){
                        Pair pair = stack.peek();
                        if(pair != null){
                            int boomIndex = pair.boomIndex+1;
                            if(boomStr.charAt(boomIndex) == c){
                                if(boomIndex == boomLength-1){

                                }
                            }
                        }
                    }
                }
            }
        }
        //System.out.println(result);
    }
}
