package backjoon.string.kmp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by jojoldu@gmail.com on 2016-02-20.
 */
public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] inputs = br.readLine().split("-");
        StringBuffer sb = new StringBuffer();
        for(String s : inputs){
            sb.append(s.charAt(0));
        }

        System.out.println(sb);
    }
}
