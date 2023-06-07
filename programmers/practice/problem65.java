class Solution {
    public String solution(String s) {
        int MAX = Integer.MIN_VALUE;
        int MIN = Integer.MAX_VALUE;
        String[] split = s.split(" ");
        for (String str : split) {
            int tmp = Integer.parseInt(str);
            MAX = Math.max(tmp, MAX);
            MIN = Math.min(tmp, MIN);
        }
        return String.valueOf(MIN) + " " + String.valueOf(MAX);
    }
}