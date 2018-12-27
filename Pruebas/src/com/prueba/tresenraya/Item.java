package com.prueba.tresenraya;

public class Item {

	private String item;

	public Item(String item) {
		if (item.equals("X") || item.equals("O")) {
			this.item = item;
		} else {
			System.out.println("El caracter debe ser X o O");
		}
	}

	public String getItem() {
		return this.item;
	}

	public String setItem() {
		if (item.equals("X")) {
			return "O";
		} else if (item.equals("O")) {
			return "X";
		}
		return "";
	}

}
