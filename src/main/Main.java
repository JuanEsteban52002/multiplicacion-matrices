package main;

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
		//StrassenWinograd strassenWinograd = new StrassenWinograd();
		//IIISequentialblock iiiSequentialblock = new IIISequentialblock();
		//IIIParallelBlock iiiParallelBlock = new IIIParallelBlock();
		//IVSequentialblock ivSequentialblock = new IVSequentialblock();
		//IVParallelBlock ivParallelBlock = new IVParallelBlock();
		//VSequentialblock vSequentialblock = new VSequentialblock();
		//VParallelBlock vParallelBlock = new VParallelBlock();
		
		
		
		//System.out.println("Algoritmo de multiplicación de matrices");
		
		
		int[][] matriz1 ={{1, 2, 3}, 
						 {4, 5, 6}, 
						 {7, 8, 9}};
		
		int[][] matriz2 ={{1, 2, 3}, 
				 		 {4, 5, 6}, 
				 		 {7, 8, 9}};
		
		int[][]resultado = new int[3][3];
		int N = 3;
		int P = 3;
		int M = 3;
		
		//imprimirMatriz(matriz1);
		
//		inicioEjecucion = System.nanoTime();
//		naivStandard.naivStandard(matriz1, matriz2, resultado, N, P, M);
//		finEjecucion = System.nanoTime();
//		tiempo = (finEjecucion-inicioEjecucion);
//		System.out.println("Tiempo de ejecucion naivStandard: "+tiempo);

		
		
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
		
		inicioEjecucion = System.nanoTime();
		winoScaled.winogradScaled(matriz1, matriz2, resultado, N, P, M);
		finEjecucion = System.nanoTime();
		tiempo = (finEjecucion-inicioEjecucion);
		System.out.println("Tiempo de ejecucion winogradScaled: "+tiempo);
		
		
		
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

}


