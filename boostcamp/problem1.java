import java.io.*;
import java.util.List;
import java.util.StringTokenizer;

public class main {
    public static class Solution {

        public int[] solution(String word) {
            String[][] arr = {{"가", "호", "저", "론", "남", "드", "부", "이", "프", "설"},
                    {"알", "크", "청", "울", "키", "초", "트", "을", "배", "주"},
                    {"개", "캠", "산", "대", "단", "지", "역", "구", "너", "양"},
                    {"라", "로", "권", "교", "마", "쿼", "파", "송", "차", "타"},
                    {"코", "불", "레", "뉴", " ", "서", "한", "산", "리", "개"},
                    {"터", "강", "봄", "토", "캠", "상", "호", "론", "운", "상"},
                    {"보", "람", "이", "경", "아", "두", "프", "바", "트", "정"},
                    {"스", "웨", "어", "쿼", "일", "소", "라", "가", "나", "도"},
                    {"판", "자", "비", "우", "사", "거", "왕", "태", "요", "풍"},
                    {"안", "배", "차", "캐", "민", "광", "재", "봇", "북", "하"}};

            int N = word.length();
            int sum = 0;
            int startX = 0;
            int startY = 0;
            int count = 0;
            boolean before = false;
            for (int i = 0; i < N; i++) {
                int distance = Integer.MAX_VALUE;
                boolean result = false;
                int x = 0;
                int y = 0;
                if (before == false) {
                    for (int j = 0; j < arr.length; j++) {
                        for (int k = 0; k < arr[j].length; k++) {
                            if (String.valueOf(word.charAt(i)).equals(arr[j][k])) {
                                result = true;
                                startX = j;
                                startY = k;
                                break;
                            }
                        }
                    }
                    if (result == true) {
                        before = true;
                        continue;
                    } else {
                        System.out.println("없음");
                        if (i == 0) {
                            continue;
                        } else {
                            count++;
                            sum += 20;
                        }
                    }
                } else {
                    for (int j = 0; j < arr.length; j++) {
                        for (int k = 0; k < arr[j].length; k++) {
                            if (String.valueOf(word.charAt(i)).equals(arr[j][k])) {
                                result = true;
                                int toChar = Math.abs(startX - j) + Math.abs(startY - k);
                                if (distance > toChar) {
                                    x = j;
                                    y = k;
                                    System.out.println(arr[j][k]);
                                    System.out.println(j + " " + k);
                                    System.out.println("값" + toChar);
                                    distance = toChar;
                                }
                            }
                        }
                    }
                    startX = x;
                    startY = y;
                    if (result == true) {
                        sum += distance;
                        count++;
                    } else {
                        System.out.println("없음");
                        sum += 20;
                        before = false;
                        count++;
                    }
                }
            }
            return new int[]{sum, count};
        }
    }

    public static void main(String[] args) {
        String s = "부슈트캠프";
        Solution solution = new Solution();
        int[] solution1 = solution.solution(s);
        System.out.println(solution1[0] + " " + solution1[1]);
    }
}