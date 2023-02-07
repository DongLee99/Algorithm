import java.util.Scanner;

public class problem2750 {
    public static void main(String args[]){
        Scanner scanf = new Scanner(System.in);

        int a = scanf.nextInt();
        int tmp = 0;
        int [] b = new int[a];
        for (int i =0; i<a; i++){
            b[i] = scanf.nextInt();
        }
        for (int i = 0; i <a; i++){
            for (int j = i+1 ; j<a; j++){
                if(b[i] > b[j] ){
                    tmp = b[i];
                    b[i] = b[j];
                    b[j] = tmp;
                }
            }
        }
        for(int i =0; i < a; i++){
            if(i != a-1){
                System.out.println(b[i]);
            }else {
                System.out.print(b[i]);
            }
        }
    }
}
