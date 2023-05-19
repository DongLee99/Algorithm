import java.util.*;
import java.io.*;
class Solution
{
    public static int T;
    public static void main(String args[]) throws Exception
    {
        Scanner sc = new Scanner(System.in);
        T = sc.nextInt();
        System.out.println(T);
        for (int i = 1; i <= T; i++) {
            int N = sc.nextInt();
            System.out.println(N);
            int[][] arr = new int[N][N];
            boolean[][] visited = new boolean[N][N];
            int cnt = 1;
            int xStart = 0;
            int yStart = 0;
            int totalCnt = N * N;
            while (cnt <= totalCnt) {
                for (int j = yStart; j < N; j++) {
                    if (visited[xStart][j] == false) {
                        visited[xStart][j] = true;
                        arr[xStart][j] = cnt;
                        cnt++;
                        yStart = j;
                    }
                }
                for (int j = xStart; j < N; j++) {
                    if (visited[j][yStart] == false) {
                        visited[j][yStart] = true;
                        arr[j][yStart] = cnt;
                        cnt++;
                        xStart = j;
                    }
                }
                for (int j = yStart; j >= 0; j--) {
                    if (visited[xStart][j] == false) {
                        visited[xStart][j] = true;
                        arr[xStart][j] = cnt;
                        cnt++;
                        yStart = j;
                    }
                }
                for (int j = xStart; j >= 0; j--) {
                    if (visited[j][yStart] == false) {
                        visited[j][yStart] = true;
                        arr[j][yStart] = cnt;
                        cnt++;
                        xStart = j;
                    }
                }
            }
            System.out.println("#" + i);
            for (int j = 0; j < N; j++) {
                for (int k = 0; k < N; k++) {
                    System.out.print(arr[j][k] + " ");
                }
                System.out.println();
            }
        }
    }
}
