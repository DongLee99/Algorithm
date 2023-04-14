import java.util.*;

class Solution {

    class Attack implements Comparable<Attack>{
        public int x;
        public int y;

        public Attack(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public int compareTo(Attack o) {
            return this.y - o.y;
        }
    }
    public int solution(int[][] targets) {
        int answer = 0;
        PriorityQueue<Attack> pq = new PriorityQueue<>();
        for (int[] target: targets) {
            pq.add(new Attack(target[0], target[1]));
        }
        int end = pq.peek().y;
        while(!pq.isEmpty()) {
            Attack poll = pq.poll();
            if (end <= poll.x) {
                end = poll.y;
                answer++;
            }
        }
        return answer + 1;
    }
}