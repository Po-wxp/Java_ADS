package Search;

import java.util.ArrayList;

public class BinarySearch {

    public static void main(String[] args) {
        int[] arr = {1,3,3,3,4,10,34,66};
        ArrayList<Integer> result = BinarySearch(arr,0, arr.length-1, 3);
        if(result.size() != 0){
            System.out.println("Congratulation! You find the data, the index is "+result);
        }else{
            System.out.println("Sorry, data cannot be found");
        }

    }
    public static ArrayList<Integer> BinarySearch(int[] arr, int left, int right, int n){
        int midIndex = (left+right)/2;
        int mid = arr[midIndex];
        if(left > right) {
            return new ArrayList<Integer>();
        }
        if(n > mid) {
            return BinarySearch(arr,midIndex+1,right,n);
        }else if(n < mid){
            return BinarySearch(arr,left,midIndex-1,n);
        }else {
            ArrayList<Integer> list = new ArrayList<>();
            int tempIndex = midIndex - 1;
            while(tempIndex >= left && arr[tempIndex] == n){
                tempIndex--;
            }
            tempIndex++;
            while(tempIndex <= right && arr[tempIndex] == n){
                list.add(tempIndex);
                tempIndex++;
            }
            return list;
        }
    }
}
