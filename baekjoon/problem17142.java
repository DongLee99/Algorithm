import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Main {

    public static int N;
    public static int M;
    public static int [][] arr;
    public static int [][] tmpArr;
    public static List<Virus> virusList = new ArrayList<>();
    public static int [] dx = {0, 0, 1, -1};
    public static int [] dy = {1, -1, 0, 0};
    public static boolean [] visited;
    public static boolean [][] checkVisited;
    public static boolean [][] virusVisited;
    public static int distance = Integer.MAX_VALUE;
    public static int MIN = Integer.MAX_VALUE;
    public static class Virus {
        public int x;
        public int y;

        public Virus(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void checkDistance(int virusX, int virusY, int x, int y, int count) {
        if (virusX == x && virusY == y) {
            distance = Math.min(distance, count);
            return;
        }
        if (count > distance) {
            return;
        }
        for (int i = 0; i < 4; i++) {
            int cx = virusX + dx[i];
            int cy = virusY + dy[i];
            if (cx >= 0 && cx < N && cy < N && cy >= 0) {
                if (arr[cx][cy] != 2 && arr[cx][cy] != 1 && virusVisited[cx][cy] == false) {
                    virusVisited[cx][cy] = true;
                    checkDistance(cx, cy, x, y, count+1);
                    virusVisited[cx][cy] = false;
                }
            }
        }
    };
    public static void makeVirus(int count, int start, int [] varr) {
        if (count == M) {
            checkVisited = new boolean[N][N];
            tmpArr = new int[N][N];
            for (int i = 0; i < varr.length; i++) {
                Virus virus = virusList.get(varr[i]);
                arr[virus.x][virus.y] = 3;
            }
            for (int j = 0; j < N; j++) {
                for (int k = 0; k < N; k++) {
                    distance = Integer.MAX_VALUE;
                    virusVisited = new boolean[N][N];
                    if (arr[j][k] == 0) {
                        for (int i = 0; i < varr.length; i++) {
                            int i1 = varr[i];
                            Virus virus = virusList.get(i1);
                            checkDistance(virus.x, virus.y, j, k, 0);
                            tmpArr[j][k] = distance;
                        }
                    }
                }
            }
            for (int i = 0; i < varr.length; i++) {
                Virus virus = virusList.get(varr[i]);
                arr[virus.x][virus.y] = 2;
            }
            int result = 0;
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (arr[i][j] == 0) {
                        result = Math.max(result, tmpArr[i][j]);
                    }
                }
            }
            MIN = Math.min(MIN, result);
            return;
        }
        for (int i = start; i < virusList.size(); i++) {
            if (visited[i] == false) {
                visited[i] = true;
                varr[count] = i;
                makeVirus(count + 1, i, varr);
                varr[count] = 0;
                visited[i] = false;
            }
        }
    }
    public static void play() {
        visited = new boolean[virusList.size()];
        int [] arr = new int[M];
        makeVirus(0, 0, arr);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        N = scanner.nextInt();
        M = scanner.nextInt();
        arr = new int[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                arr[i][j] = scanner.nextInt();
                if (arr[i][j] == 2) {
                    virusList.add(new Virus(i, j));
                }
            }
        }
        play();
        if (MIN == Integer.MAX_VALUE) {
            System.out.println(-1);
        } else {
            System.out.println(MIN);
        }
    }
}
