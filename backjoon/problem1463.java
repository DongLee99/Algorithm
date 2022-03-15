import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class problem {
    static Integer [] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int X = Integer.parseInt(bf.readLine());
        dp = new Integer[X+1];
        dp[0] = dp[1] = 0;
        System.out.println(solve(X));
    }

    private static int solve(int x) {

        if (dp[x] == null) {
            if (x % 6 == 0) {
                dp[x] = Math.min(solve(x-1), Math.min(solve(x/3), solve(x/2))) + 1;
            } else if (x % 3 == 0) {
                dp[x] = Math.min(solve(x/3), solve(x-1)) + 1;
            } else if (x % 2 == 0) {
                dp[x] = Math.min(solve(x/2), solve(x-1)) + 1;
            } else {
                dp[x] = solve(x-1) + 1;
            }
        }
        return dp[x];
    }
}