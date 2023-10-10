import java.util.*;

public class Main {
    public static int N;
    public static int M;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();

        Set<Integer> s = new HashSet<>();
        for (int i = 0; i < N; i++) {
            s.add(sc.nextInt());
        }
        M = sc.nextInt();
        for시 (int i = 0; i < M; i++) {
            int tmp = sc.nextInt();
            if (s.contains(tmp)) {
                System.out.print(1 + " ");
            } else {
                System.out.print(0 + " ");
            }
        }
    }
}