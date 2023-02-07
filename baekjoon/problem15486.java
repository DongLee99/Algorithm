import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class problem {
    static int [] dp;
    static int [] day;
    static int [] task;
    static int N;
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(bf.readLine());
        dp = new int[N+2];
        day = new int[N+2];
        task = new int[N+2];

        for (int i = 1; i < N + 1; i++) {
            StringTokenizer st = new StringTokenizer(bf.readLine());
            day[i] = Integer.parseInt(st.nextToken());
            task[i] = Integer.parseInt(st.nextToken());
        }

        int max = Integer.MIN_VALUE;

        for (int i = 1; i < N + 2; i++) {

            if (max < dp[i]) {
                max = dp[i];
            }

            int d = i + day[i];

            if (d < N + 2) {
                dp[d] = Math.max(max + task[i], dp[d]);
            }
        }
        System.out.println(max);
    }
}