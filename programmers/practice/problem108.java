import java.util.*;

class Solution {
    public int[][] solution(int[][] data, String ext, int val_ext, String sort_by) {
        HashMap<String, Integer> map = new HashMap<>();
        map.put("code", 0);
        map.put("date", 1);
        map.put("maximum", 2);
        map.put("remain", 3);

        int index = map.get(ext);
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < data.length; i++) {
            if (data[i][index] < val_ext) {
                list.add(i);
            }
        }
        int[][] tmp = new int[list.size()][data[0].length];
        for (int i = 0; i < list.size(); i++) {
            for (int j = 0; j < data[0].length; j++) {
                tmp[i][j] = data[list.get(i)][j];
            }
        }
        int sortIndex = map.get(sort_by);
        Arrays.sort(tmp, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[sortIndex]-o2[sortIndex];
            }
        });
        return tmp;
    }
}