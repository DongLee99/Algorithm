package programmers;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class programmersKnumber {

    static class Solution {
        public int[] solution(int[] array, int[][] commands) {
            List<Integer> temp = new ArrayList<>();
            int [] answer = new int[commands.length];
            for (int i = 0; i < commands.length; i++) {
                temp = new ArrayList<>();
                for (int j = commands[i][0]; j <= commands[i][1]; j++) {
                    temp.add(array[j-1]);
                }
                temp = temp
                        .stream()
                        .sorted()
                        .collect(Collectors.toList());
                answer[i] = temp.get(commands[i][2]-1);
            }
            return answer;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int [] array = {1, 5, 2, 6, 3, 7, 4};
        int [][] commands = {{2, 5, 3}, {4, 4, 1}, {1, 7, 3}};
        int[] answer = solution.solution(array, commands);
        for (int i : answer) {
            System.out.println(i);

        }
    }
}
