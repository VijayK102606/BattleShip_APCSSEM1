
public class Player extends Game {
	
	public Player() {
		
	}
	
	public void setUp(GameBoard s) {
			for(int i = 0; i < 4; i++) {	
				System.out.println("");
				
				String type = getShipType();
				
				boolean correctShip = correctShipType(type);		
				
					while(correctShip == false) {
						if(correctShip == false) {
							System.out.println("Invalid Ship Type. Check spelling etc. Reenter");
							type = TextIO.getlnString();				
								correctShip = correctShipType(type);
						}
					}
	
			int spaces = howManySpaces(type);	
	
			System.out.println("Set Location.");
				String vertHoriz = getVertHoriz();
	
			System.out.println("Position:");
				int shipRow = getShipRow();
				int shipCol = getShipCol();
						
					while(shipCol >= 8 && vertHoriz.equals("H")) {
								System.out.println("Hmmmm...that ship doesen't fit...");
								System.out.println("Remember, the gameboard is 9*9. Please reenter.");
								
									System.out.println("Row?");								
										shipRow = TextIO.getlnInt();
									System.out.println("Col?");								
										shipCol = TextIO.getlnInt();
							}
					
					while(shipRow >= 8 && vertHoriz.equals("V")) {
								System.out.println("Hmmmm...that ship doesen't fit...");
								System.out.println("Remember, the gameboard is 9*9. Please reenter.");
								
									System.out.println("Row?");								
										shipRow = TextIO.getlnInt();
									System.out.println("Col?");								
										shipCol = TextIO.getlnInt();		
					}
													
					boolean valid = s.UpdateBoard(shipRow, shipCol, vertHoriz, spaces); 
						if (valid == false) {
							i--;
						}
																		
		
			}
	}

	public void attack(GameBoard t) {
		
		System.out.println();
		System.out.println("Row?");
			int guessRow = TextIO.getlnInt();
				while(guessRow > 9 || guessRow <= 0) {
					System.out.println("Invalid row. Please reenter.");
					guessRow = TextIO.getlnInt();
				}
		
		System.out.println();
		System.out.println("Col?");
			int guessCol = TextIO.getlnInt();
				while(guessCol > 9 || guessCol <= 0) {
					System.out.println("Invalid row. Please reenter.");
					guessCol = TextIO.getlnInt();
				}
		t.userAttack(guessRow, guessCol);
	}

	private String getShipType() {
		System.out.println(" ");
		System.out.println("Place your ship.");
		System.out.println("ShipType?");						// User enters type of ship
		System.out.println("battleship (4): b");
		System.out.println("submarine  (3): s");
		System.out.println("cruiser    (3): c");
		System.out.println("destroyer  (2): d");
			String type = TextIO.getlnString();	
		return type;
	}

	private String getVertHoriz() {
		System.out.println("Vertical or Horizontal? (V/H)");	// Asks user if ship is placed vertically or horizontally
			String vertHoriz = TextIO.getlnString();			// User selection is stored in variable
			vertHoriz = vertHoriz.toUpperCase();				// Changes string to upperCase for checking purposes
				boolean validEntry = false;
					
				while(validEntry == false) {
					if(vertHoriz.equals("V") || vertHoriz.equals("H")) {
						validEntry = true;
					} else {
						System.out.println("Invalid entry. Please reenter.");
						vertHoriz = TextIO.getlnString();
						vertHoriz = vertHoriz.toUpperCase();
					}
				}
		return vertHoriz;
	}

	private int getShipCol() {
		System.out.println("");
		System.out.println("Col?");
			int col = TextIO.getlnInt();					// User col selection stored in variable
				while(col > 9 || col <= 0) {
					System.out.println("Invalid row. Please reenter.");
						col = TextIO.getlnInt();
				}
		return col;
	}

	private int getShipRow() {
		System.out.println("");
		System.out.println("Row?");							
			int row = TextIO.getlnInt();					
				while(row > 9 || row <= 0) {
					System.out.println("Invalid row. Please reenter.");
						row = TextIO.getlnInt();
				}
		return row;
	}

	public void shipSink(GameBoard t) {
		t.sinkEnemyShip();
	}
	
	private static boolean correctShipType(String type) {
		type = type.toLowerCase();
		boolean correctShipType = false;
			if(type.equals("b")) {
				correctShipType = true;
			}
			if(type.equals("c")) {
				correctShipType = true;
			}
			if(type.equals("s")) {
				correctShipType = true;
			}
			if(type.equals("d")) {
				correctShipType = true;
			}
		return correctShipType;
	}
	
	private static int howManySpaces(String type) {
		int p = 0;
		type = type.toLowerCase();
			if(type.equals("b")) {
				p = 4;
			}
			if(type.equals("c")) {
				p = 3;
			}
			if(type.equals("s")) {
				p = 3;
			}
			if(type.equals("d")) {
				p = 2;
			}
			return p;
	}

}