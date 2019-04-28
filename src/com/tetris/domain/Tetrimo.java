/**
 * 
 */
package com.tetris.domain;

import java.util.HashMap;
import java.util.Map;

/**
 * @author aniket
 * 
 * Any input  shape can be added in the below class
 *
 */
public  class Tetrimo {

	Map<String,int[][]> tetrimo = new HashMap<>();
	
	Map<String,int[][]> initialiseTetrimonoMap()
	{	
		tetrimo.put("T",new int[][] {{1,1,1},{0,1,0}});
		tetrimo.put("L",new int[][] {{0,0,1},{1,1,1}});
		tetrimo.put("S",new int[][] {{1,1},{1,1}});
		tetrimo.put("I", new int[][] {{1,1,1},{0,0,0}});

return 	tetrimo;}
	
	
	
}
