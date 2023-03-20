package algoritmos;

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
		imprimirMatriz(Result);
	}
	
	private static void imprimirMatriz(int[][] matriz) {
		// TODO Auto-generated method stub
	    System.out.println("naivOnArray");
		for (int i = 0; i < matriz.length; i++) {
		    for (int j = 0; j < matriz[i].length; j++) {
		        System.out.print(matriz[i][j] + " ");
		    }
		    System.out.println();
		}

	}
	

}
