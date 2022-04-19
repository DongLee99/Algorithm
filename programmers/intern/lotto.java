import java.util.*;
import java.util.stream.Collectors;

class Solution {
    public int[] solution(int[] lottos, int[] win_nums) {
        int count = 0;

        for (int lotto : lottos) {
            if (lotto == 0) {
                count++;
            }
        }
        List<Integer> ints = Arrays.stream(win_nums)
                .boxed()
                .collect(Collectors.toList());

        int count1 = 0;
        for (int lotto : lottos) {
            if (ints.contains(lotto)) {
                count1++;
            }
        }


        if (count == 6 && count1 <= 1) {
            return new int [] {1, 6};
        }

        if (count == 0 && count1 <= 1) {
            return new int [] {6, 6};
        }
        if (count == 6) {
            return new int [] {1, 6 - count1 + 1};
        }

        if (count1 <= 1) {
            return new int [] {6 - (count1 + count) + 1, 6};
        }
        return new int [] {6 - (count1 + count) + 1, 6 - count1 + 1};
    }
}