package SnakeLadder;

import java.util.*;
public class SnakeLadder {
	
	final int NO_PLAY = 0;
	final int LADDER = 1;
	final int SNAKE = 2;
	int min = 1;
	int max = 6;
	static int position = 0;
	static int winningPosition = 5;
	
	// Roll the dice
	public int rollDice() {		
		int diceNumber = (int)(Math.random() * (max - min +1) + min);
	    System.out.println("Dies number : " + diceNumber);
	    return diceNumber;
	}
	
	// Function to get the options 
	public int getOption(int diceResult) {
		
		int checkOption = (int)(Math.random() * 10) % 3;
		
	    switch(checkOption){
	        case NO_PLAY : 
	            System.out.println("Option : No play ");
	        break;
	        case LADDER : 
	            System.out.println("Option : Ladder ");
	            position += diceResult;
	            if(position > winningPosition) {
	            	position -= diceResult;
	            }
	        break;
	        case SNAKE : 
	            System.out.println("Option : Snake ");
	            position -= diceResult;
	         // Reset position value to 0 when it is negative
                if(position < 0){
                    position = 0;
                }
             break; 
        }
	    
	    return position;
	}
	
	public static void main(String[] args) {
		
		//create object for class SnakeLadder 
		SnakeLadder game = new SnakeLadder();
		Scanner sc = new Scanner(System.in);
		int rollCount = 0;
		int currentPosition = 0;
		//int positionArr[] = new int[1000];
		while(position < winningPosition ){
			System.out.print("Press 1 for Roll the Dice :");
			int number = sc.nextInt();
			if(number == 1){
				
			    // Get dice number
				int diceResult = game.rollDice();
				
			    // Get options 
				currentPosition = game.getOption(diceResult);
				System.out.println("Current position : " + currentPosition + "\n");
			}
			else{
			    System.out.println("Invalid Input");
			}
			//positionArr[rollCount] = currentPosition;
			rollCount++;
		}
		 System.out.println("You won the game !! ");
		 System.out.println("You rolled dies "+ rollCount +" times.");
		 //System.out.println(Arrays.toString(positionArr));  
	}
}
