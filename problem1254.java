import java.util.Scanner;

public class problem1254 {
    static int cnt = 0;
    static String tmp;
    static boolean search( String tmp){
        boolean result = true;
        for (int i = 0 ; i < tmp.length()/2; i ++){
            if (tmp.charAt(i) != tmp.charAt(tmp.length()-(i+1))){
                result =false;
            }
        }

        return result;
    }
    static void make(String a){
        int len = a.length();
        for (int i = 0; i < len; i ++){

            if (search(a) == true){
                break;
            }else {
                a = a.substring(1);
                cnt ++;
            };
        }
        tmp = a;
    }
    public static void main(String [] args){
        Scanner scanf = new Scanner(System.in);
        tmp = scanf.next();
        make(tmp);
        System.out.print(tmp.length()+(cnt*2));

    }
}

