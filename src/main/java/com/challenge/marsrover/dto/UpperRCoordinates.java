package com.challenge.marsrover.dto;

/**
 * Holds Upper right coordinates values
 *
 */
public class UpperRCoordinates {

	private int row;
	private int column;
	
	public UpperRCoordinates(int row, int column) {
		super();
		this.row = row;
		this.column = column;
	}

	public int getRow() {
		return row;
	}

	public int getColumn() {
		return column;
	}
	
}