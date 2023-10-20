import java.util.*;

public class Main {
    public static class Solution {
        public static class Node implements Comparable<Node>{
            public String value;
            public int count;

            public Node(String value, int count) {
                this.value = value;
                this.count = count;
            }

            @Override
            public int compareTo(Node o) {
                if (o.count == this.count) {
                    return this.value.compareTo(o.value);
                } else {
                    return o.count - this.count;
                }
            }
        }
        public static String solution(String[] products, String[] purchased) {
            HashMap<String, Integer> map = new HashMap<>();
            HashMap<String, Integer> notPurchased = new HashMap<>();
            for (String product : products) {
                String[] splitProduct = product.split(" ");
                notPurchased.put(splitProduct[0], 0);
            }
            for (String pur : purchased) {
                notPurchased.remove(pur);
                for (String product : products) {
                    String[] splitProduct = product.split(" ");
                    if (splitProduct[0].equals(pur)) {
                        for (int i = 1; i < splitProduct.length; i++) {
                            if (map.containsKey(splitProduct[i])) {
                                map.replace(splitProduct[i], map.get(splitProduct[i]) + 1);
                            } else {
                                map.put(splitProduct[i], 1);
                            }
                        }
                    }
                }
            }
            PriorityQueue<Node> pq = new PriorityQueue<>();
            Set<String> keySet = map.keySet();
            for (String s : keySet) {
                pq.add(new Node(s, map.get(s)));
            }
            HashMap<String, Integer> priority = new HashMap<>();
            int priorityCount = pq.size();
            while(!pq.isEmpty()) {
                Node poll = pq.poll();
                priority.put(poll.value, priorityCount--);
            }

            Set<String> notPurchasedKey = notPurchased.keySet();
            String answer = "";
            int max = Integer.MIN_VALUE;
            for (String nPK : notPurchasedKey) {
                int weight = 0;
                for (String product : products) {
                    String[] splitProduct = product.split(" ");
                    if (splitProduct[0].equals(nPK)) {
                        for (int i = 1; i < splitProduct.length; i++) {
                            weight = weight + priority.get(splitProduct[i]);
                        }
                    }
                }
                if (max < weight) {
                    answer = nPK;
                    max = weight;
                }
            }
            return answer;
        }
    }
    public static void main(String[] args) {
        String[] products = {"towel red long thin", "blanket red thick short", "curtain red long wide", "mattress thick", "hat red thin", "pillow red long", "muffler blue thick long"};
        String[] purchased = {"blanket", "curtain", "hat", "muffler"};
        System.out.println(Solution.solution(products, purchased));
    }
}