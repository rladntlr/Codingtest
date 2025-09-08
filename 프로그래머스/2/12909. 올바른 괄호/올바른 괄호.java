import java.util.*;  
import java.io.*;    


class Solution {
    boolean solution(String s) {
        Deque<Character> st = new ArrayDeque<>();
        
        char[] a = s.toCharArray();
        for(char c : a){
            if(c == '(') st.push(c);
            else{
                if(st.isEmpty() || st.pop() == c) return false;
            }
        }
        return st.isEmpty();
    }
}