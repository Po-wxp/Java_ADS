package Sort;

import java.text.SimpleDateFormat;
import java.util.Date;

public class QuickSort {
    public static void main(String[] args) {
//        int[] arr = {-9,78,0,23,-567,70};
//        sort(arr,0,5);
//        System.out.println(Arrays.toString(arr));

        int[] arr = new int[8000000];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int)(Math.random() * 80000000);
        }
        Date date = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-mm-dd HH:mm:ss");
        String d = dateFormat.format(date);

        System.out.println("Begin time: "+ d);
        sort(arr,0,79999);

        Date date2 = new Date();
        String d2 = dateFormat.format(date2);
        System.out.println("end time: "+ d2);
    }

    public static void sort(int[] arr, int left, int right){
        int l = left;
        int r = right;
        int pivot = arr[(l+r)/2];
        int temp;
        while(l < r){
            while(arr[l]<pivot){
                l++;
            }
            while(arr[r]>pivot){
                r--;
            }
            if(l >= r) break;
            temp = arr[l];
            arr[l] = arr[r];
            arr[r] = temp;

            if(arr[l] == pivot){
                r--;
            }

            if(arr[r] == pivot){
                l++;
            }
        }

        if( l == r){
            l++;
            r--;
        }

        if(left<r){
            sort(arr,left, r);
        }

        if(l<right){
            sort(arr,l, right);
        }
    }
}
