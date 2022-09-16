import java.util.Arrays;

public class task2 {
    static int[] remove(int[] arr, int num) {

        int[] newArr = arr;
        int size = arr.length;

        for (int i = arr.length -1; i >= 0; i--) {
            if (arr[i] == num) {
                size--;
                for (int j = i; j< arr.length -1 ; j++) newArr[j] = newArr[j+1];
            }

        }
        return Arrays.copyOf(newArr,size);
    }
    public static void main(String[] args) {
        int[] testArr = remove(new int[]{ 1, 2, 3, 4 },2);
        int[] testArr2 = remove(new int[]{1,2,5,3,5,3,2,2,4,2},2);
        int[] testArr3 = remove(new int[]{1,3,2,3,3,4},3);

        System.out.println(testArr.length + ", testArr = " + Arrays.toString(testArr));
        System.out.println(testArr2.length + ", testArr2 = " + Arrays.toString(testArr2));
        System.out.println(testArr3.length + ", testArr3 = " + Arrays.toString(testArr3));
    }
}
