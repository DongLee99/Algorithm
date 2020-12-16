import java.util.Scanner;

public class problem1166 {
    public static void main(String args[]) {
        Scanner scanf = new Scanner(System.in);
        int a = scanf.nextInt();
        int[] e = new int[3];
        for (int i = 0; i < 3; i++) {
            int b = scanf.nextInt();
            e[i] = b;
        }
        double min = Math.min(Math.min(e[0], e[1]), e[2]);

        double cnt = min;
        double stop = 0;
        double visit = 0;
        int c = 0;
        for (int i = 0; i < 10000; i++) {
            cnt = (stop + min) / 2;
            //System.out.print(cnt);
            if (((long) (e[0] / cnt) * (long) (e[1] / cnt) * (long) (e[2] / cnt)) >= a) {
                stop = cnt;
            } else {
                //System.out.println();
                min = cnt;

            }


        }
        System.out.print(cnt);
    }
}
