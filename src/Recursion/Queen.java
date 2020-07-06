package Recursion;

public class Queen {

    private int max = 8;
    private int[] arr = new int[max];
    private static int count;
    private static int checkTimes;

    public static void main(String[] args) {
        Queen queen = new Queen();
        queen.generate(0);

        System.out.println("Total:"+count);
        System.out.println("CheckTimes:"+checkTimes);

    }

    public void generate(int n){
        if(n == max){
            print();
            return;
        }

        for (int i = 0; i < max; i++) {
            arr[n] = i;
            if(check(n)){
                generate(n+1);
            }
        }
    }

    public boolean check(int i){
        checkTimes++;
        for (int j = 0; j < i; j++) {
            if(arr[j] == arr[i] || Math.abs(i-j) ==  Math.abs(arr[i]-arr[j])){
                return false;
            }
        }
        return true;
    }

    public void print(){
        count++;
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]+"\t");
        }
        System.out.println();
    }
}
