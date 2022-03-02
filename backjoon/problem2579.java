import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class problem {
    static Integer[] dp;
    static int arr [];
    static int N;
    static int find(int N) {
        if (dp[N] == null) {
            dp[N] = Math.max(find(N-2) , find(N-3) + arr[N - 1] ) + arr[N];
        }
        return dp[N];
    }
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        N = Integer.parseInt(st.nextToken());
        dp = new Integer[N + 1];
        arr = new int [N + 1];
        for (int i = 1; i<= N; i++) {
            st = new StringTokenizer(bf.readLine());
            arr[i] = Integer.parseInt(st.nextToken());
        }

        dp[0] = arr[0];
        dp[1] = arr[1];
        if(N >= 2) {
            dp[2] = arr[1] + arr[2];
        }

        System.out.println(find(N));
    }
}