import java.util.*;

public class problem2 {

    public static List<Integer> visit = new ArrayList<>();
    public static List<List<Node>> array = new ArrayList<>();
    public static int [] cost;
    public static List<Integer> buffer = new ArrayList<>();

    public static class Node implements Comparable<Node> {
        int startPoint;
        int endPoint;
        int cost;

        public Node(int startPoint, int endPoint, int cost) {
            this.startPoint = startPoint;
            this.endPoint = endPoint;
            this.cost = cost;
        }

        @Override
        public int compareTo(Node o) {
            return cost - o.cost;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int end = scanner.nextInt();
        int num = scanner.nextInt();

        PriorityQueue<Node> queue = new PriorityQueue<>();

        for (int i = 1; i <= end; i++) {
            visit.add(i);
        }

        for (int i = 0; i < num; i++) {
            int startP = scanner.nextInt();
            int endP = scanner.nextInt();
            int costP = scanner.nextInt();
            queue.add(new Node(startP, endP, costP));
        }
    }
}
