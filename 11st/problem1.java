// you can also use imports, for example:
import java.util.*;

// you can write to stdout for debugging purposes, e.g.
// System.out.println("this is a debug message");

class Solution {
    public int solution(String S) {
        HashMap<String, Integer> hashMap = new HashMap<>();
        Queue<String> queue = new LinkedList<>();
        for (int i = 0; i < S.length(); i++) {
            if (hashMap.containsKey(String.valueOf(S.charAt(i)))) {
                hashMap.replace(String.valueOf(S.charAt(i)), hashMap.get(String.valueOf(S.charAt(i))) + 1);
            } else {
                hashMap.put(String.valueOf(S.charAt(i)), 1);
                queue.add(String.valueOf(S.charAt(i)));
            }
        }
        int answer = 0;
        while(!queue.isEmpty()) {
            String poll = queue.poll();
            if (hashMap.get(poll) % 2 != 0) {
                answer++;
            }
        }
        return answer;
    }
}
