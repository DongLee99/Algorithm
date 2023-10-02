import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Main {

    public static int N;
    public static int K;
    public static int[] arr;
    public static int[] tmp;
    public static boolean[] visited;
    public static Set<String> set = new HashSet<>();

    public static void find(int depth) {
        if (depth == K) {
            String x = "";
            for (int i = 0; i < K; i++) {
                x = x + tmp[i];
            }
            set.add(x);
            return;
        }
        for (int i = 0; i < N; i++) {
            if (visited[i] == false) {
                visited[i] = true;
                tmp[depth] = arr[i];
                find(depth + 1);
                visited[i] = false;
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        K = sc.nextInt();
        arr = new int[N];
        tmp = new int[K];
        visited = new boolean[N];

        for (int i = 0; i < N; i++) {
            arr[i] = sc.nextInt();
        }
        find(0);
        System.out.println(set.size());
    }
}