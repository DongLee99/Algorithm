import java.util.*;
class Solution {
    public static int solution(int[] topping) {
        HashMap<Integer, Integer> left = new HashMap<>();
        HashMap<Integer, Integer> right = new HashMap<>();
        int answer = 0;
        HashSet<Integer> toppingSet = new HashSet<>();
        int start = 0;
        for (int i = 0; i < topping.length; i++) {
            toppingSet.add(topping[i]);
            right.put(topping[i], right.getOrDefault(topping[i], 0) + 1);
        }
        for (int i = start; i < topping.length; i++) {
            left.put(topping[i], left.getOrDefault(topping[i], 0) + 1);
            right.put(topping[i], right.getOrDefault(topping[i], 0) - 1);
            if (right.get(topping[i]) == 0) {
                right.remove(topping[i]);
            }
            if (left.size() > right.size()) {
                break;
            }
            if (left.size() == right.size()) {
                answer++;
            }
        }
        return answer;
    }
    // 토핑의 가짓수가 중요
}