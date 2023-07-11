
import java.util.Arrays;
import java.util.Optional;
import java.util.Stack;


public class Main {
    public static int[][] dp;

    public static class Solution {
        public int solution(int m, int n, int[][] puddles) {
            int answer = 0;
            dp = new int[n+2][m+2];
            for (int i = 0; i < dp.length; i++) {
                Arrays.fill(dp[i], Integer.MAX_VALUE);
            }

            for (int i = 0; i < puddles.length; i++) {
                int x = puddles[i][0];
                int y = puddles[i][1];
                dp[x][y] = -1;
            }
            dp[1][1] = 0;
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= m; j++) {
                    System.out.print(dp[i][j] + " ");
                }
                System.out.println();
            }
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= m; j++) {
                    if (dp[i][j] != -1) {
                        if (dp[i][j+1] != -1) {
                            dp[i][j + 1] = Math.min(dp[i][j] + 1, dp[i][j + 1]) % 1000000007;
                        }
                        if (dp[i+1][j] != -1) {
                            dp[i + 1][j] = Math.min(dp[i][j] + 1, dp[i + 1][j]) % 1000000007;
                        }
                    }
                }
            }
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= m; j++) {
                    System.out.print(dp[i][j] + " ");
                }
                System.out.println();
            }
            return dp[n][m] % 1000000007;
        }
    }

    public static void main(String[] args) {
        int m = 4;
        int n = 3;
        int[][] puddles = new int[1][2];
        puddles[0][0] = 2;
        puddles[0][1] = 2;
        Solution solution = new Solution();
        System.out.println(solution.solution(m,n,puddles));
    }
}


