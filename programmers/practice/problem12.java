import java.util.*;

class Solution {

    public int solution(int[] ingredient) {
        int answer = 0;
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < ingredient.length; i++) {
            if (ingredient[i] == 1 && stack.size() >= 3) {
                stack.push(ingredient[i]);
                if (stack.get(stack.size() -1) == 1 && stack.get(stack.size() -2) == 3 && stack.get(stack.size() -3) == 2 && stack.get(stack.size() -4) == 1) {
                    stack.pop();
                    stack.pop();
                    stack.pop();
                    stack.pop();
                    answer++;
                }
            } else {
                stack.push(ingredient[i]);
            }
        }
        return answer;
    }
}