package algoritmos;

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
		imprimirMatriz(result);
		
	}
	

	private static void imprimirMatriz(int[][] matriz) {
		// TODO Auto-generated method stub
		System.out.println("naivStandard");
		for (int i = 0; i < matriz.length; i++) {
		    for (int j = 0; j < matriz[i].length; j++) {
		        System.out.print(matriz[i][j] + " ");
		    }
		    System.out.println();
		}

	}
	
}
 