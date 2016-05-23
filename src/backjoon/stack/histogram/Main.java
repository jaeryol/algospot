package backjoon.stack.histogram;

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
            //각각의 막대가 만들 수 있는 가장 큰 직사각형을 모두 비교
            for(int i=1;i<count;i++){
                int current = rectangles[i];

                /*
                    stack의 top와 현재위치의 높이를 비교해
                    top > current 이면 높이는 top,
                    너비는 현재위치
                 */
                while(!stack.empty() && rectangles[stack.peek()] > current){
                    int height = rectangles[stack.pop()];
                    int width = stack.empty()? i: (i-stack.peek()-1);
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

            System.out.println(max);
        }
    }
}
