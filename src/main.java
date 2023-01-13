import java.util.*;

class Solution
{
    public static String MAX = "";
    public static String N;
    public static String x;
    public static String y;
    public static List<String> arr = new ArrayList<>();

    public static void find(int count, String value) {
        int size = N.length() - value.length() - 1;
        String tmp = "";
        String checkTmp = "";
        for (int i = 0; i < value.length(); i++) {
            tmp = tmp + String.valueOf(value.charAt(i));
            checkTmp = checkTmp + String.valueOf(value.charAt(i));
        }
        for (int i = 0; i <= size; i++) {
            checkTmp = checkTmp + "0";
        }
        if (count == N.length()) {
            if (value.compareTo(N) <= 0) {
                if (MAX.compareTo(value) < 0) {
                    MAX = value;
                }
            }
            return;
        }
        if (checkTmp.compareTo(N) > 0) {
            return;
        }
        if (!value.equals("") || !x.equals("0")) {
            String xValue = tmp + x;
            String realXvalue = value + x;
            for (int i = 0; i < size; i++) {
                xValue = xValue + "0";
            }
            if (xValue.compareTo(N) <= 0) {
                if (xValue.compareTo(N) == 0) {
                    if (MAX.compareTo(xValue) < 0) {
                        MAX = xValue;
                    }
                } else {
                    if (MAX.compareTo(xValue) < 0) {
                        MAX = xValue;
                    }
                    find(count + 1, realXvalue);
                }
            }
        }
        if (!value.equals("") || !y.equals("0")) {
            String yValue = tmp + y;
            String realYvalue = value + y;
            for (int i = 0; i < size; i++) {
                yValue = yValue + "0";
            }
            if (yValue.compareTo(N) <= 0) {
                if (yValue.compareTo(N) == 0) {
                    if (MAX.compareTo(yValue) < 0) {
                        MAX = yValue;
                    }
                } else {
                    if (MAX.compareTo(yValue) < 0) {
                        MAX = yValue;
                    }
                    find(count + 1, realYvalue);
                }
            }
        }

    }
    public static void main(String args[]) throws Exception
    {
		/*
		   아래의 메소드 호출은 앞으로 표준 입력(키보드) 대신 input.txt 파일로부터 읽어오겠다는 의미의 코드입니다.
		   여러분이 작성한 코드를 테스트 할 때, 편의를 위해서 input.txt에 입력을 저장한 후,
		   이 코드를 프로그램의 처음 부분에 추가하면 이후 입력을 수행할 때 표준 입력 대신 파일로부터 입력을 받아올 수 있습니다.
		   따라서 테스트를 수행할 때에는 아래 주석을 지우고 이 메소드를 사용하셔도 좋습니다.
		   단, 채점을 위해 코드를 제출하실 때에는 반드시 이 메소드를 지우거나 주석 처리 하셔야 합니다.
		 */
        //System.setIn(new FileInputStream("res/input.txt"));

		/*
		   표준입력 System.in 으로부터 스캐너를 만들어 데이터를 읽어옵니다.
		 */
        Scanner sc = new Scanner(System.in);
        int T;
        T=sc.nextInt();
		/*
		   여러 개의 테스트 케이스가 주어지므로, 각각을 처리합니다.
		*/

        for(int test_case = 1; test_case <= T; test_case++)
        {
            N = String.valueOf(sc.next());
            x = String.valueOf(sc.nextInt());
            y = String.valueOf(sc.nextInt());
            if (test_case != T) {
                sc.nextLine();
            }
            find(0, "");
            if (MAX.equals("")) {
                System.out.printf("#%d %d\n", test_case, -1);
            } else {
                System.out.printf("#%d %s\n", test_case, MAX);
            }
            arr = new ArrayList<>();
            MAX = "";
        }
    }
}