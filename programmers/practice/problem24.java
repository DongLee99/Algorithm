import java.util.*;

class Solution {

    public static boolean findD(int [] arr, int n) {
        int count = 0;
        boolean result = false;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] % n == 0) {
                result = true;
            } else {
                result = false;
                break;
            }
        }
        return result;
        // 모두 나눠질때
    }

    public static boolean findND(int [] arr, int n) {
        int count = 0;
        boolean result = false;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] % n != 0) {
                result = true;
            } else {
                result = false;
                break;
            }
        }
        return result;
        //모두 안 나눠질때
    }

    public int solution(int[] arrayA, int[] arrayB) {
        Arrays.sort(arrayA);
        Arrays.sort(arrayB);
        Set<Integer> set = new HashSet<>();
        for(int i = 2; i <= arrayA[0]; i++) {
            if(arrayA[0] % i == 0) set.add(i);
        }
        for(int i = 2; i <= arrayB[0]; i++) {
            if(arrayB[0] % i == 0) set.add(i);
        }
        List<Integer> list = new ArrayList<>(set);
        int answer = 0;
        for (int i = 0; i < list.size(); i++) {
            boolean result1 = findD(arrayA, list.get(i));
            boolean result2 = findND(arrayB, list.get(i));
            boolean result3 = findND(arrayA, list.get(i));
            boolean result4 = findD(arrayB,list.get(i));

            if (result1 == true && result2 == true) {
                answer = Math.max(answer, list.get(i));
            } else if (result3 == true && result4 == true) {
                answer = Math.max(answer, list.get(i));
            }
        }
        return answer;
    }
    // 철수가 가진 카드들에 적힌 모든 숫자를 나눌 수 있고 영희가 는 하나도 x
}