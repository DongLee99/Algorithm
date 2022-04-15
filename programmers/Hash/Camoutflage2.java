import java.util.HashMap;
import java.util.Iterator;

class Solution {
    public int solution(String[][] clothes) {
        HashMap<String, Integer> hashMap = new HashMap();

        for (String[] clothe : clothes) {
            if (hashMap.containsKey(clothe[1])) {
                hashMap.replace(clothe[1], hashMap.get(clothe[1]) + 1);
            } else {
                hashMap.put(clothe[1], 1);
            }
        }

        Iterator<Integer> iterator = hashMap.values().iterator();
        int result = 1;
        while(iterator.hasNext()) {
            result = result * (iterator.next() + 1);
        }
        return result - 1;
    }
}