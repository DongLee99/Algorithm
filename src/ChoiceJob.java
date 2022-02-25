import java.util.*;
import java.util.stream.Stream;

public class ChoiceJob {
    /*class Solution {
        public String solution(String[] table, String[] languages, int[] preference) {
            List<int[]> getResultList = new ArrayList<>();
            List<int[]> getResultPre = new ArrayList<>();
            for (String language : languages) {
                getResultList.add(findScore(language, table));
            }
            for(int i= 0; i < preference.length; i++) {
                getResultPre.add(Arrays.stream(getResultList.get(0))
                        .map(getResult-> getResult * preference[i])
                        .collect(ArrayList::new));
            }
            for (int i = 0; i < getResultPre.size(); i++) {
                getResultPre.get(i).
            }
            return answer;
        }

        public int[] findScore(String language, String[] table) {
            int count = 0;
            int [] getResult = new int[5];
            for (int i = 0; i < table.length; i++) {
                String[] contents = table[i].split(" ");
                for (int j = 0; j < contents.length; j++) {
                    if (language.equals(contents[j])) {
                        count = count + j;
                    }
                }
                getResult[i] = count;
            }
            return getResult;
        }
    }*/

    static class Solution {
        public static int solution(int[] priorities, int location) {
            int count = 0;
            Queue<Integer> queue = new ArrayDeque<>();
            for (int priority : priorities) {
                queue.add(priority);
            }
            for (int i = 0; i < 3; i++) {
                if (location == 0) {
                    int poll = queue.poll();
                    System.out.println(poll);
                    Stream<Integer> integerStream = queue.stream()
                            .filter(q -> q > poll);
                    if (integerStream.count() != 0) {
                        queue.remove(0);
                        queue.add(poll);
                        location = queue.size() - 1;
                    } else {
                        count = count + 1;
                        System.out.println("yes");
                        System.out.println(count);
                        return count;
                    }
                } else {
                    int poll = queue.poll();
                    System.out.println(poll);
                    System.out.println("no");
                    Stream<Integer> integerStream = queue.stream()
                            .filter(q -> q > poll);
                    if (integerStream.count() != 0) {
                        queue.remove(0);
                        queue.add(poll);
                        location = location - 1;
                    } else {
                        queue.remove(0);
                        location = location - 1;
                        count = count + 1;
                    }
                }
            }
            return 1;
        }
    }

    public static void main(String[] args) {
        int [] a = {2,1,3,2};
        int b = 2;
        System.out.println(Solution.solution(a,2));
    }
}
