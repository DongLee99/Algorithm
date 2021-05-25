package programmers;

import java.util.Arrays;

public class programmersPhonecketmon {
    static class Solution {
        public static int solution(int[] nums) {
            int numSize = nums.length;
            int distinctNumsSize = (int) Arrays.stream(nums)
                                    .distinct()
                                    .count();
            if ((numSize / 2) > distinctNumsSize) {
                return distinctNumsSize;
            }
            return numSize/2;
        }
    }
    public static void main(String[] args) {
        int [] a = 	{3,1,2,3};
        int [] b= {3,3,3,2,2,2};
        System.out.println(Solution.solution(b));
    }
}
