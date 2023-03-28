import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Main {

    public static Queue<Integer> [] lists;
    public static int N;
    public static int M;
    public static int T;
    public static class Node {
        public int x;
        public int y;
        public Node(int x,int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void check() {
        int [][] checkList = new int[N][M];
        for (int i = 0; i < N; i++) {
            int count = 0;
            while(!lists[i].isEmpty()) {
                checkList[i][count] = lists[i].poll();
                count++;
            }
        }
        boolean result = false;
        Queue<Node> deleteList = new LinkedList<>();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (checkList[i][j] != 0) {
                    boolean ch = false;
                    int dy1 = j - 1;
                    int dy2 = j + 1;
                    if (dy2 == M) {
                        dy2 = 0;
                    }
                    int dx1 = i - 1;
                    int dx2 = i + 1;
                    if (dy1 >= 0) {
                        if (checkList[i][j] == checkList[i][dy1]) {
                            result = true;
                            ch = true;
                            deleteList.add(new Node(i, dy1));
                        }
                    }
                    if (dy2 < M) {
                        if (checkList[i][j] == checkList[i][dy2]) {
                            result = true;
                            ch = true;
                            deleteList.add(new Node(i, dy2));
                        }
                    }
                    if (dx1 >= 0) {
                        if (checkList[i][j] == checkList[dx1][j]) {
                            result = true;
                            ch = true;
                            deleteList.add(new Node(dx1, j));
                        }
                    }
                    if (dx2 < N) {
                        if (checkList[i][j] == checkList[dx2][j]) {
                            result = true;
                            ch = true;
                            deleteList.add(new Node(dx2, j));
                        }
                    }
                    if (ch == true) {
                        deleteList.add(new Node(i, j));
                    }
                }
            }
        }
        while (!deleteList.isEmpty()) {
            Node poll = deleteList.poll();
            checkList[poll.x][poll.y] = 0;
        }
        if (result == false) {
            int count = 0;
            int sum = 0;
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    if (checkList[i][j] != 0) {
                        count++;
                        sum = sum + checkList[i][j];
                    }
                }
            }
            double avg = (float) sum / (float) count;
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    if (checkList[i][j] != 0) {
                        if (checkList[i][j] > avg) {
                            checkList[i][j]--;
                        } else if (checkList[i][j] < avg) {
                            checkList[i][j]++;
                        }
                    }
                }
            }
        }
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                lists[i].add(checkList[i][j]);
            }
        }
    }

    public static void turn(int x, int d, int k) {
        for (int i = x-1; i < lists.length; i = i + x) {
            for (int t = 0; t < k; t++) {
                Queue<Integer> list = lists[i];
                if (d == 0) {
                    Queue<Integer> tmp = new LinkedList<>();
                    for (int j = 0; j < M - 1; j++) {
                        tmp.add(list.poll());
                    }
                    while (!tmp.isEmpty()) {
                        list.add(tmp.poll());
                    }
                }

                if (d == 1) {
                    list.add(list.poll());
                }
            }
        }
        check();
    }
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        T = Integer.parseInt(st.nextToken());

        lists = new LinkedList[N];
        for (int i = 0; i < N; i++) {
            lists[i] = new LinkedList();
            String [] tmp = bf.readLine().split(" ");
            for (int j = 0; j < M; j++) {
                lists[i].add(Integer.parseInt(tmp[j]));
            }
        }
        for (int i = 0; i < T; i++) {
            st = new StringTokenizer(bf.readLine());
            int x = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());
            turn(x, d, k);
//            for (int j = 0; j < N; j++) {
//                for (Integer integer : lists[j]) {
//                    System.out.print(integer);
//                }
//                System.out.println();
//            }
        }
        int result = 0;
        for (Queue<Integer> list : lists) {
            while(!list.isEmpty()) {
                result = result + list.poll();
            }
        }
        System.out.println(result);
    }
}
