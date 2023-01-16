import java.util.*;
class Solution {
    class Position {
        public int beforeX;
        public int value;

        public Position(int beforeX, int value) {
            this.beforeX = beforeX;
            this.value = value;
        }
    }
    public int[] solution(String s) {
        int [] result = new int [s.length()];
        HashMap<String, Position> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            if (map.containsKey(String.valueOf(s.charAt(i)))) {
                Position position = map.get(String.valueOf(s.charAt(i)));
                position.value = i - position.beforeX;
                position.beforeX = i;
                result[i] = position.value;
            } else {
                map.put(String.valueOf(s.charAt(i)), new Position(i, -1));
                result[i] = -1;
            }
        }
        return result;
    }
}