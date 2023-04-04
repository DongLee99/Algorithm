class Solution {
    public static int check(int x1, int y1, int x2, int y2) {
        return (int) (Math.pow(Math.abs(x1 - x2), 2) + Math.pow(Math.abs(y2 - y1), 2));
    }

    public int[] solution(int m, int n, int startX, int startY, int[][] balls) {
        int count = 0;
        int [] answer = new int [balls.length];
        for (int i = 0; i < balls.length; i++) {
            int[] ball = balls[i];
            int MIN = Integer.MAX_VALUE;
            if (startX == ball[0] && startY < ball[1]) {
                MIN = Math.min(MIN, check(startX, startY, ball[0] + 2 * (m - ball[0]), ball[1]));
                MIN = Math.min(MIN, check(startX, startY, -1 * ball[0], ball[1]));
                MIN = Math.min(MIN, check(startX, startY, ball[0], -1 * ball[1]));
            } else if (startX == ball[0] && startY > ball[1]) {
                MIN = Math.min(MIN, check(startX, startY, ball[0] + 2 * (m - ball[0]), ball[1]));
                MIN = Math.min(MIN, check(startX, startY, ball[0], ball[1] + 2* (n - ball[1])));
                MIN = Math.min(MIN, check(startX, startY, -1 * ball[0], ball[1]));
            } else if (startY == ball[1] && startX > ball[0]) {
                MIN = Math.min(MIN, check(startX, startY, ball[0] + 2 * (m - ball[0]), ball[1]));
                MIN = Math.min(MIN, check(startX, startY, ball[0], ball[1] + 2* (n - ball[1])));
                MIN = Math.min(MIN, check(startX, startY, ball[0], -1 * ball[1]));
            } else if (startY == ball[1] && startX < ball[0]) {
                MIN = Math.min(MIN, check(startX, startY, ball[0], ball[1] + 2* (n - ball[1])));
                MIN = Math.min(MIN, check(startX, startY, -1 * ball[0], ball[1]));
                MIN = Math.min(MIN, check(startX, startY, ball[0], -1 * ball[1]));
            } else {
                MIN = Math.min(MIN, check(startX, startY, ball[0] + 2 * (m - ball[0]), ball[1]));
                MIN = Math.min(MIN, check(startX, startY, ball[0], ball[1] + 2* (n - ball[1])));
                MIN = Math.min(MIN, check(startX, startY, -1 * ball[0], ball[1]));
                MIN = Math.min(MIN, check(startX, startY, ball[0], -1 * ball[1]));
            }
            answer[count] = MIN;
            count++;

        }
        return answer;
    }
}