import java.util.*;

public class Main {
    public static int N;
    public static int M;
    public static int[][] arr;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        M = sc.nextInt();
        arr = new int[N+1][N+1];

        for (int i = 0; i < M; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            arr[a][b] = 1;
            arr[b][a] = -1;
        }

        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                for (int k = 1; k <= N; k++) {
                    if (arr[j][i] == arr[i][k] && arr[j][i] != 0) {
                        arr[j][k] = arr[j][i];
                    }
                }
            }
        }

        for (int i = 1; i <= N; i++) {
            int ans = 0;
            for (int j = 1; j <= N; j++) {
                if (i == j)
                    continue;
                if (arr[i][j] == 0 && arr[j][i] == 0) {
                    ans++;
                }
            }
            System.out.println(ans);
        }
    }
}
