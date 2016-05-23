package backjoon.ab; //이부분은 제출시 지워야합니다.

import java.util.Scanner;

/**
 * Created by jojoldu@gmail.com on 2016-01-24.
 */
public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] inputs = sc.nextLine().split(" ");
        int sum=0;
        for(int i=0;i<inputs.length;i++){
            sum += Integer.parseInt(inputs[i]);
        }

        System.out.println(sum);
    }
}
