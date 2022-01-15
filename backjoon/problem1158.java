import java.util.*;

public class problem {


    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Queue<Integer> list = new LinkedList<>();
        List<Integer> result = new ArrayList<>();
        int n = scan.nextInt();
        int k = scan.nextInt();

        for (int i = 0; i < n; i++) {
            list.add(i+1);
        }

        while (list.size() != 0) {
            for (int i = 0; i < k; i++) {
                if ((i + 1) == k) {
                    result.add(list.poll());
                } else {
                    Integer peek = list.poll();
                    list.add(peek);
                }
            }
        }

        for (int i = 0; i < result.size(); i++) {
            if (result.size() == 1) {
                System.out.println("<" + result.get(i) + ">");
                return;
            }
            if (i == 0) {
                System.out.print("<" + result.get(i) + ", ");
            } else if (i == result.size() - 1){
                System.out.print(result.get(i) + ">");
            } else {
                System.out.print(result.get(i) + ", ");
            }
        }
    }
}
