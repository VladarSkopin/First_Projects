import java.util.*;

public class TicTacToeAlphaTest {
	public static void main(String[] args) {
				String [][] matrix = getBoard();

				String[] players = {" X"," O"};

				int result; // game status result

				// Repeat while result is continue
				do {
					// Display matrix
				    displayMatrix(matrix);

					int[] cell = getCell(matrix, players[0]);
	
					placeToken(matrix, cell, players[0]);
			
					// Determine game status
					result = gameStatus(matrix, players[0]);

					// If status is continue ---> next player takes turn
					if (result == 2) {
						swap(players);
					}

				} while(result == 2);

				// Display matrix
				displayMatrix(matrix);

				// Display game result
				if (result == 0)
					System.out.println(players[0] + " wins");
				else
					System.out.println("Draw");

			}

			/** Determines the status of the game (win, draw, continue) */
			public static int gameStatus(String[][] m, String e) {
				if (isWin(m, e))
					return 0; // Win
				else if (isDraw(m))
					return 1; // Draw
				else
					return 2; // Continue
			}

			public static boolean isWin(String[][] m, String t) { 
				return isHorizontalWin(m, t) || isVerticalWin(m, t) || isDiagonalWin(m, t);
			}

			public static boolean isHorizontalWin(String[][] m, String t) {
				for (int i = 0; i < m.length; i++) {
					int count = 0;
					for (int j = 0; j < m[i].length; j++) {
						if (m[i][j] == t)
							count++;
					}
					if (count == 3)
						return true;
				}
				return false;
			}

			public static boolean isVerticalWin(String[][] m, String t) {
				for (int i = 0; i < m.length; i++) {
					int count = 0;
					for (int j = 0; j < m[i].length; j++) {
						if (m[j][i] == t)
							count++;
					}
					if (count == 3)
						return true;
				}
				return false;
			}

			public static boolean isDiagonalWin(String[][] m, String t) {
				int count = 0;
				for (int i = 0; i < m.length; i++) {
					if (m[i][i] == t)
						count++;
					if (count == 3)
						return true;
				}

				count = 0;
				for (int i = 0, j = m[i].length - 1; j >= 0 ; j--, i++) {
					if (m[i][j] == t)
						count++;
					if (count == 3)
						return true;
				}
				return false;
			}

			public static boolean isDraw(String[][] m) {
				for (int i = 0; i < m.length; i++) {
					for (int j = 0; j < m[i].length; j++) {
						if (m[i][j] == "  ")
							return false;
					}
				}
				return true;
			}

			/** Swaps the elements in an array */
			public static void swap(String[] p) {
				String temp = p[0];
				p[0] = p[1];
				p[1] = temp;
			}

			public static void placeToken(String[][] m, int[] e, String t) {
				m[e[0]][e[1]] = t;
			}

			public static int[] getCell(String[][] m, String t) {
				Scanner input = new Scanner(System.in);
				int[] cell = new int[2]; // board's row and column

				do {
					System.out.print("Enter the coordinates: ");
					cell[0] = input.nextInt() - 1;
					cell[1] = input.nextInt() - 1;

				} while (!isValidCell(m, cell));
				return cell;
			}

			/** Checks whether the cell is empty and is in a 3 x 3 array */
			public static boolean isValidCell(String[][] m, int[] cell) {
				for (int i = 0; i < cell.length; i++) {
					if (cell[i] < 0 || cell[i] >= 3) {
						System.out.println("Coordinates should be from 1 to 3!");
						return false;
					}
				}
				if (m[cell[0]][cell[1]] != "  ") {
					System.out.println("This cell is occupied! Choose another one!");
					return false;
				}
				return true;		
			}

			/** Returns a 3 x 3 array without tokens */
			public static String[][] getBoard() {
				String[][] m = new String[3][3];
				for (int i = 0; i < 3; i++) {
					for (int j = 0; j < 3; j++) {
						m[i][j] = "  ";
					}
				}
				return m;
			}

			/** Display matrix */
			public static void displayMatrix(String[][] m) {
				System.out.println("\n---------");
				for (int i = 0; i < m.length; i++) {
					System.out.print("|");
					for (int j = 0; j < m[i].length; j++) {
						System.out.print(m[i][j]);
					}
					System.out.println(" |");
				}
				System.out.println("---------");
	}
}
