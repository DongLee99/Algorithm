class Solution {

    public static boolean [] visit;
    public static int max = Integer.MIN_VALUE;
    public static int N;

    public static void find(int count, int size, int[][] dungeons) {
        if (count == N) {
            max = count;
        }
        for (int i = 0; i < dungeons.length; i++) {
            if (size >= dungeons[i][0] && size >= dungeons[i][1] && visit[i] == false) {
                visit[i] = true;
                find(count + 1, size - dungeons[i][1], dungeons);
                visit[i] = false;
            } else {
                max = Math.max(max, count);
            }
        }
    }

    public int solution(int k, int[][] dungeons) {
        visit = new boolean[dungeons.length];
        N = dungeons.length;
        int count = 0;
        for (int i = 0; i < dungeons.length; i++) {
            if (k >= dungeons[i][0] && k >= dungeons[i][1]) {
                visit[i] = true;
                find(count + 1, k - dungeons[i][1], dungeons);
                visit[i] = false;
            }
        }
        return max;
    }
    // 최소 피로도 80, 소모 피로도 20
    //
}