package com.mykyta.lr4;

public class Main {

    public static void main(String[] args) {
        int[][] f = new int[][]{
                new int[]{0, 1, 2, 3},
                new int[]{2, 3, 4, 5},
                new int[]{6, 5, 2, 8},
        };

        System.out.println(new MatrixOperations(f).countSpecialElements());
    }
}
