import java.util.ArrayList;
import java.util.Scanner;

public class problem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int x = scanner.nextInt();
        int k = scanner.nextInt();

        int count = 0;
        int number = 0;
        int max = 0;
        int position = 0;
        boolean result = false;

        List<Integer> tmp = new ArrayList<>();
        List<Integer> arrayList = new ArrayList<>();

        for (int i = 0; i < k; i++) {
            arrayList.add(scanner.nextInt());
        }

        for (int i = 0; i < k; i++) {
            if (tmp.size() < x) {
                if (tmp.contains(arrayList.get(i))) {
                    continue;
                } else {
                    tmp.add(arrayList.get(i));
                }
            } else {
                for (int j = 0; j < x; j++) {
                        arrayList.indexOf()
                }

            }
        }
        System.out.println(count);
    }
}
