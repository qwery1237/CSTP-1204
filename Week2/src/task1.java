import java.util.Arrays;

public class task1 {
    static int[] addOne(int[] arr) {
        int arrNum = 0;
        for (int el: arr) {
            arrNum *= 10;
            arrNum += el;
        }
        arrNum++;
        String numToString = Integer.toString(arrNum);
        int newArr[] = new int[numToString.length()];
        for (int i = 0; i < newArr.length; i++) {
            newArr[i] = Integer.parseInt(String.valueOf(numToString.charAt(i)));
        }
        return newArr;
    }
    public static void main(String[] args) {
        int[] testArr = { 9, 9, 9 };
        int[] testArr2 = { 1, 2, 3 };
        int[] testArr3 = { 4, 3, 2, 1 };
        System.out.println(Arrays.toString(addOne(testArr)));
        System.out.println(Arrays.toString(addOne(testArr2)));
        System.out.println(Arrays.toString(addOne(testArr3)));
    }
}
