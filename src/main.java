import java.math.BigDecimal;
import java.util.*;


public class Main
{
    public static int M;
    public static int N;
    public static int K;
    public static int[] arr;

    public static void main(String args[])
    {
        int itemsBought = 0;
        int funds = 100;
        for (int price = 10; funds >= price; price += 10) {
            funds -= price;
            itemsBought++;
        }
        System.out.println(itemsBought + "개 구입");
        System.out.println("잔돈(센트): " + funds);
    }
}