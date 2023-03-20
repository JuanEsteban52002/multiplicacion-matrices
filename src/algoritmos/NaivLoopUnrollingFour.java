package algoritmos;

public class NaivLoopUnrollingFour {


	public static void naivLoopUnrollingFour(int[][] A, int[][] B, int[][] Result, int N, int P, int M) {
		int i, j, k;
		int aux;
		if (P % 4 == 0) {
			for (i = 0; i < N; i++) {
				for (j = 0; j < M; j++) {
					aux = 0;
					for (k = 0; k < P; k += 4) {
						aux += A[i][k]*B[k][j] + A[i][k+1]*B[k+1][j] + A[i][k+2]*B[k+2][j] + A[i][k+3]*B[k+3][j];
					}
					Result[i][j] = aux;
				}
			}
		} else if (P % 4 == 1) {
			int PP = P - 1;
			for (i = 0; i < N; i++) {
				for (j = 0; j < M; j++) {
					aux = 0;
					for (k = 0; k < PP; k += 4) {
						aux += A[i][k]*B[k][j] + A[i][k+1]*B[k+1][j] + A[i][k+2]*B[k+2][j] + A[i][k+3]*B[k+3][j];
					}
					Result[i][j] = aux + A[i][PP]*B[PP][j];
				}
			}
		} else if (P % 4 == 2) {
			int PP = P - 2;
			int PPP = P - 1;
			for (i = 0; i < N; i++) {
				for (j = 0; j < M; j++) {
					aux = 0;
					for (k = 0; k < PP; k += 4) {
						aux += A[i][k]*B[k][j] + A[i][k+1]*B[k+1][j] + A[i][k+2]*B[k+2][j] + A[i][k+3]*B[k+3][j];
					}
					Result[i][j] = aux + A[i][PP]*B[PP][j] + A[i][PPP]*B[PPP][j];
				}
			}
		} else {
			int PP = P - 3;
			int PPP = P - 2;
			int PPPP = P - 1;
			for (i = 0; i < N; i++) {
				for (j = 0; j < M; j++) {
					aux = 0;
					for (k = 0; k < PP; k += 4) {
						aux += A[i][k]*B[k][j] + A[i][k+1]*B[k+1][j] + A[i][k+2]*B[k+2][j] + A[i][k+3]*B[k+3][j];
					}
					Result[i][j] = aux + A[i][PP]*B[PP][j] + A[i][PPP]*B[PPP][j] + A[i][PPPP]*B[PPPP][j];
				}
			}
		}
		
		imprimirMatriz(Result);
	}

	private static void imprimirMatriz(int[][] matriz) {
		// TODO Auto-generated method stub
		for (int i = 0; i < matriz.length; i++) {
			for (int j = 0; j < matriz[i].length; j++) {
				System.out.print(matriz[i][j] + " ");
			}
			System.out.println();
		}

	}
}
