
public class GameBoard extends Game {
	
	boolean battleship = false;
	boolean cruiser = false;
	boolean submarine = false;
	boolean destroyer = false;
	
	public GameBoard() {

	}
	
	public void GenerateBoard() {
		String[][] cells = new String[10][10];
		System.out.print("  1 2 3 4 5 6 7 8 9");
			for(int row = 1; row < 10; row++) {
				String newLine = System.lineSeparator();
				System.out.print(newLine);
				System.out.print(row + " ");
					for(int col = 1; col <= 9; col++) {
						cells [row][col] = "- ";
						System.out.print(cells[row][col]);
				}
			}
	}
	
	public boolean UpdateBoard(int shipRow, int shipCol, String vertHoriz, int spaces) {
		boolean valid = true;
			while(spaces > 0) {
				if(super.cells [shipRow][shipCol] != null) {
					System.out.println("Already existing ship at that location. Reenter.");
					valid = false;
						break;
				}
					super.cells [shipRow][shipCol] = "1";
						spaces--;
				if(vertHoriz.equals("V")) {
					shipRow++;
				} else if(vertHoriz.equals("H")) {
						shipCol++;
				}
			}	 
			
		System.out.print("  1 2 3 4 5 6 7 8 9");
			for(int row = 1; row < 10; row++) {
				String newLine = System.lineSeparator();
				System.out.print(newLine);
				System.out.print(row + " ");
					for(int col = 1; col <= 9; col++) {
						if((super.cells [row][col]) == "1") {
							System.out.print("+ ");
						} else {
							System.out.print("- ");
						}
					}
			}
				return valid;
		}
	
	public boolean EnemyUpdateBoard(int shipRow, int shipCol, String vertHoriz, int spaces, String arrayValue) {
		boolean valid = true;
		int checkShipRow = shipRow;
		int checkShipCol = shipCol;
		int checkShipSpaces = spaces;
				while(checkShipSpaces > 0) {
					if(super.enemyCells [checkShipRow][checkShipCol] != null) {
						return false;
					}
					if(vertHoriz.equals("V")) {
						checkShipRow++;
						checkShipSpaces--;
					} else if(vertHoriz.equals("H")) {
						checkShipCol++;
						checkShipSpaces--;
					}
				}
				
				while(spaces > 0) {
					super.enemyCells [shipRow][shipCol] = arrayValue;
					spaces--;
						if(vertHoriz.equals("V")) {
							shipRow++;
						} else if(vertHoriz.equals("H")) {
							shipCol++;
						}
				}
				return valid;
		}

	public void userAttack(int guessRow, int guessCol) {
		if (super.enemyCells [guessRow][guessCol] == "b" || super.enemyCells [guessRow][guessCol] == "c"
			|| super.enemyCells [guessRow][guessCol] == "d" || super.enemyCells[guessRow][guessCol] == "s") {
				super.enemyCells [guessRow][guessCol] = "2";
		} else {
			super.enemyCells [guessRow][guessCol] = "3";
		}
			System.out.print("  1 2 3 4 5 6 7 8 9");
				for(int row = 1; row < 10; row++) {
					String newLine = System.lineSeparator();
					System.out.print(newLine);
					System.out.print(row + " ");
						for(int col = 1; col <= 9; col++) {
							if((super.enemyCells [row][col]) == "2") {
								System.out.print("$ ");
							} else if((super.enemyCells [row][col]) == "3") {
								System.out.print("L ");
							} else {
								System.out.print("- ");
							}
					    }
				}
	}
	
	public void enemyAttack(int systGuessRow, int systGuessCol) {
		if((super.cells [systGuessRow][systGuessCol]) == "1") {
			super.cells [systGuessRow][systGuessCol] = "2";
		} else {
			super.cells [systGuessRow][systGuessCol] = "3";
		}
			System.out.print("  1 2 3 4 5 6 7 8 9");
				for(int row = 1; row < 10; row++) {
					String newLine = System.lineSeparator();
					System.out.print(newLine);
					System.out.print(row + " ");
						for(int col = 1; col <= 9; col++) {
							if((super.cells [row][col]) == "1") {
								System.out.print("+ ");
							} 
							if((super.cells [row][col]) == "2") {
								System.out.print("$ ");
							} 
							if((super.cells [row][col]) == "3") {
								System.out.print("L ");
							} 
							if((super.cells [row][col]) == null) {	
								System.out.print("- ");
							}
						}
				}
	}
	
	public void sinkEnemyShip() {
		int countBattleShip = 0;
		int countCruiser = 0;
		int countSubmarine = 0;
		int countDestroyer = 0;
			for(int row = 0; row < 10; row++) {
				for(int col = 1; col < 10; col++) {
					if(super.enemyCells[row][col] == "b") {
						countBattleShip++;
					} else if(super.enemyCells[row][col] == "c") {
						countCruiser++;
					} else if(super.enemyCells[row][col] == "d") {
						countDestroyer++;
					} else if(super.enemyCells[row][col] == "s") {
						countSubmarine++;
					}
				}
			}
			
			while(battleship == false) {
				if(countBattleShip == 0) {
					battleship = true;
						shipSink();
				} else {
					break;
				}
			}
			
			while(cruiser == false) {
				if(countCruiser == 0) {
					cruiser = true;
						shipSink();
				} else {
					break;
				}
			}
			while(submarine == false) {
				if(countSubmarine == 0) {
					submarine = true;
						shipSink();
				} else {
					break;
				}
			}
			while(destroyer == false) {
				if(countDestroyer == 0) {
					destroyer = true;
					shipSink();
				} else {
					break;
				}
			}
	}		
	
	public boolean endGame() {
			for(int row = 0; row < 10; row++) {
				for(int col = 1; col < 10; col++) {
					if(super.enemyCells[row][col] == "b" || super.enemyCells[row][col] == "c"
					|| super.enemyCells[row][col] == "s" || super.enemyCells[row][col] == "d") {
						return false;
					}  			
				}
			}
		return true;
	}
	
	public void shipSink() {
		System.out.println
					("     _______. __    __   __  .______           _______. __    __  .__   __.  __  ___           \r\n"
							+ "    /       ||  |  |  | |  | |   _  \\         /       ||  |  |  | |  \\ |  | |  |/  /           \r\n"
							+ "   |   (----`|  |__|  | |  | |  |_)  |       |   (----`|  |  |  | |   \\|  | |  '  /            \r\n"
							+ "    \\   \\    |   __   | |  | |   ___/         \\   \\    |  |  |  | |  . `  | |    <             \r\n"
							+ ".----)   |   |  |  |  | |  | |  |         .----)   |   |  `--'  | |  |\\   | |  .  \\   __ __ __ \r\n"
							+ "|_______/    |__|  |__| |__| | _|         |_______/     \\______/  |__| \\__| |__|\\__\\ (__|__|__)\r\n"
							+ "                                                                                               ");
	}

}