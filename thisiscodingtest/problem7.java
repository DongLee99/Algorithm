import java.io.*;
import java.util.HashMap;
import java.util.StringTokenizer;

public class problem {
    public static void main(String[] args) throws IOException {
        int [][] d = {{0, -1}, {-1, 0}, {0, 1}, {1, 0}};
        int count = 0;
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int [][] arr = new int[N][M];
        boolean [][] visited = new boolean[N][M];
        st = new StringTokenizer(bf.readLine());
        int x = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());
        int s = Integer.parseInt(st.nextToken());
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(bf.readLine());
            for (int j = 0; j < M; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        visited[x][y] = true;

        while(true) {
            boolean check = false;
            for (int i = 0; i < 4; i++) {
                if (s < 3) {
                    s++;
                } else if (s == 3) {
                    s = 0;
                }
                int dx = x + d[s][0];
                int dy = y + d[s][1];
                if (dx >= 1 && dx < N && dy >= 1 && dy < M) {
                    if (visited[dx][dy] == false && arr[dx][dy] == 0) {
                        x = dx;
                        y = dy;
                        System.out.println(dx + " " + dy);
                        visited[x][y] = true;
                        count++;
                        System.out.println(count);
                        check = true;
                        continue;
                    }
                }
            }
            if (check == false) {
                int dx = x - d[s][0];
                int dy = x - d[s][1];
                if (dx >= 1 && dx < N && dy >= 1 && dy < M) {
                    if (arr[dx][dy] == 0) {
                        x = dx;
                        y = dy;
                    } else {
                        break;
                    }
                }
            }
        }
        System.out.println(count + 1);
    }
}