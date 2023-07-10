import java.util.*;
class Solution {
    public int solution(String str1, String str2) {
        List<String> set1 = new ArrayList<>();
        List<String> set2 = new ArrayList<>();
        List<String> union = new ArrayList<>();
        List<String> intersection = new ArrayList<>();
        String firstSet = str1.toLowerCase();
        String secondSet = str2.toLowerCase();
        for (int i = 0; i < firstSet.length() - 1; i++) {
            char first = firstSet.charAt(i);
            char second = firstSet.charAt(i+1);
            if (first >= 'a' && first <= 'z' && second >= 'a' && second <= 'z') {
                set1.add(first + "" + second);
            }
        }

        for (int i = 0; i < secondSet.length() - 1; i++) {
            char first = secondSet.charAt(i);
            char second = secondSet.charAt(i+1);
            if (first >= 'a' && first <= 'z' && second >= 'a' && second <= 'z') {
                set2.add(first + "" + second);
            }
        }
        Collections.sort(set1);
        Collections.sort(set2);
        for (String s : set1) {
            if (set2.remove(s)) {
                intersection.add(s);
            }
            union.add(s);
        }
        for (String s : set2) {
            union.add(s);
        }
        double result = 0;
        if (union.size() == 0) {
            result = 1;
        } else {
            result = (double) intersection.size() / (double) union.size();
        }
        return (int) (result * 65536);
    }
}