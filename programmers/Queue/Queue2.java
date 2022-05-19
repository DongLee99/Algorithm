import java.util.*;
import java.util.stream.Collectors;

public class problem {
    static class Solution {

        static class Node implements Comparable<Node> {
            public int priorities;
            public int location;

            public Node(int priorities, int location) {
                this.priorities = priorities;
                this.location = location;
            }

            @Override
            public int compareTo(Node o) {
                return o.priorities - this.priorities;
            }
        }

        static public int solution(int[] priorities, int location) {
            PriorityQueue<Node> queue = new PriorityQueue<>();

            for (int i = 0; i < priorities.length; i++) {
                queue.add(new Node(priorities[i], i));
            }
            int count = 1;
            while (!queue.isEmpty()) {
                Node poll = queue.peek();
                if (poll.location == location) {
                    return count;
                } else {
                    queue.poll();
                    count++;
                }
            }
            return 0;
        }
    }



    public static void main(String[] args) {
        int [] priorities = {2, 1, 2, 1, 2, 1, 2, 1, 2};
        int location = 1;
        Solution solution = new Solution();
        System.out.println(solution.solution(priorities, location));
    }
}