import java.util.*;

class Solution {
    public static List<String> arr = new ArrayList<>();
    public static String[] tmp;
    public static int answer = 0;
    public static int idx = 0;
    public static char[] charArr = {'A', 'E', 'I', 'O', 'U'};
    public void dfs(String value, int count, String word) {
        if (count == 5) {
            return;
        }
        String tmp = value;
        for (int i = 0; i < 5; i++) {
            arr.add(tmp + String.valueOf(charArr[i]));
            answer++;
            if ((tmp + String.valueOf(charArr[i])).equals(word)) {
                idx = answer;
                return;
            }
            dfs(tmp + String.valueOf(charArr[i]), count+1, word);
        }
    }
    public int solution(String word) {
        dfs("", 0, word);

        return idx;
    }
}