import java.util.*;

class Solution {
    public int solution(int[] order) {
        Stack<Integer> stack = new Stack<>();
        int answer = 0;
        int size = order.length;
        int count = 0;
        int start = 1;
        while(true) {
            if (!stack.isEmpty() && order[count] == stack.peek()) {
                stack.pop();
                answer++;
                count++;
                continue;
            }

            if (start > size) {
                break;
            }

            if (order[count] == start) {
                answer++;
                start++;
                count++;
                continue;
            }

            stack.push(start);
            start++;
        }
        return answer;
    }
}