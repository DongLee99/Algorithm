import java.util.*;
import java.io.*;


public class Main
{
    public static int N;

    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();

        for (int i = 0; i < N; i++) {
            int [][] button = {{0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0} ,{0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0}};
            String first = sc.next();
            String second = sc.next();
            if (first.length() != 5) {
                int size = first.length();
                for (int j = 0; j < 5 - size; j++) {
                    first = " " + first;
                }
            }
            if (second.length() != 5) {
                int size = second.length();
                for (int j = 0; j < 5 - size; j++) {
                    second = " " + second;
                }
            }
            for (int j = 0; j < 5; j++) {
                if (first.charAt(j) == ' ') {
                    continue;
                } else if (first.charAt(j) == '0') {
                    button[j][0] = 1;
                    button[j][1] = 1;
                    button[j][2] = 1;
                    button[j][4] = 1;
                    button[j][5] = 1;
                    button[j][6] = 1;
                } else if (first.charAt(j) == '1') {
                    button[j][2] = 1;
                    button[j][5] = 1;
                } else if (first.charAt(j) == '2') {
                    button[j][0] = 1;
                    button[j][2] = 1;
                    button[j][3] = 1;
                    button[j][4] = 1;
                    button[j][6] = 1;
                } else if (first.charAt(j) == '3') {
                    button[j][0] = 1;
                    button[j][2] = 1;
                    button[j][3] = 1;
                    button[j][5] = 1;
                    button[j][6] = 1;
                } else if (first.charAt(j) == '4') {
                    button[j][1] = 1;
                    button[j][2] = 1;
                    button[j][3] = 1;
                    button[j][5] = 1;
                } else if (first.charAt(j) == '5') {
                    button[j][0] = 1;
                    button[j][1] = 1;
                    button[j][3] = 1;
                    button[j][5] = 1;
                    button[j][6] = 1;
                } else if (first.charAt(j) == '6') {
                    button[j][0] = 1;
                    button[j][1] = 1;
                    button[j][3] = 1;
                    button[j][4] = 1;
                    button[j][5] = 1;
                    button[j][6] = 1;
                } else if (first.charAt(j) == '7') {
                    button[j][0] = 1;
                    button[j][1] = 1;
                    button[j][2] = 1;
                    button[j][5] = 1;
                } else if (first.charAt(j) == '8') {
                    button[j][0] = 1;
                    button[j][1] = 1;
                    button[j][2] = 1;
                    button[j][3] = 1;
                    button[j][4] = 1;
                    button[j][5] = 1;
                    button[j][6] = 1;
                } else if (first.charAt(j) == '9') {
                    button[j][0] = 1;
                    button[j][1] = 1;
                    button[j][2] = 1;
                    button[j][3] = 1;
                    button[j][5] = 1;
                    button[j][6] = 1;
                }
            }
            int count = 0;
            for (int j = 0; j < 5; j++) {
                if (second.charAt(j) == ' ') {
                    if (button[j][0] != 0) {
                        count++;
                    }
                    if (button[j][1] != 0) {
                        count++;
                    }
                    if (button[j][2] != 0) {
                        count++;
                    }
                    if (button[j][3] != 0) {
                        count++;
                    }
                    if (button[j][4] != 0) {
                        count++;
                    }
                    if (button[j][5] != 0) {
                        count++;
                    }
                    if (button[j][6] != 0) {
                        count++;
                    }
                } else if (second.charAt(j) == '0') {
                    if (button[j][0] != 1) {
                        count++;
                    }
                    if (button[j][1] != 1) {
                        count++;
                    }
                    if (button[j][2] != 1) {
                        count++;
                    }
                    if (button[j][3] != 0) {
                        count++;
                    }
                    if (button[j][4] != 1) {
                        count++;
                    }
                    if (button[j][5] != 1) {
                        count++;
                    }
                    if (button[j][6] != 1) {
                        count++;
                    }
                } else if (second.charAt(j) == '1') {
                    if (button[j][0] != 0) {
                        count++;
                    }
                    if (button[j][1] != 0) {
                        count++;
                    }
                    if (button[j][2] != 1) {
                        count++;
                    }
                    if (button[j][3] != 0) {
                        count++;
                    }
                    if (button[j][4] != 0) {
                        count++;
                    }
                    if (button[j][5] != 1) {
                        count++;
                    }
                    if (button[j][6] != 0) {
                        count++;
                    }
                } else if (second.charAt(j) == '2') {
                    if (button[j][0] != 1) {
                        count++;
                    }
                    if (button[j][1] != 0) {
                        count++;
                    }
                    if (button[j][2] != 1) {
                        count++;
                    }
                    if (button[j][3] != 1) {
                        count++;
                    }
                    if (button[j][4] != 1) {
                        count++;
                    }
                    if (button[j][5] != 0) {
                        count++;
                    }
                    if (button[j][6] != 1) {
                        count++;
                    }
                } else if (second.charAt(j) == '3') {
                    if (button[j][0] != 1) {
                        count++;
                    }
                    if (button[j][1] != 0) {
                        count++;
                    }
                    if (button[j][2] != 1) {
                        count++;
                    }
                    if (button[j][3] != 1) {
                        count++;
                    }
                    if (button[j][4] != 0) {
                        count++;
                    }
                    if (button[j][5] != 1) {
                        count++;
                    }
                    if (button[j][6] != 1) {
                        count++;
                    }
                } else if (second.charAt(j) == '4') {
                    if (button[j][0] != 0) {
                        count++;
                    }
                    if (button[j][1] != 1) {
                        count++;
                    }
                    if (button[j][2] != 1) {
                        count++;
                    }
                    if (button[j][3] != 1) {
                        count++;
                    }
                    if (button[j][4] != 0) {
                        count++;
                    }
                    if (button[j][5] != 1) {
                        count++;
                    }
                    if (button[j][6] != 0) {
                        count++;
                    }
                } else if (second.charAt(j) == '5') {
                    if (button[j][0] != 1) {
                        count++;
                    }
                    if (button[j][1] != 1) {
                        count++;
                    }
                    if (button[j][2] != 0) {
                        count++;
                    }
                    if (button[j][3] != 1) {
                        count++;
                    }
                    if (button[j][4] != 0) {
                        count++;
                    }
                    if (button[j][5] != 1) {
                        count++;
                    }
                    if (button[j][6] != 1) {
                        count++;
                    }
                } else if (second.charAt(j) == '6') {
                    if (button[j][0] != 1) {
                        count++;
                    }
                    if (button[j][1] != 1) {
                        count++;
                    }
                    if (button[j][2] != 0) {
                        count++;
                    }
                    if (button[j][3] != 1) {
                        count++;
                    }
                    if (button[j][4] != 1) {
                        count++;
                    }
                    if (button[j][5] != 1) {
                        count++;
                    }
                    if (button[j][6] != 1) {
                        count++;
                    }
                } else if (second.charAt(j) == '7') {
                    if (button[j][0] != 1) {
                        count++;
                    }
                    if (button[j][1] != 1) {
                        count++;
                    }
                    if (button[j][2] != 1) {
                        count++;
                    }
                    if (button[j][3] != 0) {
                        count++;
                    }
                    if (button[j][4] != 0) {
                        count++;
                    }
                    if (button[j][5] != 1) {
                        count++;
                    }
                    if (button[j][6] != 0) {
                        count++;
                    }
                } else if (second.charAt(j) == '8') {
                    if (button[j][0] != 1) {
                        count++;
                    }
                    if (button[j][1] != 1) {
                        count++;
                    }
                    if (button[j][2] != 1) {
                        count++;
                    }
                    if (button[j][3] != 1) {
                        count++;
                    }
                    if (button[j][4] != 1) {
                        count++;
                    }
                    if (button[j][5] != 1) {
                        count++;
                    }
                    if (button[j][6] != 1) {
                        count++;
                    }
                } else if (second.charAt(j) == '9') {
                    if (button[j][0] != 1) {
                        count++;
                    }
                    if (button[j][1] != 1) {
                        count++;
                    }
                    if (button[j][2] != 1) {
                        count++;
                    }
                    if (button[j][3] != 1) {
                        count++;
                    }
                    if (button[j][4] != 0) {
                        count++;
                    }
                    if (button[j][5] != 1) {
                        count++;
                    }
                    if (button[j][6] != 1) {
                        count++;
                    }
                }
            }
            System.out.println(count);
        }
    }
}