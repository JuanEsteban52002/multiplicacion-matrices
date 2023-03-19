package algoritmos;

public class NaivLoopUnrollingTwo {

	//Metodo 4
	public static int[][] naivLoopUnrollingTwo(int[][] A, int[][] B) {
		int m = A.length;
		int n = A[0].length;
		int p = B[0].length;
		int[][] C = new int[m][p];
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < p; j++) {
				int sum = 0;
				for (int k = 0; k < n; k += 2) {
					sum += A[i][k] * B[k][j];
					sum += A[i][k + 1] * B[k + 1][j];
				}
				C[i][j] = sum;
			}
		}
		return C;
	}
}
