package solong;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;

/**
 * Created by dwlee on 2015-11-27.
 */
public class Main {
    private static List<Character> firstWords = new ArrayList<Character>();
    private static ArrayList<PriorityQueue<String>> sortWords = new ArrayList<PriorityQueue<String>>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int caseCount = Integer.parseInt(br.readLine());
        String[] counts = br.readLine().split(" ");
        int dicCount = Integer.parseInt(counts[0]);
        int wordCount = Integer.parseInt(counts[1]);

        for(int i=0;i<dicCount;i++){

        }
    }

}

class TrieNode
{
    private LinkedList<TrieNode> children;
    private boolean terminates = false;
    private char character;

    public TrieNode() {
        children = new LinkedList<TrieNode>();
    }

    public TrieNode(char character) {
        this();
        this.character = character;
    }

    public char getChar() {
        return character;
    }

    public void addWord(String word) {
        if (word == null || word.isEmpty()) {
            return;
        }

        TrieNode child;
        char firstChar = word.charAt(0);

        TrieNode t = getChild(firstChar);

        if (t == null) {
            child = new TrieNode(firstChar);
            children.add(child);
        } else {
            child = t;
        }

        if (word.length() > 1) {
            child.addWord(word.substring(1));
        } else {
            child.setTerminates(true);
        }
    }

    TrieNode getChild(char c) {
        for (TrieNode t : children) {
            if (t.getChar() == c) {
                return t;
            }
        }
        return null;
    }

    public boolean terminates() {
        return terminates;
    }

    public void setTerminates(boolean t) {
        terminates = t;
    }
}