package practice;

import java.util.Arrays;

public class matrix {
    public static void main(String[] args) {
        int [][] matrix = new int [4][4];
        for (int i = 0; i < matrix.length-1; i++) {
            for (int j = 0; j < matrix.length-1; j++) {
                matrix[i][j] = 0;
                if(matrix[i] == matrix[j]){
                    matrix[i][j] = 1;
                }
                System.out.print(matrix[i][j] +" ");
            }
            System.out.println();
        }
    }
}
