package com.prueba.flota;

public class Matriz {

	private String[][] matrix;

	private int barcos;

	public String[][] getMatrix() {
		return matrix;
	}

	public void setMatrix(String[][] matrix) {
		this.matrix = matrix;
	}

	public int getBarcos() {
		return barcos;
	}

	public void setBarcos(int barcos) {
		this.barcos = barcos;
	}

	public void setCasillaMatrix(int i, int j, String value) {
		this.matrix[i][j] = value;
	}

	public Matriz(int dim, int barcos) {
		this.matrix = new String[dim][dim];
		this.barcos = barcos;
		this.rellenaMatriz();
	}

	public void imprimeMatriz() {
		if (matrix != null) {
			for (int i = 0; i < matrix.length; i++) {
				System.out.println();
				for (int j = 0; j < matrix.length; j++) {
					System.out.print(matrix[i][j]);
				}
			}
			System.out.println();
		}
	}

	public int getDimension() {
		return matrix[0].length;
	}

	private void rellenaMatriz() {
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix.length; j++) {
				this.matrix[i][j] = "[ ]";
			}
		}
	}

}
