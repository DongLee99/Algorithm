import java.util.*;

class Solution {
    public static boolean isPrime(long n) {
        boolean check = true;
        if (n < 2) {
            return false;
        }
        if (n == 2) {
            return true;
        }
        for (long i = 2; i <= (long) Math.sqrt(n); i++) {
            if (n % i == 0) {
                check = false;
                return check;
            }
        }
        return check;
    }
    public int solution(int n, int k) {
        int answer = 0;

        List<Integer> list = new ArrayList<>();
        while (n != 0) {
            list.add(n % k);
            n /= k;
        }

        Collections.reverse(list);
        String numbers = "";
        for (int i = 0; i < list.size(); i++) {
            numbers = numbers + String.valueOf(list.get(i));
        }
        String tmp = "";
        List<String> aL = new ArrayList<>();
        for (int i = 0; i < numbers.length(); i++) {
            if (Integer.parseInt(String.valueOf(numbers.charAt(i))) != 0) {
                tmp = tmp + String.valueOf(numbers.charAt(i));
            } else {
                if (!tmp.equals("")) {
                    aL.add(tmp);
                }
                tmp = "";
            }
            if (numbers.length() - 1 == i) {
                if (!String.valueOf(numbers.charAt(i)).equals("0")) {
                    aL.add(tmp);
                }
            }
        }

        int count = 0;
        for (int i = 0; i < aL.size(); i++) {
            // System.out.println(aL.get(i));
            if (isPrime(Long.parseLong(aL.get(i)))) {
                count++;
            }
            // for (int j = 0; j < numberArray[i].length(); j++) {
            //     tmp = tmp + String.valueOf(numberArray[i].charAt(j));
            //     if (isPrime(Integer.parseInt(tmp))) {
            //         System.out.println(tmp);
            //         count++;
            //         tmp = "";
            //     }
            // }
        }
        return count;
    }
}