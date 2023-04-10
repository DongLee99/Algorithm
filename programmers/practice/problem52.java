import java.util.*;

class Solution {
    class Node implements Comparable<Node>{
        public String value;
        public int idx;

        public Node(String value, int idx) {
            this.value = value;
            this.idx = idx;
        }

        @Override
        public int compareTo(Node o) {
            return this.idx - o.idx;
        }
    }
    public String[] solution(String[] players, String[] callings) {
        String[] arr = players;
        PriorityQueue<Node> pq = new PriorityQueue<>();
        HashMap<String, Integer> hashmap = new HashMap<>();

        for (int i = 0; i < players.length; i++) {
            hashmap.put(players[i], i);
        }
        for (int i = 0; i < callings.length; i++) {
            int idx = hashmap.get(callings[i]);
            String tmp = arr[idx-1];
            arr[idx-1] = callings[i];
            arr[idx] = tmp;
            hashmap.replace(callings[i], hashmap.get(callings[i])-1);
            hashmap.replace(tmp, hashmap.get(tmp) + 1);
        }
        return arr;
    }
}
// m s p k m
// 1 2 3 2 5
// m k s p m
// 1 2 3 4 5
// m k m s p
