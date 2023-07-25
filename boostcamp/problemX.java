
import java.util.*;


public class Main {
    public static int[] distances;
    public static boolean[] visited;
    public static List<Node> [] nodes;
    public static int MIN;
    public static class Node {
        public int idx;
        public int cost;

        Node(int idx, int cost) {
            this.idx = idx;
            this.cost = cost;
        }
    }
    public static void dijkstra(int start) {
        PriorityQueue<Node> q = new PriorityQueue<>((o1, o2) -> o1.cost - o2.cost);
        q.add(new Node(start, 0));
        distances[start] = Integer.MAX_VALUE;
        while(!q.isEmpty()) {
            Node now = q.poll();
            if (now.idx != start) {
                if (!visited[now.idx]) {
                    visited[now.idx] = true;
                }
            }
            for (Node next : nodes[now.idx]) {
                if (!visited[next.idx] && distances[next.idx] > now.cost + next.cost) {
                    if (next.idx == start) {
                        MIN = Math.min(MIN, now.cost + next.cost);
                    }
                    distances[next.idx] = now.cost + next.cost;
                    q.add(new Node(next.idx, distances[next.idx]));
                }
            }
        }
    }
    public static void main(String args[]) throws Exception
    {

        Scanner sc = new Scanner(System.in);
        int T;
        T=sc.nextInt();
        for(int test_case = 1; test_case <= T; test_case++)
        {
            int N = sc.nextInt();
            int M = sc.nextInt();
            nodes = new ArrayList[N+1];
            visited = new boolean[N+1];
            distances = new int[N+1];
            MIN = Integer.MAX_VALUE;
            for (int i = 1; i < N + 1; i++) {
                nodes[i] = new ArrayList<>();
                distances[i] = Integer.MAX_VALUE;
            }
            for (int i = 0; i < M; i++) {
                int X = sc.nextInt();
                int Y = sc.nextInt();
                int C = sc.nextInt();
                nodes[X].add(new Node(Y,C));
            }

            for (int i = 0; i < N + 1; i++) {
                distances[i] = Integer.MAX_VALUE;
            }

            for (int i = 1; i <= N; i++) {
                visited = new boolean[N + 1];
                distances = new int[N + 1];
                for (int k = 0; k < N + 1; k++) {
                    distances[k] = Integer.MAX_VALUE;
                }
                dijkstra(i);
            }
            System.out.println("#" + test_case + " " + MIN);
        }
    }
}


