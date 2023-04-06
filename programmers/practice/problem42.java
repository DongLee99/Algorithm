class Solution {
    public static int MAX = Integer.MIN_VALUE;
    public int[] solution(int brown, int yellow) {
        int size = (int) Math.sqrt(yellow);
        int answer = 0;
        for (int i = 1; i <= yellow; i++) {
            if (yellow % i == 0) {
                int x = i;
                int y = yellow / i;
                if (((x + y) * 2 + 4) == brown) {
                    if (x >= y) {
                        return new int[]{x+2, y+2};
                    }
                };
            }
        }
        return null;
    }
}
