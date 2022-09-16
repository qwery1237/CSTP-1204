import java.util.Arrays;

public class task2 {
    static String[] remove(int[] arr, int num) {

        String[] strArr = new String[arr.length];

        for (int i = 0; i < arr.length; i++) {
            strArr[i] = String.valueOf(arr[i]);
        }

        for (int i = arr.length -1; i >= 0; i--) {
            if (arr[i] == num){
                for (int j = i; j< arr.length; j++){
                    if (j == arr.length -1) strArr[j] = "_";
                    else strArr[j] = strArr[j+1];
                }
            }

        }
        return strArr;
    }
    public static void main(String[] args) {
        int[] testArr = {1,2,3,4};
        int[] testArr2 = {1,2,5,3,5,3,2,2,4,2};
        int[] testArr3 = {1,3,2,3,3,4};

        System.out.println(Arrays.toString(remove(testArr,2)));
        System.out.println(Arrays.toString(remove(testArr2,2)));
        System.out.println(Arrays.toString(remove(testArr3,3)));
    }
}
