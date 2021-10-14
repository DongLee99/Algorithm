import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class problem1263{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int s = sc.nextInt();
        int [] arr1 = new int [s];
        int [] arr2 = new int [s];
        for (int i = 0 ; i < s; i++ ) {
            int read1 = sc.nextInt();
            int read2 = sc.nextInt();
            arr1[i] = read1;
            arr2[i] = read2;
        }
        for (int i = 0; i < s; i ++) {
            for (int j = i; j < s; j++) {
                if (arr2[j] < arr2[i]) {
                    int temp = arr2[i];
                    arr2[i] = arr2[j];
                    arr2[j] = temp;
                    int temp2 = arr1[i];
                    arr1[i] = arr1[j];
                    arr1[j] = temp2;
                }
            }
        }
        int timer1 = 0;
        int timer2 = 0;
        int timer3 = 0;
        boolean result = true;
        for (int i = 0; i < s; i++) {
            timer1 = timer1 + arr1[i];
            if (timer1 < arr2[i]) {
                continue;
            } else {
                result = false;
                break;
            }
        }
        if (result == false) {
            System.out.println(-1);
        } else {
            while(true) {
                timer2++;
                timer1 = timer2;
                for (int i = 0; i < s; i++) {
                    timer1 = timer1 + arr1[i];
                    if (timer1 < arr2[i]) {
                        continue;
                    } else {
                        System.out.println(timer2);
                        return;
                    }
                }
            }
        }
    }
}