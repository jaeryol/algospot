package backjun.graph.termproject;

import java.util.Scanner;

/**
 * Created by jojoldu@zuminternet.com on 2016-02-24.
 */
/*
    https://www.acmicpc.net/problem/9466
 */
public class Main {
    private static int count = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int inputCount = sc.nextInt();
        int[] array;
        boolean[] visited;
        for(int i=0;i<inputCount;i++){
            int size = sc.nextInt();
            visited = new boolean[size+1];
            array = new int[size+1];

            for(int j=1;j<=size;j++){
                array[j] = sc.nextInt();
            }

            for(int j=1;j<=size;j++){

                dfs(array, visited, j, j);
            }

            System.out.println(count);
        }
    }

    public static void dfs(int[] array, boolean[] visited, int start, int current){

        if(start == array[current]){
            return;
        }

        if(visited[current]){
            count++;
            return;
        }

        visited[current] = true;
        dfs(array, visited, start, array[current]);
    }
}
