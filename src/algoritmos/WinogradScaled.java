package algoritmos;

import utilidades.Utilidades;

public class WinogradScaled {


	//Metodo 8

	public static void winogradScaled(int[][] A, int[][] B, int[][] Result, int N, int P, int M) {
		// Create scaled copies of A and B
		int[][] CopyA = new int[N][P];
		int[][] CopyB = new int[P][M];
		// Scaling factors
		int a = NormInf(A, N, P);
		int b = NormInf(B, P, M);
		int lambda = (int) Math.floor(0.5 + Math.log(b/a)/Math.log(4));
		// Scaling
		MultiplyWithScalar(A, CopyA, N, P, (int) Math.pow(2, lambda));
		MultiplyWithScalar(B, CopyB, P, M, (int) Math.pow(2, -lambda));
		// Using Winograd with scaled matrices
		WinogradOriginal(CopyA, CopyB, Result, N, P, M);
	}

	public static int NormInf(int[][] A, int N, int M) {
		int maxNorm = Integer.MIN_VALUE;
		for (int i = 0; i < N; i++) {
			int rowNorm = 0;
			for (int j = 0; j < M; j++) {
				rowNorm += Math.abs(A[i][j]);
			}
			maxNorm = Math.max(maxNorm, rowNorm);
		}
		return maxNorm;
	}

	public static void MultiplyWithScalar(int[][] A, int[][] Result, int N, int M, int scalar) {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				Result[i][j] = A[i][j] * scalar;
			}
		}
	}

	public static void WinogradOriginal(int[][] A, int[][] B, int[][] Result, int N, int P, int M) {
		int i, j, k;
		int[] rowFactor = new int[N];
		int[] colFactor = new int[M];
		// Calculate row and column factors
		for (i = 0; i < N; i++) {
			rowFactor[i] = 0;
			for (k = 0; k < P - 1; k += 2) {
				rowFactor[i] += A[i][k] * A[i][k + 1];
			}
		}
		for (j = 0; j < M; j++) {
			colFactor[j] = 0;
			for (k = 0; k < P - 1; k += 2) {
				colFactor[j] += B[k][j] * B[k + 1][j];
			}
		}
		// Calculate result
		for (i = 0; i < N; i++) {
			for (j = 0; j < M; j++) {
				Result[i][j] = -rowFactor[i] - colFactor[j];
				for (k = 0; k < P - 1; k += 2) {
					Result[i][j] += (A[i][k] + B[k + 1][j]) * (A[i][k + 1] + B[k][j]);
				}
			}
		}
		// If P is odd, add the last column of A to the result
		if (P % 2 == 1) {
			for (i = 0; i < N; i++) {
				for (j = 0; j < M; j++) {
					Result[i][j] += A[i][P - 1] * B[P - 1][j];
				}
			}
		}
//	    Utilidades.guardarMatriz(Result, "./src/resultados/MatrizResultado(winogradScaled).txt");
	}
}
