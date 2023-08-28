import java.util.*;
public class Main {

    public static int N;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        String tmp = sc.next();
        int startNum = 65;
        HashMap<Integer, Double> map = new HashMap<>();

        for (int i = 0; i < N; i++) {
            double input = sc.nextDouble();
            map.put(startNum++, input);
        }

        char[] stringToChar = tmp.toCharArray();
        Stack<Double> stack = new Stack<>();
        for (char c : stringToChar) {
            if (c == '*') {
                double first = stack.pop();
                double second = stack.pop();
                stack.add(first * second);
                continue;
            } else if (c == '+') {
                double first = stack.pop();
                double second = stack.pop();
                stack.add(first + second);
                continue;
            } else if (c == '-') {
                double first = stack.pop();
                double second = stack.pop();
                stack.add(second - first);
                continue;
            } else if (c == '/') {
                double first = stack.pop();
                double second = stack.pop();
                stack.add(second / first);
                continue;
            } else {
                stack.add(map.get((int) c));
                continue;
            }
        }
        System.out.println(String.format("%.2f",stack.pop()));
    }
}
