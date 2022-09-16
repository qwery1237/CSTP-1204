import java.util.ArrayList;
import java.util.Arrays;
public class MySet {
    int [] arr;

    int size;
    MySet(){
        size = 0;
        arr = new int[]{};
    }
    void add(int a){
        arr = Arrays.copyOf(arr, ++size);
        for (int i = 0; i < size; i++)
            if(arr[i] == a)
                return;
        arr[size -1] = a;
    }
    int size(){
        return size;
    }
    void remove(int target) {
        for (int i = 0; i < size; i++) {
            if(arr[i]==target) {

                for(int j = i; j < size -1 ; j++)
                    arr[j] = arr[j + 1];
                arr = Arrays.copyOf(arr, --size);
            }
        }
    }
    boolean contains(int target){
        for (int i = 0; i < size; i++) {
            if(arr[i]==target)
                return true;
        }
        return false;
    }
}
