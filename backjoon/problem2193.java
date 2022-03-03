import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class problem {
    static long [] dp = new long[91];

    static long find(int N) {
        if (N == 0) {
            return dp[0];
        }
        if (N == 1) {
            return dp[1];
        }
        dp[N] = find(N-1) + find(N-2);
        return dp[N];
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int N = Integer.parseInt(st.nextToken());
        dp[0] = 0;
        dp[1] = 1;
        dp[2] = 1;
        for (int i = 2; i <= N; i++) {
            dp[i] = dp[i-1] + dp[i-2];
        }
        System.out.println(dp[N]);
    }
}