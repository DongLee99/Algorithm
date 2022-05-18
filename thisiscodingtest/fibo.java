
public class main {

    public static int [] dp = new int[100];

    public static int fibo(int x) {
        if (x == 1) {
            return 1;
        }
        if (x == 2) {
            return 1;
        }

        if (dp[x] != 0) {
            return dp[x];
        }
        dp[x] = fibo(x-1) + fibo(x-2);
        return dp[x];
    }

    public static void main(String[] args) {
        dp[1] = 1;
        dp[2] = 1;
        System.out.println(fibo(6));
    }
}
