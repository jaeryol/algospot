package backjun.stack.histogram;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

/**
 * Created by jojoldu@zuminternet.com on 2016-03-22.
 */

/*
    https://www.acmicpc.net/problem/6549
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] inputs;
        int[] rectangles;
        Stack<Integer> stack;
        StringBuilder sb = new StringBuilder();
        while(true){
            inputs = br.readLine().split(" ");
            rectangles = new int[inputs.length];
            for(int i=0;i<inputs.length;i++){
                rectangles[i] = Integer.parseInt(inputs[i]);
            }
            int count = rectangles[0];
            if(count == 0){
                break;
            }
            int max = 0;
            stack = new Stack<Integer>();
            for(int i=0;i<count;i++){
                int right, left;
                int current = rectangles[i];

                while(!stack.empty() && rectangles[stack.peek()] > current){
                    int height = rectangles[stack.pop()];
                    int width = stack.empty()? i: (i-stack.peek()-1);
//                    right = rectangles[i-1];
//                    left = stack.empty()? 0 : stack.peek();
                    //int currentSum = (right-left+1) * height;
                    int currentSum = height * width;
                    if(currentSum > max){
                        max = currentSum;
                    }
                }
                stack.push(i);
            }

            //stack에 있는 데이터들 비교
            while (!stack.empty()){
                int height = rectangles[stack.pop()];
                int width = count;
                if(!stack.empty()){
                    width = count - stack.peek()-1;
                }

                if(max < width * height){
                    max = width * height;
                }
            }

            sb.append(max+"\n");
        }
        System.out.println(sb.toString());
    }
}
