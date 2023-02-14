class Solution {

    public int solution(int storey) {
        int answer = 0;

        String stVal = String.valueOf(storey);
        char[] chars = stVal.toCharArray();
        int[] ints = new int[chars.length];
        for (int i = 0; i < chars.length; i++) {
            ints[i] = chars[i] - '0';
        }
        for (int i = ints.length - 1; i >= 0; i--) {
            int ants = ints[i];

            if (ants == 10) {
                if (i - 1 < 0) {
                    answer = answer + 1;
                    continue;
                }
                ints[i - 1]++;
                continue;
            }

            if (ants >= 6) {
                answer = answer + (10 - ants);
                if (i - 1 < 0) {
                    answer = answer + 1;
                    continue;
                }
                ints[i - 1]++;
            } else if (ants <= 4) {
                answer = answer + ants;
            } else if (ants == 5) {
                if (i - 1 < 0) {
                    answer = answer + 5;
                    continue;
                } else {
                    if (ints[i - 1] < 5) {
                        answer += ants;
                    } else {
                        answer += 5;
                        ints[i - 1]++;
                    }
                }
            }
        }
        return answer;
    }
}