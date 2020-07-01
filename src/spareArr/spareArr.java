package spareArr;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class spareArr {

    public static void main(String[] args) {
        int[][] arr = new int[11][11];
        arr[1][2] = 1;
        arr[2][3] = 2;

        for(int[] row : arr) {
            for(int data : row){
                System.out.printf("%d\t",data);
            }
            System.out.println();
        }

        int sum = 0;
        for(int[] row : arr) {
            for(int data : row){
                if (data!=0) sum++;
            }
        }
        int[][] spareArr = new int[sum+1][3];
        spareArr[0][0] = 11;
        spareArr[0][1] = 11;
        spareArr[0][2] = sum;

        int row = 1;
        for(int i=0;i<arr.length;i++) {
            for(int j=0;j<arr[0].length;j++) {
                if(arr[i][j]!=0) {
                    spareArr[row][0] = i;
                    spareArr[row][1] = j;
                    spareArr[row][2] = arr[i][j];
                    row++;
                }
            }
        }

        for(int[] r : spareArr) {
            for(int data : r){
                System.out.printf("%d\t",data);
            }
            System.out.println();
        }

        //save data
        try {
            FileWriter fw = new FileWriter("map.data");
            BufferedWriter bw = new BufferedWriter(fw);
            for(int i=0;i<spareArr.length;i++) {
                String out = String.format("%d\t%d\t%d\n", spareArr[i][0], spareArr[i][1], spareArr[i][2]);
                bw.write(out);
            }
            bw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        int[][] arr2 = new int[spareArr[0][0]][spareArr[0][1]];

        for(int i =1; i<spareArr.length;i++) {
            arr2[spareArr[i][0]][spareArr[i][1]] = spareArr[i][2];
        }

        for(int[] r : arr2) {
            for(int data : r){
                System.out.printf("%d\t",data);
            }
            System.out.println();
        }
    }

}
