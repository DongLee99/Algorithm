import java.util.*;
import java.util.stream.Collectors;

public class Solution {
    public int solution(int[] priorities, int location) {
        Queue<Integer> queue = new ArrayDeque<>();
        for (int priority : priorities) {
            queue.offer(priority);
        }
        int result = 0;
        while(true) {
            if (location == 0) {
                Integer poll = queue.poll();
                int count1 = (int) queue.stream()
                        .filter(q -> q > poll)
                        .count();
                if (count1 != 0) {
                    queue.remove(0);
                    location = location + queue.size();
                    queue.add(poll);
                } else {
                    result++;
                    return result;
                }
            } else {
                Integer poll = queue.poll();
                int count1 = (int) queue.stream()
                        .filter(q -> q > poll)
                        .count();
                if (count1 != 0) {
                    queue.remove(0);
                    queue.add(poll);
                    location--;
                } else {
                    queue.remove(0);
                    result++;
                    location--;
                    continue;
                }
            }
        }
    }

    public static void main(String[] args) {
        int [] priorities = {1, 1, 1, 1, 1, 1};
        int location = 3;
        Solution solution = new Solution();
        System.out.println(solution.solution(priorities, location));
    }

}
