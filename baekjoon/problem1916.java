import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class problem {

    public static List<Integer> visit = new ArrayList<>();
    public static List<List<Node>> array = new ArrayList<>();
    public static int [] costs;

    public static class Node {
        int end;
        int cost;

        public Node(int end, int cost) {
            this.end = end;
            this.cost = cost;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int size = scanner.nextInt();
        int num = scanner.nextInt();

        costs = new int[size + 1];

        for (int i = 0; i < size + 1; i++) {
            array.add(new ArrayList<>());
            costs[i] = Integer.MAX_VALUE;
        }

        for (int i = 0; i < num; i++) {
            int start = scanner.nextInt();
            int end = scanner.nextInt();
            int cost = scanner.nextInt();
            array.get(start).add(new Node(end, cost));
        }

        int startNum = scanner.nextInt();
        int endNum = scanner.nextInt();

        for (Node node : array.get(startNum)) {
            if (costs[node.end] > node.cost) {
                costs[node.end] = node.cost;
            }
        }

        visit.add(startNum);

        while (visit.size() != size) {
            int position = 0;
            int costMin = Integer.MAX_VALUE;
            for (int i = 1; i < costs.length; i++) {
                if (!visit.contains(i) && costMin > costs[i]) {
                    position = i;
                    costMin = costs[i];
                }
            }
            for (Node node : array.get(position)) {
                if (costs[node.end] > node.cost + costs[position]) {
                    costs[node.end] = node.cost + costs[position];
                }
            }

            visit.add(position);
        }
        System.out.println(costs[endNum]);
    }
}
