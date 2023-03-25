package algoritmos;

import utilidades.Utilidades;

public class NaivOnArray {

	public void naivOnArray(int[][] A, int[][] B, int[][] Result, int N, int P, int M) {


		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				Result[i][j] = 0;
				for (int k = 0; k < P; k++) {
					Result[i][j] += A[i][k]*B[k][j];
				}
			}
		}
//		Utilidades.imprimirMatriz(Result);
	}
	

	

}
