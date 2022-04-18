import java.util.*;
import java.util.stream.Collectors;

public class problem {

    static class Solution {
        public int[] solution(int[] progresses, int[] speeds) {
            Queue<Integer> queue = new LinkedList<>();

            for (int i = 0; i < progresses.length; i++) {
                int a = progresses[i];
                int b = speeds[i];
                if ((100 - a) % b == 0) {
                    queue.add((100 - a) / b);
                } else {
                    queue.add((100 - a) / b + 1);
                }
            }
            List<Integer> ans = new ArrayList<>();
            while (!queue.isEmpty()) {
                int first = queue.peek();
                int count = 0;
                for (Integer integer : queue) {
                    if (first >= integer) {
                        count++;
                    } else {
                        break;
                    }
                }
                for (int i = 0; i< count; i++) {
                    queue.poll();
                }
                if (count > 0) {
                    ans.add(count);
                }
            }
            int size = ans.size();
            int [] answer = new int[size];
            for (int i = 0; i < size; i++) {
                answer[i] = ans.get(i);
            }
            return answer;
        }
    }

    public static void main(String[] args) {
        int [] progresses = {93, 30, 55};
        int [] speeds = {1, 30, 5};

        Solution solution = new Solution();
        int[] solution1 = solution.solution(progresses, speeds);
        for (int i : solution1) {
            System.out.println(i);
        }
    }
}