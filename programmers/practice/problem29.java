import java.util.*;

class Solution {
    public double[] solution(int k, int[][] ranges) {
        int tmp = k;
        List<Integer> list = new ArrayList<>();
        int count = 0;
        List<Double> areaList = new ArrayList<>();
        list.add(tmp);
        while (tmp != 1) {
            count++;
            if (tmp % 2 == 0) {
                tmp = tmp / 2;
                list.add(tmp);
            } else if (tmp % 2 == 1) {
                tmp = tmp * 3 + 1;
                list.add(tmp);
            }
            double area = (double) Math.max(tmp, list.get(count-1)) - ((double) Math.abs((list.get(count) - list.get(count - 1)))/2);

            areaList.add(area);
        }
        double[] answer = new double[ranges.length];
        for (int i = 0; i < ranges.length; i++) {
            int start = ranges[i][0];
            int end = list.size() - 1 + ranges[i][1];

            if (end < start) {
                answer[i] = (double) -1;
                continue;
            }
            double result = 0;
            for (int j = start; j < end; j++) {
                result = result + areaList.get(j);
            }
            answer[i] = result;
        }

        return answer;
    }
}