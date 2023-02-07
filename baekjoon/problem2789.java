import java.util.*;

public class problem {
    static int N;
    static int M;
    static boolean [] visit;
    static int [] numbers;
    static int Min = Integer.MAX_VALUE;

    static void check(int num, int depth) {
        if (depth == 3) {
            if (M >= num && (M - num) < Min) {
                Min = M-num;
            }
        } else {
            for (int i = 1; i < N+1; i++) {
                if (visit[i] == false) {
                    visit[i] = true;
                    check(num + numbers[i], depth + 1);
                    visit[i] = false;
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        N = scanner.nextInt();
        M = scanner.nextInt();

        numbers = new int [N + 1];
        visit = new boolean [N + 1];

        for (int i = 1; i <= N; i++) {
            numbers[i] = scanner.nextInt();
        }

        for (int i = 1; i <= N; i++) {
            visit[i] = true;
            check(numbers[i], 1);
            visit[i] = false;
        }
        System.out.println(M - Min);
    }
}