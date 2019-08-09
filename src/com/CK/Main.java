package com.CK;

public class Main {

    public static void main(String[] args) {
        char[] s = {'t', 'h', 'e', ' ', 's', 'k', 'y', ' ', 'i', 's', ' ', 'b', 'l', 'u', 'e'};
        Solution solution = new Solution();
        solution.reverseWords(s);
        System.out.println(s);
    }
}

class Solution {
    public void reverseWords(char[] s) {
        if (s.length == 0) return;
        String reversed = reverseWordString(String.valueOf(s));
        for (int i = 0; i < s.length; i++) {
            s[i] = reversed.charAt(i);
        }
    }

    private String reverseWordString(String s) {
        if (s.length() == 0) return "";
        String[] sArr = s.split(" ");
        StringBuilder sb = new StringBuilder();
        for (int i = sArr.length - 1; i >= 0; i--) {
            if (sArr[i].length() == 0) continue;
            sb.append(sArr[i]).append(" ");
        }
        return sb.toString().trim();
    }
}

//In-place
class Solution2 {
    public void reverseWords(char[] s) {
        if (s.length == 0) return;
        reverseArr(s, 0, s.length - 1);
        int st = 0, ed = 0;
        for (int i = 0; i < s.length; i++) {
            if (s[i] == ' ') {
                ed = i - 1;
                reverseArr(s, st, ed);
                st = i + 1;
            } else if (i == s.length - 1) {
                ed = i;
                reverseArr(s, st, ed);
            }
        }
    }

    public void reverseArr(char[] s, int start, int end) {
        while (start < end) {
            char temp = s[start];
            s[start] = s[end];
            s[end] = temp;
            start++;
            end--;
        }
    }
}

