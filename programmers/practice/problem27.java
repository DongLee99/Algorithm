class Solution {
    public static char [][] arr = new char[3][3];
    public boolean find(char value) {
        if (arr[0][0] == value && arr[0][1] == value && arr[0][2] == value) {
            return true;
        } else if (arr[1][0] == value && arr[1][1] == value && arr[1][2] == value) {
            return true;
        } else if (arr[2][0] == value && arr[2][1] == value && arr[2][2] == value) {
            return true;
        } else if (arr[0][0] == value && arr[1][0] == value && arr[2][0] == value) {
            return true;
        } else if (arr[0][1] == value && arr[1][1] == value && arr[2][1] == value) {
            return true;
        } else if (arr[0][2] == value && arr[1][2] == value && arr[2][2] == value) {
            return true;
        } else if (arr[0][0] == value && arr[1][1] == value && arr[2][2] == value) {
            return true;
        } else if (arr[0][2] == value && arr[1][1] == value && arr[2][0] == value) {
            return true;
        }
        return false;
    }
    public int solution(String[] board) {
        int fCount = 0;
        int sCount = 0;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                arr[i][j] = board[i].charAt(j);
                if (arr[i][j] == 'O') {
                    fCount++;
                } else if (arr[i][j] == 'X') {
                    sCount++;
                }
            }
        }
        if (Math.abs(fCount - sCount) >= 2 || fCount < sCount) {
            return 0;
        }
        boolean xCount = find('X');
        boolean oCount = find('O');
        if (xCount == true && oCount == true) {
            return 0;
        }
        if (oCount == true && fCount - sCount != 1) {
            return 0;
        }
        if (xCount == true && fCount != sCount) {
            return 0;
        }
        return 1;
    }
}