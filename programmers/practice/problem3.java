class Solution {
    public int solution(String s) {
        int totalSize = s.length();
        int sameSize = 0;
        int defaultSize = 0;
        boolean reset = true;
        String tmp = "";
        int count = 0;
        if (totalSize == 1) {
            return 1;
        }
        for (int i = 0; i < totalSize; i++) {
            if (reset == true) {
                tmp = String.valueOf(s.charAt(i));
                sameSize++;
                reset = false;
            } else {
                if (tmp.equals(String.valueOf(s.charAt(i)))) {
                    sameSize++;
                } else {
                    defaultSize++;
                }
                if (sameSize == defaultSize) {
                    reset = true;
                    sameSize = 0;
                    defaultSize = 0;
                    count++;
                }
            }

        }
        if (sameSize != 0 || defaultSize != 0) {
            count++;
        }
        return count;
    }
}