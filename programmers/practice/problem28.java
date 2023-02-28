import java.util.*;
class Solution {
    public long solution(int k, int d) {
        long answer = 0;
        for (int i = 0; i <= d; i = i + k) {
            int canY = yPossible(i, d);
            answer = answer + (canY/k) + 1;
        }

        return answer;
    }

    public static int yPossible(int x, int d) {
        long xx = (long) Math.pow(x, 2);
        long dd = (long) Math.pow(d, 2);
        return (int) Math.sqrt(dd - xx);
    }
}