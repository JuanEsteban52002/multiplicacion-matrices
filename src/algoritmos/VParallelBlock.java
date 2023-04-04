package algoritmos;

import java.util.stream.IntStream;

import utilidades.Utilidades;

public class VParallelBlock {
	
	public void vParallelBlock(int[][]matrizB, int[][]matrizC, int tamanio) {
		
		int size=tamanio;
		int	bsize= (int) Math.sqrt(size);
		int[][] matrizA = new int[size][size];
		
        IntStream.range(0, 1).parallel().forEach(_i -> {
            for (int i1 = 0; i1 < size; i1 += bsize) {
                for (int j1 = 0; j1 < size; j1 += bsize) {
                    for (int k1 = 0; k1 < size; k1 += bsize) {
                        for (int i = i1; i < i1 + bsize && i < size; i++) {
                            for (int j = j1; j < j1 + bsize && j < size; j++) {
                                for (int k = k1; k < k1 + bsize && k < size; k++) {
                                    matrizA[k][i] += matrizB[k][j] * matrizC[j][i];
                                }
                            }
                        }
                    }
                }
            }
        });
//	    Utilidades.guardarMatriz(matrizA, "./src/resultados/MatrizResultado(vParallelBlock).txt");
	}

}