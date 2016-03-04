package backjun.graph.islecount;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by jojoldu@zuminternet.com on 2016-03-04.
 */
/*
    https://www.acmicpc.net/problem/4963
    4방향 이동만 고려되는것이 아닌, 8방향 이동을 고려해야하는 문제
 */
public class Main {

    static class Pair {
        int first;
        int second;

        public Pair() {
        }

        public Pair(int first, int second) {
            this.first = first;
            this.second = second;
        }
    }

    private static int[] dx = { 0, 0, 1,-1, 1, 1,-1,-1 };
    private static int[] dy = { 1,-1, 0, 0, 1,-1, 1,-1 };

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader((new InputStreamReader(System.in)));
        String[] wh;
        int[][] land;
        String[] landLine;
        int w=-1, h=-1;
        while(w != 0 && h != 0){
            wh = br.readLine().split(" ");
            w = Integer.parseInt(wh[0]);
            h = Integer.parseInt(wh[1]);

            for(int i=0;i<h;i++){
                landLine = br.readLine().split(" ");

            }
        }
    }

    public static void bfs(int x, int y){

    }
}
