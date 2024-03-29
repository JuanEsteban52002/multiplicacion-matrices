package algoritmos;

import utilidades.Utilidades;

public class NaivLoopUnrollingTwo {

	//Metodo 4
	public static void naivLoopUnrollingTwo(int[][] A, int[][] B, int[][] Result, int N, int P, int M) {
        int i, j, k;
        int aux;
        if (P % 2 == 0) {
            for (i = 0; i < N; i++) {
                for (j = 0; j < M; j++) {
                    aux = 0;
                    for (k = 0; k < P; k += 2) {
                        aux += A[i][k] * B[k][j] + A[i][k + 1] * B[k + 1][j];
                    }
                    Result[i][j] = aux;
                }
            }
        } else {
            int PP = P - 1;
            for (i = 0; i < N; i++) {
                for (j = 0; j < M; j++) {
                    aux = 0;
                    for (k = 0; k < PP; k += 2) {
                        aux += A[i][k] * B[k][j] + A[i][k + 1] * B[k + 1][j];
                    }
                    Result[i][j] = aux + A[i][PP] * B[PP][j];
                }
            }
        }
//	    Utilidades.guardarMatriz(Result, "./src/resultados/MatrizResultado(naivLoopUnrollingTwo).txt");
    }
	
	
}
