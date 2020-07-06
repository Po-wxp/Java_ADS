package Sort;

import java.text.SimpleDateFormat;
import java.util.Date;

public class SelectionSort {

    public static void main(String[] args) {
        int[] arr = new int[80000];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int)(Math.random() * 800000);
        }
        Date date = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-mm-dd HH:mm:ss");
        String d = dateFormat.format(date);

        System.out.println("Begin time: "+ d);
        sort(arr);

        Date date2 = new Date();
        String d2 = dateFormat.format(date2);
        System.out.println("Begin time: "+ d2);


//        sort.sort();
//        System.out.println(Arrays.toString(sort.arr));
    }

    public static void sort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            int minIndex = i;
            int min = arr[i];
            for (int j = i + 1; j < arr.length; j++) {
                if (min > arr[j]) {
                    min = arr[j];
                    minIndex = j;
                }
            }
            if (minIndex != i) {
                arr[minIndex] = arr[i];
                arr[i] = min;
            }
        }
    }
}
