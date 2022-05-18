import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class main {

    public static int [] dp;

    public static void find(int x) {

        for (int i = 3; i <= x; i++) {
            dp[i] = Math.max(dp[i - 2] + dp[i], dp[i - 1]);
        }
    }



    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bf.readLine());
        StringTokenizer st = new StringTokenizer(bf.readLine());
        dp = new int[N+1];

        for (int i = 1; i <= N; i++) {
            dp[i] = Integer.parseInt(st.nextToken());
        }

        find(N);
        System.out.println(dp[4]);
    }
}
