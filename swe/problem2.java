import java.util.*;

class main {
    static class Solution {
        public static int [] tmpLines;
        public static boolean [] visitedLine;
        public static int [] dotsInput;
        public static boolean [] dotsVisited;
        public static boolean checkResult = false;
        public static boolean check(int [] tmpLines, int depth) {
            dotsVisited = new boolean[dotsInput[dotsInput.length-1]+1];
            int count = 0;
            for (int i = dotsInput[0]; i <= dotsInput[dotsInput.length-1]; i++) {
                if (count >= depth) {
                    return false;
                }
                int start = i;
                int end = tmpLines[count] + i;
                if (end > dotsInput[dotsInput.length-1]) {
                    end = dotsInput[dotsInput.length-1];
                }
                count++;
                for (int j = start; j <= end; j++) {
                    dotsVisited[j] = true;
                }
                i = end;
            }
            for (int i = 0; i < dotsInput.length; i++) {
                if (dotsVisited[dotsInput[i]] == false) {
                    return false;
                }
            }
            return true;
        }

        public static void makeLines(int depth, int size, int [] lines) {
            if (depth == tmpLines.length) {
                if (check(tmpLines, depth)) {
                    checkResult = true;
                }
                return;
            }
            for (int i = 0; i < size; i++) {
                visitedLine[i] = true;
                tmpLines[depth] = lines[i];
                makeLines(depth+1, size, lines);
                visitedLine[i] = false;
            }
        }
        public int solution(int[] dots, int[] lines) {
            dotsInput = dots;
            visitedLine = new boolean[lines.length];
            for (int i = 0; i <= lines.length; i++) {
                tmpLines = new int[i];
                makeLines(0, lines.length, lines);
                if (checkResult) {
                    return i;
                }
            }
            return -1;
        }
    }
    public static void main(String[] args) {
        int [] dots = {1, 3, 4, 6, 7, 10};
        int [] lines = {2, 2, 2, 2};
        Solution solution = new Solution();
        int solution1 = solution.solution(dots, lines);
        System.out.println(solution1);
    }
}
