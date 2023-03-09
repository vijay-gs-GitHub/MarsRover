package com.challenge.marsrover;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.challenge.marsrover.dto.Rover;
import com.challenge.marsrover.process.MarsRover;

public class App {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub		
		List<String> input = new ArrayList<>();
		
		System.out.println("Enter inputs for mars-rover below :");
		
		try (Scanner in = new Scanner(System.in)) {
			int t = 5;
			while(t-- > 0) {
				input.add( in.nextLine());			
			}
		}
		
		try {		
			 MarsRover mri = new MarsRover();
			 List<Rover> rovers = mri.process(input);
			 System.out.println(" ");
			 rovers.forEach(r -> System.out.println(r));
		}catch(Exception e) {
			System.err.println(e.getMessage());
		}	
	}
	
}
