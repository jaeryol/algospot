package backjoon.math.gcdsum;

import java.util.Scanner;
/**
 * Created by jojoldu@zuminternet.com on 2016-03-04.
 */
public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int size = sc.nextInt();
        int[] arr;
        while(size > 0){
            arr = new int[101];
            int n = sc.nextInt();
            for(int i=0;i<n;i++){
                arr[i] = sc.nextInt();
            }
            int sum=0;

            for(int i=0;i<n-1;i++){
                for(int j=i+1; j<n; j++){
                    sum += gcd(arr[i], arr[j]);
                }
            }
            System.out.println(sum);
            size--;
        }
    }

    public static int gcd(int x, int y){
        return (y == 0)? x : gcd(y, x%y);
    }
}