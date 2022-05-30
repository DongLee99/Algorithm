import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.StringTokenizer;

public class main {

    public static int find_parent(int [] parent, int x) {
        if (parent[x] != x) {
            return find_parent(parent, parent[x]);
        }
        return x;
    }

    public static void union_parent(int[] parent, int a, int b) {
        a = find_parent(parent, a);
        b = find_parent(parent, b);

        if ( a < b ) {
            parent[b] = a;
        } else {
            parent[a] = b;
        }
    }

    public static class Node implements Comparable<Node> {
        public int a;
        public int b;
        public int cost;

        public Node(int a, int b, int cost) {
            this.a = a;
            this.b = b;
            this.cost = cost;
        }


        @Override
        public int compareTo(Node o) {
            return this.cost - o.cost;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int [] parent = new int[N + 1];

        List<Node> nodes = new ArrayList<>();
        for (int i = 0 ; i <= N; i++) {
            parent[i] = i;
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(bf.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            nodes.add(new Node(a, b, c));
        }
        nodes.sort(Node::compareTo);

        int result = 0;
        int last = 0;
        for (Node node : nodes) {
            int a = node.a;
            int b = node.b;
            int cost = node.cost;
            if (find_parent(parent, a) != find_parent(parent, b)) {
                union_parent(parent, a, b);
                result = result + cost;
                last = cost;
            }
        }
        System.out.println(result - last);
    }
}
