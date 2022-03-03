import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class problem {
    static int T;
    static int N;

    public static class Node implements Comparable<Node>{
        int x;
        int y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public int compareTo(Node o) {
            return this.x - o.x;
        }
    }
    static int check(List<Node> q) {
        int count = 1;
        Collections.sort(q);
        int pivot = q.get(0).y;
        for (int i = 1; i < N; i++) {
            if (q.get(i).y < pivot) {
                pivot = q.get(i).y;
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        T = Integer.parseInt(st.nextToken());
        for (int i = 0; i < T; i++) {
            List<Node> q = new ArrayList<>();
            st = new StringTokenizer(bf.readLine());
            N = Integer.parseInt(st.nextToken());
            for (int j = 0; j < N; j++) {
                st = new StringTokenizer(bf.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                q.add(new Node(x,y));
            }
            System.out.println(check(q));
        }
    }
}