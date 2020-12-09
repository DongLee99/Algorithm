import java.util.Scanner;

public class problem2231 {
    public static void main(String args[]){
        Scanner scanf = new Scanner(System.in);
        String text = scanf.next();
        int sn, ans = 2, sum =0;
        sn = Integer.parseInt(text);
        int a = 0;
        boolean result = true;
        while(true){
            int mod = 0;
            sum = ans;
            mod = ans;
            for (int i = 0; i<text.length();i++){
                a = mod % 10;
                mod = mod/10;
                sum = sum + a;
                a = 0;
            }
            if (sn == sum)
            {
                break;
            }
            else if (ans > sn)
            {
                System.out.print(0);
                result = false;
                break;

            }
            ans ++;
        }
        if (result == true) {
            System.out.print(ans);
        }
    }
}
