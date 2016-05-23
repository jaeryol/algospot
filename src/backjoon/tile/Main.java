package backjoon.tile;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by jojoldu@gmail.com on 2016-01-24.
 */

/*
    4*N 크기의 타일을 2*1, 1*2 크기의 도미노로 완전히 채우려고 한다.
    예를 들어 4*2 타일을 채우는 방법은 다음과 같이 5가지가 있다.
    2 : 5
    3 : 11
    7 : 781

 */
public class Main {

    static int[] memory = new int[10000000];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int inputCount = Integer.parseInt(sc.nextLine());
        Arrays.fill(memory, 0);

        memory[0] = 1;
        memory[1] = 1;
        memory[2] = 5;
        memory[3] = 11;
        memory[7] = 781;

        for(int i=0;i<inputCount;i++){
            int n = Integer.parseInt(sc.nextLine());
            System.out.println(tiling(n));
        }
    }

    public static int tiling(int n){
        if(n<0){
            return 0;
        }
        if(memory[n] != 0){
            return memory[n];
        }
        memory[n] = tiling(n-1) + 5*tiling(n-2) + tiling(n-3) - tiling(n-4);
        return memory[n];
    }
}
