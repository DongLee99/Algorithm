import java.util.Scanner;

public class problem10872 {
    public static int sum =1;
    int fact(int a){

        if (a >0){
            sum = sum * a;
            return fact(a-1);
        }else {
            return sum;
        }
    }
    public static void main(String args[]){
        Scanner scanf = new Scanner(System.in);
        int a = scanf.nextInt();
        problem10872 fact = new problem10872();
        System.out.print(fact.fact(a));
    }
}
