import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class problem {
    static int N;
    static int M;
    static int V;
    static int [][] arr;
    static boolean [] visit;
    static List<Integer> dfsResult = new ArrayList<>();
    static List<Integer> bfsResult = new ArrayList<>();

    static void dfs(int num) {
        visit[num] = true;
        dfsResult.add(num);

        for (int i = 1; i <= N; i++) {
            if (arr[num][i] == 1 && visit[i] == false) {
                dfs(i);
            }
        }
    }

    static void bfs(int num) {
        Queue<Integer> queue = new LinkedList<Integer>();
        visit[num] = true;
        queue.offer(num);

        while (queue.size() != 0) {
            int v = queue.poll();
            bfsResult.add(v);
            for (int i = 1; i <= N; i++) {
                if (arr[v][i] == 1 && visit[i] == false) {
                    queue.offer(i);
                    visit[i] = true;
                }
            }
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        V = Integer.parseInt(st.nextToken());

        arr = new int[N+1][N+1];
        visit = new boolean[N+1];

        for (int i = 0; i < M; i++) {
            StringTokenizer tt = new StringTokenizer(bf.readLine());
            int x = Integer.parseInt(tt.nextToken());
            int y = Integer.parseInt(tt.nextToken());
            arr[x][y] = 1;
            arr[y][x] = 1;
        }
        dfs(V);
        visit = new boolean[N+1];
        bfs(V);

        for (Integer integer : dfsResult) {
            System.out.print(integer + " ");
        }

        System.out.println();

        for (Integer integer : bfsResult) {
            System.out.print(integer + " ");
        }
    }
}