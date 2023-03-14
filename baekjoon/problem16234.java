import java.util.*;

class main {

    public static int N;
    public static int L;
    public static int R;
    public static int [][] arr;
    public static int [] dx = {0, 0, 1, -1};
    public static int [] dy = {1, -1, 0, 0};
    public static boolean [][] visited;

    public static void bfs(int x, int y) {
        Queue<Node> queue = new LinkedList<>();
        Queue<Node> save = new LinkedList<>();
        queue.add(new Node(x, y));
        save.add(new Node(x, y));
        int peopleCount = arr[x][y];
        int size = 1;
        while(!queue.isEmpty()) {
            Node poll = queue.poll();
            for (int i = 0; i < 4; i++) {
                int cx = poll.x + dx[i];
                int cy = poll.y + dy[i];
                if (cx >= 0 && cx < N && cy >= 0 && cy < N) {
                    if (visited[cx][cy] == false) {
                        if (Math.abs(arr[poll.x][poll.y] - arr[cx][cy]) >= L && Math.abs(arr[poll.x][poll.y] - arr[cx][cy]) <= R) {
                            visited[cx][cy] = true;
                            queue.add(new Node(cx, cy));
                            save.add(new Node(cx, cy));
                            size++;
                            peopleCount = peopleCount + arr[cx][cy];
                        }
                    }
                }
            }
        }
        while(!save.isEmpty()) {
            Node poll = save.poll();
            arr[poll.x][poll.y] = peopleCount / size;
        }
    }

    public static boolean check() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                Queue<Node> queue = new LinkedList<>();
                queue.add(new Node(i, j));
                while(!queue.isEmpty()) {
                    Node poll = queue.poll();
                    for (int k = 0; k < 4; k++) {
                        int cx = poll.x + dx[k];
                        int cy = poll.y + dy[k];
                        if (cx >= 0 && cx < N && cy >= 0 && cy < N) {
                            if (visited[cx][cy] == false) {
                                if (Math.abs(arr[poll.x][poll.y] - arr[cx][cy]) >= L && Math.abs(arr[poll.x][poll.y] - arr[cx][cy]) <= R) {
                                    return true; // 공유
                                }
                            }
                        }
                    }
                }
            }
        }
        return false; // 공유 X
    }

    public static class Node {
        public int x;
        public int y;
        public int value;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        N = scanner.nextInt();
        L = scanner.nextInt();
        R = scanner.nextInt();
        arr = new int[N][N];
        visited = new boolean[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                arr[i][j] = scanner.nextInt();
            }
        }
        int count = 0;
        boolean result = true;
        result = check();
        while(result) {
            result = check();
            if (result == false) {
                break;
            }
            count++;
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (visited[i][j] == false) {
                        visited[i][j] = true;
                        bfs(i, j);
                    }
                }
            }
            visited = new boolean[N][N];
        }
        System.out.println(count);
    }
}
