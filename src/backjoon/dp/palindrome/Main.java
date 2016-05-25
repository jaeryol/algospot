package backjoon.dp.palindrome;

/**
 * Created by jojoldu@zuminternet.com on 2016-05-25.
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * https://www.acmicpc.net/problem/10942
 */
public class Main {

    private static int[] nums;
    private static int[][] result;

    /**
     * 기본적인 방법으로 풀면 O(N * M) 이 나와 최대 2000 * 100만이여서 20초가 걸리기 때문에
     * 다른 방식으로 풀어야함
     *
     * 1) start와 end로 이루어진 2중 배열을 생성하여, 각각의 start/end 쌍이 팰린드롬인지 아닌지를 저장하여
     * 중복 계산 배제하도록 한다.
     * 2)
     * @param args
     * @throws IOException
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        nums = new int[n+1];
        String[] numsStr = br.readLine().split(" ");
        result = new int[n+1][n+1];

        for(int i=1;i<=n;i++){
            nums[i] = Integer.parseInt(numsStr[i-1]);
            Arrays.fill(result[i], -1);
        }

        int testCase = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<testCase;i++){
            String[] inputs = br.readLine().split(" ");
            int start = Integer.parseInt(inputs[0]);
            int end = Integer.parseInt(inputs[1]);
            sb.append(palindrome(start, end)).append("\n");
        }
        System.out.println(sb.toString());
    }

    private static int palindrome(int start, int end){
        if(start == end){
            return 1;
        }else if(start+1 == end){ //길이가 2일경우
            return nums[start] == nums[end]? 1:0;
        }

        if(result[start][end] != -1){
            return result[start][end];
        }

        if(nums[start] != nums[end]){
            result[start][end] = 0;
            return result[start][end];
        }else{
            result[start][end] = palindrome(start+1, end-1);
            return result[start][end];
        }
    }
}
