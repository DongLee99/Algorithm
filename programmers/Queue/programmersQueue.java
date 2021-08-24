import java.util.*;
import java.util.stream.Stream;

class Solution {
    public int solution(int[] priorities, int location) {
        int count = 0;
        Queue<Integer> queue = new ArrayDeque<>();
        for (int priority : priorities) {
            queue.add(priority);
        }
        while (true) {
            if (location == 0) {
                int poll = queue.poll();
                Stream<Integer> integerStream = queue.stream()
                        .filter(q -> q > poll);
                if (integerStream.count() != 0) {
                    queue.remove(0);
                    queue.add(poll);
                    location = queue.size()-1;
                } else {
                    count = count + 1;
                    return count;
                }
            } else {
                int poll = queue.poll();
                Stream<Integer> integerStream = queue.stream()
                        .filter(q -> q > poll);
                if (integerStream.count() != 0) {
                    queue.remove(0);
                    queue.add(poll);
                    location = location - 1;
                } else {
                    queue.remove(0);
                    location = location - 1;
                    count = count + 1;
                }
            }
        }

    }
}