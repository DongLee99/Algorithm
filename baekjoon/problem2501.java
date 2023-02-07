
public class problem2{

    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int x = scanner.nextInt();
        int y = scanner.nextInt();
        int count = 0;
        boolean result = false;

        for (int i = 1; i <= x; i ++) {
            if (x % i == 0) {
                count++;
                if (count == y) {
                    System.out.println(i);
                    result = true;
                }
            }
        }
        if (result == false) {
            System.out.println(0);
        }
    }
}