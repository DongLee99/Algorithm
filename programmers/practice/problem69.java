class Solution {
    public int solution(int n) {
        int answer = 0;
        int start = n;
        int tmp = start;
        int count = 0;
        while (tmp > 0) {
            if (tmp % 2 == 1) {
                count++;
            }
            tmp = tmp / 2;
        }
        while(true) {
            start++;
            int s_tmp = start;
            int s_count = 0;
            while (s_tmp > 0) {
                if (s_tmp % 2 == 1) {
                    s_count++;
                }
                s_tmp = s_tmp / 2;
            }
            if (count == s_count) {
                return start;
            }
        }
    }
}