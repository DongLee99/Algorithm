import java.io.IOException;
import java.util.*;

public class Main {

    public static int X;
    public static int Y;
    public static String [][] arr;
    public static boolean [][] visited;
    public static int count = 0;
    public static String resultDirection = "";
    public static String result = "";
    public static int [] dx = {0, 0, -1, 1};
    public static int [] dy = {1, -1, 0, 0};

    public static class Node {
        public int x;
        public int y;

        public Node (int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    public static boolean check(int x, int y) {
        int cnt = 0;
        for (int i = 0; i < 4; i++) {
            int cx = x + dx[i];
            int cy = y + dy[i];
            if (cx >= 0 && cx < X && cy >= 0 && cy < Y && arr[cx][cy].equals("#")) {
                cnt++;
            }
        }
        if (cnt == 1) {
            return true;
        } else {
            return false;
        }
    }

    public static void start(int x, int y, int cnt, String direction) {
        Queue<Node> queue = new LinkedList<>();
        queue.add(new Node(x, y));

        while (!queue.isEmpty()) {
            Node poll = queue.poll();
            for (int i = 0; i < 4; i++) {
                int cx = x + dx[i];
                int cy = y + dy[i];
                if (cx >= 0 && cx < X && cy >= 0 && cy < Y && arr[cx][cy].equals("#") && visited[cx][cy] == false) {
                    int ccx = cx + dx[i];
                    int ccy = cy + dy[i];
                    if (ccx >= 0 && ccx < X && ccy >= 0 && ccy < Y && arr[ccx][ccy].equals("#") && visited[ccx][ccy] == false) {

                    }
                }
            }
        }
    }

    public static String findD(int x, int y) {
        for (int i = 0; i < 4; i++) {
            int cx = x + dx[i];
            int cy = y + dy[i];
            if (cx >= 0 && cx < X && cy >= 0 && cy < Y && arr[cx][cy].equals("#")) {
                if (i == 0) {
                    return ">";
                }
                if (i == 1) {
                    return "<";
                }
                if (i == 2) {
                    return "v";
                }
                if (i == 3) {
                    return "^";
                }
            }
        }
        throw new IllegalArgumentException("잘못된 입력");
    }
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        X = scanner.nextInt();
        Y = scanner.nextInt();
        arr = new String[X][Y];
        visited = new boolean[X][Y];

        for (int i = 0; i < X; i++) {
            String tmp = scanner.next();
            for (int j = 0; j < Y; j++) {
                arr[i][j] = tmp.charAt(j) + "";
                count++;
            }
        }

        for (int i = 0; i < X; i++) {
            for (int j = 0; j < Y; j++) {
                if (arr[i][j].equals("#") && check(i, j)) {
                    visited[i][j] = true;
                    String direction = findD(i, j);
                    start(i, j, 1, direction);
                }
            }
        }
    }
}
