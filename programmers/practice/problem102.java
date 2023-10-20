import java.util.*;

public class Main {
    public static class Solution {
        public static int solution(int[] books, int[] target) {
            int answer = -1;
            List<Integer> bookList = new ArrayList<>();
            for (int i = books.length - 1; i >= 0; i--) {
                bookList.add(books[i]);
            }

            int count = 0;
            for (int i : target) {
                int position = 0;
                int weight = 0;
                for (int j = 0; j < books.length; j++) {
                    if (bookList.get(j) == i) {
                        position = j;
                        break;
                    }
                }
                weight = books.length - 1 - position;
                bookList.remove(position);
                bookList.add(i);
                count = weight + count;
            }
            return count;
        }
    }
    public static void main(String[] args) {
        int[] books = {3, 1, 2};
        int[] target = {1, 3, 2};
        System.out.println(Solution.solution(books, target));
    }
}