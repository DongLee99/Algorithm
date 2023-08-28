import java.util.*;
public class Main {

    public static int N;

    public static int[][] arr;
    public static int[][] tmp;
    public static boolean[][] visited;
    public static int studentCount = 0;
    public static List<Node> teachers = new ArrayList<>();
    public static int[] dx = {0, 0, 1, -1};
    public static int[] dy = {1, -1, 0, 0};
    public static boolean answer = false;

    public static class Node {
        public int x;
        public int y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void dfs(int count) {
        if (count == 3) {
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    tmp[i][j] = arr[i][j];
                }
            }
            for (int i = 0; i < teachers.size(); i++) {
                Node nowNode = teachers.get(i);
                for (int j = 0; j < 4; j++) {
                    int nX = nowNode.x;
                    int nY = nowNode.y;
                    while(true) {
                        if (nX + dx[j] >= 0 && nX + dx[j] < N && nY + dy[j] >= 0 && nY + dy[j] < N && tmp[nX + dx[j]][nY + dy[j]] != 4) {
                            if (tmp[nX + dx[j]][nY + dy[j]] == 2) {
                                nX = nX + dx[j];
                                nY = nY + dy[j];
                            } else {
                                nX = nX + dx[j];
                                nY = nY + dy[j];
                                tmp[nX][nY] = 2;
                            }
                        } else {
                            break;
                        }
                    }
                }

            }
            int result = 0;
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (tmp[i][j] == 1) {
                        result++;
                    }
                }
            }
            if (result == studentCount) {
                answer = true;
            }
            return;
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (visited[i][j] == false && arr[i][j] == 0) {
                    visited[i][j] = true;
                    arr[i][j] = 4;
                    dfs(count + 1);
                    arr[i][j] = 0;
                    visited[i][j] = false;
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        arr = new int[N][N];
        tmp = new int[N][N];
        visited = new boolean[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                String now = sc.next();
                if (now.equals("X")) {
                    arr[i][j] = 0;
                } else if (now.equals("S")) {
                    studentCount++;
                    arr[i][j] = 1;
                } else if (now.equals("T")) {
                    arr[i][j] = 2;
                    teachers.add(new Node(i, j));
                }
            }
        }
        dfs(0);

        if (answer) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
    }
}
