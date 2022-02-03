import org.w3c.dom.ls.LSOutput;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class problem{
    static List<Integer> result = new ArrayList<>();

    static void check(String str) {
        int count = 0;
        int temp = 0;
        for (int i = 0; i < str.length(); i++) {
            if (Integer.parseInt(String.valueOf(str.charAt(i))) != temp) {
                temp = Integer.parseInt(String.valueOf(str.charAt(i)));
                count++;
            }
        }
        result.add(count);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int N = scanner.nextInt();

        for (int i = 0; i < N; i++) {
            String str = scanner.next();
            check(str);
        }
        for (int i = 1; i <= result.size(); i++) {
            System.out.println("#" + i + " " + result.get(i-1));
        }
    }
}