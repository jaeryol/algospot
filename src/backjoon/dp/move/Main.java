package backjoon.dp.move;

/**
 * Created by jojoldu@zuminternet.com on 2016-05-24.
 */

import java.util.Scanner;

/**
 * https://www.acmicpc.net/problem/11048
 *
 * 재귀로 푸는법 참고) https://gist.github.com/jojoldu/bd6459d429d85ca59205503500476908
 */
public class Main {
    private static int[][] maze;
    private static int[][] maxList;
    private static int height;
    private static int width;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        height = sc.nextInt();
        width = sc.nextInt();
        maze = new int[height+1][width+1];
        maxList = new int[height+1][width+1];

        for(int i=1;i<=height;i++){
            for(int j=1;j<=width;j++){
                maze[i][j] = sc.nextInt();
            }
        }

        for(int i=1;i<=height;i++){
            for(int j=1;j<=width;j++){
                maxList[i][j] = Math.max(maxList[i-1][j], maxList[i][j-1]) + maze[i][j];
            }
        }
        System.out.println(maxList[height][width]);

    }
}
