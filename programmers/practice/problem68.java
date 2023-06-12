class Solution {
    public int solution(int n) {
        int answer = 0;

        for (int i = 1; i <= n; i++) {
            int result = 0;
            for (int j = i; j <= n; j++) {
                result = result + j;
                if (result == n) {
                    answer++;
                    break;
                }
                if (result > n) {
                    break;
                }
            }
        }
        return answer;
    }
}