package Search;

public class InsertValueSearch {
    public static void main(String[] args) {
        int[] arr = new int[100];
        for (int i = 0; i < 100; i++) {
            arr[i] = i+1;
        }
        int result = insertValueSearch(arr, 0, arr.length-1, 100);
        if(result != -1){
            System.out.println("Congratulation! You find the data, the index is "+result);
        }else{
            System.out.println("Sorry, data cannot be found");
        }
    }

    public static int insertValueSearch(int[] arr, int left, int right, int searchValue){
        if(left > right || searchValue < arr[0] || searchValue > arr[arr.length-1]){
            return -1;
        }

        int midIndex = left + (right - left) * (searchValue - arr[left]) / (arr[right] - arr[left]);
        int mid = arr[midIndex];

        if(searchValue > mid) {
            return insertValueSearch(arr,midIndex+1,right,searchValue);
        }else if (searchValue < mid){
            return insertValueSearch(arr, left, mid-1, searchValue);
        }else {
            return midIndex;
        }
    }
}
