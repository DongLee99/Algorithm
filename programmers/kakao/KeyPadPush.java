package programmers.kakao;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class KeyPadPush {

    
    static class Solution {
        public static final int [][] KEYPAD = {{1,2,3},{4,5,6},{7,8,9},{10,0,11}};
        public Stack<Integer> rightHand = new Stack<>();
        public Stack<Integer> leftHand = new Stack<>();
        public String answer = "";
        int temp = 0;


        public int[] find(int temp) {
            int [] result = new int [2];
            for (int i = 0; i <4; i++) {
                for (int j = 0; j <3; j ++) {
                    if (KEYPAD[i][j] == temp) {
                        result[0] = i;
                        result[1] = j;
                        break;
                    }
                }
            }
            return result;
        }

        public String solution(int[] numbers, String hand) {
            rightHand.push(11);
            leftHand.push(10);
            int [] value1 = new int [2];
            int [] value2 = new int [2];
            int leftResult = 0;
            int rightResult = 0;
            for (int number : numbers) {
                if ( number == 1 || number == 4 || number == 7 ) {
                    leftHand.push(number);
                    answer = answer + "L";
                }
                else if ( number == 3 || number == 6 || number == 9 ) {
                    rightHand.push(number);
                    answer = answer + "R";
                } else {
                    temp = leftHand.peek();
                    value1 = find(number);
                    value2 = find(temp);
                    leftResult = Math.abs(value1[0] - value2[0]) + Math.abs(value1[1] - value2[1]);
                    temp = rightHand.peek();
                    value2 = find(temp);
                    rightResult = Math.abs(value1[0] - value2[0]) + Math.abs(value1[1] - value2[1]);
                    if (leftResult > rightResult) {
                        rightHand.push(number);
                        answer = answer + "R";
                    } else if ( rightResult > leftResult) {
                        leftHand.push(number);
                        answer = answer + "L";
                    } else {
                        if (hand.equals("right")) {
                            rightHand.push(number);
                            answer = answer + "R";
                        } else {
                            leftHand.push(number);
                            answer = answer + "L";
                        }
                    }
                }

            }
            return answer;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int [] a = {7, 0, 8, 2, 8, 3, 1, 5, 7, 6, 2};
        System.out.println(solution.solution(a, "left"));
    }
}
