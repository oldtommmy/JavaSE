package Arrays_.sortArray;

import java.util.Arrays;
import java.util.Collections;

public class DescendingSort {
    public static void main(String[] args) {
        Integer[] a = {23,444,32,1,434,66,3,23};
        Arrays.sort(a, Collections.reverseOrder());

        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i]+" ");
        }
    }
}

//class MyCollections implements Comparable<Integer>{
//    @Override
//    public int compareTo(Integer a,Integer b) {
//        return a > b ? 1:-1;
//    }
//}
