package backjoon.fullsearch.remotecontroller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by jojoldu@zuminternet.com on 2016-03-07.
 */
/*
    https://www.acmicpc.net/problem/1107
 */
public class Main {
    private static boolean[] broken = new boolean[10];
    private static int result;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String targetStr = br.readLine();
        int target = Integer.parseInt(targetStr);
        int size = Integer.parseInt(br.readLine());
        String[] brokenStr = br.readLine().split(" ");
        int start = 100;

        for(int i=0;i<size;i++){
            broken[Integer.parseInt(brokenStr[i])] = true;
        }

        result = target - start;
        if(result < 0 ){
            result = -result;
        }

        for(int i=0; i <= 1000000; i++){ // N의 범위가 500,000 인데 -버튼도 있으므로 2배인 1,000,000으로 한다.
            int length = possible(i);

            if(length > 0){
                int press = i - target;
                if(press < 0){
                    press = -press;
                }

                if(result > length + press){
                    result = length + press;
                }
            }
        }

        System.out.println(result);
    }

    //불가능하면 0, 가능하면 버튼을 눌러야 하는 횟수 리턴
    public static int possible(int num){
        if(num == 0){
            return broken[0]? 0 : 1;
        }

        int length = 0;
        while(num > 0){
            if(broken[num%10]) {
                return 0;
            }

            length += 1;
            num /= 10;
        }

        return length;
    }
}
