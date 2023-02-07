import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class problem {
    static int N;
    static int L;
    static Hole [] holes;

    static class Hole {
        public int start;
        public int end;

        public Hole(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        N = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());

        holes = new Hole[N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(bf.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            holes[i] = new Hole(x,y);
        }

        Arrays.sort(holes, new Comparator<Hole>() {
            @Override
            public int compare(Hole o1, Hole o2) {
                if (o1.start > o2.start) {
                    return 1;
                } else {
                    return -1;
                }
            }
        });

        int boardCount = 0;
        int start = 0;

        for (int i = 0; i < N; i++) {
            start = Math.max(start, holes[i].start);
            int tmp = 0;
            while (tmp <holes[i].end - start) {
                tmp = tmp + L;
            }
            boardCount = boardCount + tmp/L;
            start = start + tmp;
        }
        System.out.println(boardCount);
    }
}