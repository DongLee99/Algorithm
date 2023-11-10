import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.io.FileInputStream;


class Main
{
    public static int[] dx = {-1, 1, 0, 0};
    public static int[] dy = {0, 0, -1, 1};

    static class Node {
        int x;
        int y;
        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    public static void main(String args[]) throws Exception
    {
        Scanner sc = new Scanner(System.in);
        int T;
        T=sc.nextInt();
        for(int test_case = 1; test_case <= T; test_case++)
        {
            int X = sc.nextInt();
            int Y = sc.nextInt();
            char[][] arr = new char[X][Y];
            Queue<Node> queue = new LinkedList<>();
            for (int i = 0; i < X; i++) {
                String tmp = sc.next();
                for (int j = 0; j < Y; j++) {
                    arr[i][j] = tmp.charAt(j);
                    if (tmp.charAt(j) == '?') {
                        queue.add(new Node(i, j));
                    }
                }
            }
            boolean result = false;
            for (int i = 0; i < X; i++) {
                for (int j = 0; j < Y; j++) {
                    if (arr[i][j] == '#') {
                        for (int k = 0; k < 4; k++) {
                            int cx = i + dx[k];
                            int cy = j + dy[k];
                            if (cx >= 0 && cx < X && cy >= 0 && cy < Y) {
                                if (arr[cx][cy] == '#') {
                                    result = true;
                                    break;
                                }
                            }
                        }
                    }
                    if (arr[i][j] == '.') {
                        for (int k = 0; k < 4; k++) {
                            int cx = i + dx[k];
                            int cy = j + dy[k];
                            if (cx >= 0 && cx < X && cy >= 0 && cy < Y) {
                                if (arr[cx][cy] == '.') {
                                    result = true;
                                    break;
                                }
                            }
                        }
                    }
                }
            }
            if (result) {
                System.out.println("#" + test_case + " impossible");
                continue;
            }
            if (queue.size() == X * Y) {
                System.out.println("#" + test_case + " possible");
                continue;
            }

            while(!queue.isEmpty()) {
                Node poll = queue.poll();
                boolean whiteC = false;
                boolean blackC = false;
                for (int i = 0; i < 4; i++) {
                    int cx = poll.x + dx[i];
                    int cy = poll.y + dy[i];
                    if (cx >= 0 && cx < X && cy >= 0 && cy < Y) {
                        if (arr[cx][cy] == '?') {
                            continue;
                        } else if (arr[cx][cy] == '#') {
                            whiteC = true;
                        } else {
                            blackC = true;
                        }
                    }
                }
                if (whiteC && blackC) {
                    result = true;
                    break;
                } else if (whiteC) {
                    arr[poll.x][poll.y] = '.';
                } else if (blackC) {
                    arr[poll.x][poll.y] = '#';
                } else {
                    queue.add(poll);
                }
            }
            for (int i = 0; i < X; i++) {
                for (int j = 0; j < Y; j++) {
                    if (arr[i][j] == '#') {
                        for (int k = 0; k < 4; k++) {
                            int cx = i + dx[k];
                            int cy = j + dy[k];
                            if (cx >= 0 && cx < X && cy >= 0 && cy < Y) {
                                if (arr[cx][cy] == '#') {
                                    result = true;
                                    break;
                                }
                            }
                        }
                    }
                    if (arr[i][j] == '.') {
                        for (int k = 0; k < 4; k++) {
                            int cx = i + dx[k];
                            int cy = j + dy[k];
                            if (cx >= 0 && cx < X && cy >= 0 && cy < Y) {
                                if (arr[cx][cy] == '.') {
                                    result = true;
                                    break;
                                }
                            }
                        }
                    }
                }
            }
            if (result) {
                System.out.println("#" + test_case + " impossible");
                continue;
            } else {
                System.out.println("#" + test_case + " possible");
                continue;
            }
        }
    }
}