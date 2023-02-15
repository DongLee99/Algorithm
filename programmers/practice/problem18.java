class Solution {
    public String[] solution(int n, int[] arr1, int[] arr2) {
        String [][] result = new String[n][n];
        for (int i = 0; i < arr1.length; i++) {
            String sTmp = "";
            int tmp = arr1[i];
            for (int j = 0; j < n; j++) {
                int x = tmp % 2;
                tmp = tmp / 2;
                if (x == 1) {
                    result[i][n - j - 1] =  "#";
                } else {
                    result[i][n - j - 1] =  " ";
                }
            }
        }
        for (int i = 0; i < arr2.length; i++) {
            String sTmp = "";
            int tmp = arr2[i];
            for (int j = 0; j < n; j++) {
                int x = tmp % 2;
                tmp = tmp / 2;
                if ( x == 1) {
                    result[i][n - j - 1] =  "#";
                } else {
                    if (result[i][n-j-1].equals("#")) {
                        continue;
                    } else {
                        result[i][n-j-1] = " ";
                    }
                }
            }
        }
        String [] answer = new String[n];
        for (int i = 0; i < n; i++) {
            String tmp = "";
            for (int j = 0; j < n; j++) {
                tmp = tmp + result[i][j];
            }
            answer[i] = tmp;
        }
        return answer;
    }
}