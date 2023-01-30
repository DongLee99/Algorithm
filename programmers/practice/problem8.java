import java.util.*;
import java.lang.*;

class Solution {
    public int solution(String dartResult) {
        List<String> dartList = new ArrayList<>();
        String tmp = "";
        boolean optionC = false;
        for (int i = 0; i < dartResult.length(); i++) {
            String now = String.valueOf(dartResult.charAt(i));
            if (optionC == true) {
                if (now.equals("*") || now.equals("#")) {
                    tmp = tmp + now;
                    dartList.add(tmp);
                    tmp = "";
                    optionC = false;
                }
            }
            if ((int) dartResult.charAt(i) >= 48 && (int) dartResult.charAt(i) <= 57) {
                if (optionC == true) {
                    dartList.add(tmp);
                    tmp = "";
                    optionC = false;
                }
                tmp = tmp + String.valueOf(dartResult.charAt(i));
            }
            else if (now.equals("S") || now.equals("D") || now.equals("T") ) {
                tmp = tmp + now;
                optionC = true;
                if (i == dartResult.length() -1) {
                    dartList.add(tmp);
                    tmp = "";
                }
            }
        }
        int [] resultList = new int [dartList.size()];
        for (int i = 0; i < dartList.size(); i++) {
            String dart = dartList.get(i);
            int a = 0;
            String tmpNumber = "";
            int tmpResult = 0;
            for (int j = 0; j < dart.length(); j++) {
                String now = String.valueOf(dart.charAt(j));
                if ((int) dart.charAt(j) >= 48 && (int) dart.charAt(j) <= 57) {
                    tmpNumber = tmpNumber + now;
                } else if (now.equals("S")) {
                    a = Integer.parseInt(tmpNumber);
                    tmpResult = (int) Math.pow(a, 1);
                } else if (now.equals("D")) {
                    a = Integer.parseInt(tmpNumber);
                    tmpResult = (int) Math.pow(a, 2);
                } else if (now.equals("T")) {
                    a = Integer.parseInt(tmpNumber);
                    tmpResult = (int) Math.pow(a, 3);
                } else if (now.equals("*")) {
                    if (i != 0) {
                        resultList[i-1] = resultList[i-1] * 2;
                        tmpResult = tmpResult * 2;
                    } else {
                        tmpResult = tmpResult * 2;
                    }
                } else {
                    tmpResult = tmpResult * -1;
                }
                if (dart.length() == 2) {
                    if (j == 1) {
                        resultList[i] = tmpResult;
                    }
                }
                if (dart.length() == 3) {
                    if (j == 2) {
                        resultList[i] = tmpResult;
                    }
                }
                if (dart.length() == 4) {
                    if (j == 3) {
                        resultList[i] = tmpResult;
                    }
                }
            }
        }
        int result = 0;
        for (int i = 0; i < resultList.length; i++) {
            System.out.println(resultList[i]);
            result = resultList[i] + result;
        }
        return result;
    }
    // S 1 D 2 T 3
    // * (전 점수, 이번 점수 2배) # 해당 점수 -
    // * * = 4배 * # -2배
}