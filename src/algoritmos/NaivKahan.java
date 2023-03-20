package algoritmos;

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
        imprimirMatriz(Result);
    }
	
	private static void imprimirMatriz(int[][] matriz) {
		// TODO Auto-generated method stub
	    System.out.println("naivKahan");

		for (int i = 0; i < matriz.length; i++) {
		    for (int j = 0; j < matriz[i].length; j++) {
		        System.out.print(matriz[i][j] + " ");
		    }
		    System.out.println();
		}
	}
	
}
