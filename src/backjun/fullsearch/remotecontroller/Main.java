package backjun.fullsearch.remotecontroller;

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
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        boolean[] broken = new boolean[10];
        String targetStr = br.readLine();
        int target = Integer.parseInt(targetStr);
        int size = Integer.parseInt(br.readLine());
        String[] brokenStr = br.readLine().split(" ");
        int start = 100;
        int result = 0;

        for(int i=0;i<size;i++){
            broken[Integer.parseInt(brokenStr[i])] = true;
        }

        int current = start;
        while(current != target){

        }

        System.out.println(result);
    }

}
