package backjoon.string.constant;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by jojoldu@gmail.com on 2016-02-20.
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] inputs = br.readLine().split(" ");
        int a = reverse(inputs[0]);
        int b = reverse(inputs[1]);

        System.out.println(a>b? a : b);
    }

    public static int reverse(String str){
        int length = str.length();
        StringBuffer sb = new StringBuffer();

        for(int i=length-1;i>=0;i--){
            sb.append(str.charAt(i));
        }

        return Integer.parseInt(sb.toString());

    }
}
