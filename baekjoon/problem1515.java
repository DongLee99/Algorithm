import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String value = sc.next();
        int base = 0;
        int pt = 0;

        while(base++ <= 30000) {
            String tmp = String.valueOf(base);
            for (int i = 0; i < tmp.length(); i++) {
                if (tmp.charAt(i) == value.charAt(pt)) {
                    pt++;
                }
                if (pt == value.length()) {
                    System.out.println(base);
                    return;
                }
            }
        }
    }
}