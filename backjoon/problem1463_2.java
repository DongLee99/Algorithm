import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class problem {

    static Integer [] dp;
    static int N;

    static int solve(int n) {
        if (dp[n] == null) {
            if (n % 6 == 0) {
                dp[n] = Math.min(solve(n-1), Math.min(solve(n/3), solve(n/2))) + 1;
            } else if (n % 3 == 0) {
                dp[n] = Math.min(solve(n/3),solve(n-1)) + 1;
            } else if (n % 2 == 0) {
                dp[n] = Math.min(solve(n/2),solve(n-1)) + 1;
            } else {
                dp[n] = solve(n-1) + 1;
            }
        }
        return dp[n];
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(bf.readLine());
        N = Integer.parseInt(st.nextToken());
        dp = new Integer[N + 1];
        dp[0] = dp[1] = 0;
        System.out.println(solve(N));
    }
}