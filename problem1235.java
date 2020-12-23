import java.util.Scanner;

public class problem1235 {
    public static void main(String args[]){
        Scanner scanf = new Scanner(System.in);
        int a = scanf.nextInt();
        String [] tmp = new String[a];
        for (int i = 0 ; i< a; i++) {
            String b = scanf.next();
            tmp[i] = b;
        }
        int cnt = tmp[0].length();
        boolean result = false;
        boolean result2 = false;
        while(true){
            result2 = false;
            --cnt;

            if ( cnt == -1){
                break;
            }

            for (int i = 0 ; i<a; i++){
                for (int j = i+1 ; j < a ; j++){
                    if (tmp[i].substring(cnt).equals(tmp[j].substring(cnt))){
                        result2 = true;
                        break;
                    }
                }
            }
            if (result2 == false){
                break;
            }
        }
        System.out.print(tmp[0].length() -cnt);
    }
}
