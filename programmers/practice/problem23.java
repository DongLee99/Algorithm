class Solution {



    public String solution(String[] cards1, String[] cards2, String[] goal) {
        int size = goal.length;
        int count1 = 0;
        int count2 = 0;
        boolean check = false;
        for (int i = 0; i < size; i++) {
            String tmp = goal[i];
            check = false;
            if (count1 < cards1.length) {
                if (tmp.equals(cards1[count1])) {
                    count1++;
                    check = true;
                }
            }
            if (count2 < cards2.length) {
                if (tmp.equals(cards2[count2])) {
                    count2++;
                    check = true;
                }
            }
            if (check == false) {
                return "No";
            }
        }
        return "Yes";
    }
}