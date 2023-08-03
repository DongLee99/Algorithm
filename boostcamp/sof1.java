import java.util.*;
import java.io.*;


public class Main
{
    public static void main(String args[])
    {
        Scanner scanner = new Scanner(System.in);
        int [] arr = new int[8];

        for (int i = 0; i < 8; i++) {
            arr[i] = scanner.nextInt();
        }
        int before = arr[0];
        int state = 2; // 1 상승 -1 하락 0 믹스
        for (int i = 1; i < 8; i++) {
            if (before < arr[i]) {
                if (state == 2 || state == 1) {
                    state = 1;
                    before = arr[i];
                } else {
                    System.out.println("mixed");
                    return;
                }
            } else {
                if (state == 2 || state == -1) {
                    state = -1;
                    before = arr[i];
                } else {
                    System.out.println("mixed");
                    return;
                }
            }
        }
        if (state == 1) {
            System.out.println("ascending");
        } else {
            System.out.println("descending");
        }
    }
}