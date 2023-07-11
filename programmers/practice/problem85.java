import java.util.*;

class Solution
{
    public int solution(String s)
    {
        Stack<String> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            String now = String.valueOf(s.charAt(i));
            if (stack.isEmpty()) {
                stack.add(now);
            } else {
                if (stack.peek().equals(now)) {
                    stack.pop();
                } else {
                    stack.add(now);
                }
            }
        }
        if (stack.isEmpty()) {
            return 1;
        } else {
            return 0;
        }
    }
}