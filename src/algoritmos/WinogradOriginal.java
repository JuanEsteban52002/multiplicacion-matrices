package algoritmos;

import utilidades.Utilidades;

public class WinogradOriginal {

	public void winogradOriginal(int[][] A, int[][] B) {
		int n = A.length;
		int[][] C = new int[n][n];

		// Calcular las constantes de Winograd
		int[] rowFactors = new int[n];
		int[] colFactors = new int[n];
		for (int i = 0; i < n; i++) {
			rowFactors[i] = A[i][0] * A[i][1];
			colFactors[i] = B[0][i] * B[1][i];
			for (int j = 1; j < n / 2; j++) {
				int idx = j * 2;
				rowFactors[i] += A[i][idx] * A[i][idx + 1];
				colFactors[i] += B[idx][i] * B[idx + 1][i];
			}
		}

		// Calcular el producto de matrices usando las constantes de Winograd
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				int dotProduct = 0;
				for (int k = 0; k < n / 2; k++) {
					int idx1 = k * 2;
					int idx2 = idx1 + 1;
					dotProduct += (A[i][idx1] + B[idx2][j]) * (A[i][idx2] + B[idx1][j]);
				}
				C[i][j] = dotProduct - rowFactors[i] - colFactors[j] + A[i][n-1] * B[n-1][j];
			}
		}
//		Utilidades.imprimirMatriz(C);
	}





}
