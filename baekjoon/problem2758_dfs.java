import java.io.*;
import java.util.*;

public class main {

    public static int T;
    public static int N;
    public static int M;
    public static long [][] arr;
    public static boolean [] visited;
    public static long result = 0;
    public static void dfs(int start , int count) {
        if (count == N) {
            result++;
            arr[count][start] = result;
            return;
        }

        for (int i = start * 2; i <= M; i++) {
            if (visited[i] == false) {
                visited[i] = true;
                dfs(i, count+1);
                visited[i] = false;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(bf.readLine());
        arr = new long[11][2001];
        visited = new boolean[2001];

        for (int j = 0; j < T; j++) {
            StringTokenizer st = new StringTokenizer(bf.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            result = 0;
            if (arr[N][M] == 0) {
                for (int i = 1; i <= M; i++) {
                    visited[i] = true;
                    dfs(i, 1);
                    visited[i] = false;
                }
                System.out.println(arr[N][M]);
            } else {
                System.out.println(arr[N][M]);
            }
        }
    }
}