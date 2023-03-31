import java.util.*;
class Solution {
    public int[] solution(String[] name, int[] yearning, String[][] photo) {
        HashMap<String, Integer> map = new HashMap<>();
        int count = 0;
        for (String value : name) {
            map.put(value, yearning[count]);
            count++;
        }
        int [] answer = new int [photo.length];

        for (int i = 0; i < photo.length; i++) {
            int result = 0;
            System.out.println(photo[i].length);
            for (int j = 0; j < photo[i].length; j++) {
                result = result + map.getOrDefault(photo[i][j], 0);
            }
            answer[i] = result;
        }
        return answer;
    }
}