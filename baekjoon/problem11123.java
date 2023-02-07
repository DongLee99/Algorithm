import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class problem {

    static int T;
    static int H;
    static int W;
    static int [] dx = {0, 0, 1, -1};
    static int [] dy = {1, -1, 0, 0};
    static String [][] arr;
    static boolean [][] visit;

    static void dfs(int i, int j) {
        if (visit[i][j] == false) {
            visit[i][j] = true;
        } else {
            return;
        }

        for (int k = 0; k < 4; k++) {
            int cx = i + dx[k];
            int cy = j + dy[k];
            if (cx >= 0 && cx < H && cy >= 0 && cy < W) {
                if (visit[cx][cy] == false && arr[cx][cy].equals("#")) {
                    dfs(cx, cy);
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        T = Integer.parseInt(st.nextToken());
        for (int c = 0; c < T; c++) {
            st = new StringTokenizer(bf.readLine());
            H = Integer.parseInt(st.nextToken());
            W = Integer.parseInt(st.nextToken());
            arr = new String[H][W];
            visit = new boolean[H][W];
            for (int i = 0; i < H; i++) {
                String buffer = bf.readLine();
                for (int j = 0; j < W; j++) {
                    arr[i][j] = String.valueOf(buffer.charAt(j));
                }
            }
            int count = 0;
            for (int i = 0; i < H; i++) {
                for (int j = 0; j < W; j++) {
                    if (visit[i][j] == false && arr[i][j].equals("#")) {
                        count++;
                        dfs(i, j);
                    }
                }
            }

            System.out.println(count);
        }
    }
}