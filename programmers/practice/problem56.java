import java.util.*;

class Solution {
    public static int[][] nodes;

    public int bfs(int n, int idx) {
        boolean[] visited = new boolean[n+1];
        int count = 1;
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(idx);
        while(!queue.isEmpty()) {
            int point = queue.poll();
            visited[point] = true;
            for (int i = 1; i <= n; i++) {
                if (visited[i] == false) {
                    if (nodes[point][i] == 1) {
                        queue.add(i);
                        count++;
                    }
                }
            }
        }
        return (int)Math.abs(n-2*count);
    }
    public int solution(int n, int[][] wires) {
        nodes = new int[n+1][n+1];
        int answer = n;
        for (int i = 0; i < wires.length; i++) {
            int idx = wires[i][0];
            int next = wires[i][1];
            nodes[idx][next] = 1;
            nodes[next][idx] = 1;
        }
        int count = Integer.MAX_VALUE;

        for (int i = 0; i < wires.length; i++) {
            int idx = wires[i][0];
            int next = wires[i][1];
            nodes[idx][next] = 0;
            nodes[next][idx] = 0;
            answer = Math.min(answer, bfs(n, idx));
            nodes[idx][next] = 1;
            nodes[next][idx] = 1;
        }
        return answer;
    }
}