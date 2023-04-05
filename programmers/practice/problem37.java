import java.util.*;

class Solution {
    class Tangerine implements Comparable<Tangerine>{
        public int idx;
        public int count;

        public Tangerine(int idx, int count) {
            this.idx = idx;
            this.count = count;
        }

        @Override
        public int compareTo(Tangerine o) {
            return o.count - this.count;
        }
    }
    public int solution(int k, int[] tangerine) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < tangerine.length; i++) {
            if (map.containsKey(tangerine[i])) {
                map.replace(tangerine[i], map.get(tangerine[i]) + 1);
            } else {
                map.put(tangerine[i], 1);
            }
        }
        PriorityQueue<Tangerine> queue = new PriorityQueue<>();

        Set<Integer> keys = map.keySet();
        for (int i : keys) {
            queue.add(new Tangerine(i, map.get(i)));
        }
        int count = k;
        int answer = 0;
        while(!queue.isEmpty()) {
            Tangerine tmp = queue.poll();
            if (tmp.count >= count) {
                return answer + 1;
            } else {
                count = count - tmp.count;
                answer++;
            }
        }
        return answer;
    }
}