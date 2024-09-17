
public class Computer extends Game {
	
	public Computer() {
		
	}
	
	public void setUp(GameBoard t) {
		
			for(int j = 0, k = 1; j < 4; j++, k++) {

					String type = getShipType(k);
		
					int spaces = howManySpaces(type);
		
					int l = (int) (Math.random() *2) +1;
					String vertHoriz = getVertHoriz(l);
		
					int shipRow = (int) ((Math.random()*9) + 1);
					int shipCol = (int) ((Math.random()*9) + 1);
					boolean outOfBounds = true;
					while(outOfBounds == true) {
						if(shipCol + spaces > 10 || shipRow + spaces > 10) {
							outOfBounds = true;
							shipCol = (int) ((Math.random()*9) + 1);
							shipRow = (int) ((Math.random()*9) + 1);
						} else {
							outOfBounds = false;
						}
											   }
					
					boolean valid = t.EnemyUpdateBoard(shipRow, shipCol, vertHoriz, spaces, type);
						if(valid == false) {
							j--;
							k--;
						}
			
			}		
	}
	
	public void attack(GameBoard s) {
		System.out.println("Computer turn.");
		int systGuessRow = (int) ((Math.random()*9) + 1);
		int systGuessCol = (int) ((Math.random()*9) + 1);
			s.enemyAttack(systGuessRow, systGuessCol);
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
		
	
	private static String getVertHoriz(int l) {
		String vertOrHoriz = "";
			if (l == 1) {
				vertOrHoriz = "V";
			}
			if (l == 2) {
				vertOrHoriz = "H";
			}		
		return vertOrHoriz;
	}
	
	private static String getShipType(int k) {
		String shipType = "";
			if(k == 1) {
				shipType = "b";
			}
			if(k == 2) {
				shipType = "c";
			}
			if(k == 3) {
				shipType = "s";
			}
			if(k == 4) {
				shipType = "d";
			}
		return shipType;
		
	}
}
