class Solution {
    public String solution(String s) {
        String[] splitS = s.split(" ");
        int index = 0;
        for (String value : splitS) {
            splitS[index] = value.substring(0, 1).toUpperCase() + value.substring(1, value.length()).toLowerCase();
            index++;
        }
        String answer = "";
        for (int i = 0; i < splitS.length; i++) {
            if (i != splitS.length -1) {
                answer = answer + splitS[i] + " ";
            } else {
                answer = answer + splitS[i];
            }
        }

        return answer;
    }
}