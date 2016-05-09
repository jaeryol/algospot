package backjun.kmp.advertising;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by jojoldu@zuminternet.com on 2016-05-03.
 */
/*
    https://www.acmicpc.net/problem/1305

    테스트케이스
    6
    aabaaa
    입력시 결과는 aaba: 4

    6
    baaaba
    입력시 결과는 baaa: 4

    5
    aaaaa
    입력시 결과는 a: 1

    8
    abaabaab
    입력시 결과는 aba: 3



 */
public class Main {

    private static int line;
    private static String base;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        line = Integer.parseInt(br.readLine());
        base = br.readLine();

        for (int i = 0; i < line - 1; i++) {
            int result = kmp(base.substring(0, i+1));
            if(result > 0){
                System.out.println(result);
                break;
            }
        }
    }

    private static int kmp(String key) {
        int length = key.length();
        int currentIndex = 0;
        int result = 0;
        String current;
        while (true) {
            int nextIndex = currentIndex+length;

            if(nextIndex > base.length()){
                int remainderLength = base.length() - currentIndex;
                String keyRemainder = key.substring(0, remainderLength);
                String baseRemainder = base.substring(currentIndex, base.length());

                if(keyRemainder.equals(baseRemainder)){
                    result = length;
                }

                break;
            }

            current = base.substring(currentIndex, nextIndex);
            if(!key.equals(current)){
                break;
            }
            currentIndex += length;
        }

        return result;
    }
}
