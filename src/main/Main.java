package main;

import java.io.FileWriter;
import java.io.IOException;

import algoritmos.NaivKahan;
import algoritmos.NaivLoopUnrollingFour;
import algoritmos.NaivLoopUnrollingThree;
import algoritmos.NaivLoopUnrollingTwo;
import algoritmos.NaivOnArray;
import algoritmos.NaivStandard;
import algoritmos.StrassenNaiv;
import algoritmos.StrassenWinograd;
import algoritmos.WinogradOriginal;
import algoritmos.WinogradScaled;

public class Main {
	
	public static void main(String[] args) {
		
		long inicioEjecucion, finEjecucion, tiempo;

		
		//Declaracion de todos los objetos para ejecutar cada uno de los algoritmos
		
		NaivStandard naivStandard = new NaivStandard();
		NaivOnArray naivOnArray = new NaivOnArray();
		NaivKahan naivKahan = new NaivKahan();
		NaivLoopUnrollingTwo naivLoopUnrollingTwo = new NaivLoopUnrollingTwo();
		NaivLoopUnrollingThree naivLoopUnrollingThree = new NaivLoopUnrollingThree();
		NaivLoopUnrollingFour naivLoopUnrollingFour = new NaivLoopUnrollingFour();
		WinogradOriginal winogradOriginal = new WinogradOriginal();
		WinogradScaled winoScaled = new WinogradScaled();
		StrassenNaiv strassenNaiv = new StrassenNaiv();
		StrassenWinograd strassenWinograd = new StrassenWinograd();
		//IIISequentialblock iiiSequentialblock = new IIISequentialblock();
		//IIIParallelBlock iiiParallelBlock = new IIIParallelBlock();
		//IVSequentialblock ivSequentialblock = new IVSequentialblock();
		//IVParallelBlock ivParallelBlock = new IVParallelBlock();
		//VSequentialblock vSequentialblock = new VSequentialblock();
		//VParallelBlock vParallelBlock = new VParallelBlock();
		
		
		
		//System.out.println("Algoritmo de multiplicación de matrices");
		
		
//		int[][] matriz1 ={{1, 2, 3}, 
//						 {4, 5, 6}, 
//						 {7, 8, 9}};
//		
//		int[][] matriz2 ={{1, 2, 3}, 
//				 		 {4, 5, 6}, 
//				 		 {7, 8, 9}};
//		
		int tamanio = 2048;
		int[][]resultado = new int[tamanio][tamanio];
		int N = tamanio;
		int P = tamanio;
		int M = tamanio;
		
		
		/*
		 * Para generar las matrices 
		 */
		
        int[][] matriz1 = generarMatriz(tamanio);
        int[][] matriz2 = generarMatriz(tamanio);

        // Guardar la matriz en un archivo
        guardarMatriz(matriz1, "./src/matrices/prueba1(M1).txt");
        guardarMatriz(matriz2, "./src/matrices/prueba1(M2).txt");

		
		//imprimirMatriz(matriz1);
		
		inicioEjecucion = System.nanoTime();
		naivStandard.naivStandard(matriz1, matriz2, resultado, N, P, M);
		finEjecucion = System.nanoTime();
		tiempo = (finEjecucion-inicioEjecucion);
		System.out.println("Tiempo de ejecucion naivStandard: "+tiempo);

		
		
//		inicioEjecucion = System.nanoTime();
//		naivOnArray.naivOnArray(matriz1, matriz2, resultado, N, P, M);
//		finEjecucion = System.nanoTime();
//		tiempo = (finEjecucion-inicioEjecucion);
//		System.out.println("Tiempo de ejecucion naivOnArray: "+tiempo);
		
		
//		inicioEjecucion = System.nanoTime();
//		naivKahan.naivKahan(matriz1, matriz2, resultado, N, P, M);
//		finEjecucion = System.nanoTime();
//		tiempo = (finEjecucion-inicioEjecucion);
//		System.out.println("Tiempo de ejecucion naivKahan : "+tiempo);
		
//		inicioEjecucion = System.nanoTime();
//		naivLoopUnrollingTwo.naivLoopUnrollingTwo(matriz1, matriz2, resultado, N, P, M);
//		finEjecucion = System.nanoTime();
//		tiempo = (finEjecucion-inicioEjecucion);
//		System.out.println("Tiempo de ejecucion naivLoopUnrollingTwo: "+tiempo);
		
//		inicioEjecucion = System.nanoTime();
//		naivLoopUnrollingThree.naiveLoopUnrollingThree(matriz1, matriz2);
//		finEjecucion = System.nanoTime();
//		tiempo = (finEjecucion-inicioEjecucion);
//		System.out.println("Tiempo de ejecucion naiveLoopUnrollingThree: "+tiempo);
		
//		inicioEjecucion = System.nanoTime();
//		naivLoopUnrollingFour.naivLoopUnrollingFour(matriz1, matriz2, resultado, N, P, M);
//		finEjecucion = System.nanoTime();
//		tiempo = (finEjecucion-inicioEjecucion);
//		System.out.println("Tiempo de ejecucion naivLoopUnrollingFour: "+tiempo);
		
//		inicioEjecucion = System.nanoTime();
//		winogradOriginal.winogradOriginal(matriz1, matriz2);
//		finEjecucion = System.nanoTime();
//		tiempo = (finEjecucion-inicioEjecucion);
//		System.out.println("Tiempo de ejecucion winogradOriginal: "+tiempo);
		
//		inicioEjecucion = System.nanoTime();
//		winoScaled.winogradScaled(matriz1, matriz2, resultado, N, P, M);
//		finEjecucion = System.nanoTime();
//		tiempo = (finEjecucion-inicioEjecucion);
//		System.out.println("Tiempo de ejecucion winogradScaled: "+tiempo);		
		
//		inicioEjecucion = System.nanoTime();
//		strassenNaiv.StrassenNaiv(matriz1, matriz2, resultado, N, P, M);
//		finEjecucion = System.nanoTime();
//		tiempo = (finEjecucion-inicioEjecucion);
//		System.out.println("Tiempo de ejecucion StrassenNaiv: "+tiempo);
		
//		inicioEjecucion = System.nanoTime();
//		StrassenWinograd.StrassenWinograd(matriz1, matriz2, resultado, N, P, M);
//		finEjecucion = System.nanoTime();
//		tiempo = (finEjecucion-inicioEjecucion);
//		System.out.println("Tiempo de ejecucion StrassenWinograd: "+tiempo);
		
		
		
		
		

		
		
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
	
	
	public static int[][] generarMatriz(int n) {
        int[][] matriz = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                matriz[i][j] = (int) (Math.random() * (9999 - 1000 + 1) + 1000);
            }
        }
        return matriz;
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


