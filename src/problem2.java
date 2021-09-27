import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class problem2 {
    public static void main(String[] args) {
        int[][] dp;
        int[] w;
        int[] v;
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int k = scanner.nextInt();
        dp = new int[n+1][k+1];
        w = new int[n+1];
        v = new int[n+1];

        for(int i = 1; i <= n; i++) {
            w[i] = scanner.nextInt();
            v[i] = scanner.nextInt();
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= k; j++) {
                dp[i][j] = dp[i-1][j];
                if (j - w[i] >= 0) { //j는 현재 무게, w[i]는 현재 무게에 해당하는 입력되어있는 무게
                    dp[i][j] = Math.max(dp[i-1][j], dp[i-1][j-w[i]]+v[i]); //이전꺼 (13) + dp[2][7-3]+v[3] = 8 + 6
                }
            }
        }

        System.out.println(dp[n][k]);
    }
}