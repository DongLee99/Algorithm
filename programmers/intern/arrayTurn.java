import java.util.*;
import java.util.stream.Collectors;

public class problem {

    static class Solution {
        public List<Integer> result = new ArrayList<>();
        public int [][] arr;

        public int[] solution(int rows, int columns, int[][] queries) {

            arr = new int [rows+1][columns+1];
            int count = 1;
            for (int i = 1; i <= rows; i++) {
                for (int j = 1; j <= columns; j++) {
                    arr[i][j] = count++;
                }
            }

            for (int i = 0; i < queries.length; i++) {
                int x1 = queries[i][0];
                int y1 = queries[i][1];
                int x2 = queries[i][2];
                int y2 = queries[i][3];
                move(x1, y1, x2, y2);
            }
            return result.stream()
                    .mapToInt(num -> num)
                    .toArray();
        }

        public void move(int x1, int y1, int x2, int y2) {
            Queue<Integer> list = new LinkedList<>();

            int count = 0;
            for (int i = y1; i < y2; i++) {
                list.add(arr[x1][i]);
            }

            for (int i = x1; i < x2; i++) {
                list.add(arr[i][y2]);
            }

            for (int i = y2; i > y1; i--) {
                list.add(arr[x2][i]);
            }

            for (int i = x2; i > x1; i--) {
                list.add(arr[i][y1]);
            }

            int result1 = list.stream()
                    .mapToInt(x -> x)
                    .min()
                    .orElseThrow();
            result.add(result1);
            for (int i = y1 + 1; i <= y2; i++) {
                arr[x1][i] = list.poll();
            }

            for (int i = x1 + 1; i <= x2; i++) {
                arr[i][y2] = list.poll();
            }

            for (int i = y2 - 1; i >= y1; i--) {
                arr[x2][i] = list.poll();
            }

            for (int i = x2 - 1; i >= x1; i--) {
                arr[i][y1] = list.poll();
            }

        }
    }

    public static void main(String[] args) {
        int rows = 6;
        int colums = 6;
        int [][] queries = {{2,2,5,4}, {3,3,6,6}, {5,1,6,3}};

        Solution solution = new Solution();
        int[] solution1 = solution.solution(rows, colums, queries);
        for (int i : solution1) {
            System.out.println(i);
        }
    }
}