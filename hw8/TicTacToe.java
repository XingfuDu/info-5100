//package TicTacToe;

import java.util.*;



/**
 * I put some codes I wrote in ticTacToe.java file which can give some tips I think. 
 * You can just delete codes or functions I wrote if you come up with some other methods to finish the requirements.
 */

public class TicTacToe {
    
    private static List<Integer> playerPositions;
    private static List<Integer> cpuPositions;
    private static char[][] gameBoard;
    
    public static void setGame(char[][] gb) {
	gameBoard = gb;
	playerPositions = new ArrayList<>();
        cpuPositions = new ArrayList<>();
    }
 
    public static void main(String[] args) {
        char[][] gameBoard = {
	    {' ', '|', ' ', '|', ' '},
	    {'-', '+', '-', '+', '-'},
	    {' ', '|', ' ', '|', ' '},
	    {'-', '+', '-', '+', '-'},
	    {' ', '|', ' ', '|', ' '},
        };

        printGameBoard(gameBoard);
	TicTacToe.setGame(gameBoard);
       
        while (true) {
            Scanner scan = new Scanner(System.in);
	    System.out.println("\n\n\n");
            System.out.println("Enter your placement (1-9): ");
            int playerPos = scan.nextInt();
            // write your code here
	    if (!placeAlreadyTaken(playerPos)) {
		    placePiece(gameBoard, playerPos, "player");
		    printGameBoard(gameBoard);
		    if (checkWinner() == "player") {
			System.out.println("\nCongratulations you won!\n");
			break;
		    }
                    if (checkWinner() == "cpu") {
                        System.out.println("\nCPU wins! Sorry:(\n");
                        break;
                    } 
		    if (checkFull() == true) {
			System.out.println("\nCAT!\n");
			break;
		    }
		    
	    } else {
		System.out.println("\nThe position is already taken. Come up with another step\n");
		continue;
	    }
	    System.out.println("\n\n\n");
	    System.out.println("Computer move: ");
	    int cpuPos = (int) (Math.random() * 9 + 1);
	    while (placeAlreadyTaken(cpuPos)) {
		cpuPos = (int) (Math.random() * 9 + 1);
	    }
	    placePiece(gameBoard, cpuPos, "cpu");
	    printGameBoard(gameBoard);
	    if (checkWinner() == "player") {
		System.out.println("\nCongratulations you won!\n");
		break;
	    }
	    if (checkWinner() == "cpu") {
		System.out.println("\nCPU wins! Sorry:(\n");
		break;
	    }
	    if (checkFull() == true) {
		System.out.println("\nCAT!\n");
		break;
	    }  
	    
        }
    }

    public static boolean placeAlreadyTaken(int pos) {
	return playerPositions.contains(pos) 
	    || cpuPositions.contains(pos);
    }

    public static void printGameBoard(char[][] gameBoard) {
        // write your code here
        for (int i = 0; i < gameBoard.length; i++) {
            for (int j = 0; j < gameBoard[i].length; j++) {
		System.out.print(gameBoard[i][j]);
	    }
	    System.out.println();
        }
    }

    public static void placePiece(char[][] gameBoard, int pos, String user) {

        char symbol = ' ';
        if (user.equals("player")) {
            symbol = 'X';
            playerPositions.add(pos);
        } else if (user.equals("cpu")) {
            symbol = 'O';
            cpuPositions.add(pos);
        }
        
        // write your code here
	int row = (pos % 3 == 0 ? pos / 3 - 1 : pos / 3) * 2 ;
	int column = ((pos % 3 == 0 ? 3 : pos % 3 ) - 1) * 2 ;
	gameBoard[row][column] = symbol;
	

    }

    public static String checkWinner() {
        // write your code here
	int size = gameBoard.length;

	for (int i = 0; i < size; i+=2) {
	    int count = 0;
	    for (int j = 0; j < size; j+=2) {
		if (gameBoard[i][j] == 'X') {
		    count++;
		}
	    } 
	    if (count == 3) return "player";
	}
	
	for (int i = 0; i < size; i+=2) {
            int count = 0;
            for(int j = 0; j < size; j+=2) {
		if (gameBoard[j][i] == 'X') {
                    count++;
		}
            }
            if (count == 3) return "player";
        }

	{
	    int count = 0;
	    for (int i = 0, j = 0; i < size && j < size; i +=2, j+=2) {
		if (gameBoard[i][j] == 'X') {
		    count++;
		}
	    }
	    if (count == 3) return "player";
	}

	{
            int count = 0;
            for (int i = 0, j = size - 1; i < size && j >= 0; i +=2, j-=2) {
                if (gameBoard[i][j] == 'X') {
		    count++;
                }
	    }
	    if (count == 3) return "player";
	}


        for (int i = 0; i < size; i+=2) {
            int count = 0;
            for (int j = 0; j < size; j+=2) {
                if (gameBoard[i][j] == 'O') {
                    count++;
                }
            }
            if (count == 3) return "cpu";
        }

        for (int i = 0; i < size; i+=2) {
            int count = 0;
            for(int j = 0; j < size; j+=2) {
                if (gameBoard[j][i] == 'O') {
                    count++;
                }
            }
            if (count == 3) return "cpu";
        }

        {
            int count = 0;
            for (int i = 0, j = 0; i < size && j < size; i +=2, j+=2) {
                if (gameBoard[i][j] == 'O') {
                    count++;
                }
            }
            if (count == 3) return "cpu";
        }

        {
            int count = 0;
            for (int i = 0, j = size - 1; i < size && j >= 0; i +=2, j-=2) {
                if (gameBoard[i][j] == 'O') {
                    count++;
                }
            }
            if (count == 3) return "cpu";
        }

	return "not finished";
    }

    public static boolean checkFull() {
	for (int i = 1; i <= 9; i++) {
	    if (!playerPositions.contains(i) && !cpuPositions.contains(i)) {
		return false;
	    }
	}
	return true;
    }
}