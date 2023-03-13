package implementacion;


public class Algoritmo {


	public Algoritmo() {

	}
	
	//Metodo 1
	public void naivStandard(double A, double B, double Result, int N, int P, int M) {

		double aux;

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				aux = 0.0;
				for (int k = 0; k < P; k++) {

				}
			}
		}
	}

	//Metodo 2
	public void naivOnArray(double A, double B, double Result, int N, int P, int M) {


		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {

				for (int k = 0; k < P; k++) {

				}
			}
		}
	}

	//Metodo 3
	public static double[][] naiveKahanMult(double[][] A, double[][] B) {
		int m = A.length;
		int n = B.length;
		int p = B[0].length;

		double[][] C = new double[m][p];

		for (int i = 0; i < m; i++) {
			for (int j = 0; j < p; j++) {
				double sum = 0;
				double c = 0;

				for (int k = 0; k < n; k++) {
					double y = A[i][k] * B[k][j] - c;
					double t = sum + y;
					c = (t - sum) - y;
					sum = t;
				}

				C[i][j] = sum;
			}
		}

		return C;
	}

	//Metodo 4
	public static int[][] naivLoopUnrollingTwo(int[][] A, int[][] B) {
		int m = A.length;
		int n = A[0].length;
		int p = B[0].length;
		int[][] C = new int[m][p];
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < p; j++) {
				int sum = 0;
				for (int k = 0; k < n; k += 2) {
					sum += A[i][k] * B[k][j];
					sum += A[i][k + 1] * B[k + 1][j];
				}
				C[i][j] = sum;
			}
		}
		return C;
	}

	//Metodo 5
	public static double[][] naiveLoopUnrollingThree(double[][] A, double[][] B) {
		int m = A.length;
		int n = A[0].length;
		int p = B[0].length;
		double[][] C = new double[m][p];

		for (int i = 0; i < m; i++) {
			for (int j = 0; j < p; j++) {
				double sum = 0.0;
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
		return C;
	}

	//Metodo 6
	public static int[][] naivLoopUnrollingFour(int[][] matrix1, int[][] matrix2) {
		int rowsA = matrix1.length;
		int colsA = matrix1[0].length;
		int colsB = matrix2[0].length;

		int[][] result = new int[rowsA][colsB];

		for (int i = 0; i < rowsA; i++) {
			for (int j = 0; j < colsB; j += 4) {
				int sum1 = 0, sum2 = 0, sum3 = 0, sum4 = 0;
				for (int k = 0; k < colsA; k++) {
					sum1 += matrix1[i][k] * matrix2[k][j];
					sum2 += matrix1[i][k] * matrix2[k][j + 1];
					sum3 += matrix1[i][k] * matrix2[k][j + 2];
					sum4 += matrix1[i][k] * matrix2[k][j + 3];
				}
				result[i][j] = sum1;
				result[i][j + 1] = sum2;
				result[i][j + 2] = sum3;
				result[i][j + 3] = sum4;
			}
		}

		return result;
	}


	//Metodo 7
	public static int[][] winogradOriginal(int[][] A, int[][] B) {
		int n = A.length;
		int[][] C = new int[n][n];

		// Calcular las constantes de Winograd
		int[] rowFactors = new int[n];
		int[] colFactors = new int[n];
		for (int i = 0; i < n; i++) {
			rowFactors[i] = A[i][0] * A[i][1];
			colFactors[i] = B[0][i] * B[1][i];
			for (int j = 1; j < n / 2; j++) {
				int idx = j * 2;
				rowFactors[i] += A[i][idx] * A[i][idx + 1];
				colFactors[i] += B[idx][i] * B[idx + 1][i];
			}
		}

		// Calcular el producto de matrices usando las constantes de Winograd
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				int dotProduct = 0;
				for (int k = 0; k < n / 2; k++) {
					int idx1 = k * 2;
					int idx2 = idx1 + 1;
					dotProduct += (A[i][idx1] + B[idx2][j]) * (A[i][idx2] + B[idx1][j]);
				}
				C[i][j] = dotProduct - rowFactors[i] - colFactors[j] + A[i][n-1] * B[n-1][j];
			}
		}
		return C;
	}


	//Metodo 8
	public static int[][] winogradScaled(int[][] a, int[][] b) {
		int m = a.length;
		int n = b[0].length;
		int r = a[0].length;

		// Paso 1: Calcular las constantes para las operaciones de preprocesamiento
		int[] rowFactor = new int[m];
		int[] colFactor = new int[n];
		for (int i = 0; i < m; i++) {
			rowFactor[i] = a[i][0] * a[i][1];
			for (int j = 2; j < r; j += 2) {
				rowFactor[i] += a[i][j] * a[i][j + 1];
			}
		}
		for (int i = 0; i < n; i++) {
			colFactor[i] = b[0][i] * b[1][i];
			for (int j = 2; j < r; j += 2) {
				colFactor[i] += b[j][i] * b[j + 1][i];
			}
		}

		// Paso 2: Calcular la matriz intermedia
		int[][] intermediate = new int[m][n];
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				intermediate[i][j] = -rowFactor[i] - colFactor[j];
				for (int k = 0; k < r; k += 2) {
					intermediate[i][j] += (a[i][k + 1] + b[k][j]) * (a[i][k] + b[k + 1][j]);
				}
			}
		}

		// Paso 3: Calcular la matriz resultante
		int[][] result = new int[m][n];
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				result[i][j] = intermediate[i][j];
				if (r % 2 != 0) {
					result[i][j] += a[i][r - 1] * b[r - 1][j];
				}
			}
		}

		return result;
	}


	//Metodo 9
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

	//Metodo 10
	public void strassenWinograd() {

	}
	

	//Metodo 11
	public void sequentialBlockIII() {

	}

	//Metodo 12
	public void parallelBlockIII() {

	}

	//Metodo 13
	public void sequentialBlockIV() {

	}

	//Metodo 14
	public void parallelBlockIV() {

	}

	//Metodo 15
	public void sequentialBlockV() {

	}

	//Metodo 16
	public void parallelBlockV() {

	}





}
