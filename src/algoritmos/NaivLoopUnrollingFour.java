package algoritmos;

public class NaivLoopUnrollingFour {

	
	public static int[][] naivLoopUnrollingFour(int[][] matrix1, int[][] matrix2) {
		int rowsA = matrix1.length;
		int colsA = matrix1[0].length;
		int colsB = matrix2[0].length;

		int[][] result = new int[rowsA][colsB];

		for (int i = 0; i < rowsA; i++) {
			for (int j = 0; j < colsB; j += 4) {
				int sum1 = 0, sum2 = 0, sum3 = 0, sum4 = 0;
				for (int k = 0; k < colsA; k++) {
					sum1 += matrix1[i][k] * matrix2[k][j];
					sum2 += matrix1[i][k] * matrix2[k][j + 1];
					sum3 += matrix1[i][k] * matrix2[k][j + 2];
					sum4 += matrix1[i][k] * matrix2[k][j + 3];
				}
				result[i][j] = sum1;
				result[i][j + 1] = sum2;
				result[i][j + 2] = sum3;
				result[i][j + 3] = sum4;
			}
		}

		return result;
	}
}
