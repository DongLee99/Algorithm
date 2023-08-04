import java.util.*;
import java.io.*;


public class Main
{
    public static int N;
    public static int [][] arr;
    public static List<Integer> result = new ArrayList<>();
    public static boolean[][] visited;
    public static int [] dx = {0, 0, 1, -1};
    public static int [] dy = {1, -1, 0, 0};

    public static class Node {
        public int x;
        public int y;

        public Node (int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void bfs(int x, int y) {
        Queue<Node> queue = new LinkedList<>();
        queue.add(new Node(x, y));
        visited[x][y] = true;
        int count = 1;
        while(!queue.isEmpty()) {
            Node poll = queue.poll();
            for (int i = 0; i < 4; i++) {
                int cx = poll.x + dx[i];
                int cy = poll.y + dy[i];
                if (cx >= 0 && cx < N && cy >= 0 && cy < N) {
                    if (visited[cx][cy] != true && arr[cx][cy] == 1) {
                        queue.add(new Node(cx, cy));
                        visited[cx][cy] = true;
                        count++;
                    }
                }
            }
        }
        result.add(count);
    }

    public static void main(String args[])
    {
        Scanner scanner = new Scanner(System.in);
        N = scanner.nextInt();
        arr = new int[N][N];
        visited = new boolean[N][N];

        for (int i = 0; i < N; i++) {
            String tmp = scanner.next();
            for (int j = 0; j < tmp.length(); j++) {
                arr[i][j] = Integer.parseInt(tmp.charAt(j)+"");
            }
        }
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (visited[i][j] == false && arr[i][j] == 1) {
                    bfs(i, j);
                }
            }
        }
        Collections.sort(result);
        System.out.println(result.size());
        for (Integer re : result) {
            System.out.println(re);
        }
    }
}