import java.util.Scanner;

public class Main {
    public static int N;

    public static boolean sFind(String number) {
        int iNumber = Integer.parseInt(number);
        for (int i = 2; i < iNumber; i++) {
            if (iNumber % i == 0) {
                return false;
            }
        }
        return true;
    }

    public static void find(int depth, String number) {
        if (depth == N) {
            System.out.println(number);
            return;
        }
        for (int i = 1; i < 10; i++) {
            if (depth == 0) {
                if (i == 1) {
                    continue;
                } else if (i == 2 || i == 3 || i == 5 || i == 7){
                    find(depth + 1, number + i);
                    continue;
                }
            }
            String tmp = number + i;
            if (sFind(tmp)) {
                find(depth + 1, tmp);
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        find(0, "");
    }
}