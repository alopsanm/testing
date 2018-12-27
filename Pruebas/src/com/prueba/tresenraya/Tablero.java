package com.prueba.tresenraya;

public class Tablero {

	String[][] tablero;

	public Tablero() {
		this.tablero = new String[3][3];
		for (int i = 0; i < tablero.length; i++) {
			for (int j = 0; j < tablero.length; j++) {
				tablero[i][j] = "[ ]";
			}
		}
	}

	public int setCasilla(String item, int i, int j) {
		if (i < 0 || i > 2 || j < 0 || j > 2) {
			System.out.println("La casilla seleccionada no es válida");
		}
		if (!item.equals("X") && !item.equals("O")) {
			System.out.println("El item no es válido");
		}
		if (tablero[i][j].equals("[ ]")) {
			tablero[i][j] = "[" + item + "]";
			return 0;
		} else {
			System.out.println("La casilla seleccionada ya tiene contenido");
		}
		return 1;
	}

	public boolean checkFila() {
		if (!tablero[0][0].equals("[ ]") && tablero[0][0].equals(tablero[0][1])
				&& tablero[0][1].equals(tablero[0][2])) {
			return true;
		} else if (!tablero[1][0].equals("[ ]") && tablero[1][0].equals(tablero[1][1])
				&& tablero[1][1].equals(tablero[1][2])) {
			return true;
		} else if (!tablero[2][0].equals("[ ]") && tablero[2][0].equals(tablero[2][1])
				&& tablero[2][1].equals(tablero[2][2])) {
			return true;
		}
		return false;
	}

	public boolean checkColumna() {
		if (!tablero[0][0].equals("[ ]") && tablero[0][0].equals(tablero[1][0])
				&& tablero[1][0].equals(tablero[2][0])) {
			return true;
		} else if (!tablero[0][1].equals("[ ]") && tablero[0][1].equals(tablero[1][1])
				&& tablero[1][1].equals(tablero[2][1])) {
			return true;
		} else if (!tablero[0][2].equals("[ ]") && tablero[0][2].equals(tablero[1][2])
				&& tablero[1][2].equals(tablero[2][2])) {
			return true;
		}
		return false;
	}

	public boolean checkDiagonal() {
		if (!tablero[0][0].equals("[ ]") && tablero[0][0].equals(tablero[1][1])
				&& tablero[1][1].equals(tablero[2][2])) {
			return true;
		} else if (!tablero[0][2].equals("[ ]") && tablero[0][2].equals(tablero[1][1])
				&& tablero[1][1].equals(tablero[2][0])) {
			return true;
		}
		return false;
	}

	public void imprimeTablero() {
		for (int i = 0; i < tablero.length; i++) {
			System.out.println();
			for (int j = 0; j < tablero.length; j++) {
				System.out.print(tablero[i][j]);
			}
		}
		System.out.println();
	}

	public int setOrden() {
		return (int) Math.round(Math.random());
	}

}
