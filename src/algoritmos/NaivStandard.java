package algoritmos;

import java.io.FileWriter;
import java.io.IOException;

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
		guardarMatriz(result, "./src/matrices/Resultado(P1).txt");
		
	}
	

    public static void guardarMatriz(int[][] matriz, String archivo) {
        try {
            FileWriter writer = new FileWriter(archivo);
            for (int i = 0; i < matriz.length; i++) {
                for (int j = 0; j < matriz[i].length; j++) {
                    writer.write(matriz[i][j] + " ");
                }
                writer.write("\n");
            }
            writer.close();
            System.out.println("La matriz se ha guardado correctamente en el archivo " + archivo);
        } catch (IOException e) {
            System.out.println("Error al guardar la matriz en el archivo " + archivo);
            e.printStackTrace();
        }
    }
	
}
 