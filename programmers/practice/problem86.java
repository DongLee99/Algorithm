import java.util.*;

class Solution {
    public int[] solution(String[] operations) {
        int[] answer = {};
        PriorityQueue<Integer> down = new PriorityQueue<>();
        PriorityQueue<Integer> top = new PriorityQueue<>(Collections.reverseOrder());
        for (String operation : operations) {
            String[] operationArr = operation.split(" ");
            String key = operationArr[0];
            int value = Integer.parseInt(operationArr[1]);
            if (key.equals("I")) {
                down.add(value);
                top.add(value);
            } else {
                if (down.size() >= 1) {
                    if (value == 1) {
                        Integer getValue = top.peek();
                        down.remove(getValue);
                        top.poll();
                    } else {
                        Integer getValue = down.peek();
                        top.remove(getValue);
                        down.poll();
                    }

                }
            }
        }
        if (top.size() == 0) {
            return new int[]{0, 0};
        } else {
            return new int[]{top.poll(), down.poll()};
        }
    }
}