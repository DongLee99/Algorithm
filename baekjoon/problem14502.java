import java.util.Scanner;

class main {

    public static int N;
    public static int M;
    public static int [][] arr;
    public static boolean [][] wallVisited;
    public static boolean [][] virusVisited;
    public static int [] dx = {1, -1, 0, 0};
    public static int [] dy = {0, 0, -1, 1};
    public static int MAX = Integer.MIN_VALUE;

    public static void findVirus(int [][] tmp, int x, int y) {
        for (int i = 0; i < 4; i++) {
            int cx = x + dx[i];
            int cy = y + dy[i];
            if (cx >= 0 && cx < N && cy >= 0 && cy < M && arr[cx][cy] != 1) {
                if (virusVisited[cx][cy] == false) {
                    virusVisited[cx][cy] = true;
                    tmp[cx][cy] = 2;
                    findVirus(tmp, cx, cy);
                }
            }
        }
    }

    public static void putWall(int count) {
        if (count == 3) {
            int [][] tmp = new int[N][M];
            virusVisited = new boolean[N][M];
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    tmp[i][j] = arr[i][j];
                }
            }
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    if (tmp[i][j] == 2 && virusVisited[i][j] == false){
                        findVirus(tmp, i, j);
                    }
                }
            }
            int result = 0;
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    if (tmp[i][j] == 0){
                        result++;
                    }
                }
            }
            MAX = Math.max(result, MAX);
            return;
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (arr[i][j] == 0) {
                    arr[i][j] = 1;
                    putWall(count + 1);
                    arr[i][j] = 0;
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        N = scanner.nextInt();
        M = scanner.nextInt();

        arr = new int[N][M];
        wallVisited = new boolean[N][M];
        virusVisited = new boolean[N][M];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                arr[i][j] = scanner.nextInt();
            }
        }
        putWall(0);
        System.out.println(MAX);
    }

}