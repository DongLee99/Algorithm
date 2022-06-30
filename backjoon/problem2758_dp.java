import java.io.*;
import java.util.*;

public class main {

    public static int T;
    public static int N;
    public static int M;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(bf.readLine());

        for (int j = 0; j < T; j++) {
            StringTokenizer st = new StringTokenizer(bf.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            long [][] dp = new long[N+1][M+1];
            for (int i = 0; i <= M; i++) {
                dp[0][i] = 1;
            }

            for (int i = 1; i <= N; i++) {
                for (int k = 1; k <= M; k++) {
                    dp[i][k] = dp[i-1][k/2] + dp[i][k-1];
                }
            }
            System.out.println(dp[N][M]);
        }
    }
}