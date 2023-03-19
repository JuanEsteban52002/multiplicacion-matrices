package algoritmos;

public class WinogradScaled {

	
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
}
