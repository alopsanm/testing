package com.prueba.flota;

public class Barco {

	private int[] casilla_inicial;
	private String direccion;
	private int longitud;
	private Matriz matrix;

	public Barco(int[] casilla_inicial, String direccion, int longitud, Matriz matrix) {
		this.matrix = matrix;
		if (casilla_inicial[0] < 0 || casilla_inicial[1] < 0 || casilla_inicial[0] > matrix.getDimension()
				|| casilla_inicial[1] > matrix.getDimension()) {
			System.out.println("La casilla inicial es incorrecta");
		} else {
			this.casilla_inicial = casilla_inicial;
		}
		if (direccion.toUpperCase().equals("H") || direccion.toUpperCase().equals("V")) {
			this.direccion = direccion.toUpperCase();
		} else {
			System.out.println("La dirección es horizontal (H) o vertical (V)");
		}
		if (longitud < 0) {
			System.out.println("La longitud no puede ser menor de 0");
		} else {
			this.longitud = longitud;
		}
	}

	public int[] getCasilla_inicial() {
		return casilla_inicial;
	}

	public void setCasilla_inicial(int[] casilla_inicial) {
		this.casilla_inicial = casilla_inicial;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public int getLongitud() {
		return longitud;
	}

	public void setLongitud(int longitud) {
		this.longitud = longitud;
	}

	public int ponBarco() {
		System.out.println();
		if (checkEspacio()) {
			if (direccion.equals("H")) {
				for (int i = casilla_inicial[1]; i < longitud + casilla_inicial[1]; i++) {
					matrix.setCasillaMatrix(casilla_inicial[0], i, "[" + String.valueOf(longitud) + "]");
				}
			}
			if (direccion.equals("V")) {
				for (int i = casilla_inicial[0]; i < longitud + casilla_inicial[0]; i++) {
					matrix.setCasillaMatrix(i, casilla_inicial[1], "[" + String.valueOf(longitud) + "]");
				}
			}
			return 0;
		}
		return 1;
	}

	private boolean checkEspacio() {
		if (direccion.equals("H")) {
			if ((longitud + casilla_inicial[1]) > matrix.getDimension()) {
				return false;
			}
			for (int i = casilla_inicial[1]; i < longitud + casilla_inicial[1]; i++) {
				if (!matrix.getMatrix()[casilla_inicial[0]][i].equals("[ ]")) {
					return false;
				}
			}
		}
		if (direccion.equals("V")) {
			if ((longitud + casilla_inicial[0]) > matrix.getDimension()) {
				return false;
			}
			for (int i = casilla_inicial[0]; i < longitud + casilla_inicial[0]; i++) {
				if (!matrix.getMatrix()[i][casilla_inicial[1]].equals("[ ]")) {
					return false;
				}
			}
		}
		return true;
	}

}
