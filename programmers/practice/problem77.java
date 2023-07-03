import java.util.*;

class Solution {
    public long solution(int n, int[] works) {
        long answer = 0;
        PriorityQueue<Integer> queue = new PriorityQueue<>(Collections.reverseOrder());

        for (int i = 0; i < works.length; i++) {
            queue.add(works[i]);
        }

        for (int i = 0; i < n; i++) {
            if (queue.peek() - 1 <= 0) {
                queue.poll();
                queue.add(0);
            } else {
                queue.add(queue.poll() - 1);
            }
        }

        while(!queue.isEmpty()) {
            answer = answer + (long) Math.pow(queue.poll(), 2);
        }

        return answer;
    }
}