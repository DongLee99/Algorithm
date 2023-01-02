
public class main {
    static class Solution {

        public boolean [] visited;
        public void dfs(int x, int n, int [][] computers) {
            for (int i = 0; i < n; i++) {
                if (visited[i] == false && computers[x][i] == 1) {
                    visited[i] = true;
                    dfs(i, n, computers);
                }
            }
        }

        public int solution(int n, int[][] computers) {
            visited = new boolean[n];
            int count = 0;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (visited[i] == false && computers[i][j] == 1) {
                        visited[i] = true;
                        count++;
                        dfs(j,  n, computers);
                    }
                }
            }
            return count;
        }
    }

    public static void main(String[] args) {
        //int [][] computers = {{1, 1, 0}, {1, 1, 0}, {0, 1, 0}};
        int [][] computers = {{1, 1, 0}, {1, 1, 1}, {0, 1, 1}};
        Solution solution = new Solution();
        System.out.println(solution.solution(3, computers));
    }

}