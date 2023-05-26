import java.util.*;

class Solution {
    public static class Node {
        public int x;
        public int y;
        public int value;

        public Node (int x, int y, int value) {
            this.x = x;
            this.y = y;
            this.value = value;
        }
    }
    public static int[] dx = {0, 1, 1};
    public static int[] dy = {1, 1, 0};
    public static boolean[][] visited;
    public static int[][] arr;
    public static void bfs(int n) {
        Queue<Node> q = new LinkedList<>();
        q.add(new Node(0, 0, 1));
        int start = 1;
        arr[0][0] = 1;
        while(!q.isEmpty()) {
            Node node = q.poll();
            for (int i = 0; i < 3; i++) {
                int cx = node.x + dx[i];
                int cy = node.y + dy[i];
                if (cx < n && cx >= 0 && cy < n && cy >= 0) {
                    if (visited[cx][cy] == false) {
                        visited[cx][cy] = true;
                        arr[cx][cy] = node.value + 1;
                        q.add(new Node(cx, cy, node.value + 1));
                    }
                }
            }
        }
    }
    public int[] solution(int n, long left, long right) {
        arr = new int[n][n];

        int[] answer = new int[(int)(right - left + 1)];

        visited = new boolean[n][n];
        bfs(n);
        int count = 0;
        int index = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (count >= left && count <= right) {
                    answer[index] = arr[i][j];
                    index++;
                }
                count++;
            }
        }
        return answer;
    }
}