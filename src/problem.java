import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class problem {
    static class Solution {
        static class reportName {
            private String name;
            private List<String> names = new ArrayList<>();

            public reportName(String name) {
                this.name = name;
            }

            public String getName() {
                return name;
            }

            public List<String> getNames() {
                return names;
            }

            public void setNames(String ames) {
                names.add(ames);
            }
        }

        public static int[] solution(String[] id_list, String[] report, int k) {
            List<String> idList = new ArrayList<>();
            for (String s : id_list) {
                idList.add(s);
            }
            int[] answer = new int[idList.size()];
            List<String> reports = new ArrayList<>();
            for (String s : report) {
                reports.add(s);
            }
            List<reportName> reportNames = new ArrayList<>();
            for (int i = 0; i < idList.size(); i++) {
                reportNames.add(new reportName(idList.get(i)));
            }
            reports = reports.stream()
                    .distinct().collect(Collectors.toList());
            for (int i = 0; i < reports.size(); i++) {
                String s = reports.get(i).split(" ")[1];
                String s0 = reports.get(i).split(" ")[0];
                for (int j = 0; j < idList.size(); j++) {
                    if (reportNames.get(j).name.equals(s0)) {
                        //System.out.println("report Name " + reportNames.get(j).name);
                        reportNames.get(j).setNames(s);
                        //System.out.println(s);
                        //System.out.println("reported names " + reportNames.get(j).getNames());
                        //System.out.println("------");

                    }
                }
                //System.out.println(s);
                for (int j = 0; j < idList.size(); j++) {
                    if (idList.get(j).equals(s)) {
                        //System.out.println(idList.get(j));
                        answer[j] = answer[j] + 1;
                    }
                }
            }
            int count = 0;
            //System.out.println();
            int[] answer2 = new int[idList.size()];
            for (int i = 0; i < idList.size(); i++) {
                if (answer[i] >= k) {
                    for (int j = 0; j< reportNames.size(); j ++) {
                        if (reportNames.get(j).names.contains(idList.get(i))) {
                            //System.out.println(reportNames.get(j).name);
                            answer2[j]++;
                        }
                    }
                }
            }
            return answer2;
        }
    }

    public static void main(String[] args) {
        String [] id_list = {"muzi", "frodo", "apeach", "neo"};
        String [] report = {"muzi frodo","apeach frodo","frodo neo","muzi neo","apeach muzi"};
        int k = 2;
        int [] result = Solution.solution(id_list, report, k);
        for (int i : result) {
            System.out.println(i);
        }
    }
}
