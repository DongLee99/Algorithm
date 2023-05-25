import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static int[][] arr;
    public static int[][] dp1;
    public static int[][] dp2;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        arr = new int[N+1][3];
        dp1 = new int[N+1][3];
        dp2 = new int[N+1][3];
        dp1[0][0] = 0;
        dp1[0][1] = 0;
        dp1[0][2] = 0;
        dp2[0][0] = 0;
        dp2[0][0] = 0;
        dp2[0][0] = 0;
        int answer1 = 0;

        for (int i = 0; i < N; i++) {
            String[] strs = br.readLine().split(" ");
            arr[i+1][0] = Integer.parseInt(strs[0]);
            arr[i+1][1] = Integer.parseInt(strs[1]);
            arr[i+1][2] = Integer.parseInt(strs[2]);
        }

        for (int i = 1; i <= N; i++) {
            dp1[i][0] = Math.max(dp1[i-1][0] + arr[i][0], dp1[i-1][1] + arr[i][0]);
            dp1[i][1] = Math.max(dp1[i-1][0] + arr[i][1], Math.max(dp1[i-1][2] +arr[i][1], dp1[i-1][1] + arr[i][1]));
            dp1[i][2] = Math.max(dp1[i-1][1] + arr[i][2], dp1[i-1][2] + arr[i][2]);
            answer1 = Math.max(dp1[i][0], Math.max(dp1[i][1], dp1[i][2]));
        }
        int answer2 = 0;
        for (int i = 1; i <= N; i++) {
            dp2[i][0] = Math.min(dp2[i-1][0] + arr[i][0], dp2[i-1][1] + arr[i][0]);
            dp2[i][1] = Math.min(dp2[i-1][0] + arr[i][1], Math.min(dp2[i-1][2] +arr[i][1], dp2[i-1][1] + arr[i][1]));
            dp2[i][2] = Math.min(dp2[i-1][1] + arr[i][2], dp2[i-1][2] + arr[i][2]);
            answer2 = Math.min(dp2[i][0], Math.min(dp2[i][1], dp2[i][2]));
        }
        System.out.println(answer1 + " " + answer2);
    }
}
