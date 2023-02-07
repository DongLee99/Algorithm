
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class problem{
    static int dp [] = new int [41];

    static int d(int num) {
        if (num == 0) {
            return 0;
        }
        if (num == 1) {
            return 1;
        }
        if (dp[num] != 0) {
            return dp[num];
        }
        return dp[num] = d(num-1) + d(num-2);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        dp[0] = 0;
        dp[1] = 1;
        dp[2] = 1;
        for (int i = 0; i < N; i++) {
            int x = Integer.parseInt(br.readLine());
            if (x == 0) {
                System.out.println("1 0");
            } else if (x == 1) {
                System.out.println("0 1");
            } else {
                d(x);
                System.out.println(dp[x - 1] + " " + dp[x]);
            }
        }

    }


}