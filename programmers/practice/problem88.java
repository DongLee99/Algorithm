class Solution {
    public String solution(int n) {
        String answer = "";
        String [] anw = {"4", "1" ,"2"};
        int count = 0;
        while(n > 0) {
            int x = n % 3;
            n = n / 3;
            if (x == 0) n--;
            answer = anw[x] + answer;
        }

        return answer;
    }
}