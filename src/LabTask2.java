public class LabTask2 {
    static int[] duplicate(int[] arr) {
        int [] newArr = arr;
        for (int i = 0; i < newArr.length; i++) {
            if (newArr[i] == 0) {
                for (int j = i + 1; j < newArr.length - 1; j++) {
                    newArr[j + 1] = newArr[j];
                }
                newArr[i+1] = 0;
            }
        }
        return newArr;
    }
    public static void main(String[] args) {

    }
}
