package backjun.graph.danji;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by jojoldu@gmail.com on 2016-03-02.
 */
/*
    https://www.acmicpc.net/problem/2667
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

    static int[][] map;
    static int[][] visited;
    static int[] answer;
    static int[] dx = {1,-1,0,0};
    static int[] dy = {0,0,1,-1};
    static int mapSize;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        mapSize = Integer.parseInt(br.readLine());
        map = new int[mapSize][mapSize];
        visited = new int[mapSize][mapSize];
        String line;

        //지도 만들기
        for(int i=0;i<mapSize;i++){
            line = br.readLine();
            for(int j=0;j<mapSize;j++){
                map[i][j] = line.charAt(j) - 48;
            }
        }

        //단지 구성하기
        int count=0;
        for(int i=0;i<mapSize;i++){
            for(int j=0;j<mapSize;j++){
                if(map[i][j] == 1 && visited[i][j] == 0){
                    bfs(i, j, ++count); //연결이 끊긴곳이 있다면  ++단지번호
                }
            }
        }

        System.out.println(count);
        answer = new int[count+1];
        for(int i=0;i<mapSize;i++){
            for(int j=0;j<mapSize;j++){
                if(visited[i][j] != 0){
                    answer[visited[i][j]] += 1;
                }
            }
        }

        Arrays.sort(answer);
        for(int i=1;i<=count;i++){
            System.out.println(answer[i]);
        }
    }

    public static void bfs(int x, int y, int count){
        Queue<Pair> queue = new LinkedList<Pair>();
        queue.add(new Pair(x, y));
        visited[x][y] = count;
        Pair p;
        while(!queue.isEmpty()){
            p = queue.remove();
            x = p.first;
            y = p.second;

            for(int j=0;j<4;j++){
                int nx = x+dx[j];
                int ny = y+dy[j];

                if(nx >= 0 && nx < mapSize && ny >= 0 && ny < mapSize){
                    if(map[nx][ny] == 1 && visited[nx][ny] == 0){
                        queue.add(new Pair(nx, ny));
                        visited[nx][ny] = count;
                    }
                }
            }
        }
    }
}

