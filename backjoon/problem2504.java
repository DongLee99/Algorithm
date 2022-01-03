import java.util.EmptyStackException;
import java.util.Scanner;
import java.util.Stack;

public class problem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String next = scanner.next();
        Stack<String> stack = new Stack<>();
        Stack<String> stack2 = new Stack<>();
        boolean result = false;
        int temp = 1;
        int ans = 0;
        try {
            for (int i = 0; i < next.length(); i++) {
                if (next.charAt(i) == '(') {
                    temp = temp * 2;
                    stack.push(String.valueOf(next.charAt(i)));
                    stack2.push(String.valueOf(next.charAt(i)));
                    continue;
                } else if (next.charAt(i) == '[') {
                    temp = temp * 3;
                    stack.push(String.valueOf(next.charAt(i)));
                    stack2.push(String.valueOf(next.charAt(i)));
                    continue;
                } else if (next.charAt(i) == ')') {
                    if (stack.peek().equals("(")) {
                        ans = ans + temp;
                    }
                    if (stack2.peek().equals("(")) {
                        stack2.pop();
                    }
                    stack.push(String.valueOf(next.charAt(i)));
                    temp = temp / 2;
                    continue;
                } else if (next.charAt(i) == ']') {
                    if (stack.peek().equals("[")) {
                        ans = ans + temp;
                    }
                    if (stack2.peek().equals("[")) {
                        stack2.pop();
                    }
                    stack.push(String.valueOf(next.charAt(i)));
                    temp = temp / 3;
                    continue;
                }
            }
        } catch (EmptyStackException e) {
            result = true;
        }
        if (result == false && stack2.empty()) {
            System.out.println(ans);
        } else {
            System.out.println(0);
        }
    }
}
