import java.util.Scanner;

public class problem1105 {
    static int cnt = 0;
    static int min = 0;
    public static void search(String a, String b){

        if (a.length() == b.length()){
            for (int i = 0 ; i < a.length(); i ++){
                if (a.charAt(i) == b.charAt(i)){
                    if (a.charAt(i) =='8') {
                        cnt++;
                    }
                }else {
                    break;
                }
            }
        }
        System.out.print(cnt);
    }
    public static void main(String [] args){
        Scanner scanf = new Scanner(System.in);
        String a = scanf.next();
        String b = scanf.next();

        search(a,b);
    }
}
