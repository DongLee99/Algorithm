import java.util.*;
class Solution {
    public int solution(int k, int m, int[] score) {
        Arrays.sort(score);
        int answer = 0;
        List<Integer> result = new ArrayList<>();
        int N = score.length;
        while(N >= 0) {
            if (N - m >= 0) {
                answer = answer + (score[N-m] * m);
                N = N - m;
            } else {
                N = N - m;
            }
        }

        return answer;
    }
    // k = 최상점
    // 한 상자 m
    // 가장 낮은 게 p 사과 한 상자 = p * m
}