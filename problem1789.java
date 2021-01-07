import java.util.Scanner;

public class problem1789 {

    public static void main(String[] args) {
        Scanner scanf = new Scanner(System.in);
        long N = scanf.nextLong();
        int left = 1;
        int right = 0;
        int result = 0;
        while(N >=result){
            result += left;
            left ++;
            right ++;
        }
        if (result == N){
            System.out.print(right);
        }else {
            System.out.print(right - 1);
        }
    }
}
// 시간 초과가 나는 이유를 모르겠다... 다른 사람들 코드를 봐도 다 비슷한데 왜 나만....
