//import java.util.*;
//import java.util.stream.Collectors;
//
//public class Solution {
//    public int solution(int[][] jobs) {
//        Arrays.sort(jobs, new Comparator<int[]>() {
//            @Override
//            public int compare(int[] o1, int[] o2) {
//                if(o1[0] == o2[0]) {
//                    return o1[1] - o2[1];
//                } return o1[0] - o2[0];
//            }
//        });
//
//        PriorityQueue<int[]> queue = new PriorityQueue<>(new Comparator<int[]>() {
//            @Override
//            public int compare(int[] o1, int[] o2) {
//                return o1[1] - o2[1];
//            }
//        });
//        queue.offer(jobs[0]);
//        int end = jobs[0][0];
//        int sum = 0;
//        int idx = 1;
//
//        while(!queue.isEmpty()) {
//            int [] cul = queue.poll();
//            end = cul[1];
//            sum = sum + end - cul[0];
//            System.out.println(sum);
//        }
//    }
//
//    public static void main(String[] args) {
//        int bridge_length = 5;
//        int weight = 5;
//        int[] truck_weights = {2, 2, 2, 2, 1, 1, 1, 1, 1};
//        Solution solution = new Solution();
//        System.out.println(solution.solution(bridge_length, weight, truck_weights));
//    }
//
//}
