package algoritmos;

import java.io.FileWriter;
import java.io.IOException;

import utilidades.Utilidades;

public class NaivStandard {

	public void naivStandard(int[][] A, int[][] B, int[][] result, int N, int P, int M) {

		int aux;

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				aux = 0;
				for (int k = 0; k < P; k++) {
					aux += A[i][k] * B[k][j];
				}
				result[i][j] = aux;
			}
		}
		Utilidades.guardarMatriz(result, "./src/matrices/Resultado(P1).txt");
		
	}
	


	
}
 