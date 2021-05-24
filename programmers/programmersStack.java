package programmers;

import java.util.*;
import java.util.stream.Collectors;

public class programmersStack {
    static class Solution {
        static class process {
            int value = 0;
            int weight = 0;

            public process(int value, int weight) {
                this.value = value;
                this.weight = weight;
            }

            public void changeValue() {
                this.value = value + weight;
            }

            public int getValue() {
                return value;
            }
        }
        public static int[] solution(int[] progresses, int[] speeds) {
            Queue<process> progressQueue = new LinkedList<>();
            List<Integer> answer = new LinkedList<>();
            int count = 0;
            for (int index = 0; index < progresses.length; index++) {
                progressQueue.add(new process(progresses[index], speeds[index]));
            }

            while (!progressQueue.isEmpty()) {
                progressQueue.stream()
                        .forEach(process::changeValue);
                for (process process : progressQueue) {
                    if (process.getValue() >= 100) {
                        System.out.println(process.getValue());
                        count++;
                    } else {
                        break;
                    }
                }
                for (int i = 0 ; i < count; i++) {
                    progressQueue.poll();
                }
                if (count != 0) {
                    answer.add(count);
                }
                count = 0;

            }
            int [] result = new int [answer.size()];
            for (int i = 0; i <answer.size(); i++) {
                    result[i] = answer.get(i);
            }
            return result;
        }
    }

    public static void main(String[] args) {
        int [] a = 	{93, 30, 55};
        int [] b= {1, 30, 5};
        Solution.solution(a,b);
    }
}
