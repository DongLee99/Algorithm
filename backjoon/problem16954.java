import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class problem {

    static String [][] arr = new String[8][8];
    static boolean [][] visit = new boolean[8][8];
    static int[] dy = {-1, 0, 1, 0, 0, -1, 1, -1, 1};
    static int[] dx = {0, -1, 0, 1, 0, 1, -1, -1, 1};

    static class Node {
        int x;
        int y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
//    static void down() {
//        for (int i = 0; i < 8; i++) {
//            for (int j = 0; j < 8; j++) {
//                if (arr[i][j].equals("#")) {
//                    arr[i][j] = ".";
//                    if (i != 7) {
//                        arr[i+1][j] = "#";
//                    }
//                }
//            }
//        }
//        for (int i = 0; i < 8; i++) {
//            arr[0][i] = ".";
//        }
//    }

    public static void down() {
        for (int i = 7; i >= 0; i--) {
            for (int j = 0; j < 8; j++) {
                if (arr[i][j].equals("#")) {
                    arr[i][j] = ".";

                    if (i != 7) {
                        arr[i + 1][j] = "#";
                    }
                }
            }
        }
    }

    static boolean bfs() {
        Queue<Node> queue = new LinkedList<>();
        queue.add(new Node(7, 0));

        while(!queue.isEmpty()) {
            int size = queue.size();

            visit = new boolean[8][8];

            for (int i = 0; i < size; i++) {
                Node node = queue.poll();

                if (arr[node.x][node.y].equals("#")) {
                    continue;
                }
                if (node.x == 0 && node.y == 7) {
                    return true;
                }
                for (int k = 0; k < 9; k++) {
                    int cx = node.x + dx[k];
                    int cy = node.y + dy[k];
                    if (cx >= 0 && cy < 8 && cy >= 0 && cx < 8) {
                        if (visit[cx][cy] == false && arr[cx][cy].equals(".")) {
                            queue.add(new Node(cx, cy));
                            visit[cx][cy] = true;
                        }
                    }
                }
                down();
            }
        }
        return false;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        for (int i = 0; i < 8; i++) {
            String tmp = bf.readLine();
            for (int j = 0; j < 8; j++) {
                arr[i][j] = String.valueOf(tmp.charAt(j));
            }
        }

        if (bfs()) {
            System.out.println(1);
        } else {
            System.out.println(0);
        }
    }
}