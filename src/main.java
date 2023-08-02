import java.util.*;
public class Main {
    public static class Solution {
        public static int[] solution(String s) {
            List<Integer> answer = new ArrayList<>();
            s = s.substring(2, s.length());
            s = s.substring(0 ,s.length()-2).replace("},{", "-");
            String [] str = s.split("-");
            Arrays.sort(str, new Comparator<String>() {
                @Override
                public int compare(String o1, String o2) {
                    return Integer.compare(o1.length(), o2.length());
                }
            });

            for (String x : str) {
                String [] temps = x.split(",");
                for (String tmp : temps) {
                    int n = Integer.parseInt(tmp);
                    if (!answer.contains(n)) {
                        answer.add(n);
                    }
                }
            }
            return answer.stream()
                    .mapToInt(data -> data)
                    .toArray();
        }
    }
    public static void main(String[] args) {
        Deque<Integer> deque = new LinkedList<>();
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        for (int i = 1; i <= N; i++) {
            deque.add(i);
        }
        while (deque.size() != 1) {
            deque.poll();
            deque.add(deque.peek());
            deque.poll();
        }
        System.out.println(deque.poll());
    }
}
