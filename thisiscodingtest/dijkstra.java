import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class main {
    public static int N;
    public static int M;
    public static int start;
    public static boolean [] visit;
    public static ArrayList<Node>[] list;
    public static int [] result;

    private static class Node implements Comparable<Node> { //우선순위큐로 성능개선(안하면 시간초과뜸)
        int vertex;
        int weight;

        public Node(int vertex, int weight) {
            this.vertex = vertex;
            this.weight = weight;
        }

        @Override
        public int compareTo(Node o) {
            return weight - o.weight;
        }
    }

    public static void find(int start) {
        PriorityQueue<Node> queue = new PriorityQueue<>();
        queue.add(new Node(start,0));

        while(!queue.isEmpty()) {
            Node poll = queue.poll();
            if (result[poll.vertex] < poll.weight) {
                continue;
            }
            for (int i = 0; i < list[poll.vertex].size(); i++) {
                int vertex2 = list[poll.vertex].get(i).vertex;
                int weight2 = list[poll.vertex].get(i).weight + poll.weight;
                if (result[vertex2] > weight2) { //지금께 더 최단경로라면 갱신해준다.
                    result[vertex2] = weight2;
                    queue.add(new Node(vertex2, weight2));
                }
            }
        }
    };

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        start = Integer.parseInt(bf.readLine());
        list = new ArrayList[N+1];
        for (int i = 1; i <= N; i++) {
            list[i] = new ArrayList<>();
        }

        visit = new boolean[N+1];
        result = new int[N+1];
        Arrays.fill(result, Integer.MAX_VALUE);
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(bf.readLine());
            list[Integer.parseInt(st.nextToken())].add(new Node(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
        }

        find(start);
        for (int i : result) {
            System.out.println(i);
        }
    }
}
