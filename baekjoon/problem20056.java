import java.sql.SQLOutput;
import java.util.*;

public class Main {
    public static int[] dx = {-1, -1, 0, 1, 1, 1, 0, -1};
    public static int[] dy = {0, 1, 1, 1, 0, -1, -1, -1};
    public static int[] p = {0, 1, 2, 3, 4, 5, 6, 7};
    public static int N;
    public static int M;
    public static int K;
    public static Queue<Node> queue = new LinkedList<>();
    public static Queue<Node> next = new LinkedList<>();
    public static int[][] arr;
    public static Queue<Node>[][] tmp;

    public static class Node {
        public int r;
        public int c;
        public int m;
        public int s;
        public int d;
        public Node (int r, int c, int m, int s, int d) {
            this.r = r;
            this.c = c;
            this.m = m;
            this.s = s;
            this.d = d;
        }
    }

    public static void go() {
        while(!queue.isEmpty()) {
            Node poll = queue.poll();
            tmp[poll.r][poll.c].poll();
            int cx = poll.r;
            int cy = poll.c;
            for (int i = 0; i < poll.s; i++) {
                if (cx + dx[poll.d] > 0 && N >= cx + dx[poll.d]) {
                    cx = cx + dx[poll.d];
                }
                if (cy + dy[poll.d] > 0 && N >= cy + dy[poll.d]) {
                    cy = cy + dy[poll.d];
                }
            }
            next.add(new Node(cx, cy, poll.m, poll.s, poll.d));
        }

        while(!next.isEmpty()) {
            Node poll = next.poll();
            tmp[poll.r][poll.c].add(new Node(poll.r, poll.c, poll.m, poll.s, poll.d));
        }
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                if (tmp[i][j].size() > 1) {
                    int [] check = new int[tmp[i][j].size()];
                    int index = 0;
                    int mC = 0;
                    int sC = 0;
                    while (!tmp[i][j].isEmpty()) {
                        Node poll = tmp[i][j].poll();
                        mC = mC + poll.m;
                        sC = sC + poll.s;
                        check[index] = poll.d;
                        index++;
                    }
                    if (mC / 5 == 0) {
                        continue;
                    } else {
                        if (ch1(check)) {
                            next.add(new Node(i, j, mC/5, sC / check.length, 0));
                            next.add(new Node(i, j, mC/5, sC / check.length, 2));
                            next.add(new Node(i, j, mC/5, sC / check.length, 4));
                            next.add(new Node(i, j, mC/5, sC / check.length, 6));
                        } else if (ch2(check)) {
                            next.add(new Node(i, j, mC/5, sC / check.length, 0));
                            next.add(new Node(i, j, mC/5, sC / check.length, 2));
                            next.add(new Node(i, j, mC/5, sC / check.length, 4));
                            next.add(new Node(i, j, mC/5, sC / check.length, 6));
                        } else {
                            next.add(new Node(i, j, mC/5, sC / check.length, 1));
                            next.add(new Node(i, j, mC/5, sC / check.length, 3));
                            next.add(new Node(i, j, mC/5, sC / check.length, 5));
                            next.add(new Node(i, j, mC/5, sC / check.length, 7));
                        }
                    }
                } else if (tmp[i][j].size() == 1) {
                    Node poll = tmp[i][j].poll();
                    next.add(new Node(poll.r, poll.c, poll.m, poll.s, poll.d));
                }
            }
        }
        while(!next.isEmpty()) {
            Node poll = next.poll();
            queue.add(poll);
            System.out.println(poll.r + " " + poll.c);
            tmp[poll.r][poll.c].add(poll);
        }
    }

    public static boolean ch1(int[] arr) {
        for (int i : arr) {
            if (i % 2 == 0) {
                return false;
            }
        }
        return true;
    }
    public static boolean ch2(int[] arr) {
        for (int i : arr) {
            if (i % 2 == 0) {
                return true;
            }
        }
        return false;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        K = sc.nextInt();
        tmp = new Queue[N+1][N+1];
        for (int i = 0; i < N + 1; i++) {
            for (int j = 0; j < N + 1; j++) {
                tmp[i][j] = new LinkedList<>();
            }
        }
        arr = new int[N+1][N+1];
        for (int i = 0; i < M; i++) {
            int r = sc.nextInt();
            int c = sc.nextInt();
            int m = sc.nextInt();
            int s = sc.nextInt();
            int d = sc.nextInt();
            queue.add(new Node(r, c, m, s, d));
            tmp[r][c].add(new Node(r, c, m, s, d));
        }
        go();
        go();
        int result = 0;
        while(!queue.isEmpty()) {
            result = result + queue.poll().m;
        }
        System.out.println(result);
    }
}

