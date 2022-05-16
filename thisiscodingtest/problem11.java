import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class main {
    public static class Node implements Comparable<Node> {
        String name;
        int point;

        public Node(String name, int point) {
            this.name = name;
            this.point = point;
        }

        @Override
        public int compareTo(Node o) {
            return this.point - o.point;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bf.readLine());
        Node [] arr = new Node[N];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(bf.readLine());
            arr[i] = new Node(st.nextToken(), Integer.parseInt(st.nextToken()));
        }

        Arrays.sort(arr);
        for (Node node : arr) {
            System.out.println(node.name);
        }
    }
}
