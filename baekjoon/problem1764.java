import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Scanner;

public class problem1764 {
    static int N;
    static int M;
    static ArrayList <String> arr = new ArrayList<>();
    static HashSet<String> hs = new HashSet<String>();
    public static void main(String[] args) {
        Scanner scanf = new Scanner(System.in);
        N = scanf.nextInt();
        M = scanf.nextInt();

        for (int i = 0 ; i < N; i++){
            hs.add(scanf.next());
        }
        for (int i = 0 ; i < M; i++){
            String tmp = scanf.next();
            if (hs.contains(tmp)){
                arr.add(tmp);
            };
        }
        Collections.sort(arr);
        System.out.println(arr.size());
        for (int i = 0; i < arr.size(); i++) {
            System.out.println(arr.get(i));
        }

    }
}
