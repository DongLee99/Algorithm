import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class problem {
    static int MIN = Integer.MAX_VALUE;
    static boolean [] visit;
    static int F;
    static int S;
    static int G;
    static int U;
    static int D;

    static void check(int num) {
        Queue<Node> queue = new LinkedList<>();
        queue.offer(new Node(num, 0));
        visit[num] = true;

        while(!queue.isEmpty()) {
            Node x = queue.poll();
            if (x.x == G) {
                MIN = Math.min(MIN, x.cost);
            }
            if (x.x + U  <= F && visit[x.x + U] == false) {
                queue.offer(new Node(x.x+U, x.cost + 1));
                visit[x.x + U] = true;
            }
            if (x.x - D >= 1 && visit[x.x - D] == false) {
                queue.offer(new Node(x.x-D, x.cost + 1));
                visit[x.x - D] = true;
            }
        }
    }

    public static class Node {
        int x;
        int cost;

        public Node(int x, int cost) {
            this.x = x;
            this.cost = cost;
        }
    }


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        F = scanner.nextInt();
        S = scanner.nextInt();
        G = scanner.nextInt();
        U = scanner.nextInt();
        D = scanner.nextInt();
        visit = new boolean[F + 1];
        check(S);

        if (MIN == Integer.MAX_VALUE) {
            System.out.println("use the stairs");
        } else {
            System.out.println(MIN);
        }
    }
}