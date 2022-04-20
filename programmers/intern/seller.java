import java.util.*;
import java.util.stream.Collectors;

public class problem {

    static class Solution {
        public int[] solution(String[] enroll, String[] referral, String[] seller, int[] amount) {
            int [] answer = new int[enroll.length];

            Map<String, String> parentMap = new HashMap<>();
            Map<String, Integer> index = new HashMap<>();

            for (int i = 0; i < enroll.length; i++) {
                parentMap.put(enroll[i], referral[i]);
                index.put(enroll[i], i);
            }

            for (int i = 0; i < seller.length; i++) {
                String now = seller[i];
                int profit = amount[i] * 100;
                while(!now.equals("-")) {
                    int profitForParent = profit / 10; // 부모에게 넘겨줄 금액
                    int nowProfit = profit - profitForParent; // 자신이 가져갈 금액

                    answer[index.get(now)] += nowProfit;

                    now = parentMap.get(now);
                    profit = profitForParent;

                    if (profitForParent < 1) {
                        break;
                    }
                }
            }
            return answer;
        }
    }

    public static void main(String[] args) {
        String [] enroll = {"john", "mary", "edward", "sam", "emily", "jaimie", "tod", "young"};
        String [] referral = {"-", "-", "mary", "edward", "mary", "mary", "jaimie", "edward"};
        String [] seller = {"young", "john", "tod", "emily", "mary"};
        int [] amount = {12, 4, 2, 5, 10};

        Solution solution = new Solution();
        int[] solution1 = solution.solution(enroll, referral, seller, amount);
        for (int i : solution1) {
            System.out.println(i);
        }
    }
}