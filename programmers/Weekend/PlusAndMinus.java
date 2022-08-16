class Solution {
    public int solution(int[] absolutes, boolean[] signs) {
        int size = absolutes.length;
        int answer = 0;
        for (int i = 0; i < size; i++) {
            if (signs[i]) {
                answer = answer + absolutes[i];
            } else {
                answer = answer - absolutes[i];
            }
        }
        return answer;
    }
}