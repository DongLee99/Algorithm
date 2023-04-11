import java.util.*;

class Solution {
    long answer = 0;
    public long solution(int[] weights) {
        Arrays.sort(weights);
        int tmpCnt = 0;

        for (int i = 0; i < weights.length; i++) {
            if (i != 0) {
                if (weights[i] == weights[i-1]) {
                    tmpCnt--;
                    answer = answer + tmpCnt;
                    continue;
                }
            }
            tmpCnt = 0;
            for (int j = i+1 ; j < weights.length; j++) {
                if (weights[i] == weights[j] ||
                        weights[i] * 2 == weights[j] * 3 ||
                        weights[i] * 2 == weights[j] * 4 ||
                        weights[i] * 3 == weights[j] * 2 ||
                        weights[i] * 3 == weights[j] * 4 ||
                        weights[i] * 4 == weights[j] * 2 ||
                        weights[i] * 4 == weights[j] * 3 ) {
                    tmpCnt++;
                }
            }
            answer = answer + tmpCnt;
        }

        return answer;
    }
}