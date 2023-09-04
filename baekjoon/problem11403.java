import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static int N;
    public static int[][] arr;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        arr = new int[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                arr[i][j] = sc.nextInt();
                if (arr[i][j] == 0) {
                    arr[i][j] = 987654321;
                }
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                for (int k = 0; k < N; k++) {
                    if (arr[j][i] + arr[i][k] < arr[j][k]) {
                        arr[j][k] = arr[j][i] + arr[i][k];
                    }
                }
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (arr[i][j] == 987654321) {
                    System.out.print(0 + " ");
                    continue;
                }
                if (arr[i][j] > 0) {
                    System.out.print(1 + " ");
                    continue;
                }
            }
            System.out.println();
        }
    }
}
