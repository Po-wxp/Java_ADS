package Search;

public class SequenceSearch {

    public static void main(String[] args) {
        int[] arr = {1,3,4,6,-2,23};
        int result = search(arr,-2);

        if(result != -1){
            System.out.println("Congratulation! You find the data, the index is "+result);
        }else{
            System.out.println("Sorry, data cannot be found");
        }
    }

    public static int search(int[] arr, int n){
        for (int i = 0; i < arr.length; i++) {
            if(arr[i]==n){
                return i;
            }
        }
        return -1;
    }
}
