import java.util.Scanner;

public class problem1157 {
    public static void main(String args[]){
        Scanner scanf = new Scanner((System.in));

        String a = scanf.next();
        int cnt =0;
        int big = 0;
        int bigAt = 0;
        boolean result = false;
        for (int i = 0; i<a.length(); i++){
            for (int j = i+1; j<a.length(); j++){
                if(a.charAt(i) == a.charAt(j)){
                   cnt++;
                   continue;

                }
                else if(a.charAt(i) == (a.charAt(j)+32)){
                    cnt++;
                    continue;
                }
                else if(a.charAt(i) == (a.charAt(j)-32)) {
                    cnt++;
                    continue;
                }
            }

            if (cnt > big){
                big = cnt;
                bigAt = i;
                result = false;

            }
            else if( cnt == big){
                result = true;
            }
            cnt =0;
        }
        if (result == true){
            System.out.print("?");
        }
        else {

            System.out.print((char)(a.charAt(bigAt)-32));
        }

    }

}
