import java.util.*;
import java.util.stream.Collectors;

public class problem {
    static class Solution {
        public int solution(String s) {
            int answer = s.length();
            for (int i = 1; i < s.length()/2 + 1; i++) {
                String tmp = s.substring(0,i);
                String result = "";
                String last = "";
                int count = 1;
                for (int j = i; j < s.length(); j = j + i) {
                    if (j + i > s.length()) {
                        last = s.substring(j);
                        continue;
                    }
                    if (tmp.equals(s.substring(j, j + i))) {
                        count++;
                    } else {
                        result = result + tmp;
                        if (count != 1) {
                            result = result + count;
                        }
                        tmp = s.substring(j, j+i);
                        count = 1;
                    }
                }
                result = result + last + tmp;
                if (count != 1) {
                    result = result + count;
                }
                answer = Math.min(answer, result.length());
            }
            return answer;
        }
    }
    public static void main(String[] args) {
        String input = "aabbaccc";
        Solution solution = new Solution();
        System.out.println(solution.solution(input));
    }
}