import java.util.*;

class Solution {
    public String toBinary(int value) {
        int count = value;

        String answer = "";
        while (count > 0) {
            if (count % 2 == 0) {
                count = count / 2;
                answer = answer + "0";
            } else {
                count = count / 2;
                answer = answer + "1";
            }
        }
        return answer;
    }

    public int[] solution(String s) {
        int count1 = 0;
        String tmp = s;
        int count2 = 0;
        while(tmp.length() != 1) {
            for (int i = 0; i < tmp.length(); i++) {
                if (tmp.charAt(i) == '0') {
                    count1++;
                }
            }
            tmp = tmp.replaceAll("0", "");
            tmp = toBinary(tmp.length());
            count2++;
        }
        int[] answer = {count2, count1};
        return answer;
    }
}