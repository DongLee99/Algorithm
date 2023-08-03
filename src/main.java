import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int K = scanner.nextInt();
        int [] array = new int[N];
        for (int i = 0; i < N; i++) {
            array[i] = scanner.nextInt();
        }
        int result = 0;
        int MAX = Integer.MIN_VALUE;
        for (int i = 0; i < N; i++) {
            if (i < K) {
                result = result + array[i];
            } else {
                MAX = Math.max(MAX, result);
                result = result - array[i - K] + array[i];
                MAX = Math.max(MAX, result);
            }
        }
        MAX = Math.max(MAX, result);
        System.out.println(MAX);
    }
}
