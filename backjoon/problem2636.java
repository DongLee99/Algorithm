import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class problem {

    static int [][] arr;
    static boolean [][] visit;
    static int N;
    static int M;
    static int [] dx = {0, 0, 1, -1};
    static int [] dy = {1, -1, 0, 0};

    static class Node {
        int x;
        int y;
        int value;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static void bfs(Node node) {
        Queue<Node> queue = new LinkedList<>();
        queue.add(node);
        while(!queue.isEmpty()) {
            Node start = queue.poll();

            for (int i = 0; i < 4; i++) {
                int nx = start.x + dx[i];
                int ny = start.y + dy[i];

                if (nx >= 0 && nx < N && ny >= 0 && ny < M) {
                    if (visit[nx][ny] == false) {
                        if (arr[nx][ny] == 1) {
                            arr[nx][ny] = 2;
                            visit[nx][ny] = true;
                        }
                        if (arr[nx][ny] == 0) {
                            queue.add(new Node(nx, ny));
                            visit[nx][ny] = true;
                        }
                    }
                }
            }
            removeCheese();
        }
    }

    static void removeCheese() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (arr[i][j] == 2)
                    arr[i][j] = 0;
            }
        }
    }

    static int getCount() {
        int count = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (arr[i][j] == 1)
                    count++;
            }
        }
        return count;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(bf.readLine());
            for (int j = 0; j < M; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        boolean task = true;
        int time = 0;
        List<Integer> result = new ArrayList<>();
        int firstCount = getCount();

        while(task) {
            time++;
            visit = new boolean[N][M];
            bfs(new Node(0, 0));

            int count = getCount();
            if (count == 0) {
                task = false;
            } else {
                result.add(count);
            }
        }
        System.out.println(time);
        if (result.size() > 0) {
            System.out.println(result.get(result.size()-1));
        } else {
            System.out.println(firstCount);
        }
    }
}