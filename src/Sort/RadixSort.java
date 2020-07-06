package Sort;

import java.util.Arrays;

public class RadixSort {

    public static void main(String[] args) {
        int[] arr = {53,3,542,748,14,214};
        sort(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static void sort(int[] arr){
        int[][] buckets = new int[10][arr.length];
        int[] bucketIndex = new int[10];
        int max = arr[0];

        for (int i = 1; i < arr.length; i++) {
            if(arr[i]>max) max = arr[i];
        }
        int maxLength = (max+"").length();

        for (int i = 0; i < maxLength; i++) {
            int n = (int)Math.pow(10,i);
            for (int j = 0; j < arr.length; j++) {
                int module = arr[j]/n%10;
                buckets[module][bucketIndex[module]] = arr[j];
                bucketIndex[module]++;
            }
            int index = 0;
            for (int k = 0; k < buckets.length; k++) {
                for (int j = 0; j < bucketIndex[k]; j++) {
                    arr[index] = buckets[k][j];
                    index++;
                }
                bucketIndex[k] = 0;
            }
        }
    }
}
