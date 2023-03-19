package algoritmos;

public class StrassenNaiv {

	
	public void strassenNaiv() {


		/*
		 * public class StrassenNaive {
    public static int[][] multiply(int[][] A, int[][] B) {
        int n = A.length;
        int[][] C = new int[n][n];

        if (n == 1) {
            C[0][0] = A[0][0] * B[0][0];
        } else {
            int[][] A11 = new int[n/2][n/2];
            int[][] A12 = new int[n/2][n/2];
            int[][] A21 = new int[n/2][n/2];
            int[][] A22 = new int[n/2][n/2];
            int[][] B11 = new int[n/2][n/2];
            int[][] B12 = new int[n/2][n/2];
            int[][] B21 = new int[n/2][n/2];
            int[][] B22 = new int[n/2][n/2];

            // Divide A and B into submatrices
            for (int i = 0; i < n/2; i++) {
                for (int j = 0; j < n/2; j++) {
                    A11[i][j] = A[i][j];
                    A12[i][j] = A[i][j+n/2];
                    A21[i][j] = A[i+n/2][j];
                    A22[i][j] = A[i+n/2][j+n/2];

                    B11[i][j] = B[i][j];
                    B12[i][j] = B[i][j+n/2];
                    B21[i][j] = B[i+n/2][j];
                    B22[i][j] = B[i+n/2][j+n/2];
                }
            }

            // Compute submatrices of C recursively
            int[][] C11 = add(multiply(A11, B11), multiply(A12, B21));
            int[][] C12 = add(multiply(A11, B12), multiply(A12, B22));
            int[][] C21 = add(multiply(A21, B11), multiply(A22, B21));
            int[][] C22 = add(multiply(A21, B12), multiply(A22, B22));

            // Combine submatrices of C into C
            for (int i = 0; i < n/2; i++) {
                for (int j = 0; j < n/2; j++) {
                    C[i][j] = C11[i][j];
                    C[i][j+n/2] = C12[i][j];
                    C[i+n/2][j] = C21[i][j];
                    C[i+n/2][j+n/2] = C22[i][j];
                }
            }
        }

        return C;
    }

    public static int[][] add(int[][] A, int[][] B) {
        int n = A.length;
        int[][] C = new int

		 */

	}
	
}
