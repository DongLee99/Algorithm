import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class main {

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bf.readLine());
        int [] coins = new int[N + 1];
        int [] dp = new int [N + 1];
        String [] str = bf.readLine().split(" ");
        for (int i = 1; i <= N; i++) {
            coins[i] = Integer.parseInt(str[i-1]);
        }

        for (int i = 1; i <= N; i++) {
            dp[i] = coins[1] * i;
        }

        for (int i = 2; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                if (j - i >= 0) {
                    dp[j] = Math.max(coins[i] + dp[j - i], dp[j]);
                }
            }
        }
        System.out.println(dp[N]);
    }
}