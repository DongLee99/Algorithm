
import java.util.Scanner;

class problem{
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int result = 0;

        int N = s.nextInt();

        int [] dp = new int [N];
        int [] arr = new int [N];

        dp[0] = 1;
        for (int i = 1; i < N; i++) {
            dp[i] = 1;
            for (int j = 0; j < N; j++) {
                if (arr[j] < arr[i] && dp[i] <= dp[j]) {
                    dp[i] = dp[j] + 1;
                }
            }
        }

        for (int i : dp) {
            result = Math.max(result, i);
        }

        System.out.println(result);
    }
}