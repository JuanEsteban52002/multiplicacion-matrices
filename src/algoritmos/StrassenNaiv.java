package algoritmos;

public class StrassenNaiv {

	public void StrassenNaiv(int[][] A, int[][] B, int[][] Result, int N, int P, int M) {
		int MaxSize, k, m, NewSize, i, j;
		MaxSize = Math.max(N, Math.max(P, M));
		if (MaxSize < 16) {
			MaxSize = 16; // otherwise it is not possible to compute k
		}
		k = (int) Math.floor(Math.log(MaxSize) / Math.log(2)) - 4;
		m = (int) Math.floor(MaxSize * Math.pow(2, -k)) + 1;
		NewSize = m * (int) Math.pow(2, k);
		// add zero rows and columns to use Strassen's algorithm
		int[][] NewA = new int[NewSize][NewSize];
		int[][] NewB = new int[NewSize][NewSize];
		int[][] AuxResult = new int[NewSize][NewSize];
		for (i = 0; i < NewSize; i++) {
			for (j = 0; j < NewSize; j++) {
				NewA[i][j] = 0;
				NewB[i][j] = 0;
			}
		}
		for (i = 0; i < N; i++) {
			for (j = 0; j < P; j++) {
				NewA[i][j] = A[i][j];
			}
		}
		for (i = 0; i < P; i++) {
			for (j = 0; j < M; j++) {
				NewB[i][j] = B[i][j];
			}
		}
		StrassenNaivStep(NewA, NewB, AuxResult, NewSize, m);

		// extract the result

		for( i = 0; i < N; i++){
			for( j = 0; j < M; j++){
				Result[i][j] = AuxResult[i][j];
			}
		}
	}


	public void StrassenNaivStep(int[][] newA, int[][] newB, int[][] auxResult, int N, int m) {
		int i, j, NewSize;
		
		if ((N % 2 == 0) && (N > m)) {
			NewSize = N / 2;
			int[][] A11 = new int[NewSize][NewSize];
			int[][] A12 = new int[NewSize][NewSize];
			int[][] A21 = new int[NewSize][NewSize];
			int[][] A22 = new int[NewSize][NewSize];
			int[][] B11 = new int[NewSize][NewSize];
			int[][] B12 = new int[NewSize][NewSize];
			int[][] B21 = new int[NewSize][NewSize];
			int[][] B22 = new int[NewSize][NewSize];
			int[][] ResultPart11 = new int[NewSize][NewSize];
			int[][] ResultPart12 = new int[NewSize][NewSize];
			int[][] ResultPart21 = new int[NewSize][NewSize];
			int[][] ResultPart22 = new int[NewSize][NewSize];
			int[][] Helper1 = new int[NewSize][NewSize];
			int[][] Helper2 = new int[NewSize][NewSize];
			int[][] Aux1 = new int[NewSize][NewSize];
			int[][] Aux2 = new int[NewSize][NewSize];
			int[][] Aux3 = new int[NewSize][NewSize];
			int[][] Aux4 = new int[NewSize][NewSize];
			int[][] Aux5 = new int[NewSize][NewSize];
			int[][] Aux6 = new int[NewSize][NewSize];
			int[][] Aux7 = new int[NewSize][NewSize];

			for ( i = 0; i < NewSize; i++) {
				A11[i] = new int[NewSize];
				A12[i] = new int[NewSize];
				A21[i] = new int[NewSize];
				A22[i] = new int[NewSize];
				B11[i] = new int[NewSize];
				B12[i] = new int[NewSize];
				B21[i] = new int[NewSize];
				B22[i] = new int[NewSize];
				ResultPart11[i] = new int[NewSize];
				ResultPart12[i] = new int[NewSize];
				ResultPart21[i] = new int[NewSize];
				ResultPart22[i] = new int[NewSize];
				Helper1[i] = new int[NewSize];
				Helper2[i] = new int[NewSize];
				Aux1[i] = new int[NewSize];
				Aux2[i] = new int[NewSize];
				Aux3[i] = new int[NewSize];
				Aux4[i] = new int[NewSize];
				Aux5[i] = new int[NewSize];
				Aux6[i] = new int[NewSize];
				Aux7[i] = new int[NewSize];
			}


			for ( i = 0; i < NewSize; i++) {
				for ( j = 0; j < NewSize; j++) {
					A11[i][j] = newA[i][j];
				}
			}
			for ( i = 0; i < NewSize; i++) {
				for ( j = 0; j < NewSize; j++) {
					A12[i][j] = newA[i][NewSize + j];
				}
			}
			for ( i = 0; i < NewSize; i++) {
				for ( j = 0; j < NewSize; j++) {
					A21[i][j] = newA[NewSize + i][j];
				}
			}
			for ( i = 0; i < NewSize; i++) {
				for ( j = 0; j < NewSize; j++) {
					A22[i][j] = newA[NewSize + i][NewSize + j];
				}
			}
			for ( i = 0; i < NewSize; i++) {
				for ( j = 0; j < NewSize; j++) {
					B11[i][j] = newB[i][j];
				}
			}
			for ( i = 0; i < NewSize; i++) {
				for ( j = 0; j < NewSize; j++) {
					B12[i][j] = newB[i][NewSize + j];
				}
			}
			for ( i = 0; i < NewSize; i++) {
				for ( j = 0; j < NewSize; j++) {
					B21[i][j] = newB[NewSize + i][j];
				}
			}
			for ( i = 0; i < NewSize; i++) {
				for ( j = 0; j < NewSize; j++) {
					B22[i][j] = newB[NewSize + i][NewSize + j];
				}
			}

			Plus(A11, A22, Helper1, NewSize, NewSize);
			Plus(B11, B22, Helper2, NewSize, NewSize);
			StrassenNaivStep(Helper1, Helper2, Aux1, NewSize, m);
			Plus(A21, A22, Helper1, NewSize, NewSize);
			StrassenNaivStep(Helper1, B11, Aux2, NewSize, m);
			Minus(B12, B22, Helper1, NewSize, NewSize);
			StrassenNaivStep(A11, Helper1, Aux3, NewSize, m);
			Minus(B21, B11, Helper1, NewSize, NewSize);
			StrassenNaivStep(A22, Helper1, Aux4, NewSize, m);
			Plus(A11, A12, Helper1, NewSize, NewSize);
			StrassenNaivStep(Helper1, B22, Aux5, NewSize, m);
			Minus(A21, A11, Helper1, NewSize, NewSize);
			Plus(B11, B12, Helper2, NewSize, NewSize);
			StrassenNaivStep(Helper1, Helper2, Aux6, NewSize, m);
			Minus(A12, A22, Helper1, NewSize, NewSize);
			Plus(B21, B22, Helper2, NewSize, NewSize);
			StrassenNaivStep(Helper1, Helper2, Aux7, NewSize, m);
			// computing the four parts of the result
			Plus(Aux1, Aux4, ResultPart11, NewSize, NewSize);
			Minus(ResultPart11, Aux5, ResultPart11, NewSize, NewSize);
			Plus(ResultPart11, Aux7, ResultPart11, NewSize, NewSize);
			Plus(Aux3, Aux5, ResultPart12, NewSize, NewSize);
			Plus(Aux2, Aux4, ResultPart21, NewSize, NewSize);
			Plus(Aux1, Aux3, ResultPart22, NewSize, NewSize);
			Minus(ResultPart22, Aux2, ResultPart22, NewSize, NewSize);
			Plus(ResultPart22, Aux6, ResultPart22, NewSize, NewSize);

			for ( i = 0; i < NewSize; i++) {
				for ( j = 0; j < NewSize; j++) {
					auxResult[i][j] = ResultPart11[i][j];
				}
			}

			for ( i = 0; i < NewSize; i++) {
				for ( j = 0; j < NewSize; j++) {
					auxResult[i][NewSize + j] = ResultPart12[i][j];
				}
			}

			for ( i = 0; i < NewSize; i++) {
				for ( j = 0; j < NewSize; j++) {
					auxResult[NewSize + i][j] = ResultPart21[i][j];
				}
			}

			for ( i = 0; i < NewSize; i++) {
				for ( j = 0; j < NewSize; j++) {
					auxResult[NewSize + i][NewSize + j] = ResultPart22[i][j];
				}
			}

			// free helper variables
			A11 = null;
			A12 = null;
			A21 = null;
			A22 = null;
			B11 = null;
			B12 = null;
			B21 = null;
			B22 = null;
			ResultPart11 = null;
			ResultPart12 = null;
			ResultPart21 = null;
			ResultPart22 = null;
			Helper1 = null;
			Helper2 = null;
			Aux1 = null;
			Aux2 = null;
			Aux3 = null;
			Aux4 = null;
			Aux5 = null;
			Aux6 = null;
			Aux7 = null;

		} else {
			// use naive algorithm
			naivStandard(newA, newB, auxResult, N, N, N);
		}

	}
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

	public static void Plus(int[][] A, int[][] B, int[][] Result, int N, int M) {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				Result[i][j] = A[i][j] + B[i][j];
			}
		}
	}

	public static void Minus(int[][] A, int[][] B, int[][] Result, int N, int M) {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				Result[i][j] = A[i][j] - B[i][j];
			}
		}
	}




	private static void imprimirMatriz(int[][] matriz) {
		// TODO Auto-generated method stub
		System.out.println("StrassenNaiv");
		for (int i = 0; i < matriz.length; i++) {
			for (int j = 0; j < matriz[i].length; j++) {
				System.out.print(matriz[i][j] + " ");
			}
			System.out.println();
		}

	}





}


