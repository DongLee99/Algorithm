import java.util.*;
import java.util.stream.Collectors;

public class Solution {
    class Album implements Comparable<Album>{
        int id;
        String type;
        int count;

        public Album(int id, String type, int count) {
            this.id = id;
            this.type = type;
            this.count = count;
        }

        public int getCount() {
            return count;
        }

        @Override
        public int compareTo(Album o) {
            if (o.count > count) {
                return 1;
            } else if (o.count < count) {
                return -1;
            }
            return 0;
        }
    }

    public int[] solution(String[] genres, int[] plays) {
        HashMap<String, Integer> hashMapHashMap = new HashMap<>();
        List<Album> list = new ArrayList<>();
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < genres.length; i++) {
            hashMapHashMap.put(genres[i], hashMapHashMap.getOrDefault(genres[i], 0)+plays[i]);
            list.add(new Album(i, genres[i], plays[i]));
        }
        List<String> collect = Arrays.stream(genres).distinct()
                .collect(Collectors.toList());
        Collections.sort(list);
        int max = 0;
        int key = 0;
        for (int i = 0; i < collect.size(); i++) {
            max = 0;
            for (int j = 0; j < collect.size(); j++) {
                if (hashMapHashMap.getOrDefault(collect.get(j), 0) > max) {
                    max = hashMapHashMap.get(collect.get(j));
                    key = j;
                }
            }
            int semiCnt = 0;
            for (int j = 0; j < list.size(); j++) {
                if (semiCnt != 2 ) {
                    if (list.get(j).type == collect.get(key)) {
                        result.add(list.get(j).id);
                        semiCnt++;
                    }
                } else {
                    semiCnt = 0;
                }
            }
            hashMapHashMap.remove(genres[key]);
        }
        int [] result1 = new int[result.size()];
        int cnt2 = 0;
        for (Integer integer : result) {
            result1[cnt2] = integer;
            System.out.println(integer);
            cnt2++;
        }
        return result1;
    }

    public static void main(String[] args) {
        String [] genres = {"classic", "pop", "classic", "classic", "pop", "test"};
        int [] plays = {500, 600, 150, 800, 2500, 100};
        Solution solution = new Solution();
        for (int i : solution.solution(genres, plays)) {
            System.out.println(i);
        }
    }

}
