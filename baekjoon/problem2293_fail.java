import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.SQLOutput;
import java.util.*;
import java.util.stream.Collectors;

class main {

    public static int [] dp;
    public static int [] numbers;
    public static int n;
    public static int k;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        k = scanner.nextInt();
        numbers = new int[n];
        dp = new int[k + 1];
        for (int i = 0; i < n; i++) {
            numbers[i] = scanner.nextInt();
        }
        Arrays.sort(numbers);
        dp[0] = 1;
        dp[numbers[0]] = 1;
        for (int i = 0; i < n; i++) {
            for (int j = numbers[i]; j <= k; j++) {
                dp[j] = dp[j] + dp[j-numbers[i]];
            }
        }
        System.out.println(dp[k]);
    }
}