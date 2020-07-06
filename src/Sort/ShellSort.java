package Sort;

import java.text.SimpleDateFormat;
import java.util.Date;

public class ShellSort {

    public static void main(String[] args) {
//        int[] arr = {8,9,1,7,2,3,5,4,6,0};
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

//    public static void sort(int[] arr) {
//        int temp = 0;
//        for (int k = arr.length/2; k>=1; k /= 2){
//            for(int i = k; i<arr.length;i++){
//                for(int j=i-k; j>=0; j -= k){
//                    if(arr[j]>arr[j+k]){
//                        temp = arr[j];
//                        arr[j] = arr[j+k];
//                        arr[j+k] = temp;
//                    }
//                }
//            }        System.out.println(Arrays.toString(arr));
//
//        }
//    }

    public static void sort(int[] arr) {
        for (int gap = arr.length/2; gap>=1; gap /= 2){
            for (int i = gap; i < arr.length; i++) {
                int pos = i;
                int temp = arr[i];
                while (pos-gap >= 0 && arr[pos-gap] > temp){
                    arr[pos] = arr[pos-gap];
                    pos -= gap;
                }
                arr[pos] = temp;
            }
        }
    }
}
