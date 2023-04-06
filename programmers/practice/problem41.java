import java.util.*;

class Solution {

    public int solution(String[][] book_time) {
        int[] time = new int [1449];

        for (int i = 0; i < book_time.length; i++) {
            String[] starts = book_time[i][0].split(":");
            String[] ends = book_time[i][1].split(":");
            int start = Integer.parseInt(starts[0]) * 60 + Integer.parseInt(starts[1]);
            int end = Integer.parseInt(ends[0]) * 60 + Integer.parseInt(ends[1]) + 9;
            for (int j = start; j <= end; j++) {
                time[j] = time[j]+ 1;
            }
        }
        int answer = 0;
        for (int i = 0; i < time.length; i++) {
            answer = Math.max(answer, time[i]);
        }
        return answer;
    }
}