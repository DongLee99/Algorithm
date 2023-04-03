import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Main {
    private static int N;
    private static int [][] arr;
    private static int [] dx = {0, 0, 1, -1};
    private static int [] dy = {1, -1 ,0 ,0};
    private static HashMap<Integer, int []> hashMap = new HashMap<>();
    private static class Node implements Comparable<Node>{
        int x;
        int y;
        int d;
        int emptyD;

        public Node(int x, int y, int d, int emptyD) {
            this.x = x;
            this.y = y;
            this.d = d;
            this.emptyD = emptyD;
        }

        @Override
        public int compareTo(Node o) {
            if (d == o.d) {
                if (emptyD == o.emptyD) {
                    if (x == o.x) {
                        return y - o.y;
                    } else {
                        return x - o.x;
                    }
                } else {
                    return o.emptyD - emptyD;
                }
            } else {
                return o.d - d;
            }
        }
    }

    private static class Shark {
        int idx;
        int [] fIdx;

        public Shark(int idx, int[] fIdx) {
            this.idx = idx;
            this.fIdx = fIdx;
        }
    }
    private static PriorityQueue<Node> check1(int idx) {
        PriorityQueue<Node> check1 = new PriorityQueue<>();
        int MAX = 0;
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                if (arr[i][j] == 0) {
                    int count = 0;
                    int count2 = 0;
                    for (int k = 0; k < 4; k++) {
                        int cx = i + dx[k];
                        int cy = j + dy[k];
                        if (cx >= 1 && cx <= N && cy >= 1 && cy <= N) {
                            for (int z = 0; z < 4; z++) {
                                int[] ints = hashMap.get(idx);
                                if (arr[cx][cy] == ints[z]) {
                                    count++;
                                }
                            }
                            if (arr[cx][cy] == 0) {
                                count2++;
                            }
                        }
                    }
                    MAX = Math.max(MAX, count);
                    check1.add(new Node(i, j, count, count2));
                }
            }
        }

        PriorityQueue<Node> result = new PriorityQueue<>();
        while(!check1.isEmpty()) {
            Node poll = check1.peek();
            //System.out.println(poll.x + " " + poll.y + " " + poll.d + " " + poll.emptyD);
            if (check1.peek().d == MAX) {
                result.add(check1.poll());
            } else {
                break;
            }
        }
        //System.out.println();
        return result;
    }

    private static void find(int x, int f1, int f2, int f3, int f4) {
        hashMap.put(x, new int[] {f1, f2, f3, f4});
        PriorityQueue<Node> check1Result = check1(x);
        Node poll = check1Result.poll();
        arr[poll.x][poll.y] = x;
    }

    private static int getWeight() {
        int result = 0;
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                int count = 0;
                int[] ints = hashMap.get(arr[i][j]);
                for (int k = 0; k < 4; k++) {
                    int cx = i + dx[k];
                    int cy = j + dy[k];
                    if (cx >= 1 && cx <= N && cy >= 1 && cy <= N) {
                        for (int z = 0; z < 4; z++) {
                            if (arr[cx][cy] == ints[z]) {
                                count++;
                            }
                        }
                    }
                }
                if (count == 1) {
                    result = result + 1;
                } else if (count == 2) {
                    result = result + 10;
                } else if (count == 3) {
                    result = result + 100;
                } else if (count == 4) {
                    result = result + 1000;
                }
            }
        }
        return result;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        arr = new int[N+1][N+1];
        int count = N * N;
        for (int i = 0; i < count; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int f1 = Integer.parseInt(st.nextToken());
            int f2 = Integer.parseInt(st.nextToken());
            int f3 = Integer.parseInt(st.nextToken());
            int f4 = Integer.parseInt(st.nextToken());
            find(x, f1, f2, f3, f4);
        }
//        for (int i = 1; i <= N; i++) {
//            for (int j = 1; j <= N; j++) {
//                System.out.print(arr[i][j] + " ");
//            }
//            System.out.println();
//        }
        System.out.println(getWeight());
    }
}k