import java.util.*;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class problem {
    static class Solution {
        public int solution(int[][] board, int[] moves) {
            int answer = 0;
            int x = board.length;
            int y = board[0].length;
            Stack<Integer> stack = new Stack<>();
            for (int i = 0; i < moves.length; i++) {
                for (int j = 0; j < x; j++) {
                    if (board[j][moves[i]-1] != 0) {
                        if (stack.isEmpty()) {
                            stack.add(board[j][moves[i]-1]);
                        } else {
                            if (stack.peek() == board[j][moves[i]-1]) {
                                stack.pop();
                                answer = answer + 2;
                            } else {
                                stack.add(board[j][moves[i]-1]);
                            }
                        }
                        board[j][moves[i]-1] = 0;
                        break;
                    }
                }
            }

            return answer;
        }

    }
    public static void main(String[] args) {
        int [][] board = {{0,0,0,0,0},{0,0,1,0,3},{0,2,5,0,1},{4,2,4,4,2},{3,5,1,3,1}};
        int [] moves = {1,5,3,5,1,2,1,4};
        Solution solution = new Solution();
        System.out.println(solution.solution(board, moves));
    }
}