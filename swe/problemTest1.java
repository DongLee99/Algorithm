/////////////////////////////////////////////////////////////////////////////////////////////
// 기본 제공코드는 임의 수정해도 관계 없습니다. 단, 입출력 포맷 주의
// 아래 표준 입출력 예제 필요시 참고하세요.
// 표준 입력 예제
// int a;
// double b;
// char g;
// String var;
// long AB;
// a = sc.nextInt();                           // int 변수 1개 입력받는 예제
// b = sc.nextDouble();                        // double 변수 1개 입력받는 예제
// g = sc.nextByte();                          // char 변수 1개 입력받는 예제
// var = sc.next();                            // 문자열 1개 입력받는 예제
// AB = sc.nextLong();                         // long 변수 1개 입력받는 예제
/////////////////////////////////////////////////////////////////////////////////////////////
// 표준 출력 예제
// int a = 0;
// double b = 1.0;
// char g = 'b';
// String var = "ABCDEFG";
// long AB = 12345678901234567L;
//System.out.println(a);                       // int 변수 1개 출력하는 예제
//System.out.println(b); 		       						 // double 변수 1개 출력하는 예제
//System.out.println(g);		       						 // char 변수 1개 출력하는 예제
//System.out.println(var);		       				   // 문자열 1개 출력하는 예제
//System.out.println(AB);		       				     // long 변수 1개 출력하는 예제
/////////////////////////////////////////////////////////////////////////////////////////////
import java.util.Scanner;

class Solution
{
    public static char [][] arr;
    public static boolean [][] visitArr;
    public static int R;
    public static int C;
    public static boolean [] visitAlphabet;
    public static int [] dx = {1, -1, 0 ,0};
    public static int [] dy = {0, 0, -1, 1};
    public static int count = 0;
    public static int result = 0;
    public static void dfs(int x, int y) {
        result = Math.max(result, count);
        for (int i = 0; i < 4; i++) {
            int cx = x + dx[i];
            int cy = y + dy[i];

            if (cx >= 0 && cx < R && cy >= 0 && cy < C) {
                if (visitArr[cx][cy] == false) {
                    if (visitAlphabet[(int) arr[cx][cy] - 65] == false) {
                        visitArr[cx][cy] = true;
                        visitAlphabet[(int) arr[cx][cy] - 65] = true;
                        count++;
                        dfs(cx, cy);
                        count--;
                        visitArr[cx][cy] = false;
                        visitAlphabet[(int) arr[cx][cy] - 65] = false;
                    }
                }
            }
        }
    }
    public static void main(String args[]) throws Exception
    {
        Scanner sc = new Scanner(System.in);
        int T;
        T=sc.nextInt();

        for(int test_case = 1; test_case <= T; test_case++)
        {
            R = sc.nextInt();
            C = sc.nextInt();

            // A = 65 / Z = 90
            // 배열과 방문 배열 초기화
            arr = new char [R][C];
            visitArr = new boolean [R][C];
            visitAlphabet = new boolean [26];
//            if (test_case == 1) {
//                sc.nextLine();
//            }
            sc.nextLine();
            // 배열에 알파벳 넣기
            for (int i = 0; i < R; i++) {
                String value = sc.nextLine();
                for (int j = 0; j < C; j++) {
                    arr[i][j] = value.charAt(j);
                }
            }
            visitArr[0][0] = true;
            visitAlphabet[(int) arr[0][0] - 65] = true;
            count++;
            dfs(0, 0 );
            System.out.printf("#%d %d\n", test_case, result);
            // 카운트 초기화
            count = 0;
            result = 0;
        }
    }
}