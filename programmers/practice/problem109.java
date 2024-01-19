class Solution {
    public int solution(int a, int b, int n) {
        int answer = 0;
        while (n >= a) {
            int tmp = n % a;
            answer = answer + ((n/a) * b);
            n = (n / a) * b;
            n = n + tmp;
        }
        return answer;
    }
}