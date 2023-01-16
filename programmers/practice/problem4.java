import java.util.HashMap;

class Solution {
    public String solution(String[] survey, int[] choices) {
        HashMap<String, Integer> map = new HashMap<>();
        map.put("R", 0);
        map.put("T", 0);
        map.put("C", 0);
        map.put("F", 0);
        map.put("J", 0);
        map.put("M", 0);
        map.put("A", 0);
        map.put("N", 0);

        for (int i = 0; i < survey.length; i++) {
            String question = survey[i];
            String left = String.valueOf(question.charAt(0));
            String right = String.valueOf(question.charAt(1));
            int answer = choices[i];
            if (answer == 1) {
                map.replace(left, map.get(left) + 3);
            } else if (answer == 2) {
                map.replace(left, map.get(left) + 2);
            } else if (answer == 3) {
                map.replace(left, map.get(left) + 1);
            } else if (answer == 5) {
                map.replace(right, map.get(right) + 1);
            } else if (answer == 6) {
                map.replace(right, map.get(right) + 2);
            } else if (answer == 7) {
                map.replace(right, map.get(right) + 3);
            }
        }
        String result = "";
        if (map.get("R") >= map.get("T")) {
            result = result + "R";
        } else {
            result = result + "T";
        }

        if (map.get("C") >= map.get("F")) {
            result = result + "C";
        } else {
            result = result + "F";
        }

        if (map.get("J") >= map.get("M")) {
            result = result + "J";
        } else {
            result = result + "M";
        }

        if (map.get("A") >= map.get("N")) {
            result = result + "A";
        } else {
            result = result + "N";
        }
        return result;
    }
}