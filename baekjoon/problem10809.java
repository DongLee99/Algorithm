import java.util.Scanner;

public class problem10809 {
    public static void main(String args[]){
        int [] a = new int[26];
        char b[] = {'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z'};
        for (int i = 0; i<26; i++){
            a[i] = -1;
        }


        Scanner scanf = new Scanner(System.in);
        String text = scanf.next();
        for (int i = 0; i<text.length(); i++){
            for (int j = 0; j <26; j++){
                if(text.charAt(i) == b[j]){
                    if (a[j] == -1) {
                        a[j] = i;
                    }
                }
            }
        }
        for (int i = 0; i<26; i++){
            System.out.print(a[i]);
            System.out.print(' ');
        }

    }
}
