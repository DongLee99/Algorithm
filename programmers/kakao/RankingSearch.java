package programmers.kakao;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class RankingSearch {
    static class Solution {
        public int[] solution(String[] info, String[] query) {
            List<String> infos = Arrays.stream(info)
                    .collect(Collectors.toList());
            List<String> queries = Arrays.stream(query)
                    .collect(Collectors.toList());
            List<Integer> result = new ArrayList<>();
            int [] answer = new int [6];
            boolean check = true;
            int count = 0;
            for (int i = 0; i < queries.size(); i++) {
                List<String> splitQuery = Arrays.stream(queries.get(i).split(" "))
                        .collect(Collectors.toList());
                for (int t = 0; t < splitQuery.size(); t++) {
                    if (splitQuery.get(t).equals("and")) {
                        splitQuery.remove(t);
                    }
                }
                for (int k = 0; k < 6; k++) {
                    if (splitQuery.equals("-")) {
                        continue;
                    } else {
                        result.add(k);
                    }
                }
                for (int j = 0; j < infos.size(); j++) {

                    for (Integer integer : result) {
                        if (integer == 5) {
                            String[] spliteinfos = infos.get(i).split(" ");
                            int a = Integer.parseInt(spliteinfos[integer]);
                            int b = Integer.parseInt(splitQuery.get(integer));
                            System.out.println(a);
                            if (a >= b) {
                                System.out.println(a);
                                continue;
                            } else {
                                check = false;
                                break;
                            }
                        }
                        else if (infos.get(i).contains(splitQuery.get(integer))) {
                            System.out.println(splitQuery.get(integer));
                            System.out.println(infos.get(i));
                            continue;
                        } else {
                            check = false;
                            break;
                        }
                    }
                    if (check == true) {
                        count++;
                    }
                }
                answer[i] =count;
                System.out.println(count);
                count = 0;
            }

            return answer;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        String [] info = {"java backend junior pizza 150","python frontend senior chicken 210","python frontend senior chicken 150","cpp backend senior pizza 260","java backend junior chicken 80","python backend senior chicken 50"};
        String [] query = {"java and backend and junior and pizza 100","python and frontend and senior and chicken 200","cpp and - and senior and pizza 250","- and backend and senior and - 150","- and - and - and chicken 100","- and - and - and - 150"};
        solution.solution(info, query);
    }
}