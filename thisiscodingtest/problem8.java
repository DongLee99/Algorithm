import java.io.*;
import java.util.StringTokenizer;

public class problem {

    static int N;
    static int M;
    static int [][] arr;
    static boolean [][] visited;
    static int [] dx = {0, 0, 1, -1};
    static int [] dy = {1, -1, 0, 0};
    static void dfs(int x, int y) {
        if (visited[x][y] == false) {
            visited[x][y] = true;

            for (int i = 0; i < 4; i++) {
                int cx = x + dx[i];
                int cy = y + dy[i];

                if (cx >= 0 && cx < N && cy >= 0 && cy < M) {
                    if (visited[cx][cy] == false && arr[cx][cy] == 0) {
                        dfs(cx, cy);
                    }
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[N][M];
        visited = new boolean[N][M];
        for (int i = 0; i < N; i++) {
            String buffer = bf.readLine();
            for (int j = 0; j < M; j++) {
                arr[i][j] = Integer.parseInt(String.valueOf(buffer.charAt(j)));
            }
        }

        int count = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (visited[i][j] == false && arr[i][j] == 0) {
                    count++;
                    dfs(i, j);
                }
            }
        }
        System.out.println(count);

    }
}