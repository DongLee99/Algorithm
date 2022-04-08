import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class problem {

    static class Solution {

        static int N;
        static int target;
        static int result = 0;
        static boolean [] visit;

        public void dfs(int [] numbers, int count, int depth) {

            if (depth == N) {
                if (count == target) {
                    result++;
                    return;
                }
                return;
            }

            dfs(numbers ,count + numbers[depth], depth + 1);
            dfs(numbers ,count - numbers[depth], depth + 1);

        }

        public int solution(int [] numbers, int target) {
            N = numbers.length;
            this.target = target;
            visit = new boolean[N];
            dfs(numbers, 0, 0);
            return result;
        }

    }
    public static void main(String[] args) {
        int [] numbers = {4,1,2,1};
        int target = 4;
        Solution solution = new Solution();
        System.out.println(solution.solution(numbers, target));
    }
}