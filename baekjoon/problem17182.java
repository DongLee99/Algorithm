import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.*;
public class Main {
    public static int N;
    public static int DESTINATION;
    public static int [][] map;
    public static boolean [] visited;
    public static int[] arr;
    public static int MIN = Integer.MAX_VALUE;

    public static void dfs(int count, int before, int sum) {
        if (count == N) {
            MIN = Math.min(MIN, sum);
            return;
        }

        for (int i = 0; i < N; i++) {
            if (visited[i] == false) {
                visited[i] = true;
                arr[count] = i;
                dfs(count + 1, i, sum + map[before][i]);
                arr[count] = 0;
                visited[i] = false;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader sb = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(sb.readLine());
        N = Integer.parseInt(st.nextToken());
        DESTINATION = Integer.parseInt(st.nextToken());
        map = new int[N][N];
        arr = new int[N];
        visited = new boolean[N];


        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(sb.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int k = 0; k < N; k++) {
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (i == j) continue;
                    map[i][j] = Math.min(map[i][j], map[i][k] + map[k][j]);
                }
            }
        }
        dfs(0, DESTINATION, 0);
        System.out.println(MIN);
    }
}
