package Sort;

import java.text.SimpleDateFormat;
import java.util.Date;

public class InsertSort {

    public static void main(String[] args) {
//        int[] arr = {101,34,119,1};
//        sort(arr);
//        System.out.println(Arrays.toString(arr));

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
    }

    public static void sort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int insertValue = arr[i];
            int insertIndex = i-1;

            while(insertIndex>=0 && insertValue < arr[insertIndex]){
                arr[insertIndex+1] = arr[insertIndex];
                insertIndex--;
            }
            if(insertIndex+1 != i){
                arr[insertIndex+1] = insertValue;
            }
        }
    }

//    public static void sort(int[] arr){
//        for (int i = 1; i < arr.length; i++) {
//            int insertValue = arr[i];
//            int insertIndex = 0;
//
//            for (int j = 0; j < i; j++) {
//                if(insertValue>arr[j]){
//                    insertIndex = j+1;
//                }
//            }
//            if(insertIndex != i){
//                for(int k = i; k>insertIndex;k--){
//                    arr[k] = arr[k-1];
//                }
//                arr[insertIndex] = insertValue;
//            }
//        }
//    }

}
