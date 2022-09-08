import java.util.Arrays;


public class HelloWorld {
    static void f1(){
        System.out.println("f1 has been executed!");
    }
    public static void main(String[] args) {
        System.out.println("Hi, this is my first code in Java!");

        f1();

        int x = 5;
        char y = 't';

        String z = "swfeijljesf";
        Integer xx = 15;

        System.out.println(z.length());
        System.out.println(xx.equals(15));
        System.out.println();

        boolean t = false;
        if (t)
            System.out.println(" t is true");
        else
            System.out.println("t is false");

        for (int i = 0; i < 10; i++)
            System.out.println(i);

        int i = 0;
        while (i < 10)
            System.out.println(i++);
    }
}

