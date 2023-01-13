
import java.lang.reflect.Array;
import java.text.ParseException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.stream.Collectors;

public class main {
    public static class Solution {
        public int[] solution(String today, String[] terms, String[] privacies) throws ParseException {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy.MM.dd");
            LocalDate localDate = LocalDate.parse(today, formatter);
            HashMap<String, Integer> map = new HashMap<>();
            for (String term : terms) {
                String[] s = term.split(" ");
                map.put(s[0], Integer.parseInt(s[1]));
            }
            int count = 1;
            List<Integer> answer = new ArrayList<>();
            for (String privacy : privacies) {

                String[] s = privacy.split(" ");
                String getDate = s[0];
                Integer integer = map.get(s[1]);
                LocalDate getLocalDate = LocalDate.parse(getDate, formatter);
                if (getLocalDate.plusMonths(integer).isBefore(localDate) || getLocalDate.plusMonths(integer).isEqual(localDate)) {
                    answer.add(count);
                }
                count++;
            }
            int [] result = new int[answer.size()];
            int count2 = 0;
            for (Integer integer : answer) {
                result[count2] = integer;
                count2++;
            }
            return result;
        }
    }
    public static void main(String[] args) {
        String today = "2022.05.13";
        String[] terms = {"A 6"};
        String[] privacies = {" "};
        Solution solution = new Solution();
        solution.solution(today, terms, privacies);
    }
}