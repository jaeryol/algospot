package backjoon.graph.linkcount;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by jojoldu@zuminternet.com on 2016-02-23.
 */

/*
    https://www.acmicpc.net/problem/11724
 */
public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int nodes = sc.nextInt();
        int paths = sc.nextInt();
        List<Integer>[] list = (List<Integer>[]) new List[nodes+1];

        for(int i=1;i<=nodes;i++){
            list[i] = new ArrayList<Integer>();
        }
        //인접리스트 생성
        for(int i=0;i<paths;i++){
            int node1 = sc.nextInt();
            int node2 = sc.nextInt();
            list[node1].add(node2);
            list[node2].add(node1);
        }
        int count = 0;
        boolean[] visited = new boolean[nodes+1];
        for(int i=1;i<=nodes;i++){
            if(!visited[i]) {
                count++;
                dfs(list, visited, i);
            }
        }
        System.out.println(count);
    }

    public static void dfs(List<Integer>[] list, boolean[] visited, int current){

        for(int i : list[current]){
            if(!visited[i]){ //방문한적이 없다면
                visited[i] = true;
                dfs(list, visited, i);
            }
        }
    }
}
