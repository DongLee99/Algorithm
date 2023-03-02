
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

class main {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        int P = scanner.nextInt();
        int [] answer = new int [P];
        for (int i = 0; i < P; i++) {
            int N = scanner.nextInt();
            int [] arr = new int[20];
            for (int k = 0; k < arr.length; k++) {
                arr[k] = scanner.nextInt();
            }
            int count = 0;
            for (int j = 0; j < arr.length; j++) {
                for (int z = 0; z < j; z++) {
                    if (arr[z] > arr[j]) {
                        count++;
                    }
                }
            }
            System.out.println(N + " " + count);
        }
    }
}