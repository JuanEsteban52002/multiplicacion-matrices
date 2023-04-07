package main;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import algoritmos.IIIParallelBlock;
import algoritmos.IIISequentialblock;
import algoritmos.IVParallelBlock;
import algoritmos.IVSequentialblock;
import algoritmos.NaivKahan;
import algoritmos.NaivLoopUnrollingFour;
import algoritmos.NaivLoopUnrollingThree;
import algoritmos.NaivLoopUnrollingTwo;
import algoritmos.NaivOnArray;
import algoritmos.NaivStandard;
import algoritmos.StrassenNaiv;
import algoritmos.StrassenWinograd;
import algoritmos.VParallelBlock;
import algoritmos.VSequentialblock;
import algoritmos.WinogradOriginal;
import algoritmos.WinogradScaled;
import utilidades.Utilidades;

public class Main {
	
	public static void main(String[] args) {
		
		/*
		 * En el paquete matrices se guardan las matrices que se generan para
		 * probar los algoritmos, por motivos de peso del proyecto y de subir los
		 * archivos a github las matrices generadas las eliminamos, en el paquete unicamente
		 * se encuentran las matrices mas pequeñas.
		 */
		
		/*
		 * En el paquete resultados se encuentran los tiempos de ejecucion
		 * de los algoritmos por cada tamaño de matriz.
		 */
		
		
		/*
		 * En el paquete tiemposIndividuales se encuentran los tienpos por algoritmo
		 * en cada una de las ejecuciones con los diferentes tamaños de matrices.
		 */
		
		/*
		 * Los requerimientos 4, 5, 6 y 7 se encuentran en main´s separados
		 * en un paquete llamado utilidades.
		 */
		
		/*
		 * Los archivos .png que se encuentan por fuera de src son las graficas que
		 * se generan en los requerimientos 4, 5, 6 y 7.
		 */
		

		
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
		IIISequentialblock iiiSequentialblock = new IIISequentialblock();
		IIIParallelBlock iiiParallelBlock = new IIIParallelBlock();
		IVSequentialblock ivSequentialblock = new IVSequentialblock();
		IVParallelBlock ivParallelBlock = new IVParallelBlock();
		VSequentialblock vSequentialblock = new VSequentialblock();
		VParallelBlock vParallelBlock = new VParallelBlock();
		
		
//		int[] tamañoMatrices = {4, 8, 16, 32, 64, 128, 256, 512, 1024, 2048, 4096, 8192};
		
		
		int tamanio = 4;
		int[][]resultado = new int[tamanio][tamanio];
		int N = tamanio;
		int P = tamanio;
		int M = tamanio;
		String nombreArchivoResultados = "./src/resultados/Tiempos de Ejecucion "+ tamanio +".txt";
		String nombreArchivoEstadisticos = "./src/resultados/Estadisticos "+ tamanio +".txt";		
		

		
		/*
		 * Para generar las matrices 
		 */
		
        int[][] matriz1 = Utilidades.generarMatriz(tamanio);
        int[][] matriz2 = Utilidades.generarMatriz(tamanio);

        
        // Guardar la matriz en un archivo
        Utilidades.guardarMatriz(matriz1, "./src/matrices/Matriz1 ("+ tamanio + ").txt");
        Utilidades.guardarMatriz(matriz2, "./src/matrices/Matriz2 ("+ tamanio + ").txt");

			
        
        //Ejecucion de cada algoritmo
		inicioEjecucion = System.nanoTime();
		naivStandard.naivStandard(matriz1, matriz2, resultado, N, P, M);
		finEjecucion = System.nanoTime();
		tiempo = (finEjecucion-inicioEjecucion);
		System.out.println("Tiempo de ejecucion naivStandard: "+tiempo);
		Utilidades.guardarResultado("naivStandard", tiempo, nombreArchivoResultados);
		Utilidades.guardarResultado2(tiempo, "./src/tiemposIndividuales/naivStandard");

		
		inicioEjecucion = System.nanoTime();
		naivOnArray.naivOnArray(matriz1, matriz2, resultado, N, P, M);
		finEjecucion = System.nanoTime();
		tiempo = (finEjecucion-inicioEjecucion);
		System.out.println("Tiempo de ejecucion naivOnArray: "+tiempo);
		Utilidades.guardarResultado("naivOnArray", tiempo, nombreArchivoResultados);
		Utilidades.guardarResultado2(tiempo, "./src/tiemposIndividuales/naivOnArray");

		
		inicioEjecucion = System.nanoTime();
		naivKahan.naivKahan(matriz1, matriz2, resultado, N, P, M);
		finEjecucion = System.nanoTime();
		tiempo = (finEjecucion-inicioEjecucion);
		System.out.println("Tiempo de ejecucion naivKahan : "+tiempo);
		Utilidades.guardarResultado("naivKahan", tiempo, nombreArchivoResultados);
		Utilidades.guardarResultado2(tiempo, "./src/tiemposIndividuales/naivKahan");

		
		inicioEjecucion = System.nanoTime();
		naivLoopUnrollingTwo.naivLoopUnrollingTwo(matriz1, matriz2, resultado, N, P, M);
		finEjecucion = System.nanoTime();
		tiempo = (finEjecucion-inicioEjecucion);
		System.out.println("Tiempo de ejecucion naivLoopUnrollingTwo: "+tiempo);
		Utilidades.guardarResultado("naivLoopUnrollingTwo", tiempo, nombreArchivoResultados);
		Utilidades.guardarResultado2(tiempo, "./src/tiemposIndividuales/naivLoopUnrollingTwo");


		
		inicioEjecucion = System.nanoTime();
		naivLoopUnrollingThree.naiveLoopUnrollingThree(matriz1, matriz2);
		finEjecucion = System.nanoTime();
		tiempo = (finEjecucion-inicioEjecucion);
		System.out.println("Tiempo de ejecucion naiveLoopUnrollingThree: "+tiempo);
		Utilidades.guardarResultado("naiveLoopUnrollingThree", tiempo, nombreArchivoResultados);
		Utilidades.guardarResultado2(tiempo, "./src/tiemposIndividuales/naiveLoopUnrollingThree");
		
		
		inicioEjecucion = System.nanoTime();
		naivLoopUnrollingFour.naivLoopUnrollingFour(matriz1, matriz2, resultado, N, P, M);
		finEjecucion = System.nanoTime();
		tiempo = (finEjecucion-inicioEjecucion);
		System.out.println("Tiempo de ejecucion naivLoopUnrollingFour: "+tiempo);
		Utilidades.guardarResultado("naivLoopUnrollingFour", tiempo, nombreArchivoResultados);
		Utilidades.guardarResultado2(tiempo, "./src/tiemposIndividuales/naivLoopUnrollingFour");


		
		inicioEjecucion = System.nanoTime();
		winogradOriginal.winogradOriginal(matriz1, matriz2);
		finEjecucion = System.nanoTime();
		tiempo = (finEjecucion-inicioEjecucion);
		System.out.println("Tiempo de ejecucion winogradOriginal: "+tiempo);
		Utilidades.guardarResultado("winogradOriginal", tiempo, nombreArchivoResultados);
		Utilidades.guardarResultado2(tiempo, "./src/tiemposIndividuales/winogradOriginal");


		
		inicioEjecucion = System.nanoTime();
		winoScaled.winogradScaled(matriz1, matriz2, resultado, N, P, M);
		finEjecucion = System.nanoTime();
		tiempo = (finEjecucion-inicioEjecucion);
		System.out.println("Tiempo de ejecucion winogradScaled: "+tiempo);		
		Utilidades.guardarResultado("winogradScaled", tiempo, nombreArchivoResultados);
		Utilidades.guardarResultado2(tiempo, "./src/tiemposIndividuales/winogradScaled");

		
		inicioEjecucion = System.nanoTime();
		strassenNaiv.StrassenNaiv(matriz1, matriz2, resultado, N, P, M);
		finEjecucion = System.nanoTime();
		tiempo = (finEjecucion-inicioEjecucion);
		System.out.println("Tiempo de ejecucion StrassenNaiv: "+tiempo);
		Utilidades.guardarResultado("StrassenNaiv", tiempo, nombreArchivoResultados);
		Utilidades.guardarResultado2(tiempo, "./src/tiemposIndividuales/StrassenNaiv");


		
		inicioEjecucion = System.nanoTime();
		StrassenWinograd.StrassenWinograd(matriz1, matriz2, resultado, N, P, M);
		finEjecucion = System.nanoTime();
		tiempo = (finEjecucion-inicioEjecucion);
		System.out.println("Tiempo de ejecucion StrassenWinograd: "+tiempo);
		Utilidades.guardarResultado("StrassenWinograd", tiempo, nombreArchivoResultados);
		Utilidades.guardarResultado2(tiempo, "./src/tiemposIndividuales/StrassenWinograd");


		
		inicioEjecucion = System.nanoTime();
		iiiSequentialblock.iiisequentianblock(matriz1, matriz2, tamanio);
		finEjecucion = System.nanoTime();
		tiempo = (finEjecucion-inicioEjecucion);
		System.out.println("Tiempo de ejecucion iiisequentianblock: "+tiempo);
		Utilidades.guardarResultado("iiisequentianblock", tiempo, nombreArchivoResultados);
		Utilidades.guardarResultado2(tiempo, "./src/tiemposIndividuales/iiisequentianblock");

        
		inicioEjecucion = System.nanoTime();
		iiiParallelBlock.iiiParallelblock(matriz1, matriz2, tamanio);
		finEjecucion = System.nanoTime();
		tiempo = (finEjecucion-inicioEjecucion);
		System.out.println("Tiempo de ejecucion iiiParallelblock: "+tiempo);
		Utilidades.guardarResultado("iiiParallelblock", tiempo, nombreArchivoResultados);
		Utilidades.guardarResultado2(tiempo, "./src/tiemposIndividuales/iiiParallelblock");


		
		inicioEjecucion = System.nanoTime();
		ivSequentialblock.ivSequentialblock(matriz1, matriz2, tamanio);
		finEjecucion = System.nanoTime();
		tiempo = (finEjecucion-inicioEjecucion);
		System.out.println("Tiempo de ejecucion ivSequentialblock: "+tiempo);
		Utilidades.guardarResultado("ivSequentialblock", tiempo, nombreArchivoResultados);
		Utilidades.guardarResultado2(tiempo, "./src/tiemposIndividuales/ivSequentialblock");


		
        
		inicioEjecucion = System.nanoTime();
		ivParallelBlock.ivParallelBlock(matriz1, matriz2, tamanio);
		finEjecucion = System.nanoTime();
		tiempo = (finEjecucion-inicioEjecucion);
		System.out.println("Tiempo de ejecucion ivParallelBlock: "+tiempo);
		Utilidades.guardarResultado("ivParallelBlock", tiempo, nombreArchivoResultados);
		Utilidades.guardarResultado2(tiempo, "./src/tiemposIndividuales/ivParallelBlock");


		
		inicioEjecucion = System.nanoTime();
		vSequentialblock.vSequentialblock(matriz1, matriz2, tamanio);
		finEjecucion = System.nanoTime();
		tiempo = (finEjecucion-inicioEjecucion);
		System.out.println("Tiempo de ejecucion vSequentialblock: "+tiempo);
		Utilidades.guardarResultado("vSequentialblock", tiempo, nombreArchivoResultados);
		Utilidades.guardarResultado2(tiempo, "./src/tiemposIndividuales/vSequentialblock");



		inicioEjecucion = System.nanoTime();
		vParallelBlock.vParallelBlock(matriz1, matriz2, tamanio);
		finEjecucion = System.nanoTime();
		tiempo = (finEjecucion-inicioEjecucion);
		System.out.println("Tiempo de ejecucion vParallelBlock : "+tiempo);	
		Utilidades.guardarResultado("vParallelBlock", tiempo, nombreArchivoResultados);
		Utilidades.guardarResultado2(tiempo, "./src/tiemposIndividuales/vParallelBlock");


		
	}

	

}


