import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class main {

    public static int N;
    public static int M;
    public static int [] parents;
    public static int result = 0;

    public static int find(int [] parent, int x) {
        if (parent[x] != x) {
            parent[x] = find(parent, parent[x]);
        }
        return parent[x];
    }

    public static void union(int [] parent, int a, int b) {
        int x = find(parent, a);
        int y = find(parent, b);

        if ( x < y ) {
            parent[y] = x;
        } else {
            parent[x] = y;
        }
    }

    public static class Edge implements Comparable<Edge>{
        int start;
        int end;
        int cost;

        public Edge(int start, int end, int cost) {
            this.start = start;
            this.end = end;
            this.cost = cost;
        }

        @Override
        public int compareTo(Edge o) {
            return this.cost - o.cost;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        parents = new int[N + 1];

        for (int i = 1; i <= N; i++) {
            parents[i] = i;
        }

        PriorityQueue<Edge> queue = new PriorityQueue<>();

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(bf.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            queue.add(new Edge(start, end, cost));
        }

        while(!queue.isEmpty()) {
            Edge poll = queue.poll();
            if (find(parents, poll.start) != find(parents, poll.end)) {
                System.out.println(poll.start + "      " + poll.end);
                System.out.println(find(parents, poll.start) + "     " + find(parents, poll.end));
                union(parents, poll.start, poll.end);
                System.out.println(find(parents, poll.start) + "     " + find(parents, poll.end));
                result += poll.cost;
                System.out.println(poll.cost);
            }
            for (int parent : parents) {
                System.out.println(parent);

            }
            System.out.println("------");
        }
        System.out.println(result);
    }
}