import java.util.*;
import java.util.stream.Collectors;

public class problem {

    static class Solution {
        public int[] solution(String[] id_list, String[] report, int k) {
            HashMap<String, Integer> id_map = new HashMap<>();
            HashMap<String, Integer> id_index = new HashMap<>();
            HashMap<String, String> id_report = new HashMap<>();
            int [] result = new int[id_list.length];
            int [] answer = new int[id_list.length];

            int i = 0;
            for (String s : id_list) {
                id_map.put(s, 0);
                id_index.put(s, i);
                id_report.put(s, "");
                i++;
            }

            String [] report_di = Arrays.stream(report)
                    .distinct()
                    .toArray(String[]::new);

            for (String s : report_di) {
                String[] s1 = s.split(" ");
                id_map.replace(s1[1], id_map.get(s1[1]) + 1);
                id_report.replace(s1[0], id_report.get(s1[0]) + " " + s1[1]);
            }
            int j = 0;

            for (String s : id_list) {
                if (id_map.get(s) >= k) {
                    result[j] = 1;
                } else {
                    result[j] = 0;
                }
                j++;
            }

            for (String s : report_di) {
                String[] s1 = s.split(" ");
                if (result[id_index.get(s1[1])] == 1) {
                    answer[id_index.get(s1[0])]++;
                }
            }
            return answer;
        }
    }

    public static void main(String[] args) {
        String [] id_list = {"muzi", "frodo", "apeach", "neo"};
        String [] report = {"muzi frodo","apeach frodo","frodo neo","muzi neo","apeach muzi"};
        int k = 2;

        Solution solution = new Solution();
        int[] solution1 = solution.solution(id_list, report, k);
        for (int i : solution1) {
            System.out.println(i);
        }
    }
}