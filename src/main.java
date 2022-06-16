import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class main {

    public static int N;
    public static int M;
    public static int [] dp;
    public static int [] coins;

    public static void find(int x) {
        dp[0] = 0;
        for (int i = 0; i < N; i++) {
            for (int j = coins[i]; j <= x; j++) {
                if (dp[j - coins[i]] != 10001) {
                    dp[j] = Math.min(dp[j - coins[i]] + 1, dp[j]);
                }
            }
        }
    }
    a

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        coins = new int[N];
        dp = new int[M+1];
        Arrays.fill(dp, 10001);
        for (int i = 0; i < N; i++) {
            coins[i] = Integer.parseInt(bf.readLine());
        }
        find(M);
        System.out.println(dp[M]);
    }
}
