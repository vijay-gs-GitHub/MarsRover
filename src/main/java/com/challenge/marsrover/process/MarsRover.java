package com.challenge.marsrover.process;

import java.util.ArrayList;
import java.util.List;

import com.challenge.marsrover.dto.Rover;
import com.challenge.marsrover.dto.UpperRCoordinates;
import com.challenge.marsrover.util.InputParser;

public class MarsRover {
	
	/**
	 * This method process input and returns list of Rovers with result 
	 * 
	 * @param input - List of input 
	 * @return - List of rover
	 * @throws Exception
	 */
	public List<Rover> process(List<String> input) throws IllegalArgumentException, IllegalStateException {
		
		List<Rover> roverList = new ArrayList<>();
		Instructions ins = new Instructions();
         		
		UpperRCoordinates uRc = InputParser.getUpperRCoordinates(input.get(0));
		int n = input.size();
		int i = 1;
		while (i < n) {
			Rover r = InputParser.getRover(input.get(i), input.get(i+1));
			roverList.add(ins.process(r,uRc));
			i+=2;
		}			
		
		return roverList;
	}

}
