package com.prueba.flota;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) {
		try {
			BufferedReader entrada = null;
			System.out.println("DIMENSION DEL TABLERO: ");
			while (entrada == null) {
				entrada = new BufferedReader(new InputStreamReader(System.in));
			}
			int dimension = 0, x = 0, y = 0, cuenta = 0;
			dimension = Integer.parseInt(entrada.readLine());
			Matriz matrix = rellenaJuego(dimension);
			Matriz matrizJuego = new Matriz(matrix.getDimension(), matrix.getBarcos());
			while (cuenta < matrix.getBarcos()) {
				entrada = null;
				System.out.println();
				System.out.println("******************************************************");
				System.out.println("COORDENADAS DEL TABLERO: ");
				System.out.println("VERTICAL: ");
				while (entrada == null) {
					entrada = new BufferedReader(new InputStreamReader(System.in));
				}
				x = Integer.parseInt(entrada.readLine());
				entrada = null;
				System.out.println("HORIZONTAL: ");
				while (entrada == null) {
					entrada = new BufferedReader(new InputStreamReader(System.in));
				}
				y = Integer.parseInt(entrada.readLine());
				entrada = null;
				System.out.println("******************************************************");
				System.out.println();
				cuenta += checkMisil(matrix, matrizJuego, x, y);
				System.out.println();
				System.out.println("******************************************************");
				matrizJuego.imprimeMatriz();
				System.out.println();
				System.out.println("******************************************************");
				System.out.println("Llevas " + cuenta + " casillas descubiertas de " + matrix.getBarcos()
						+ " casillas por descubrir");
				System.out.println("******************************************************");
			}
		} catch (NumberFormatException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private static int checkMisil(Matriz matriz, Matriz matrizJuego, int i, int j) {
		String[][] matrix = matriz.getMatrix();
		if (matrix[i][j].equals("[ ]")) {
			System.out.println("Agua");
			matrizJuego.setCasillaMatrix(i, j, "[+]");
			return 0;
		} else {
			System.out.println("Tocado!");
			matrizJuego.setCasillaMatrix(i, j, "[X]");
			return 1;
		}
	}

	private static Matriz rellenaJuego(int dimension) {
		Matriz matrizCPU = null;
		String[] direcciones = new String[] { "H", "V" };
		if (dimension >= 5 && dimension <= 30) {
			int[] dimensiones;
			if (dimension <= 10) {
				dimensiones = Constant.DIMENSIONES_BARCOS_10x10;
			} else if (dimension <= 20) {
				dimensiones = Constant.DIMENSIONES_BARCOS_20x20;
			} else {
				dimensiones = Constant.DIMENSIONES_BARCOS_30x30;
			}
			int casillas = 0;
			for (int i = 0; i < dimensiones.length; i++) {
				casillas += dimensiones[i];
			}
			matrizCPU = new Matriz(dimension, casillas);
			for (int i = 0; i < dimensiones.length; i++) {
				Barco barco = new Barco(
						new int[] { (int) (Math.random() * dimension), (int) (Math.random() * dimension) },
						direcciones[(int) Math.round(Math.random())], dimensiones[i], matrizCPU);
				int resultado = barco.ponBarco();
				while (resultado != 0) {
					barco = new Barco(
							new int[] { (int) (Math.random() * dimension), (int) (Math.random() * dimension) },
							direcciones[(int) Math.round(Math.random())], dimensiones[i], matrizCPU);
					resultado = barco.ponBarco();
				}
			}
		} else {
			System.out.println("El tablero debe ser al menos de 5x5 y como máximo 30x30");
		}
		return matrizCPU;
	}

}
