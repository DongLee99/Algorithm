import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class main {

    public static int N;
    public static int M;
    public static int C;
    public static List<Node>[] arrays;
    public static boolean visit[];
    public static int result[];

    public static class Node {
        int vertex;
        int weight;

        public Node(int vertex, int weight) {
            this.vertex = vertex;
            this.weight = weight;
        }
    }

    public static void find(int start) {
        Queue<Node> queue = new LinkedList<>();
        queue.add(new Node(start, 0));
        visit[start] = true;

        while(!queue.isEmpty()) {
            Node poll = queue.poll();
            if (result[poll.vertex] < poll.weight) {
                continue;
            }
            for (int i = 0; i < arrays[poll.vertex].size(); i++) {
                int now = poll.vertex;
                int next = arrays[now].get(i).vertex;
                if (visit[next] == false) {
                    int vertex2 = arrays[poll.vertex].get(i).vertex;
                    int weight2 = arrays[poll.vertex].get(i).weight + poll.weight;
                    if (result[vertex2] > weight2) {
                        result[vertex2] = weight2;
                        queue.add(new Node(vertex2, weight2));
                    }
                }
            }
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        arrays = new List[N+1];

        for (int i = 0; i < N+1; i++) {
            arrays[i] = new ArrayList<>();
        }
        result = new int[N+1];

        Arrays.fill(result, Integer.MAX_VALUE);
        result[1] = 0;
        visit = new boolean[N+1];

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(bf.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int z = Integer.parseInt(st.nextToken());
            arrays[x].add(new Node(y, z));
        }

        find(C);

        int count = 0;
        int distance = 0;
        for (int i : result) {
            if (i != Integer.MAX_VALUE) {
                count++;
                distance = Math.max(distance, i);
            }
        }
        System.out.println(count - 1 + " " +distance);
    }
}
