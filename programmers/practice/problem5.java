import java.util.Arrays;
import java.util.Collections;

class Solution {
    public int[] solution(int k, int[] score) {
        Integer [] tmp = new Integer [score.length];
        Arrays.fill(tmp, 0);
        int count = 0;
        int [] result = new int [score.length];
        for (int i = 0; i < score.length; i++) {
            count++;
            tmp[i] = score[i];
            Arrays.sort(tmp, Collections.reverseOrder());
            if (count < k) {
                result[i] = tmp[i];
            } else {
                result[i] = tmp[k-1];
            }
        }
        return result;
    }
}
