import javax.swing.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class problem {
    static int T;
    static int M;
    static int N;
    static int K;
    static int [][] arr;
    static boolean [][] visit;
    static int count = 0;
    static List<Integer> result = new ArrayList<>();
    static int[] dx = { 0, -1, 0, 1 };
    static int[] dy = { 1, 0, -1, 0 };

    static class Node {
        public int x;
        public int y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public int getX() {
            return x;
        }

        public void setX(int x) {
            this.x = x;
        }

        public int getY() {
            return y;
        }

        public void setY(int y) {
            this.y = y;
        }
    }

    static void bfs(int x, int y) {
        if (visit[x][y] == true) {
            return;
        } else {
            visit[x][y] = true;
            Queue<Node> q = new LinkedList<>();
            q.offer(new Node(x, y));

            while (!q.isEmpty()) {
                Node poll = q.poll();
                for (int i = 0; i < 4; i++) {
                    int cx = poll.getX() + dx[i];
                    int cy = poll.getY() + dy[i];
                    if (cx >= 0 && cy >= 0 && cx < M && cy < N) {
                        if (!visit[cx][cy] && arr[cx][cy] == 1) {
                            visit[cx][cy] = true;
                            q.offer(new Node(cx, cy));
                        }
                    }
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(bf.readLine());


        for (int i = 0; i < T; i++) {
            StringTokenizer st = new StringTokenizer(bf.readLine());
            M = Integer.parseInt(st.nextToken());
            N = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());
            arr = new int[M][N];
            visit = new boolean[M][N];
            count = 0;
            for (int j = 0; j < K; j++) {
                StringTokenizer tt = new StringTokenizer(bf.readLine());
                int x = Integer.parseInt(tt.nextToken());
                int y = Integer.parseInt(tt.nextToken());
                arr[x][y] = 1;
            }
            for (int k = 0; k < M; k++) {
                for (int l = 0; l < N; l++) {
                    if (visit[k][l] == false && arr[k][l] == 1) {
                        count++;
                        bfs(k, l);
                    }
                }
            }
            result.add(count);

        }
        for (Integer integer : result) {
            System.out.println(integer);
        }
    }
}