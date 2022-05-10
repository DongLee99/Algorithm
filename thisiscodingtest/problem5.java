import java.io.*;

public class problem {
    public static void main(String[] args) throws IOException {
        int count = 0;
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bf.readLine());
        for (int i = 0; i <= N; i++) {
            for (int j = 0; j <= 59; j++) {
                for (int k = 0; k <= 59; k++) {
                    String buffer = String.valueOf(i) + String.valueOf(j) + String.valueOf(k);
                    if (buffer.contains("3")) {
                        count++;
                    };
                }
            }
        }
        System.out.println(count);
    }
}