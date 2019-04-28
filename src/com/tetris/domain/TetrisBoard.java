/**
 * 
 */
package com.tetris.domain;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author aniket
 *
 *
 * This is a simple x*y array.
 * 
 * The array is initialized with 0,0 entries at each x,y locations
 * 
 * 
 * 
 *
 */
public class TetrisBoard {

	static int heightofBoard =6;//this can also be taken as user input
	static int lengthofBoard =5;
	
	static int userPoints =0;
	//this can be taken from the user
	 static int[][] tetrisBoard= new int[heightofBoard][lengthofBoard];
	
	 TetrisBoard() {
		
		for(int y=0;y<heightofBoard;y++) {
			for(int x=0;x<lengthofBoard;x++)
			{
				tetrisBoard[y][x]=0;
			}
		}
	}
	 
	 
	public static void main(String[] args) {
		//starter which will accept the input and check whether the input is valid one or not and based on that whether 
		// the step is valid or invalid.
		//accept input from user
		
		printTheBoard();

		Coordinates coordinate = new Coordinates();
		String name =null;
		Tetrimo s = new Tetrimo();
		s.initialiseTetrimonoMap();
while(true) {
		try {
		System.out.println("Enter LENGTH coordinate");
		 BufferedReader xCoordinate =  
                 new BufferedReader(new InputStreamReader(System.in));
			int x = Integer.parseInt(xCoordinate.readLine());

			
		 System.out.println("Enter HEIGHT coordinate");
		 BufferedReader yCoordinate =  
                 new BufferedReader(new InputStreamReader(System.in));
			int y = Integer.parseInt(yCoordinate.readLine());

		
     // Reading data using readLine 
        
			coordinate.setX(x);
			coordinate.setY(y);
			
			System.out.println("Please provide your desired input");
			
			//Enter data using BufferReader 
	        BufferedReader reader =  
	                   new BufferedReader(new InputStreamReader(System.in));

			name = reader.readLine();


		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
  
		
		//check if the any row is complete , so that you can change it to 0; 
		isRowComplete();
		
		//check if board is full, this will happen if the top row is full and it cannot any valid tetrimo
		  boolean result = processInput(s,coordinate,name);
		if (!result) {
			System.out.println("Invalid");
			} else {
				updateBoard(s,coordinate,name);
			}

		//print the board
		printTheBoard();
		//isBoardFull();
		
		//processInput(s,)
}
	} 
	
	
	
	
	/*
	 * 
	 * This will take the above input and process 
	 * 
	 *algo :
	 *
	 * check the type of shape , and call the factory to fetch the appropriate shape
	 * 
	 * 
	 * c is the coordinate where you want to place the shape 
	 * 
	 * 
	 * 
	 * 		tetrimo.put("T",new int[][] {{1,1,1},{0,1,0}});

	 */
	 
	static boolean processInput(Tetrimo s,Coordinates c, String tetrimoType) {
	   
		int[][] input =  s.tetrimo.get(tetrimoType);
		
		//fetch the  input details from coordinates
				int coordinateX =  c.getX();
				int coordinateY = c.getY();
				
				if(coordinateX>lengthofBoard || coordinateY> heightofBoard) {
					return false;//cant process;
				}
		
				System.out.println("printing the input");
				print(input);	
		//iterate till the length and width of tetrimo 
		for(int y=0;y<input.length;y++)
			for(int x=0;x<input[y].length;x++) {
				//check the feasibility of the board
				if (coordinateX+x>=lengthofBoard || coordinateY+y>=heightofBoard || (input[y][x] + tetrisBoard[coordinateY+y][coordinateX+x]==2)) {
					return false;

				} else {
					continue;
				}
				
			}
							
	return true;
	}
	
	
	/*
	 * 
	 * isComplete
	 * 
	 */
	static void isRowComplete() {

		for (int j = 0; j < heightofBoard; j++) {
			int counter = 0;
			for (int i = 0; i < lengthofBoard; i++) {
				if (tetrisBoard[j][i] == 1) {
					continue;

				}
				
			}if (counter == lengthofBoard) {
				// clean up the row
				for (int row = 0; row < lengthofBoard; row++) {
					tetrisBoard[row][j] = 0;
					userPoints++;
				}
			}
		}

	}
	
	
	
	//UPDATE BOARD
	static void updateBoard(Tetrimo s,Coordinates c, String tetrimoType) {
		
			   
			int[][] input =  s.tetrimo.get(tetrimoType);
			
			//fetch the  input details from coordinates
					int coordinateX =  c.getX();
					int coordinateY = c.getY();
					
					
				
			//iterate till the length and width of tetrimo 
			for(int y=0;y<input.length;y++) {
				for(int x=0;x<input[y].length;x++) {
					//check the feasibility of the board
						tetrisBoard[coordinateY+y][coordinateX+x] = tetrisBoard[coordinateY+y][coordinateX+x] + input[y][x];
					
								
		}}
		
		
	}
	
	
	
	//Print the board
	
	static void printTheBoard() {
		
		//iterate till1 the length and width of tetrimo 
				for(int y=0;y< heightofBoard;y++) {
					for(int x=0;x<lengthofBoard;x++) {
						System.out.print("\t" + tetrisBoard[y][x]);
	} System.out.println("");}
	}	
	
	
	
	/*
	 * [1 1 1]
	 * [0 1 0]
	 * 
	 * 
	 * To do , merge the print methods 
	 */
	static void print(int[][] input) {
		System.out.println("INPUT LENGH" + input.length);
		for(int y=0;y<input.length;y++) {
			for(int x=0;x<input[y].length;x++) {
				System.out.print("\t" +input[y][x]);
	}System.out.println("");}
}}
