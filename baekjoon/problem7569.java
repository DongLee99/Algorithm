import java.util.*;

public class Main {
    public static class Node {
        public int x;
        public int y;
        public int z;

        public Node (int x, int y, int z) {
            this.x = x;
            this.y = y;
            this.z = z;
        }
    }
    public static int N;
    public static int M;
    public static int H;
    public static int[] dx = {1, -1, 0, 0, 0, 0};
    public static int[] dy = {0, 0, 1, -1, 0, 0};
    public static int[] dz = {0 ,0 ,0 ,0 ,1 ,-1};
    public static int[][][] arr;
    public static int RESULT = Integer.MIN_VALUE;
    public static Queue<Node> q = new LinkedList<>();

    public static int bfs() {
        while(!q.isEmpty()) {
            Node poll = q.poll();
            for (int i = 0; i < 6; i++) {
                int cx = dx[i] + poll.x;
                int cy = dy[i] + poll.y;
                int cz = dz[i] + poll.z;
                if (cx >= 0 && cx < N && cy >= 0 && cy < M && cz >= 0 && cz < H) {
                    if (arr[cx][cy][cz] == 0) {
                        q.add(new Node(cx, cy, cz));
                        arr[cx][cy][cz] = arr[poll.x][poll.y][poll.z] + 1;
                    }
                }
            }
        }
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                for (int z = 0; z < H; z++) {
                    if (arr[i][j][z] == 0) {
                        return -1;
                    }
                    RESULT = Math.max(RESULT, arr[i][j][z]);
                }
            }
        }
        if (RESULT == 1) {
            return 0;
        }
        return RESULT - 1;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        M = sc.nextInt();
        N = sc.nextInt();
        H = sc.nextInt();
        arr = new int[N][M][H];
        for (int z = 0; z < H; z++) {
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    arr[i][j][z] = sc.nextInt();
                    if (arr[i][j][z] == 1) {
                        q.add(new Node(i, j, z));
                    }
                }
            }
        }

        System.out.println(bfs());
    }
}
