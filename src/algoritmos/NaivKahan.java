package algoritmos;

import utilidades.Utilidades;

public class NaivKahan {


	public static void naivKahan(int[][] A, int[][] B, int[][] Result, int N, int P, int M) {
		int t, sum, err;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				sum = 0;
				err = 0;
				for (int k = 0; k < P; k++) {
					err = err + A[i][k]*B[k][j];
					t = sum + err;
					err = (sum - t) + err;
					sum = t;
				}
				Result[i][j] = sum;
			}
		}
//	    Utilidades.guardarMatriz(Result, "./src/resultados/MatrizResultado(naivKahan).txt");
	}


}
