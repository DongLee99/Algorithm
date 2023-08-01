import java.util.*;
public class Main {
    public static void main(String[] args) {
        Deque<Integer> deque = new LinkedList<>();
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        for (int i = 1; i <= N; i++) {
            deque.add(i);
        }
        while (deque.size() != 1) {
            deque.poll();
            deque.add(deque.peek());
            deque.poll();
        }
        System.out.println(deque.poll());
    }
}
