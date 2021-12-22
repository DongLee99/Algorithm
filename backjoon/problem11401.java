import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.*;

public class problem2{

    public static long factorial(int x) {
        if (x <= 1) {

            return x;
        }
        else {

            return factorial(x - 1) * x;
        }
    }

    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int x = scanner.nextInt();
        int y = scanner.nextInt();
        long i = factorial(x) / (factorial(y) * (factorial(x - y)));
        System.out.println(i % 1000000007);

    }
}