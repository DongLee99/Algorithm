import java.util.*;

class Solution {
    boolean solution(String s) {
        boolean answer = true;
        Stack<String> stack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            if (stack.isEmpty()) {
                if (s.charAt(i) == ')') {
                    return false;
                } else {
                    stack.add("(");
                    continue;
                }
            }
            if (s.charAt(i) == ')') {
                if (stack.peek() == "(") {
                    stack.pop();
                } else {
                    stack.add(")");
                }
            } else {
                stack.add("(");
            }
        }
        if (stack.size() == 0) {
            return true;
        } else {
            return false;
        }
    }
}