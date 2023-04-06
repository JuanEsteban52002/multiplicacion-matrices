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
		ArrayList<Long> datos = new ArrayList<>();
		
		

		
		/*
		 * Para generar las matrices 
		 */
		
        int[][] matriz1 = Utilidades.generarMatriz(tamanio);
        int[][] matriz2 = Utilidades.generarMatriz(tamanio);

        // Guardar la matriz en un archivo
        Utilidades.guardarMatriz(matriz1, "./src/matrices/Matriz1 ("+ tamanio + ").txt");
        Utilidades.guardarMatriz(matriz2, "./src/matrices/Matriz2 ("+ tamanio + ").txt");

			
		inicioEjecucion = System.nanoTime();
		naivStandard.naivStandard(matriz1, matriz2, resultado, N, P, M);
		finEjecucion = System.nanoTime();
		tiempo = (finEjecucion-inicioEjecucion);
		System.out.println("Tiempo de ejecucion naivStandard: "+tiempo);
		Utilidades.guardarResultado("naivStandard", tiempo, nombreArchivoResultados);
		Utilidades.guardarResultado2(tiempo, "./src/tiemposIndividuales/naivStandard");
		
		datos.add(tiempo);
		
		
		
		inicioEjecucion = System.nanoTime();
		naivOnArray.naivOnArray(matriz1, matriz2, resultado, N, P, M);
		finEjecucion = System.nanoTime();
		tiempo = (finEjecucion-inicioEjecucion);
		System.out.println("Tiempo de ejecucion naivOnArray: "+tiempo);
		Utilidades.guardarResultado("naivOnArray", tiempo, nombreArchivoResultados);
		Utilidades.guardarResultado2(tiempo, "./src/tiemposIndividuales/naivOnArray");

		datos.add(tiempo);

		
		inicioEjecucion = System.nanoTime();
		naivKahan.naivKahan(matriz1, matriz2, resultado, N, P, M);
		finEjecucion = System.nanoTime();
		tiempo = (finEjecucion-inicioEjecucion);
		System.out.println("Tiempo de ejecucion naivKahan : "+tiempo);
		Utilidades.guardarResultado("naivKahan", tiempo, nombreArchivoResultados);
		Utilidades.guardarResultado2(tiempo, "./src/tiemposIndividuales/naivKahan");

		datos.add(tiempo);


		
		inicioEjecucion = System.nanoTime();
		naivLoopUnrollingTwo.naivLoopUnrollingTwo(matriz1, matriz2, resultado, N, P, M);
		finEjecucion = System.nanoTime();
		tiempo = (finEjecucion-inicioEjecucion);
		System.out.println("Tiempo de ejecucion naivLoopUnrollingTwo: "+tiempo);
		Utilidades.guardarResultado("naivLoopUnrollingTwo", tiempo, nombreArchivoResultados);
		Utilidades.guardarResultado2(tiempo, "./src/tiemposIndividuales/naivLoopUnrollingTwo");

		datos.add(tiempo);


		
		inicioEjecucion = System.nanoTime();
		naivLoopUnrollingThree.naiveLoopUnrollingThree(matriz1, matriz2);
		finEjecucion = System.nanoTime();
		tiempo = (finEjecucion-inicioEjecucion);
		System.out.println("Tiempo de ejecucion naiveLoopUnrollingThree: "+tiempo);
		Utilidades.guardarResultado("naiveLoopUnrollingThree", tiempo, nombreArchivoResultados);
		Utilidades.guardarResultado2(tiempo, "./src/tiemposIndividuales/naiveLoopUnrollingThree");

		datos.add(tiempo);

		
		
		inicioEjecucion = System.nanoTime();
		naivLoopUnrollingFour.naivLoopUnrollingFour(matriz1, matriz2, resultado, N, P, M);
		finEjecucion = System.nanoTime();
		tiempo = (finEjecucion-inicioEjecucion);
		System.out.println("Tiempo de ejecucion naivLoopUnrollingFour: "+tiempo);
		Utilidades.guardarResultado("naivLoopUnrollingFour", tiempo, nombreArchivoResultados);
		Utilidades.guardarResultado2(tiempo, "./src/tiemposIndividuales/naivLoopUnrollingFour");

		datos.add(tiempo);

		
		
		inicioEjecucion = System.nanoTime();
		winogradOriginal.winogradOriginal(matriz1, matriz2);
		finEjecucion = System.nanoTime();
		tiempo = (finEjecucion-inicioEjecucion);
		System.out.println("Tiempo de ejecucion winogradOriginal: "+tiempo);
		Utilidades.guardarResultado("winogradOriginal", tiempo, nombreArchivoResultados);
		Utilidades.guardarResultado2(tiempo, "./src/tiemposIndividuales/winogradOriginal");

		datos.add(tiempo);

		
		inicioEjecucion = System.nanoTime();
		winoScaled.winogradScaled(matriz1, matriz2, resultado, N, P, M);
		finEjecucion = System.nanoTime();
		tiempo = (finEjecucion-inicioEjecucion);
		System.out.println("Tiempo de ejecucion winogradScaled: "+tiempo);		
		Utilidades.guardarResultado("winogradScaled", tiempo, nombreArchivoResultados);
		Utilidades.guardarResultado2(tiempo, "./src/tiemposIndividuales/winogradScaled");
		
		datos.add(tiempo);

		
		inicioEjecucion = System.nanoTime();
		strassenNaiv.StrassenNaiv(matriz1, matriz2, resultado, N, P, M);
		finEjecucion = System.nanoTime();
		tiempo = (finEjecucion-inicioEjecucion);
		System.out.println("Tiempo de ejecucion StrassenNaiv: "+tiempo);
		Utilidades.guardarResultado("StrassenNaiv", tiempo, nombreArchivoResultados);
		Utilidades.guardarResultado2(tiempo, "./src/tiemposIndividuales/StrassenNaiv");

		datos.add(tiempo);

		
		inicioEjecucion = System.nanoTime();
		StrassenWinograd.StrassenWinograd(matriz1, matriz2, resultado, N, P, M);
		finEjecucion = System.nanoTime();
		tiempo = (finEjecucion-inicioEjecucion);
		System.out.println("Tiempo de ejecucion StrassenWinograd: "+tiempo);
		Utilidades.guardarResultado("StrassenWinograd", tiempo, nombreArchivoResultados);
		Utilidades.guardarResultado2(tiempo, "./src/tiemposIndividuales/StrassenWinograd");

		datos.add(tiempo);

		
		inicioEjecucion = System.nanoTime();
		iiiSequentialblock.iiisequentianblock(matriz1, matriz2, tamanio);
		finEjecucion = System.nanoTime();
		tiempo = (finEjecucion-inicioEjecucion);
		System.out.println("Tiempo de ejecucion iiisequentianblock: "+tiempo);
		Utilidades.guardarResultado("iiisequentianblock", tiempo, nombreArchivoResultados);
		Utilidades.guardarResultado2(tiempo, "./src/tiemposIndividuales/iiisequentianblock");

		datos.add(tiempo);

        
        
		inicioEjecucion = System.nanoTime();
		iiiParallelBlock.iiiParallelblock(matriz1, matriz2, tamanio);
		finEjecucion = System.nanoTime();
		tiempo = (finEjecucion-inicioEjecucion);
		System.out.println("Tiempo de ejecucion iiiParallelblock: "+tiempo);
		Utilidades.guardarResultado("iiiParallelblock", tiempo, nombreArchivoResultados);
		Utilidades.guardarResultado2(tiempo, "./src/tiemposIndividuales/iiiParallelblock");

		datos.add(tiempo);

		
		inicioEjecucion = System.nanoTime();
		ivSequentialblock.ivSequentialblock(matriz1, matriz2, tamanio);
		finEjecucion = System.nanoTime();
		tiempo = (finEjecucion-inicioEjecucion);
		System.out.println("Tiempo de ejecucion ivSequentialblock: "+tiempo);
		Utilidades.guardarResultado("ivSequentialblock", tiempo, nombreArchivoResultados);
		Utilidades.guardarResultado2(tiempo, "./src/tiemposIndividuales/ivSequentialblock");

		datos.add(tiempo);

		
        
		inicioEjecucion = System.nanoTime();
		ivParallelBlock.ivParallelBlock(matriz1, matriz2, tamanio);
		finEjecucion = System.nanoTime();
		tiempo = (finEjecucion-inicioEjecucion);
		System.out.println("Tiempo de ejecucion ivParallelBlock: "+tiempo);
		Utilidades.guardarResultado("ivParallelBlock", tiempo, nombreArchivoResultados);
		Utilidades.guardarResultado2(tiempo, "./src/tiemposIndividuales/ivParallelBlock");

		datos.add(tiempo);

		
		inicioEjecucion = System.nanoTime();
		vSequentialblock.vSequentialblock(matriz1, matriz2, tamanio);
		finEjecucion = System.nanoTime();
		tiempo = (finEjecucion-inicioEjecucion);
		System.out.println("Tiempo de ejecucion vSequentialblock: "+tiempo);
		Utilidades.guardarResultado("vSequentialblock", tiempo, nombreArchivoResultados);
		Utilidades.guardarResultado2(tiempo, "./src/tiemposIndividuales/vSequentialblock");

		datos.add(tiempo);


		inicioEjecucion = System.nanoTime();
		vParallelBlock.vParallelBlock(matriz1, matriz2, tamanio);
		finEjecucion = System.nanoTime();
		tiempo = (finEjecucion-inicioEjecucion);
		System.out.println("Tiempo de ejecucion vParallelBlock : "+tiempo);	
		Utilidades.guardarResultado("vParallelBlock", tiempo, nombreArchivoResultados);
		Utilidades.guardarResultado2(tiempo, "./src/tiemposIndividuales/vParallelBlock");

		datos.add(tiempo);

		

		
		//Requerimiento 6:
		double media = Utilidades.calcularMedia(datos);
        double varianza = Utilidades.calcularVarianza(datos, media);
        double desviacionEstandar = Math.sqrt(varianza);
        System.out.println("La Desviacion Estandar es: " + desviacionEstandar);
		double rengo = Utilidades.calcularRango(datos);
		Utilidades.guardarEstadisticos(media, varianza, desviacionEstandar, rengo, nombreArchivoEstadisticos);
		

		
		//Requerimiento 4
//		Utilidades.calcularPromedio();
		//Clase que se GraficoDeBarras
		
		
		//Requerimiento 5:
		//Clase que se llama requerimiento 5
		
		
		//Requerimiento 7:
		//Tomar cada uno de los archivos en los que estan guardados los tiempos de cada algoritmo
		
		
		
			
		
	

		
		
		
	}

	

}


