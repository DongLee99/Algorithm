// you can also use imports, for example:
import java.util.*;

// you can write to stdout for debugging purposes, e.g.
// System.out.println("this is a debug message");

class Solution {
    public static int questionCount = 0;
    public static char [] arr;
    public static boolean [] visited;
    public static char [] brackets = {'<', '>'};
    public static int MAX = Integer.MIN_VALUE;

    public void find() {
        Stack<Character> stack = new Stack<>();
        int countLeft = 0;
        int countRight = 0;
        for (int i = 0; i < arr.length; i++) {
            if (stack.isEmpty()) {
                if (arr[i] == '>') {
                    continue;
                } else {
                    countLeft++;
                    stack.add(arr[i]);
                }
            } else {
                if (arr[i] == '>') {
                    if (countLeft > countRight) {
                        countRight++;
                    } else {
                        MAX = Math.max(MAX, countRight);
                        countLeft = 0;
                        countRight = 0;
                        while (!stack.isEmpty()) {
                            stack.pop();
                        }
                    }
                } else if (countRight != 0) {
                    if (arr[i] == '<') {
                        MAX = Math.max(MAX, countRight);
                        countLeft = 0;
                        countRight = 0;
                        while (!stack.isEmpty()) {
                            stack.pop();
                        }
                        stack.add(arr[i]);
                        countLeft++;
                    }
                } else {
                    stack.add(arr[i]);
                    countLeft++;
                }

            }
        }
        MAX = Math.max(MAX, countRight);
    }

    public void dfs(int count) {
        if (count == questionCount) {
            find();
            return;
        }
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < 2; j++) {
                if (visited[i] == false) {
                    visited[i] = true;
                    arr[i] = brackets[j];
                    dfs(count + 1);
                    arr[i] = '?';
                    visited[i] = false;
                }
            }
        }
    }
    public int solution(String S) {
        arr = new char[S.length()];
        visited = new boolean[S.length()];
        for (int i = 0; i < S.length(); i++) {
            if (S.charAt(i) == '?') {
                questionCount++;
            } else {
                visited[i] = true;
            }
            arr[i] = S.charAt(i);
        }
        dfs(0);
        return MAX * 2;
    }
}

