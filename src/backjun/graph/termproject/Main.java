package backjun.graph.termproject;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by jojoldu@zuminternet.com on 2016-02-24.
 */
/*
    https://www.acmicpc.net/problem/9466
 */
public class Main {

    public static int[] numbers = new int[100001];
    public static int[] positions = new int[100001];
    public static int[] visited = new int[100001];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int inputCount = sc.nextInt();
        for(int i=0;i<inputCount;i++){
            int size = sc.nextInt();

            for(int j=1;j<=size;j++){
                numbers[j] = sc.nextInt();
                positions[j] = 0;
                visited[j] = 0;
            }

            int result=0;
            for(int j=0;j<=size;j++){
                if(positions[i] == 0){
                    result += dfs(i, 1, i);
                }
            }
            System.out.println(size - result);
        }
    }

    /*
       1. 시작점이 곧 끝점이어야 한다.
       2. 시작점을 다시 만나기전에 이미 방문한 점을 만나면 안된다.
       3. 이미 완전 한조가 되었다면 제외
     */
    public static int dfs(int current, int count, int step){
        if(positions[current] != 0){
            if(visited[current] != step){
                return 0;
            }
            return count - positions[current];
        }
        positions[current] = count;
        visited[current] = step;
        return dfs(numbers[current], count+1, step);
    }
}
