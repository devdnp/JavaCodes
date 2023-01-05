package gfg._daily_problem;

import java.io.*;
import java.util.*;

public class FindLongestString {
    public static void main(String[] args) {
        int n=4;
        String[] arr = {"ab","a","abc","abd"};
        System.out.println(longestString(n,arr));
    }
    public static String longestString(int n, String[] arr) {
        // code here
        TrieNode root = new TrieNode();
        for(String s : arr) {
            add(root,s);
        }
        String ans ="";
        for(String s : arr) {
            if(isValid(root,s)) {
                if(ans.length()<s.length()) {
                    ans=s;
                } else if(ans.length()==s.length()) {
                    if(ans.compareTo(s)>0) ans=s;
                }
            }
        }
        return ans;
    }

    public static void add(TrieNode root,String s) {
        int index;
        for(int i=0;i<s.length();i++) {
            index = s.charAt(i)-'a';
            if(root.node[index]==null) root.node[index] = new TrieNode();
            root = root.node[index];
        }
        root.isWord=true;
    }

    public static class TrieNode{
        TrieNode[] node;
        boolean isWord=false;
        TrieNode() {
            node = new TrieNode[26];
        }
    }

    public static boolean isValid(TrieNode root,String s) {
        int index;
        for(int i=0;i<s.length();i++) {
            index = s.charAt(i)-'a';
            // if(root.node[index]==null) return false;
            root = root.node[index];
            if(!root.isWord) return false;
        }
        return true;
    }
}