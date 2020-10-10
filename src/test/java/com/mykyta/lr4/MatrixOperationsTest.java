package com.mykyta.lr4;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class MatrixOperationsTest {

    //MatrixOperations validation tests

    @Test(expected = IllegalArgumentException.class)
    public void testNullMatrix(){
        new MatrixOperations(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testEmptyMatrix(){
        new MatrixOperations(new int[0][0]);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testMatrixWithWrongSize(){
        new MatrixOperations(new int[][]{
                new int[]{1,2},
                new int[]{0}
        });
    }

    @Test(expected = IllegalArgumentException.class)
    public void testMatrixWithNullRows(){
        new MatrixOperations(new int[][]{
                null,
                new int[]{1,2}
        });
    }

    @Test(expected = IllegalArgumentException.class)
    public void testMatrixWithEmptyRows(){
        new MatrixOperations(new int[][]{
                new int[]{},
                new int[]{1,2}
        });
    }

    //MatrixOperations.countSpecialElements Tests

    @Test
    public void testMatrixWith0SpecialNumbers(){
        MatrixOperations ops = new MatrixOperations(new int[][]{
                new int[]{0, 1, 2, 3},
                new int[]{2, 4, 4, 5},
                new int[]{2, 5, 2, 8},
        });
        Assert.assertEquals(0, ops.countSpecialElements());
    }

    @Test
    public void testMatrixWith2SpecialNumbers(){
        MatrixOperations ops = new MatrixOperations(new int[][]{
                new int[]{0, 1, 2, 3},
                new int[]{2, 3, 4, 5},
                new int[]{6, 5, 2, 8},
        });
        Assert.assertEquals(2, ops.countSpecialElements());
    }

    @Test
    public void testMatrixWithSpecialNumbersInAllColumns(){
        MatrixOperations ops = new MatrixOperations(new int[][]{
                new int[]{0, 1, 2, 3},
                new int[]{2, 3, 5, 1},
                new int[]{6, 5, 2, 8},
        });
        Assert.assertEquals(4, ops.countSpecialElements());
    }

    //MatrixOperations.maxColumnIndex Tests
    @Test
    public void testMatrixWithMaxElementsSumInFirstColumn(){
        MatrixOperations ops = new MatrixOperations(new int[][]{
                new int[]{8, 1, 2, 3},
                new int[]{2, 3, 5, 1},
                new int[]{6, 5, 0, 0},
        });
        Assert.assertEquals(0, ops.maxColumnIndex());
    }

    @Test
    public void testMatrixWithMaxElementsSumInThirdColumn(){
        MatrixOperations ops = new MatrixOperations(new int[][]{
                new int[]{0, 1, 9, 3},
                new int[]{2, 3, 5, 1},
                new int[]{6, 5, 9, 8},
        });
        Assert.assertEquals(2, ops.maxColumnIndex());
    }

    @Test
    public void testMatrixWithMaxElementsSumInLastColumn(){
        MatrixOperations ops = new MatrixOperations(new int[][]{
                new int[]{0, 1, 2, 9},
                new int[]{2, 3, 5, 1},
                new int[]{6, 5, 2, 8},
        });
        Assert.assertEquals(3, ops.maxColumnIndex());
    }

    @Test
    public void testMatrixWithEqualElementsSumInAllColumns(){
        MatrixOperations ops = new MatrixOperations(new int[][]{
                new int[]{0, 1, 1, 0},
                new int[]{2, 2, 5, 0},
                new int[]{6, 5, 2, 8},
        });
        Assert.assertEquals(0, ops.maxColumnIndex());
    }

}
