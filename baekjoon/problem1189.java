import java.util.*;



public class Main
{
    public static int R;
    public static int C;
    public static int K;
    public static int [][] arr;
    public static boolean [][] visited;
    public static int result = 0;
    public static int [] dx = {0, 0, 1, -1};
    public static int [] dy = {1, -1, 0, 0};

    public static void find(int x, int y, int count) {
        if (count > K) {
            return;
        }
        if (count == K && x == 0 && y == C-1) {
            result++;
            return;
        }
        for (int i = 0; i < 4; i++) {
            int cx = x + dx[i];
            int cy = y + dy[i];
            if (cx >= 0 && cx < R && cy >= 0 && cy < C) {
                if (visited[cx][cy] == false && arr[cx][cy] != 1) {
                    visited[cx][cy] = true;
                    find(cx, cy, count+1);
                    visited[cx][cy] = false;
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        R = sc.nextInt();
        C = sc.nextInt();
        K = sc.nextInt();
        arr = new int[R][C];
        visited = new boolean[R][C];

        for (int i = 0; i < R; i++) {
            String tmp = sc.next();
            for (int j = 0; j < C; j++) {
                if (tmp.charAt(j) == 'T') {
                    arr[i][j] = 1;
                } else {
                    arr[i][j] = 0;
                }
            }
        }
        visited[R-1][0] = true;
        find(R-1, 0, 1);
        System.out.println(result);
    }
}