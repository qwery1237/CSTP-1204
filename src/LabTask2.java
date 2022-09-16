import java.util.Arrays;

public class LabTask2 {
    static int[] duplicate(int[] arr) {
        int [] newArr = arr;
        for (int i = newArr.length -1; i >= 0; i--) {
            if (newArr[i] == 0) {
                for (int j = newArr.length -1 ; j > i; j--)
                    newArr[j] = newArr[j - 1];
            }
        }
        return newArr;
    }
    public static void main(String[] args) {
        int [] arr = {1,0,2,3,0,4,5,0};
        int [] arr2 = {1,2,3};
        arr = duplicate(arr);
        arr2 = duplicate(arr2);

        System.out.println(Arrays.toString(arr));
        System.out.println(Arrays.toString(arr2));
    }
}
