import java.io.*;
import java.util.*;

public class main {

    public static int R;
    public static int C;
    public static String [][] arr;
    public static String [][] arr2;
    public static int [] dx = {1, -1, 0, 0};
    public static int [] dy = {0, 0, 1, -1};
    public static boolean [][] visited;
    public static int endX;
    public static int endY;
    public static int startX;
    public static int startY;
    public static int Qcount = 0;
    public static int result = Integer.MAX_VALUE;
    public static boolean check = true;
    static Queue<Node> moveQ = new LinkedList<Node>();

    public static class Node {
        int x;
        int y;

        public Node(int cx, int cy) {
            x = cx;
            y = cy;
        }
    }
    public static void bfs(int move) {

        int cnt = moveQ.size();
        while(cnt-- > 0) {
            Node poll = moveQ.poll();
            for (int i = 0; i < 4; i++) {
                int cx = poll.x + dx[i];
                int cy = poll.y + dy[i];

                if (cx >= 0 && cx < R && cy >= 0 && cy < C) {
                    if (arr[cx][cy].equals("D")) {
                        result = move;
                        check = false;
                        moveQ.clear();
                        return;
                    }
                    if (visited[cx][cy] == false && arr[cx][cy].equals(".")) {
                        moveQ.add(new Node(cx, cy));
                        visited[cx][cy] = true;
                    }
                }
            }
        }
        Qcount = moveQ.size();
    }

    public static void spread() {
        for (int i = 0; i < R; i++) {
            for (int k = 0; k < C; k++) {
                if (arr[i][k].equals("*")) {
                    for (int j = 0; j < 4; j++) {
                        int cx = i + dx[j];
                        int cy = k + dy[j];
                        if (cx >= 0 && cx < R && cy >= 0 && cy < C ) {
                            if (arr[cx][cy].equals(".")) {
                                arr[cx][cy] = "T";
                            }
                        }
                    }
                }
            }
        }

        for (int i = 0; i < R; i++) {
            for (int k = 0; k < C; k++) {
                if (arr[i][k].equals("T")) {
                    arr[i][k] = "*";
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        arr = new String[R][C];
        visited = new boolean[R][C];

        for (int i = 0; i < R; i++) {
            String value = bf.readLine();
            for (int k = 0; k < C; k++) {
                arr[i][k] = String.valueOf(value.charAt(k));
                if (String.valueOf(value.charAt(k)).equals("D")) {
                    endX = i;
                    endY = k;
                }

                if (String.valueOf(value.charAt(k)).equals("S")) {
                    startX = i;
                    startY = k;
                }
            }
        }

        int move = 0;
        Qcount++;
        int cnt = Qcount;
        moveQ.add(new Node(startX, startY));
        while(check || !moveQ.isEmpty()) {

            spread();
            move++;
            if (Qcount == 0) {
                break;
            }
            Qcount = 0;
            bfs(move);
        }


        if (result == Integer.MAX_VALUE) {
            System.out.println("KAKTUS");
        } else {
            System.out.println(result);
        }
    }
}