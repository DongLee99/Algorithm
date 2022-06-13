import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class main {

    public static boolean [][] visit;
    public static String [][] arr;
    public static String [][] arr2;
    public static int count1 = 0;
    public static int count2 = 0;

    public static int N;
    public static int [] dx = {0, 1, 0, -1};
    public static int [] dy = {-1, 0, 1, 0};


    public static void dfs(String color, int x, int y, String [][] s_arr) {
        visit[x][y] = true;

        for (int i = 0; i < 4; i++) {
            int cx = x + dx[i];
            int cy = y + dy[i];

            if (cx >= 0 && cx < N && cy >= 0 && cy < N) {
                if (visit[cx][cy] == false && s_arr[cx][cy].equals(color)) {
                    System.out.println(cx + "    " + cy + s_arr[cx][cy]);
                    dfs(color, cx, cy, s_arr);
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(bf.readLine());

        visit = new boolean[N][N];
        arr = new String[N][N];
        arr2 = new String[N][N];
        for (int i = 0; i < N; i++) {
            String buffer = bf.readLine();
            for (int j = 0; j < N; j++) {
                arr[i][j] = String.valueOf(buffer.charAt(j));
                if (String.valueOf(buffer.charAt(j)).equals("R")) {
                    arr2[i][j] = "G";
                } else {
                    arr2[i][j] = String.valueOf(buffer.charAt(j));
                }
            }
        }
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (visit[i][j] != true) {
                    if (arr[i][j].equals("R")) {
                        dfs("R", i, j, arr);
                        count1++;
                    } else if (arr[i][j].equals("B")) {
                        dfs("B", i, j, arr);
                        count1++;
                    } else if (arr[i][j].equals("G")){
                        dfs("G", i, j, arr);
                        count1++;
                    }
                }
            }
        }
        visit = new boolean[N][N];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (visit[i][j] == false) {
                    if (arr2[i][j].equals("G")) {
                        dfs("G", i, j, arr2);
                        count2++;
                    } else if (arr2[i][j].equals("B")) {
                        dfs("B", i, j, arr2);
                        count2++;
                    }
                }
            }
        }
        System.out.println(count1 + " " + count2);
    }
}
