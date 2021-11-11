import java.util.HashMap;

public class Solution {

    public String solution(String[] participant, String[] completion) {
        HashMap<String, Integer> hashMap = new HashMap<>();
        for (String s : participant) {
            if (hashMap.containsKey(s)) {
                hashMap.replace(s, hashMap.get(s) + 1);
            } else {
                hashMap.put(s, 1);
            }
        }

        for (String s : completion) {
            if (hashMap.containsKey(s)) {
                hashMap.replace(s, hashMap.get(s) - 1);
            }
        }

        for (String s : participant) {
            if (hashMap.get(s) != 0) {
                return s;
            }
        }
        return null;
    }

    public static void main(String[] args) {
        String[] participant = {"leo", "kiki", "eden"};
        String[] completion = {"eden", "kiki"};

        Solution solution = new Solution();
        System.out.println(solution.solution(participant, completion));
    }

}
