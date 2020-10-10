package com.mykyta.lr4;

import org.apache.commons.lang3.ArrayUtils;

public class MatrixOperations {

    int[][] matrix;
    int n; //columns num
    int m; //rows num

    public MatrixOperations(int[][] matrix) {
        checkMatrix(matrix);
        this.matrix = matrix;
        n = matrix[0].length;
        m = matrix.length;
    }

    public int countSpecialElements(){
        int specElementsCount = 0;
        for (int j = 0; j < n; j++){
            int sum = sumOfColumnElements(j);
            for (int i = 0; i < m; i++){
                if(sum - matrix[i][j] < matrix[i][j]){
                    specElementsCount++;
                }
            }
        }
        return specElementsCount;

    }

    //In case if some rows sums are equals and this sums is max returns first max row index
    public int maxColumnIndex(){
        int indxOfMax = 0;
        int maxSum = sumOfColumnElements(0);
        for(int j = 1; j < n; j++){
            int sum = sumOfColumnElements(j);
            if(maxSum < sum){
                indxOfMax = j;
                maxSum = sum;
            }
        }
        return indxOfMax;
    }

    private int sumOfColumnElements(int columnNum){
        int sum = 0;
        for (int i = 0; i < m; i++){
            sum += matrix[i][columnNum];
        }
        return sum;
    }

    private void checkMatrix(int[][] matrix){
        if(matrix == null){
            throw new IllegalArgumentException("Matrix can`t be null");
        }
        if (matrix.length == 0) {
            throw new IllegalArgumentException("Matrix is empty");
        }

        int firstColumnLength = matrix[0] != null ? matrix[0].length : 0;
        for(int[] vector : matrix){
            if(ArrayUtils.isEmpty(vector)){
                throw new IllegalArgumentException("Matrix row is empty");
            }
            if(vector.length != firstColumnLength){
                throw new IllegalArgumentException("Unsupported matrix size");
            }
        }
    }
}
