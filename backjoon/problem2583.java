import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.List;

public class problem {
    static int N;
    static int M;
    static int K;
    static boolean [][] visit;
    static int [][] arr;
    static int size = 0;
    static int count = 1;
    static int [] dx = {0, 0, 1, -1};
    static int [] dy = {-1, 1, 0, 0};
    static List<Integer> result = new ArrayList<>();

    static void dfs(int x, int y) {
        visit[x][y] = true;
        for (int i = 0; i < 4; i++) {
            int ax = x + dx[i];
            int ay = y + dy[i];
            if (ax >= 0 && ax < M && ay >= 0 && ay < N) {
                if (visit[ax][ay] == false && arr[ax][ay] == 0) {
                    count++;
                    dfs(ax,ay);
                }
            }
        }
    }



    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        visit = new boolean[M][N];
        arr = new int[M][N];

        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(bf.readLine());
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());
            for (int j = x1; j < x2; j++) {
                for (int k = y1; k < y2; k++) {
                    arr[j][k] = 1;
                    visit[j][k] = true;
                }
            }
        }

        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                if (visit[i][j] == false) {
                    dfs(i,j);
                    result.add(count);
                    count = 1;
                    size++;
                }
            }
        }
        System.out.println(size);
        Collections.sort(result);
        for (Integer integer : result) {
            System.out.print(integer + " ");
        }
    }
}