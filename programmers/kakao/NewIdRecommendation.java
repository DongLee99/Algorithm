package programmers.kakao;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Stack;
import java.util.stream.Collectors;

public class NewIdRecommendation {
    /** Id 3 ~ 15
     아이디는 알파벳 소문자, 숫자, 빼기(-), 밑줄(_), 마침표(.) 문자만 사용할 수 있습니다.
     단, 마침표(.)는 처음과 끝에 사용할 수 없으며 또한 연속으로 사용할 수 없습니다.
     **/
    static class Validation {
        public Validation() {};

        public String FirstStep(String new_id) {
            return new_id.toLowerCase();
        }

        public String SecondStep(String new_id) {
            String idTemp = new_id;
            idTemp = idTemp.replace('-',' ');
            idTemp = idTemp.replace('_',' ');
            idTemp = idTemp.replace('.',' ');
            idTemp = idTemp.replaceAll("[a-z]", " ");
            idTemp = idTemp.replaceAll("[0-9]", " ");
            for (int i = 0; i < idTemp.length(); i++) {
                new_id = new_id.replace(idTemp.charAt(i), ' ');
            }
            new_id = new_id.replaceAll(" ", "");
            return new_id;
        }

        public String ThirdStep(String new_id) {
            char[] idTemps = new_id.toCharArray();
            for (int i = 0; i < idTemps.length; i++){
                if (idTemps[i] == '.') {
                    for (int j = i+1; j <idTemps.length; j++) {
                        if (idTemps[j] == '.') {
                            idTemps[j] = ' ';
                            continue;
                        } else {
                            i = j;
                            break;
                        }
                    }
                }
            }
            String validateId="";
            for (char idTemp : idTemps) {
                if (!(idTemp == ' ')){
                    validateId = validateId+ idTemp;
                }
            }
            return validateId;
        }
        public String FourthStep(String new_id) {
            if (new_id.charAt(0) == '.') {
                new_id = new_id.substring(1);
            }
            if (new_id.charAt(new_id.length()-1)=='.'){
                new_id = new_id.substring(0,new_id.length()-1);
            }
            return new_id;
        }

        public String FifthStep(String new_id) {
            if (new_id.isEmpty()) {
                new_id = new_id + "a";
            }
            return new_id;
        }

        public String SixthStep(String new_id) {
            if (new_id.length() > 15) {
                if (new_id.charAt(14) == '.') {
                    new_id = new_id.substring(0,new_id.length()-1);
                    return new_id;
                } else {
                    return new_id.substring(0, 15);
                }
            } else {
                return new_id;
            }
        }

        public String SeventhStep(String new_id) {
            if (new_id.length() <= 2) {
                while (new_id.length() < 3) {
                    new_id = new_id + new_id.charAt(new_id.length() - 1);
                }
            }
            return new_id;
        }

    }
    static class Solution {

        public Solution() {};
        public String solution(String new_id) {
            Validation validation = new Validation();
            String answer;
            answer = validation.FirstStep(new_id);
            answer = validation.SecondStep(answer);
            answer = validation.ThirdStep(answer);
            answer = validation.FourthStep(answer);
            answer = validation.FifthStep(answer);
            answer = validation.SixthStep(answer);
            answer = validation.SeventhStep(answer);
            return answer;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.solution("abcdefghijklnmoptqrsvwxyz"));
    }
}
