import java.util.*;
import java.lang.*;

class Solution {
    class Stage implements Comparable<Stage> {
        public int n;
        public double value;

        public Stage(int n, double value) {
            this.n = n;
            this.value = value;
        }

        @Override
        public int compareTo(Stage o1) {
            if (this.value > o1.value) {
                return -1;
            } else if (this.value == o1.value) {
                return 0;
            } else {
                return 1;
            }
        }
    }
    public int[] solution(int N, int[] stages) {
        int size = stages.length;

        List<Stage> result = new ArrayList<>();
        for (int i = 1; i <= N; i++) {
            int count = 0;
            for (int stage : stages) {
                if (stage == i) {
                    count++;
                }
            }
            double value = 0;
            if (count == 0 || size == 0) {
                value = 0;
            } else {
                value = (double) count / (double) size;
                size = size - count;
            }

            result.add(new Stage(i, value));
        }
        for (Stage stage : result) {

        }
        Collections.sort(result);
        int [] answer = new int [result.size()];
        for (int i = 0; i < result.size(); i++) {
            answer[i] = result.get(i).n;
        }
        return answer;
    }
    // 아직 클리어하지 못한 플레이어의 수 / 스테이지에 도달한 플레이어 수
    // 전체 스테이지 수 N 1 ~ 500
    // stages 길이 = 1 ~ N + 1 이하
    // 실패율 동일 = 작은 번호의 스테이지가 먼저
}

