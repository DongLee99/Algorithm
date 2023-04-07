import java.util.*;

class Solution {
    public static int[] start;
    public static int[] lever;
    public static int[] exit;
    public static boolean[][] visited;
    public static int[][] map;
    public static char[][] arr;
    public static int[] dx = {0, 0, 1, -1};
    public static int[] dy = {1, -1, 0, 0};

    public class Node {
        public int x;
        public int y;
        public Node (int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public void find(int x, int y, int dX, int dY) {
        Node node = new Node(x, y);
        Queue<Node> queue = new LinkedList<>();
        queue.add(node);
        while (!queue.isEmpty()) {
            Node poll = queue.poll();
            for (int i = 0; i < 4; i++) {
                int cx = poll.x + dx[i];
                int cy = poll.y + dy[i];
                if (cx >= 0 && cx < arr.length && cy >= 0 && cy < arr[0].length) {
                    if (arr[cx][cy] != 'X' && visited[cx][cy] == false) {

                        map[cx][cy] = Math.min(map[cx][cy], map[poll.x][poll.y] + 1);

                        visited[cx][cy] = true;
                        queue.add(new Node(cx, cy));
                    }
                }
            }
        }

    }

    public int solution(String[] maps) {
        map = new int[maps.length][maps[0].length()];
        arr = new char[maps.length][maps[0].length()];
        visited = new boolean[maps.length][maps[0].length()];
        for(int i = 0; i < maps.length; i++) {
            for (int j = 0; j < maps[0].length(); j++) {
                map[i][j] = Integer.MAX_VALUE;
                arr[i][j] = maps[i].charAt(j);
                if (arr[i][j] == 'S') {
                    start = new int[]{i, j};
                } else if (arr[i][j] == 'E') {
                    exit = new int[]{i, j};
                } else if (arr[i][j] == 'L') {
                    lever = new int[]{i, j};
                }
            }
        }
        visited[start[0]][start[1]] = true;
        map[start[0]][start[1]] = 0;
        find(start[0], start[1], lever[0], lever[1]);
        visited[start[0]][start[1]] = false;
        visited[lever[0]][lever[1]] = true;
        int temp = map[lever[0]][lever[1]];

        for(int i = 0; i < maps.length; i++) {
            for (int j = 0; j < maps[0].length(); j++) {
                map[i][j] = Integer.MAX_VALUE;
            }
        }
        map[lever[0]][lever[1]] = temp;
        if (temp == Integer.MAX_VALUE) {
            return -1;
        }
        System.out.println("    ");
        visited = new boolean[maps.length][maps[0].length()];
        visited[lever[0]][lever[1]] = true;
        find(lever[0], lever[1], exit[0], exit[1]);

        if (map[exit[0]][exit[1]] == Integer.MAX_VALUE) {
            return -1;
        }
        return map[exit[0]][exit[1]];
    }
}