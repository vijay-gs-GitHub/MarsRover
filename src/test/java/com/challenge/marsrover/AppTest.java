package com.challenge.marsrover;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;

import com.challenge.marsrover.dto.Rover;
import com.challenge.marsrover.process.MarsRover;

/**
 * Unit test cases for mars rover App.
 */
public class AppTest {
			
	@Test
	public void testPositiveCase() {
		List<String> input = Arrays.asList("5 5","1 2 N","LMLMLMLMM","3 3 E","MMRMMRMRRM");
		try {
			List<Rover> roverList = new MarsRover().process(input);			
			assertEquals("1 3 N", roverList.get(0).toString());
			assertEquals("5 1 E", roverList.get(1).toString());
		} catch (Exception e) {
			e.printStackTrace();
		}		
	}
	
	
	/**
	 *  Negative number -5 in the Upper right coordinate 'x' 
	 */
	@Test(expected=IllegalArgumentException.class)
	public void testNegative_upperRightCoordinates() {
		List<String> input = Arrays.asList("-5 5","1 2 N","LMLMLMLMM","3 3 E","MMRMMRMRRM");
		try {
			new MarsRover().process(input);
		} catch (IllegalArgumentException e) {
			assertEquals("Error : Upper right coordinates must be positive number", e.getMessage());
			throw e;
		}		
	}
	
	/**
	 *  Character 'A' in the Upper right coordinate 'y' 
	 */
	@Test(expected=IllegalArgumentException.class)
	public void testNegative_upperRightCoordinates_02() {
		List<String> input = Arrays.asList("5 A","1 2 N","LMLMLMLMM","3 3 E","MMRMMRMRRM");
		try {
			new MarsRover().process(input);
		} catch (IllegalArgumentException e) {
			assertEquals("Error : Invalid upper right coordinates value", e.getMessage());
			throw e;
		}		
	}
	
	/**
	 *  Negative number -1 in the 1st Rover position 
	 */
	@Test(expected=IllegalArgumentException.class)
	public void testNegative_RoverCoordinates() {
		List<String> input = Arrays.asList("5 5","-1 2 N","LMLMLMLMM","3 3 E","MMRMMRMRRM");
		try {
			 new MarsRover().process(input);
		} catch (IllegalArgumentException e) {
			assertEquals("Error : Rover coordinates must be positive number", e.getMessage());
			throw e;
		}		
	}
	
	
	/**
	 *  Invalid direction value 'U' in the 1st Rover position 
	 */
	@Test(expected=IllegalArgumentException.class)
	public void testNegative_RoverDirection() {
		List<String> input = Arrays.asList("5 5","1 2 U","LMLMLMLMM","3 3 E","MMRMMRMRRM");
		try {
			new MarsRover().process(input);
		} catch (IllegalArgumentException e) {
			assertEquals("Error : Invalid direction, must be N, S, E, or W", e.getMessage());
			throw e;
		}						
	}
	
	/**
	 *  Invalid character 'O' in the 1st Rover instructions 
	 */
	@Test(expected=IllegalArgumentException.class)
	public void testNegative_Invalid_Instructions() {
		List<String> input = Arrays.asList("5 5","1 2 N","LMLOMLMLMM","3 3 E","MMRMMRMRRM");
		try {
			new MarsRover().process(input);
		} catch (IllegalArgumentException e) {
			assertEquals("Error: Invalid instruction must be L, R, or M", e.getMessage());
			throw e;
		}						
	}
	
	
	
	/**
	 *  Second rover final value after processing instructions (MMRMMRMRRMMMMM) is (9 1 E)
	 *  The x value is beyond the limit of upper right x coordinate which is 5
	 *  Hence the method is throwing IllegalStateException. 
	 */
	@Test(expected=IllegalStateException.class)
	public void testNegative_Invalid_Move() {
		List<String> input = Arrays.asList("5 5","1 2 N","LMLMLMLMM","3 3 E","MMRMMRMRRMMMMM");
		try {
			new MarsRover().process(input);
		} catch (IllegalStateException e) {
			assertEquals("Error : Invalid move, position not in the range", e.getMessage());
			throw e;
		}						
	}
	
	
	/**
	 * Increasing the upper right coordinates to (10 10) to pass previous test case instructions "MMRMMRMRRMMMMM"
	 */
	@Test
	public void testPositive_02() {
		List<String> input = Arrays.asList("10 10","1 2 N","LMLMLMLMM","3 3 E","MMRMMRMRRMMMMM");
		try {
			List<Rover> roverList = new MarsRover().process(input);			
			assertEquals("1 3 N", roverList.get(0).toString());
			assertEquals("9 1 E", roverList.get(1).toString());
		} catch (Exception e) {
			e.printStackTrace();
		}		
	}
	
	
	
}
