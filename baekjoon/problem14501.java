import java.util.Scanner;

class main {

    public static int N;
    public static int [] dp;
    public static int MAX = 0;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        N = scanner.nextInt();
        dp = new int [N + 1];
        for (int i = 0; i < N; i++) {
            int time = scanner.nextInt();
            int value = scanner.nextInt();
            if (i + time <= N) {
                if (i - 1 >= 0) {
                    dp[i] = Math.max(dp[i], dp[i - 1]);
                }
                dp[i + time] = Math.max(dp[i + time], dp[i] + value);
                MAX = Math.max(dp[i+time], MAX);
            }
        }
        System.out.println(MAX);
    }
}