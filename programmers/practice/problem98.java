class Solution {

    public static int[][] arr;
    public static boolean[] visited;

    public static void dfs(int n, int[][] computers, int start) {
        for (int i = 0; i < computers.length; i++) {
            if (visited[i] == false && computers[start][i] == 1) {
                visited[i] = true;
                dfs(n, computers, i);

            }
        }
    }
    public int solution(int n, int[][] computers) {
        visited = new boolean[n];
        int count = 0;
        for (int i = 0; i < n; i++) {
            if (visited[i] == false) {
                dfs(n, computers, i);
                count++;
            }
        }

        return count;
    }
}