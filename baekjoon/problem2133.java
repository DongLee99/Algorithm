import java.util.Scanner;

class problem{
    static int [] dp = new int [1000];

    static int dp(int n) {
        if (n == 0) return 1;
        if (n == 1) return 0;
        if (n == 2) return 3;
        if (dp[n] != 0) return dp[n];
        int result = 3 * dp(n-2);
        for (int i = 3; i <= n; i++) {
            if (i % 2 == 0) {
                result += 2 * dp(n-i);
            }
        }
        return dp[n] = result;
    }

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int x = s.nextInt();
        System.out.println(dp(x));
    }
}