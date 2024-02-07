import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String buffer = sc.next();
        sc.close();
        String ans = "";
        buffer = buffer.replaceAll("XXXX", "AAAA");
        ans = buffer.replaceAll("XX", "BB");
        if (ans.contains("X")) {
            System.out.println(-1);
            return;
        }
        System.out.println(ans);
    }
}
