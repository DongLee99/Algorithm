class Solution {
    public String solution(String s, String skip, int index) {
        int [] tmp = new int [26];
        int [] result = new int[s.length()];
        for (int i = 0; i < skip.length(); i++) {
            tmp[(int)skip.charAt(i) - 97] = 1;
        }

        for (int i = 0; i < s.length(); i++) {
            int count = 0;
            int n = (int) s.charAt(i) - 97;
            while (count != index) {
                //System.out.println(n);
                if (n + 1 == 26) {
                    if (tmp[0] == 0) {
                        count++;
                        n = 0;
                    } else {
                        n = 0;
                    }
                } else if (tmp[n + 1] == 0 && n + 1 < 26) {
                    count++;
                    n++;
                } else {
                    n++;
                }
            }
            result[i] = n;
        }
        String answer = "";
        for (int i = 0; i < s.length(); i++) {
            // System.out.println(result[i] + 97);
            answer = answer + String.valueOf((char) (result[i] + 97));
        }
        return answer;
    }
    // a = 97
    // z = 123
}