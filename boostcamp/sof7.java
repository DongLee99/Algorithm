import java.util.*;
import java.io.*;


public class Main
{
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int addPoint = 1;
        int startPoint = 2;
        for (int i = 0; i < N; i++) {
            startPoint = startPoint + addPoint;
            addPoint = addPoint * 2;
        }
        System.out.println(startPoint * startPoint);
    }
}