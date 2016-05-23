package backjoon.dp.fishbread;

/**
 * Created by jojoldu@zuminternet.com on 2016-05-23.
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * https://www.acmicpc.net/problem/11052
 */
public class Main {

    private static int[] price;
    private static int[] maxPrice;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String[] priceStr = br.readLine().split(" ");
        price = new int[n+1];
        for(int i=1;i<=n; i++){
            price[i] = Integer.parseInt(priceStr[i-1]);
        }
        maxPrice = new int[n+1];
        getMax(n);
        System.out.println(maxPrice[n]);

    }

    private static void getMax(int n){
        for(int i=1;i<=n;i++){
            for(int j=1;j<=i;j++){
                if(maxPrice[i] < maxPrice[i-j] + price[j]){
                    maxPrice[i] = maxPrice[i-j] + price[j];
                }
            }
        }
    }
}
