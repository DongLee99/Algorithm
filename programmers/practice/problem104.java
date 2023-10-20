import java.util.*;

public class Main {
    public static class Solution {
        public static class Node implements Comparable<Node> {
            int startTime;
            int finishTime;

            public Node(int startTime, int finishTime) {
                this.startTime = startTime;
                this.finishTime = finishTime;
            }

            @Override
            public int compareTo(Node o) {

                return this.finishTime - o.finishTime;
            }
        }
        public static int solution(int N, int[][] simulation_data) {
            int nowTime = simulation_data[0][0];
            int nowN = 1;
            int nowCount = 1;
            PriorityQueue<Node> pq = new PriorityQueue<>();
            pq.add(new Node(simulation_data[0][0], simulation_data[0][1] + simulation_data[0][0]));
            int answer = 0;
            while (nowCount != simulation_data.length) {
                nowTime++;
                if (pq.peek().finishTime <= nowTime) {
                    pq.poll();
                    nowN--;
                }
                if (simulation_data[nowCount][0] <= nowTime) {
                    if (nowN < N) {
                        answer = answer + nowTime - simulation_data[nowCount][0];
                        pq.add(new Node(simulation_data[nowCount][0], simulation_data[nowCount][1] + nowTime));
                        nowN++;
                        nowCount++;
                    }
                }

            }
            return answer;
        }
    }
    public static void main(String[] args) {
        int N = 2;
        int[][] simulation_data = {{0, 3}, {2, 5}, {4, 2}, {5, 3}};
        int N1 = 1;
        int[][] simulation_data1 = {{2, 3}, {5, 4}, {6, 3}, {7, 4}};

        System.out.println(Solution.solution(N, simulation_data));
    }
}