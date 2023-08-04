import java.util.*;
import java.io.*;


public class Main
{
    public static int W;
    public static int N;
    public static PriorityQueue<Node> pq = new PriorityQueue<>();

    public static class Node implements Comparable<Node> {
        public int m;
        public int p;

        public Node (int m, int p) {
            this.m = m;
            this.p = p;
        }

        @Override
        public int compareTo(Node o1) {
            return o1.p - this.p;
        }
    }
    public static void main(String args[]) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        W = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            pq.add(new Node(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
        }
        int result = 0;
        while(!pq.isEmpty()) {
            Node poll = pq.poll();
            if (W < poll.m) {
                result = result + (poll.p * W);
                break;
            } else {
                result = result + (poll.p * poll.m);
                W = W - poll.m;
            }
        }
        System.out.println(result);
    }
}