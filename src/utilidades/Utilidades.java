package utilidades;

import java.io.FileWriter;
import java.io.IOException;

public class Utilidades {
	
	public Utilidades() {
		
	}
	
    public static void guardarResultado(String resultado, String nombreAlgoritmo) {
        try {
            FileWriter archivo = new FileWriter("archivo.txt", true); // true para abrir en modo de append
            archivo.write(resultado + " - " + nombreAlgoritmo + "\n"); // agregar el resultado y el parametro adicional al final del archivo
            archivo.close(); // cerrar el archivo
        } catch (IOException e) {
            System.out.println("Ha ocurrido un error al guardar el resultado en el archivo.");
            e.printStackTrace();
        }
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
