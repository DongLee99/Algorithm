import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.Buffer;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        br.readLine();
        List<Integer> a = new ArrayList<>();
        Collections.sort(a);
        StringTo
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
