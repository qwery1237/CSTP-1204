import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class lab8 {
    static void vertical_numbers_recursive(int n){
        if(n>=10) vertical_numbers_recursive(n / 10);
        System.out.println(n % 10);
    }
    static void vertical_numbers_iterative(int n) {
        int X = (int) Math.pow(10,Integer.toString(n).length()-1);

        while(n !=0){
            System.out.println(n / X);
            n %= X;
            X /= 10;
        }
    }
    static int fibonacci_recursive(int n){
        if (n == 0 || n == 1) return n;
        return fibonacci_recursive(n-1) + fibonacci_recursive( n-2);

    }
    static int fibonacci_iterative(int n) {
        if (n == 0||n == 1) return n;
        Queue<Integer> sum = new LinkedList<>();
        for (int i = 0; i <=n; i++) {
            if (i == 0||i == 1) {
                sum.add(i);
            }else {
                sum.add(sum.remove()+sum.peek());
            }
        }
        sum.remove();
        return sum.peek();
    }

    public static void main(String[] args) {
        int x = 1234;
        //vertical_numbers_recursive(x);
        //vertical_numbers_iterative(x);
        //System.out.println(fibonacci_recursive(19));
        System.out.println(fibonacci_iterative(19));
    }
}
