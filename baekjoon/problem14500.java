import java.util.Scanner;

class main {
    public static int N;
    public static int M;
    public static boolean [][] visited;
    public static int [][] arr;
    public static int [] dx = {1, -1, 0, 0};
    public static int [] dy = {0, 0, -1, 1};
    public static int MAX = Integer.MIN_VALUE;

    public static void dfs(int x, int y, int count, int number) {
        if (count == 4) {
            MAX = Math.max(number, MAX);
            return;
        }
        for (int i = 0; i < 4; i++) {
            int cx = x + dx[i];
            int cy = y + dy[i];
            if (cx >= 0 && cx < N && cy >= 0 && cy < M) {
                if (visited[cx][cy] == false) {
                    if (count == 2) {
                        visited[cx][cy] = true;
                        dfs(x, y, count + 1, number + arr[cx][cy]);
                        visited[cx][cy] = false;
                    }
                    visited[cx][cy] = true;
                    dfs(cx, cy, count + 1, number + arr[cx][cy]);
                    visited[cx][cy] = false;
                }
            }
        }

    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        N = scanner.nextInt();
        M = scanner.nextInt();

        arr = new int [N][M];
        visited = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                arr[i][j] = scanner.nextInt();
            }
        }
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                visited[i][j] = true;
                dfs(i, j, 1, arr[i][j]);
                visited[i][j] = false;
            }
        }
        System.out.println(MAX);
    }
}