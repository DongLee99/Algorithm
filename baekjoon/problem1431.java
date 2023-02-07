import java.util.Scanner;
import java.util.Arrays;
import java.util.Comparator;

public class problem1431 {
    public static void main(String[] args) {
        Scanner scanf =new Scanner(System.in);
        int a = scanf.nextInt();
        String [] b = new String[a];
        for (int i = 0; i < a; i++){
            String tmp = scanf.next();
            b[i] = tmp;
        }
        Arrays.sort(b, new Comparator<String>() {
            public int compare(String s1, String s2) {
                int num1 = 0;
                int num2 = 0;
                if (s1.length() == s2.length()) {
                    for (int j = 0; j < s1.length(); j++) {
                        if ((int)s1.charAt(j) >= 48 && (int)s1.charAt(j) <= 57) {
                            num1 = num1 + Integer.parseInt(s1.charAt(j)+"");
                        }
                        if ((int)s2.charAt(j) >= 48 && (int)s2.charAt(j) <= 57) {
                            num2 = num2 + Integer.parseInt(s2.charAt(j)+"");
                        }
                    }
                    if (num1 > num2) {
                        return 1;
                    }else if (num1 == num2){
                        return s1.compareTo(s2);
                    }
                    else {
                        return -1;
                    }
                }
                else {
                    return s1.length() - s2.length();
                }
            }
        });
        for (int i = 0; i< a; i++){
            System.out.println(b[i]);
        }
    }
}
