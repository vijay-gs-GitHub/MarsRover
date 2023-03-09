package com.challenge.marsrover.process;

import java.util.Map;

import com.challenge.marsrover.dto.Rover;
import com.challenge.marsrover.dto.UpperRCoordinates;
import com.challenge.marsrover.util.Direction;


public class Instructions {
	
	
	public static Map<Character, Map<Character, Character>> directionMap = Direction.getDirections();
	

	/**
	 * This method is for operating rover 
	 * Spins 90 degree left or right and move one grid point based on instructions and directions 
	 * 
	 * @param r - Rover
	 * @param c - upper right coordinates
	 * @return Rover details 
	 * @throws Exception
	 */
	public Rover process(Rover r, UpperRCoordinates c) throws IllegalArgumentException, IllegalStateException{
		char[] inArr = r.getInstruction().toCharArray();
		int currentRow = r.getRow();
		int currentColumn = r.getColumn();
		char currentDirection = r.getDirection();
		int maxR = c.getRow();
		int maxC = c.getColumn();

		for (char instruction : inArr) {
			if (instruction == 'R' || instruction == 'L') {
				currentDirection = directionMap.get(currentDirection).get(instruction);
			} else if (instruction == 'M') {
				switch (currentDirection) {
				case 'N': 
					currentColumn++;
					break;
				case 'S': 
					currentColumn--;
					break;
				case 'E': 
					currentRow++;
					break;
				case 'W':
					currentRow--;
					break;
				}

				if( currentRow < 0 || currentColumn < 0 || currentRow > maxR || currentColumn > maxC) {
					throw new IllegalStateException("Error : Invalid move, position not in the range");
				}

			} else {
				throw new IllegalArgumentException("Error: Invalid instruction must be L, R, or M");
			}
		}		
		return new Rover(currentRow, currentColumn, currentDirection);
	}

}
