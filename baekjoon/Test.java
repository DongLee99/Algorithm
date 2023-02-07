public class Test{
    static long sum(int[] a){
        int length = a.length;
        long sum = 0;
        for(int i = 0; i < length; i++){
            sum = sum + a[i];
        }
        return sum;
    }
    public static void main(String[] args) {
        int a[] = {1,2,3,4,5,6};
        System.out.print(sum(a));
    }}