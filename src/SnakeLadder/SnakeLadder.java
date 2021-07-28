package SnakeLadder;

import java.util.*;
public class SnakeLadder {
	
	final int NO_PLAY = 0;
	final int LADDER = 1;
	final int SNAKE = 2;
	int min = 1;
	int max = 6;
	
	// Roll the dice
	private int rollDice() {		
		int diceNumber = (int)(Math.random() * (max - min +1) + min);
	    System.out.println("Dies number : " + diceNumber);
	    return diceNumber;
	}
	
	// Function to get the options 
	private int getOption() {
		int checkOption = (int)(Math.random() * 10) % 3;
	    
	    switch(checkOption){
	        case NO_PLAY : 
	            System.out.println("Option : No play ");
	        break;
	        case LADDER : 
	            System.out.println("Option : Ladder ");
	        break;
	        case SNAKE : 
	            System.out.println("Option : Snake ");
	        break;
	    }
	    return checkOption;
	}
	
	public static void main(String[] args) {
		
		SnakeLadder game = new SnakeLadder();
		Scanner sc= new Scanner(System.in);
		// initialise position as 0
		int position = 0;		
		
		System.out.print("Press 1 for Roll the Dice :");
		int number = sc.nextInt();
		if(number == 1){
			
		    // Get dice number
			game.rollDice();
			
		    // Get options 
			game.getOption();		    
		}
		else{
		    System.out.println("Invalid Input");
		}
	}
}
