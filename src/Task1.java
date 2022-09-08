import java.util.Arrays;

public class Task1 {
    public static void main(String[] args) {
        MySet x = new MySet();
        x.add(11);
        x.add(12);
        x.add(13);
        x.add(14);
        x.add(15);
        x.remove(11);
        x.remove(12);
        System.out.println(x.contains(11));
        System.out.println(x.contains(13));
        System.out.println(Arrays.toString(x.arr));
        System.out.println(x.arr.length);
    }
    //set<Integer> x = new HashSet<>();
//    MySet x = new MySet();
//        x.add(11);
//        x.add(12);
//        System.out.println(x.size());
//        System.out.println(Arrays.toString(x.arr));
}
