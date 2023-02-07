import java.util.Scanner;

public class problem1074{

    public static int row;
    public static int col;

    public static int[] dy = {0, 0, 1, 1};
    public static int[] dx = {0, 1, 0, 1};
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int pow = sc.nextInt();

        int size = (int) Math.pow(2, pow);
        row = sc.nextInt();
        col = sc.nextInt();

        drawZ(0, 0, 0, size);

        sc.close();

        System.out.println(size*size);
    }

    public static void drawZ(int y, int x, int cnt, int size) {
        // 확인하고자 하는 row와 col 좌표가 y <= row < y+size, x <= col < x+size 범위 에 해당되지 않으면 구할 필요 없다.
        if(y > row || y+size <= row || x > col || x+size <= col) return;

        if(size == 2) {

            for(int i=0; i < 4; i++) {
                int yy = dy[i] + y;
                int xx = dx[i] + x;

                if(yy == row && xx == col) System.out.println(cnt + i);
            }
            return;
        }

        int newSize = size/2;

        drawZ(y, x, cnt, newSize);

        drawZ(y, x+newSize, cnt+(newSize*newSize), newSize);

        drawZ(y+newSize, x, cnt+(newSize*newSize*2), newSize);

        drawZ(y+newSize, x+newSize, cnt+(newSize*newSize*3), newSize);
    }
}
//출처  https://pangsblog.tistory.com/49