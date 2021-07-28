package SnakeLadder;

//import java.util.*;
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
	    System.out.println("Dice number : " + diceNumber);
	    return diceNumber;
	}
	
	// Function to get the options 
	public int playGame(int currentPosition) {
		
		// Get dice number
		int diceResult = rollDice();
		int checkOption = (int)(Math.random() * 10) % 3;
		
	    switch(checkOption){
	        case NO_PLAY : 
	            System.out.println("Option : No play ");
	        break;
	        case LADDER : 
	            System.out.println("Option : Ladder ");
	            currentPosition += diceResult;
	            
	            //play game again when not in winningPosition
	            if(currentPosition != winningPosition) {
	            	currentPosition = playGame(currentPosition);
	            }
	            //stay current position when it is reached greater than 100
	            if(currentPosition > winningPosition) {
	            	currentPosition -= diceResult;
	            }
	        break;
	        case SNAKE : 
	            System.out.println("Option : Snake ");
	            currentPosition -= diceResult;
	         // Reset position value to 0 when it is negative
                if(currentPosition < 0){
                	currentPosition = 0;
                }
             break; 
        }
	    
	    return currentPosition;
	}
	
	public static void main(String[] args) {
		
		//create object for class SnakeLadder 
		SnakeLadder game = new SnakeLadder();
		int rollCount = 0;
		int playerOnePosition = 0;
		int playerTwoPosition = 0;
			
		while(playerOnePosition < winningPosition && playerTwoPosition < winningPosition ){
			// Get options and returns position value
			System.out.println("\nPlayer1 Roll the Dice ");
			playerOnePosition = game.playGame( playerOnePosition);
			System.out.println("Player1 Position : " + playerOnePosition);
			//player2 have chance only if player1 not won
			if(playerOnePosition != winningPosition) {
				System.out.println("\nPlayer2 Roll the Dice ");
				playerTwoPosition = game.playGame( playerTwoPosition);
				System.out.println("Player2 Position : " + playerTwoPosition);
			}
		}
		if(playerOnePosition == winningPosition) {
			 
			System.out.println("\nPlayer1 won the game !! ");
		}
		else {
			
			System.out.println("\nPlayer2 won the game !! ");
		}
	}
		
}
