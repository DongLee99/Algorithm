import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class problem {
    static int [] dp;

    public static int solve(int x) {
        if (x > 3) {
            dp[x] = solve(x-1) + solve(x-2) + solve(x-3);
            return dp[x];
        }
        if (x < 0) {
            return 0;
        } else {
            return dp[x];
        }

    }
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int X = Integer.parseInt(bf.readLine());
        dp = new int[12];
        dp[0] = 0;
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 4;
        solve(11);
        for (int i = 0; i < X; i++) {
            int n = Integer.parseInt(bf.readLine());
            System.out.println(dp[n]);
        }
    }
}