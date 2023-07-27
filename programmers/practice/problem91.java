import java.util.*;

class Solution {
    public static int[][] visited;
    public static int[][] arr;
    public static int[] dx = {0, 0, 1, -1};
    public static int[] dy = {1, -1, 0, 0};
    public static int MIN = Integer.MAX_VALUE;

    public static class Node {
        public int x;
        public int y;
        public Node (int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    public static void bfs(int x, int y) {
        Queue<Node> q = new LinkedList<>();
        q.add(new Node(x, y));
        visited[x][y] = 1;
        while (!q.isEmpty()) {
            Node poll = q.poll();
            for (int i = 0; i < 4; i++) {
                int cx = poll.x + dx[i];
                int cy = poll.y + dy[i];
                if (cx >= 0 && cx < arr.length && cy >= 0 && cy < arr[0].length) {
                    if (visited[cx][cy] == 0 && arr[cx][cy] == 1) {
                        visited[cx][cy] = visited[poll.x][poll.y] + 1;
                        q.add(new Node(cx, cy));
                    }
                }
            }
        }
    }

    public int solution(int[][] maps) {
        visited = new int[maps.length][maps[0].length];
        arr = new int[maps.length][maps[0].length];

        for (int i = 0; i < maps.length; i++) {
            for (int j = 0; j < maps[0].length; j++) {
                arr[i][j] = maps[i][j];
            }
        }

        bfs(0, 0);
        if (visited[maps.length-1][maps[0].length-1] == 0) {
            return -1;
        } else {
            return visited[maps.length-1][maps[0].length-1];
        }
    }
}