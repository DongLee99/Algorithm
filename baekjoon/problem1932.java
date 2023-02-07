import java.util.Scanner;

public class problem {
    static Integer [][] dp;
    static int [][] arr;
    static int N;

    static int d(int n, int depth) {
        if (depth == N - 1) {
            return dp[depth][n];
        }
        if (dp[depth][n] == null) {
            dp[depth][n] = Math.max(d(n+1, depth+1), d(n, depth+1)) + arr[depth][n];
        }
        return dp[depth][n];
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        N = scanner.nextInt();
        dp = new Integer [N][N];
        arr = new int [N][N];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < i + 1; j++) {
                arr[i][j] = scanner.nextInt();
            }
        }
        for (int i = 0; i < N; i++) {
            dp[N - 1][i] = arr[N - 1][i];
        }

        System.out.println(d(0, 0));
    }
}