package backjoon.graph.repeatseq;

import java.util.Scanner;

/**
 * Created by jojoldu@gmail.com on 2016-03-01.
 */
public class Main {
    static int[] checked = new int[10000001];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int start = sc.nextInt();
        int repeat = sc.nextInt();

        System.out.println(length(start, repeat, 1));
    }

    public static int length(int number, int repeat, int pos){
        if(checked[number] != 0){
            return checked[number] - 1;
        }
        checked[number] = pos;
        return length(next(number,repeat), repeat, pos+1);
    }

    public static int next(int number, int repeat){
        int result=0;
        while(number > 0){
            result += pow(number%10, repeat);
            number = number / 10;
        }
        return result;
    }

    public static int pow(int number, int repeat){
        int result=1;
        for(int i=0;i<repeat;i++){
            result *= number;
        }
        return result;
    }
}
