package backjun.graph.dfsandbfs;

import java.util.*;

/**
 * Created by jojoldu@zuminternet.com on 2016-02-22.
 */

/*
    https://www.acmicpc.net/problem/1260
 */
public class Main {

    public static void dfs(List<Integer>[] list, boolean[] visited, int current){
        if(visited[current]){
            return;
        }
        visited[current] = true;
        System.out.print(current + " ");

        for(int i : list[current]){
            if(!visited[i]){
                dfs(list, visited, i);
            }
        }
    }

    public static void bfs(List<Integer>[] list, boolean[] visited, int start){
        Queue<Integer> queue = new LinkedList<Integer>();
        queue.add(start);
        visited[start] = true;

        while(!queue.isEmpty()) {
            int next = queue.remove();
            System.out.print(next + " ");
            for(int i : list[next]){
                if(!visited[i]){
                    visited[i] = true;
                    queue.add(i);
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int nodeCount = sc.nextInt();
        int lineCount = sc.nextInt();
        int startNode = sc.nextInt();

        List<Integer>[] list = (List<Integer>[]) new List[nodeCount+1];

        for(int i=1;i<=nodeCount;i++){
            list[i] = new ArrayList<Integer>();
        }

        for(int i=0;i<lineCount;i++){
            int x = sc.nextInt();
            int y = sc.nextInt();
            list[x].add(y);
            list[y].add(x);
        }

        for(int i=1;i<=nodeCount;i++){
            Collections.sort(list[i]);
        }
        boolean[] visited = new boolean[nodeCount+1];
        dfs(list, visited, startNode);
        System.out.println();
        Arrays.fill(visited, false);
        bfs(list, visited, startNode);
        System.out.println();
    }
}
