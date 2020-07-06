package Search;

import java.util.Arrays;

public class FibSearch {

    public static void main(String[] args) {
        int[] arr = {1,8,10, 89, 1000, 1024};
        int result = fibSearch(arr, 1024);
        System.out.println("index=" + result);
    }

    public static int[] generateArray (int length){
        int[] arr = new int[length];
        arr[0] = 1;
        arr[1] = 1;
        for (int i = 2; i<length; i++){
            arr[i] = arr[i-1] + arr[i-2];
        }
        return arr;
    }
    public static int fibSearch(int[] arr, int key){
        int k = 0;
        int left = 0;
        int right = arr.length -1;
        int[] fibArr = generateArray(10);
        while(right > fibArr[k]-1){
            k++;
        }
        int[] temp = Arrays.copyOf(arr, fibArr[k]-1);
        for (int i = right + 1; i<temp.length; i++){
            temp[i] = arr[right];
        }
        while (left <= right){
            int mid = left + fibArr[k-1] - 1;
            if(key > temp[mid]) {
                left = mid + 1;
                k -= 2;
            }else if (key < temp[mid]){
                right = mid - 1;
                k --;
            }else {
                if(mid <= right){
                    return mid;
                }
                return right;
            }
        }
        return -1;
    }
}
