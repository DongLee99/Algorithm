
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class problem{

    static int [] dp = new int [10000001];

    static int d(int n) {
        if (n == 1) {
            return 1;
        }
        if (n == 2) {
            return 2;
        }
        if (dp[n] != 0) {
            return dp[n];
        }
        else {
            return dp[n] = (d(n-1) + d(n-2)) % 15746;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        dp[0] = 0;
        dp[1] = 1;
        dp[2] = 2;
        System.out.println(d(N));
    }
}