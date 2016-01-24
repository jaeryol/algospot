package algospot.naming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by dwlee on 2015-11-27.
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String f = br.readLine();
        String m = br.readLine();

        kmpSearch(f+m);
    }

    public static void kmpSearch(String name){
        char[] chars = name.toCharArray();
        int length =  chars.length;
        int lastIndex = chars.length-1;

        StringBuilder[] starts = new StringBuilder[length];
        StringBuilder[] ends = new StringBuilder[length];
        String start, end;

        for(int i=0;i<length;i++){
            starts[i] = new StringBuilder();
            ends[i] = new StringBuilder();

            if(i == 0){
                starts[i].append(chars[i]);
                ends[i].append(chars[lastIndex]);
            }else{
                starts[i].append(starts[i-1]).append(chars[i]);
                ends[i].append(ends[i-1]).insert(0,chars[lastIndex-i]);
            }

            start = starts[i].toString();
            end = ends[i].toString();

            if(start.equals(end)){
                System.out.print(start.length() +" ");
            }
        }
    }
}
