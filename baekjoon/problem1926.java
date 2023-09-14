import java.util.*;

public class Main {
    public static int N;
    public static int M;
    public static int[] dx = {0, 0, 1, -1};
    public static int[] dy = {1, -1, 0, 0};
    public static int[][] arr;
    public static boolean[][] visited;
    public static int MAX = 0;

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
        int count = 1;
        while(!queue.isEmpty()) {
            Node poll = queue.poll();
            for (int i = 0; i < 4; i++) {
                int cx = poll.x + dx[i];
                int cy = poll.y + dy[i];
                if (cx >= 0 && cx < N && cy >= 0 && cy < M) {
                    if (visited[cx][cy] == false && arr[cx][cy] == 1) {
                        visited[cx][cy] = true;
                        count++;
                        queue.add(new Node(cx, cy));
                    }
                }
            }
        }
        MAX = Math.max(MAX, count);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();

        arr = new int[N][M];
        visited = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                arr[i][j] = sc.nextInt();
            }
        }
        int count1 = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (visited[i][j] == false && arr[i][j] == 1) {
                    visited[i][j] = true;
                    count1++;
                    bfs(i, j);
                }
            }
        }
        System.out.println(count1);
        System.out.println(MAX);
    }
}
