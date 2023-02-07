import java.util.*;

public class problem {

    public static void dfs(LinkedList<Integer>[] list, int[] depth, int [] parent, int cur, int d, int p) {
        depth[cur] = d;
        parent[cur] = p;

        for (int next : list[cur]) {
            if (next != p) {
                dfs(list, depth, parent, next, d+1, cur);
            }
        }
    }

    public static void lca(int [] depth, int [] parent, int a, int b) {
        int depthA = depth[a];
        int depthB = depth[b];

        while(depthA > depthB) {
            a = parent[a];
            depthA--;
        }

        while(depthB > depthA) {
            b = parent[b];
            depthB--;
        }

        while(a != b) {
            a = parent[a];
            b = parent[b];
        }
        System.out.println(a);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();

        for (int i = 0; i < N; i++) {
            int M = scanner.nextInt();
            LinkedList<Integer> [] list = new LinkedList[M+1];
            int [] parent = new int[M+1];
            int [] depth = new int[M+1];
            boolean [] vertex = new boolean[M+1];

            for (int j = 1; j <= M; j++) {
                list[j] = new LinkedList<Integer>();
            }

            for (int j = 0; j < M-1; j++) {
                int A = scanner.nextInt();
                int B = scanner.nextInt();

                vertex[B] = true;

                list[A].add(B);
                list[B].add(A);
            }
            int root = 0;
            for (int j = 1; j <= M; j++) {
                if (vertex[j] == false) {
                    root = j;
                }
            }

            int V1 = scanner.nextInt();
            int V2 = scanner.nextInt();

            dfs(list, depth, parent, root, 0, -1);

            lca(depth, parent, V1, V2);
        }
    }
}