package algo.dp;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

import static org.junit.Assert.assertEquals;

/**
 * Problem Statement: ""
 *
 * @author Alimuddin Khan (aak5031@rit.edu)
 * @version on 11/2/17
 */
@RunWith(MockitoJUnitRunner.class)
public class MatrixChainMultiplicationTest {

    @Test
    public void shouldFIndMinCOstMatrixChainMultiplication() {
        final int[] matrixDimensions =  {1, 2, 3, 4};
        assertEquals(18, MatrixChainMultiplication.getMinCostMatrixChainMultiplication(matrixDimensions));
        assertEquals(18, MatrixChainMultiplication.getMinCostMatrixChainMultiplication2(matrixDimensions));
        assertEquals(18, MatrixChainMultiplication.getMinCostMatrixChainMultiplication3(matrixDimensions));
    }
}
