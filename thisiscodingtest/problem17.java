import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class main {

    public static int [] dp;

    public static int find(int x) {
        if (x == 1) {
            return 1;
        }
        if (x == 2) {
            return 3;
        }
        for (int i = 3; i <= x; i++) {
            dp[i] = dp[i-1] + 2 * dp[i-2];
        }
        return dp[x];
    }
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bf.readLine());
        dp = new int[N+1];
        dp[1] = 1;
        dp[2] = 3;
        System.out.println(find(N));
    }
}
