import java.util.Scanner;

public class problem1152 {
    public static void main(String args[]){
        Scanner scanf = new Scanner(System.in);
        String text = scanf.nextLine();
        int cnt =0;
        for (int i = 0; i <text.length(); i++){
            if(text.charAt(i) == ' '){
                cnt++;
                if (i == text.length()-1){
                    cnt--;
                }
                if (i == 0){
                    cnt--;
                }
            }
        }
        System.out.print(cnt+1);
    }
}
