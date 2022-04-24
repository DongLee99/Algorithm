import java.util.*;
import java.util.regex.Pattern;

class Solution {
    public int solution(String s) {
        HashMap<String, Integer> map = new HashMap<>();
        map.put("zero", 0);
        map.put("one", 1);
        map.put("two", 2);
        map.put("three", 3);
        map.put("four", 4);
        map.put("five", 5);
        map.put("six", 6);
        map.put("seven", 7);
        map.put("eight", 8);
        map.put("nine", 9);
        Pattern pattern = Pattern.compile("[0-9]");
        String tmp = "";
        String result = "";
        for (int i = 0; i < s.length(); i++) {
            if (!pattern.matcher(String.valueOf(s.charAt(i))).find()) {
                tmp = tmp + s.charAt(i);
                if (map.containsKey(tmp)) {
                    result = result + map.get(tmp);
                    tmp = "";
                }
            } else {
                if (tmp.equals("")) {
                    result = result + s.charAt(i);
                    tmp = "";
                } else {
                    result = result + map.get(tmp);
                    tmp = "";
                }
            }
        }
        return Integer.parseInt(result);
    }
}