class Solution {
    public int solution(String t, String p) {
        long totalSize = t.length();
        int size = p.length();
        int count = 0;
        for (int i = 0; i <= (totalSize - size); i++) {
            long tmpI = Long.parseLong(t.substring(i, i + size));
            long sP = Long.parseLong(p);
            if (sP >= tmpI) {
                count++;
            }
        }
        return count;
    }
}