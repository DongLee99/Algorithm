import java.util.*;

class Solution {
    public int solution(int k, int[] tangerine) {
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < tangerine.length; i++) {
            map.put(tangerine[i], map.getOrDefault(tangerine[i], 0) + 1);
        }

        List<Integer> list = new ArrayList<>(map.keySet());

        list.sort((o1, o2) -> map.get(o2) - map.get(o1));

        int i = 0;
        int answer = 0;
        while (k > 0) {
            k = k - map.get(list.get(i));
            answer++;
            i++;
        }
        return answer;
    }
}