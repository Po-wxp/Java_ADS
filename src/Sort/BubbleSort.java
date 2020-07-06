package Sort;

import java.text.SimpleDateFormat;
import java.util.Date;

public class BubbleSort {
    private static int[] arr = new int[80000];

    public static void main(String[] args) {
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int)(Math.random() * 800000);
        }
        Date date = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-mm-dd HH:mm:ss");
        String d = dateFormat.format(date);

        BubbleSort bubbleSort = new BubbleSort();

        System.out.println("Begin time: "+ d);
        bubbleSort.sort();

        Date date2 = new Date();
        String d2 = dateFormat.format(date2);
        System.out.println("Begin time: "+ d2);
//        System.out.println(Arrays.toString(bubbleSort.arr));
    }
    public void sort(){
        int temp = 0;
        boolean flag = false;
        for (int i = 0; i < arr.length-1; i++) {
            flag = false;
            for(int j=0;j< arr.length-1-i;j++){
                if(arr[j]>arr[j+1]){
                    flag = true;
                    temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
            if(!flag) break;
        }
    }

}
