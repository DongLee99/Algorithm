import java.util.*;
class Solution {
    public static int answer = 0;
    public void find(int start, String[] discount, HashMap<String, Integer> wantMap) {
        HashMap<String, Integer> map = new HashMap<>();
        for (int i = start; i < start + 10; i++) {
            if (map.containsKey(discount[i])) {
                map.replace(discount[i], map.get(discount[i]) + 1);
            } else {
                map.put(discount[i], 1);
            }
        }
        Set<String> set = map.keySet();
        for (String key : set) {
            if (wantMap.get(key) != map.get(key)) {
                return;
            }
        }
        answer++;
    }
    public int solution(String[] want, int[] number, String[] discount) {
        HashMap<String, Integer> map = new HashMap<>();
        for (int i = 0; i < want.length; i++) {
            map.put(want[i], number[i]);
        }
        for (int i = 0; i <= discount.length - 10; i++) {
            find(i, discount, map);
        }

        return answer;
    }
}