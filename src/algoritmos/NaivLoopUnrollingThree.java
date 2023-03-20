package algoritmos;

public class NaivLoopUnrollingThree {

	
	//Metodo 5
	public void naiveLoopUnrollingThree(int[][] A, int[][] B) {
		int m = A.length;
		int n = A[0].length;
		int p = B[0].length;
		int[][] C = new int[m][p];

		for (int i = 0; i < m; i++) {
			for (int j = 0; j < p; j++) {
				int sum = 0;
				for (int k = 0; k < n - 3; k += 4) {
					sum += A[i][k] * B[k][j] + A[i][k+1] * B[k+1][j] +
							A[i][k+2] * B[k+2][j] + A[i][k+3] * B[k+3][j];
				}
				for (int k = n - n % 4; k < n; k++) {
					sum += A[i][k] * B[k][j];
				}
				C[i][j] = sum;
			}
		}
		imprimirMatriz(C);
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
