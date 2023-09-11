import java.util.*;

class Solution {
    public static boolean check(String sub) {
        char[] cArr = sub.toCharArray();
        Stack<Character> q = new Stack<>();

        for (int i = 0; i < cArr.length; i++) {
            if (q.isEmpty()) {
                q.add(cArr[i]);
            } else {
                if (cArr[i] == ')') {
                    if (q.peek() == '(') {
                        q.pop();
                    } else {
                        q.add(cArr[i]);
                    }
                } else if (cArr[i] == '}') {
                    if (q.peek() == '{') {
                        q.pop();
                    } else {
                        q.add(cArr[i]);
                    }
                } else if (cArr[i] == ']') {
                    if (q.peek() == '[') {
                        q.pop();
                    } else {
                        q.add(cArr[i]);
                    }
                } else {
                    q.add(cArr[i]);
                }
            }
        }
        if (q.isEmpty()) {
            return true;
        }
        return false;
    }
    public int solution(String s) {
        int count = 0;
        String tmp = s;
        for (int i = 0; i < tmp.length(); i++) {
            tmp = tmp.substring(1, tmp.length()) + tmp.substring(0, 1);
            if (check(tmp)) {
                count++;
            };
        }

        return count;
    }
}