import java.util.*;

class Solution {
    public int[] solution(String[] keymap, String[] targets) {
        HashMap<String, Integer> map = new HashMap<>();
        int [] answer = new int[targets.length];
        for (int i = 0; i < keymap.length; i++) {
            for (int j = 0; j < keymap[i].length(); j++) {
                if (map.containsKey(String.valueOf(keymap[i].charAt(j)))) {
                    if (map.get(String.valueOf(keymap[i].charAt(j))) > j + 1) {
                        map.put(String.valueOf(keymap[i].charAt(j)), j + 1);
                    }
                } else {
                    map.put(String.valueOf(keymap[i].charAt(j)), j + 1);
                }
            }

        }
        for (int i = 0; i < targets.length; i++) {
            int count = 0;
            for (int j = 0; j < targets[i].length(); j++) {
                if (map.containsKey(String.valueOf(targets[i].charAt(j)))) {
                    count = count + map.get(String.valueOf(targets[i].charAt(j)));
                } else {
                    count = -1;
                    break;
                }
            }
            answer[i] = count;
        }
        return answer;
    }
}