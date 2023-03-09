package com.challenge.marsrover.util;

import java.util.Arrays;
import java.util.List;

import com.challenge.marsrover.dto.Rover;
import com.challenge.marsrover.dto.UpperRCoordinates;

public class InputParser {
	

	public static List<Character> directionList = Arrays.asList('N','E','W','S');
	
	
	/**
	 * This method parse input and returns created upper right coordinates object
	 * 
	 * @param coordinates - String 
	 * @return UpperRCoordinates
	 * @throws Exception
	 */
	public static UpperRCoordinates getUpperRCoordinates(String coordinates) throws IllegalArgumentException {
		String upperRCordinates[] = getParsedInputs(coordinates);
		int r,c;
		try {
			r = Integer.parseInt(upperRCordinates[0]);
			c = Integer.parseInt(upperRCordinates[1]);			
		}catch (Exception e) {
			throw new IllegalArgumentException("Error : Invalid upper right coordinates value");
		}
		
		if(r<0 || c<0) {
			throw new IllegalArgumentException("Error : Upper right coordinates must be positive number");
		}
		return new UpperRCoordinates(r, c);
	}	


	static String[] getParsedInputs(String s) {
		return s.split("\\s+");
	}


	/**
	 * This method parse input and returns Rover object.
	 * 
	 * @param position - String - eg (3 1 N)
	 * @param instruction - String - eg (LMMLMMLM)
	 * @return Rover 
	 * @throws Exception
	 */
	public static Rover getRover(String position, String instruction) throws IllegalArgumentException {
		String Position[] = getParsedInputs(position);
		int x, y;
		char d; 
		try {
			x = Integer.parseInt(Position[0]);
			y = Integer.parseInt(Position[1]);
	        d = (Position[2].length() == 1) ? Position[2].charAt(0) : ' ';			
		}catch (Exception e) {
			throw new IllegalArgumentException("Error : Invalid rover position value");
		}
        
		if(x<0 || y<0) {
			throw new IllegalArgumentException("Error : Rover coordinates must be positive number");
		}
		
		if(!directionList.contains(d)) {
			throw new IllegalArgumentException("Error : Invalid direction, must be N, S, E, or W");
		}

		return new Rover(x, y, d, instruction);
	}	

}
