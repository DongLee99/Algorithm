import java.io.IOException;
import java.util.Scanner;

class main {

    public static int [] dp;
    public static void main(String[] args) throws IOException {

        Scanner scanner = new Scanner(System.in);

        int N = scanner.nextInt();

        dp = new int [10001];
        for (int j = 1; j <= 10000; j++) {
            dp[j] = 1;
        }
        for (int j = 1; j <= 10000; j++) {
            if (j-2 > 0) {
                dp[j] = dp[j] + dp[j - 2];
            } else if (j - 2 == 0) {
                dp[j] = dp[j] + 1;
            } else {
                dp[j] = dp[j];
            }
        }
        for (int j = 1; j <= 10000; j++) {
            if (j-3 > 0) {
                dp[j] = dp[j] + dp[j - 3];
            } else if (j - 3 == 0) {
                dp[j] = dp[j] + 1;
            } else {
                dp[j] = dp[j];
            }
        }
        for (int i = 0; i < N; i++) {
            System.out.println(dp[scanner.nextInt()]);
        }
    }
}