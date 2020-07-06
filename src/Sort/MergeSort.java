package Sort;

import java.text.SimpleDateFormat;
import java.util.Date;

public class MergeSort {
    public static void main(String[] args) {
//        int[] arr = {8,4,5,7,1,3,6,2};
//        int[] temp = new int[arr.length];
//
//        mergeSort(arr,0, arr.length-1,temp);
//
//        System.out.println(Arrays.toString(temp));

        int[] arr = new int[8000000];
        int[] temp = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int)(Math.random() * 80000000);
        }
        Date date = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-mm-dd HH:mm:ss");
        String d = dateFormat.format(date);

        System.out.println("Begin time: "+ d);
        mergeSort(arr,0,arr.length-1,temp);

        Date date2 = new Date();
        String d2 = dateFormat.format(date2);
        System.out.println("end time: "+ d2);

    }

    public static void mergeSort(int[] arr, int left, int right, int[] temp){
        if(left<right){
            int mid = (left+right)/2;
            mergeSort(arr,left,mid,temp);
            mergeSort(arr,mid+1,right,temp);
            merge(arr,left,mid,right,temp);
        }
    }

    public static void merge(int[] arr, int left, int mid, int right,int[] temp){
        int l = left;
        int r = mid+1;
        int tempIndex = 0;

        while(l<=mid && r<=right){
            if(arr[l]<=arr[r]){
                temp[tempIndex] = arr[l];
                l++;
            }else{
                temp[tempIndex] = arr[r];
                r++;
            }
            tempIndex++;
        }

        while(l<=mid){
            temp[tempIndex] = arr[l];
            l++;
            tempIndex++;
        }

        while(r<=right){
            temp[tempIndex] = arr[r];
            r++;
            tempIndex++;
        }

        int tempLeft = left;
        int index = 0;

        while(tempLeft<=right){
            arr[tempLeft] = temp[index];
            tempLeft++;
            index++;
        }

    }
}
