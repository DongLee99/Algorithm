import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main
{
    public static int N;
    public static int M;
    public static int [][] arr;
    public static boolean [][] visited;
    public static int[] dx = {1, -1, -1, 1, 0 ,0 ,1, -1};
    public static int[] dy = {0, 0, 1, -1, 1, -1, 1, -1};
    public static int MIN = Integer.MAX_VALUE;
    public static class Node {
        public int x;
        public int y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void bfs(int x, int y) {
        Queue<Node> queue = new LinkedList<>();
        queue.add(new Node(x, y));
        int[][] tArr = new int[N][M];
        visited = new boolean[N][M];
        while(!queue.isEmpty()) {
            Node poll = queue.poll();
            for (int i = 0; i < 8; i++) {
                int cx = poll.x + dx[i];
                int cy = poll.y + dy[i];
                if (cx >= 0 && cx < N && cy >= 0 && cy < M && visited[cx][cy] == false) {
                    visited[cx][cy] = true;
                    if (arr[cx][cy] == -1) {
                        MIN = Math.min(MIN, tArr[poll.x][poll.y] + 1);
                        return;
                    } else {
                        tArr[cx][cy] = tArr[poll.x][poll.y] + 1;
                        queue.add(new Node(cx, cy));
                    }
                }
            }
        }

    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();

        arr = new int[N][M];
        visited = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                int temp = sc.nextInt();
                if (temp == 1) {
                    arr[i][j] = -1;
                } else {
                    arr[i][j] = temp;
                }
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (arr[i][j] == -1) {
                    bfs(i, j);
                }
            }
        }
        System.out.println(MIN);
    }
}