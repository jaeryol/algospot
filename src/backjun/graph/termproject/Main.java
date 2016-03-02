package backjun.graph.termproject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by jojoldu@zuminternet.com on 2016-02-24.
 */
/*
    https://www.acmicpc.net/problem/9466
 */
public class Main {

    public static int[] numbers = new int[100001];
    public static int[] moveCounts = new int[100001];
    public static int[] teams = new int[100001];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int inputCount = Integer.parseInt(br.readLine());
        for(int i=0;i<inputCount;i++){
            int size = Integer.parseInt(br.readLine());
            String[] inputNumbers = br.readLine().split(" ");
            for(int j=1;j<=size;j++){
                numbers[j] = Integer.parseInt(inputNumbers[j-1]);
                moveCounts[j] = 0;
                teams[j] = 0;
            }

            int result=0;
            for(int j=1;j<=size;j++){
                if(moveCounts[j] == 0){
                    result += dfs(j, 1, j); // 팀에 포함안된 인원
                }
            }
            System.out.println(size - result); //전체 인원 - 포함된 인원
        }
    }

    public static int dfs(int current, int moveCount, int start){
        if(moveCounts[current] != 0){ //이미 방문한적이 있고
            if(teams[current] != start){ //같은조가 아니라면
                return 0;
            }
            /*
                총 이동횟수 - 현재 숫자까지의 이동횟수
                즉 1에서 시작하여 3에 도착할 경우 3은 다시 본인을 바라보므로
                current가 3일때,
                moveCount는 3이며 (1->3->3)
                moveCounts[3]은 2이다. (처음 3에 도착할때 이동횟수가 2이므로)
                이럴경우 moveCount-moveCounts[current] = 1이 된다
             */
            return moveCount - moveCounts[current];
        }
        moveCounts[current] = moveCount;
        teams[current] = start;
        return dfs(numbers[current], moveCount+1, start);
    }
}
