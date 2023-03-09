package com.challenge.marsrover.dto;

public class Rover {

	private int row;	
	private int column;
	private char direction;
	private String instruction;

	public Rover(int row, int column, char direction) {
		super();
		this.row = row;
		this.column = column;
		this.direction = direction;
	}

	public Rover(int row, int column, char direction, String instruction) {
		super();
		this.row = row;
		this.column = column;
		this.direction = direction;
		this.instruction = instruction;
	}

	public int getRow() {
		return row;
	}
	public void setRow(int row) {
		this.row = row;
	}
	public int getColumn() {
		return column;
	}
	public void setColumn(int column) {
		this.column = column;
	}

	public char getDirection() {
		return direction;
	}
	public void setDirection(char direction) {
		this.direction = direction;
	}
	public String getInstruction() {
		return instruction;
	}
	public void setInstruction(String instruction) {
		this.instruction = instruction;
	}

	@Override
	public String toString() {
		return row + " " + column + " " + direction;
	}
}

