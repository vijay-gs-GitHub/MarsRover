package com.challenge.marsrover.util;

import java.util.HashMap;
import java.util.Map;

public class Direction {
		
	/**
	 * Holds direction details . 
	 * Returns Right or Left direction when rover spins 90 degree based on current direction . 
	 * 
	 *  eg:  current direction of rover : N (North)
	 *       If it spins 90 degree Right then the value is E (East) 
	 * 
	 * 
	 * @return direction map
	 */
	public static Map<Character, Map<Character, Character>> getDirections() {

		Map<Character, Character> NorthMap = new HashMap<>();
		NorthMap.put('R', 'E');
		NorthMap.put('L', 'W');

		Map<Character, Character> EastMap = new HashMap<>();
		EastMap.put('R', 'S');
		EastMap.put('L', 'N');

		Map<Character, Character> SouthMap = new HashMap<>();
		SouthMap.put('R', 'W');
		SouthMap.put('L', 'E');

		Map<Character, Character> WestMap = new HashMap<>();
		WestMap.put('R', 'N');
		WestMap.put('L', 'S');

		Map<Character, Map<Character, Character>> directionMap = new HashMap<>();
		directionMap.put('N', NorthMap);
		directionMap.put('E', EastMap);
		directionMap.put('S', SouthMap);
		directionMap.put('W', WestMap);

		return directionMap;

	}

}
