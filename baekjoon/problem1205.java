import java.util.*;
public class Main {

    public static int N;
    public static int T;
    public static int P;

    public static class Node implements Comparable<Node>{

        public int point;
        public String name;

        public Node (int point, String name) {
            this.point = point;
            this.name = name;
        }

        @Override
        public int compareTo(Node o) {
            if (o.point == this.point) {
                if (o.name.equals("")) {
                    return 1;
                } else {
                    return -1;
                }
            }
            return o.point - this.point;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        T = sc.nextInt();
        P = sc.nextInt();
        PriorityQueue<Node> pq = new PriorityQueue<>();
        for (int i = 0; i < N; i++) {
            pq.add(new Node(sc.nextInt(), ""));
        }
        pq.add(new Node(T, "tae"));
        int rank = 1;
        int nowRank = 1;
        int nowPoint = pq.peek().point;
        while(nowRank <= P && !pq.isEmpty()) {
            Node poll = pq.poll();
            if (poll.name.equals("tae")) {
                if (nowPoint != poll.point) {
                    if (nowRank != rank) {
                        rank = nowRank;
                    }
                    if (nowRank > P) {
                        System.out.println(-1);
                        return;
                    }
                    System.out.println(rank);
                    return;
                } else {
                    if (nowRank > P) {
                        System.out.println(-1);
                        return;
                    }
                    System.out.println(rank);
                    return;
                }
            } else {
                if (nowPoint != poll.point) {
                    if (nowRank != rank) {
                        rank = nowRank;
                    }
                }
            }
            nowRank++;
            nowPoint = poll.point;
        }
        System.out.println(-1);
    }
}
