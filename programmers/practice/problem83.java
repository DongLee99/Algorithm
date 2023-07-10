import java.util.*;

class Solution {
    public int solution(int cacheSize, String[] cities) {
        int answer = 0;
        if (cacheSize == 0) {
            return cities.length * 5;
        }
        LinkedList<String> cache = new LinkedList<>();

        for (int i = 0; i < cities.length; i++) {
            String city = cities[i].toUpperCase();
            if (cache.remove(city)) {
                answer = answer + 1;
                cache.add(city);
            } else {
                answer = answer + 5;
                if (cache.size() >= cacheSize) {
                    cache.remove(0);
                }
                cache.add(city);
            }
        }
        return answer;
    }
}