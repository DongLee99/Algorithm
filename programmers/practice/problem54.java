import java.util.*;

class Solution {
    public int solution(int n, int m, int[] section) {
        int[] arr = new int[n + 1];
        Arrays.fill(arr, 1);
        for (int i = 0; i < section.length; i++) {
            arr[section[i]] = 0;
        }
        int count = 0;
        for (int i = 1; i <= n; i++) {
            if (arr[i] == 0) {
                count++;
                for (int j = 0; j < m; j++) {
                    if (i + j <= n) {
                        arr[i + j] = 1;
                    } else {
                        break;
                    }
                }
            }
        }
        return count;
    }
}