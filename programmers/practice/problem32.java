import java.util.*;
class Solution {

    public static class Node implements Comparable<Node>{
        int d;
        int i;
        int s;

        public Node(int d, int i, int s) {
            this.d = d;
            this.i = i;
            this.s = s;
        }

        @Override
        public int compareTo(Node o) {
            if (this.d > o.d) {
                return -1;
            } else if (this.d < o.d) {
                return 1;
            } else {
                if (this.i > o.i) {
                    return -1;
                } else if (this.i < o.i) {
                    return 1;
                } else {
                    if (this.s > o.s) {
                        return -1;
                    } else {
                        return 1;
                    }
                }
            }
        }
    }
    public int solution(int[] picks, String[] minerals) {
        int n = 0;
        List<Node> nodes = new ArrayList<>();
        int share = minerals.length/ 5;
        int extra = minerals.length % 5;
        int aCount = 0;
        System.out.println(share);
        n = picks[0] + picks[1] + picks[2];
        if (extra != 0) {
            aCount = share + 1;
        } else {
            aCount = share;
        }
        if (share <= n) {
            for (int i = 0; i < share; i++) {
                int dCount = 0;
                int iCount = 0;
                int sCount = 0;
                for (int j = i * 5; j < i * 5 + 5; j++) {
                    if (minerals[j].equals("diamond")) {
                        dCount++;
                    } else if (minerals[j].equals("iron")) {
                        iCount++;
                    } else {
                        sCount++;
                    }
                }
                System.out.println(dCount + " " + iCount + " " + sCount);
                nodes.add(new Node(dCount, iCount, sCount));
            }
            int dCount = 0;
            int iCount = 0;
            int sCount = 0;
            for (int i = 0; i < extra; i++) {
                if (minerals[i + (share * 5)].equals("diamond")) {
                    dCount++;
                } else if (minerals[i + (share * 5)].equals("iron")) {
                    iCount++;
                } else {
                    sCount++;
                }
            }
            nodes.add(new Node(dCount, iCount, sCount));
        } else {
            for (int i = 0; i < n; i++) {
                int dCount = 0;
                int iCount = 0;
                int sCount = 0;
                for (int j = i * 5; j < i * 5 + 5; j++) {
                    if (minerals[j].equals("diamond")) {
                        dCount++;
                    } else if (minerals[j].equals("iron")) {
                        iCount++;
                    } else {
                        sCount++;
                    }
                }
                System.out.println(dCount + " " + iCount + " " + sCount);
                nodes.add(new Node(dCount, iCount, sCount));
            }
        }

        Collections.sort(nodes);
        int lCount = 0;
        int answer = 0;
        for (int i = 0; i < 3; i++) {
            while (picks[i] > 0) {
                if (lCount < nodes.size()) {
                    if (i == 0) {
                        answer = answer + nodes.get(lCount).d + nodes.get(lCount).i + nodes.get(lCount).s;
                    } else if (i == 1) {
                        answer = answer + (5 * nodes.get(lCount).d) + nodes.get(lCount).i + nodes.get(lCount).s;
                    } else {
                        answer = answer + (25 * nodes.get(lCount).d) + (5 * nodes.get(lCount).i) + nodes.get(lCount).s;
                    }
                    lCount++;
                    picks[i]--;
                } else {
                    break;
                }
            }
        }

        return answer;
    }
}