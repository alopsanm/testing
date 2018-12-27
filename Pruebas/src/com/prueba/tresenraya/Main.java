package com.prueba.tresenraya;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws IOException {
		Tablero tablero = new Tablero();
		tablero.imprimeTablero();

		BufferedReader entrada = null;
		System.out.println("********************************************");
		System.out.println("ELIGE X o O: ");
		System.out.println("********************************************");
		while (entrada == null) {
			entrada = new BufferedReader(new InputStreamReader(System.in));
		}
		Item itemUser = new Item(entrada.readLine().trim());
		Item itemCPU = new Item(itemUser.setItem());
		int turno = tablero.setOrden();

		while (!tablero.checkColumna() && !tablero.checkFila() && !tablero.checkDiagonal()) {
			if (turno == 0 || turno % 2 == 0) {
				int resultado = 1;
				while (resultado != 0) {
					System.out.println("********************************************");
					entrada = null;
					System.out.println("COORDENADAS DEL TABLERO: ");
					System.out.println("VERTICAL: ");
					while (entrada == null) {
						entrada = new BufferedReader(new InputStreamReader(System.in));
					}
					int x = Integer.parseInt(entrada.readLine());
					entrada = null;
					System.out.println("HORIZONTAL: ");
					while (entrada == null) {
						entrada = new BufferedReader(new InputStreamReader(System.in));
					}
					int y = Integer.parseInt(entrada.readLine());
					entrada = null;
					System.out.println("******************************************************");
					System.out.println();
					resultado = tablero.setCasilla(itemUser.getItem(), x, y);
				}
				turno++;
			} else {
				System.out.println("********************************************");
				int resultado = tablero.setCasilla(itemCPU.getItem(), (int) (Math.random() * 3),
						(int) (Math.random() * 3));
				while (resultado != 0) {
					resultado = tablero.setCasilla(itemCPU.getItem(), (int) (Math.random() * 3),
							(int) (Math.random() * 3));
				}
				turno++;
			}
			tablero.imprimeTablero();
		}
		if (turno % 2 != 0) {
			System.out.println("GANA EL USUARIO");
		} else {
			System.out.println("GANA LA MÁQUINA");
		}
	}

}
