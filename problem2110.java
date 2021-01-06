import java.util.Arrays;
import java.util.Scanner;

public class problem2110 {
    static int N;
    static int M;
    static int arr[];
    public static void main(String[] args) {
        Scanner scanf = new Scanner(System.in);
        N = scanf.nextInt();
        M = scanf.nextInt();
        arr = new int[N];
        for (int i = 0; i< N; i++){
            arr[i] = scanf.nextInt();
        }
        Arrays.sort(arr);
        int d = 0;
        int ans = 0;
        int left = 0;
        int right = arr[N-1] - arr[0];
        while(left <= right){
            int mid= (left + right) /2; //공유기 사이의 거리
            int start = arr[0];
            int count =1;
            for (int i = 0; i <N ; i++) {
                d= arr[i]-start;
                if(d >= mid){ // 두 공유기 사이의 거리가 정해놓았던 거리 mid 보다 크면 다음 집으로 이동을 한다를 표현
                    count++;
                    start = arr[i];
                }
            }

            if(count>=M){ //공유기의 개수 비교 count 는 위의 과정을 거치고 나온 값으로 count = 공유기의
                ans = mid;
                left = mid + 1;
            }else{
                right = mid-1;
            }
        }
        System.out.println(ans);
    }

}
