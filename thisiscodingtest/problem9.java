import java.io.*;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class problem {

    static int N;
    static int M;
    static int [][] arr;
    static boolean [][] visited;
    static int [] dx = {0, 0, 1, -1};
    static int [] dy = {1, -1, 0, 0};

    static class Node implements Comparable<Node> {
        public int x;
        public int y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public int compareTo(Node o) {
            return this.x - o.x;
        }
    }

    static int bfs(int x, int y) {
        PriorityQueue<Node> queue = new PriorityQueue<>();
        queue.add(new Node(x, y));

        while(!queue.isEmpty()) {
            Node poll = queue.poll();
            for (int i = 0; i < 4; i++) {
                int cx = poll.x + dx[i];
                int cy = poll.y + dy[i];

                if (cx >= 1 && cx <= N && cy >= 1 && cy <= M) {
                    if (visited[cx][cy] == false && arr[cx][cy] == 1) {
                        arr[cx][cy] = arr[poll.x][poll.y] + 1;
                        visited[cx][cy] = true;
                        queue.add(new Node(cx, cy));
                    }
                }
            }
        }
        return arr[N-1][M-1];
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[N + 1][M + 1];
        visited = new boolean[N + 1][M + 1];

        for (int i = 1; i < N; i++) {
            String buffer = bf.readLine();
            for (int j = 0; j < M; j++) {
                arr[i][j+1] = Integer.parseInt(String.valueOf(buffer.charAt(j)));
            }
        }

        System.out.println(bfs(1, 1));
    }
}