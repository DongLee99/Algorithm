import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class problem {
    static int N;
    static int M;
    static int K;
    static int X;

    static List<Node> [] list;
    static int [] distance;

    static class Node implements Comparable<Node>{
        public int vertex;
        public int distance;

        public Node(int vertex, int distance) {
            this.vertex = vertex;
            this.distance = distance;
        }

        @Override
        public int compareTo(Node o) {
            return this.distance - o.distance;
        }
    }

    static void find() {
        PriorityQueue<Node> q = new PriorityQueue<>();
        q.offer(new Node(X, 0));

        while(!q.isEmpty()) {
            Node poll = q.poll();
            int vertex = poll.vertex;
            int weight = poll.distance;
            if (distance[vertex] < weight) {
                continue;
            }
            for (int i = 0; i < list[vertex].size(); i++) {
                int vertex2 = list[vertex].get(i).vertex;
                int weight2 = list[vertex].get(i).distance + weight;
                if (distance[vertex2] > weight2) {
                    distance[vertex2] = weight2;
                    q.offer(new Node(vertex2, weight2));
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());

        distance = new int[N + 1];
        Arrays.fill(distance, Integer.MAX_VALUE);
        distance[X] = 0;
        list = new ArrayList[N+1];

        for (int i = 0; i <= N; i++) {
            list[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(bf.readLine());

            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            list[x].add(new Node(y, 1));
        }

        find();
        boolean result = false;
        for (int i = 0; i < distance.length; i++) {
            if (distance[i] == K) {
                System.out.println(i);
                result = true;
            }
        }
        if (result == false) {
            System.out.println(-1);
        }
    }
}