import java.util.*;

class main {

    public static int [][] dp;
    public static int n;
    public static int k;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        dp = new int[n+1][10];
        for (int i = 0; i < 10; i++) {
            dp[0][i] = 1;
        }
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j <= 9; j++) {
                if (j == 0) {
                    dp[i][j] = (dp[i - 1][0] + dp[i - 1][1] + dp[i - 1][2] + dp[i - 1][3] + dp[i - 1][4] + dp[i - 1][5] + dp[i - 1][6] + dp[i - 1][7] + dp[i - 1][8] + dp[i - 1][9] + 10007) % 10007;
                } else {
                    dp[i][j] = (dp[i][j - 1] - dp[i-1][j -1] + 10007) % 10007;
                }
            }
        }
        System.out.println(dp[n][0] % 10007);
    }
}