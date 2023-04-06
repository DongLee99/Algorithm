import java.util.*;

class Solution {
    public static HashMap<Integer, Integer> map = new HashMap<>();

    public int solution(int[] elements) {
        int[] extraElements = new int[elements.length * 2];

        for (int i = 0; i < elements.length; i++) {
            extraElements[i] = elements[i];
            extraElements[i+elements.length] = elements[i];
        }

        for (int i = 1; i <= elements.length; i++) {
            for (int j = 0; j < elements.length; j++) {
                int result = 0;
                int start = j;
                int end = j + i;
                for (int k = start; k < end; k++) {
                    result = result + extraElements[k];
                }

                if (!map.containsKey(result)) {
                    map.put(result, 1);
                }
            }
        }

        return map.size();
    }
}