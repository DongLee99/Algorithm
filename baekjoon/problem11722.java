import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class problem {
    static int [] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bf.readLine());
        int [] arr = new int[N+1];

        StringTokenizer st = new StringTokenizer(bf.readLine());
        for (int i = 1; i <= N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        dp = new int[N+1];
        dp[1] = 1;

        for (int i = 2; i <= N; i++) {
            dp[i] = 1;
            for (int j = 0; j < i; j++) {
                if (arr[i] < arr[j] && dp[i] <= dp[j]) {
                    dp[i] = dp[j] + 1;
                } else if (arr[i] == arr[j]) {
                    dp[i] = dp[j];
                }
            }
        }
        int max = Integer.MIN_VALUE;

        for (int i : dp) {
            max = Math.max(max, i);
        }

        System.out.println(max);
    }
}