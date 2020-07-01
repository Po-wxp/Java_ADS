package Recursion;

public class MGong {

    public static void main(String[] args) {
        int[][] migong = new int[8][7];
        for (int i = 0; i < migong.length; i++) {
            migong[i][0] = 1;
            migong[i][6] = 1;
        }

        for (int i = 0; i < migong[0].length; i++) {
            migong[0][i] = 1;
            migong[7][i] = 1;
        }

        migong[3][1] = 1;
        migong[3][2] = 1;

        for (int[] arr : migong){
            for (int i : arr){
                System.out.print(i+"\t");
            }
            System.out.println();
        }

        System.out.println();
        setRoad(migong,1,1);
        for (int[] arr : migong){
            for (int i : arr){
                System.out.print(i+"\t");
            }
            System.out.println();
        }



    }
    public static boolean setRoad(int[][] map, int x, int y) {
        if (map[6][5] == 2) {
            return true;
        } else {
            if (map[x][y] == 0) {
                map[x][y] = 2;
                if (setRoad(map, x + 1, y)) {
                    return true;
                } else if (setRoad(map, x, y + 1)) {
                    return true;
                } else if (setRoad(map, x - 1, y)) {
                    return true;
                } else if (setRoad(map, x, y - 1)) {
                    return true;
                } else {
                    map[x][y] = 3;
                    return false;
                }
            }else {
                return false;
            }
        }

    }
}
