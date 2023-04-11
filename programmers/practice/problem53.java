import java.util.*;

class Solution {
    public int[] solution(String[] wallpaper) {
        int startX = Integer.MAX_VALUE;
        int startY = Integer.MAX_VALUE;
        int finishX = Integer.MIN_VALUE;
        int finishY = Integer.MIN_VALUE;
        for (int i = 0; i < wallpaper.length; i++) {
            for (int j = 0; j < wallpaper[i].length(); j++) {
                if (wallpaper[i].charAt(j) == '#') {
                    startX = Math.min(startX, i);
                    startY = Math.min(startY, j);
                    finishX = Math.max(finishX, i);
                    finishY = Math.max(finishY, j);
                }
            }
        }
        return new int[] {startX, startY, finishX+1, finishY+1};
    }
}
