
public class BattleShipRunner {

	String[][] cells = new String[10][10];			
	String[][] enemyCells = new String[10][10];		
	
	public static void main(String[] args) {
		
		System.out.println(""
				+ " __          ___      __    __  .__   __.   ______  __    __   __  .__   __.   _______    .______        ___   .___________.___________. __       _______     _______. __    __   __  .______   \r\n"
				+ "|  |        /   \\    |  |  |  | |  \\ |  |  /      ||  |  |  | |  | |  \\ |  |  /  _____|   |   _  \\      /   \\  |           |           ||  |     |   ____|   /       ||  |  |  | |  | |   _  \\  \r\n"
				+ "|  |       /  ^  \\   |  |  |  | |   \\|  | |  ,----'|  |__|  | |  | |   \\|  | |  |  __     |  |_)  |    /  ^  \\ `---|  |----`---|  |----`|  |     |  |__     |   (----`|  |__|  | |  | |  |_)  | \r\n"
				+ "|  |      /  /_\\  \\  |  |  |  | |  . `  | |  |     |   __   | |  | |  . `  | |  | |_ |    |   _  <    /  /_\\  \\    |  |        |  |     |  |     |   __|     \\   \\    |   __   | |  | |   ___/  \r\n"
				+ "|  `----./  _____  \\ |  `--'  | |  |\\   | |  `----.|  |  |  | |  | |  |\\   | |  |__| |    |  |_)  |  /  _____  \\   |  |        |  |     |  `----.|  |____.----)   |   |  |  |  | |  | |  |      \r\n"
				+ "|_______/__/     \\__\\ \\______/  |__| \\__|  \\______||__|  |__| |__| |__| \\__|  \\______|    |______/  /__/     \\__\\  |__|        |__|     |_______||_______|_______/    |__|  |__| |__| | _|      \r\n"
				+ "                                                                                                                                                                                            ");
		delay();
		GameRules();
		delay();
	
		Game battleShip = new Game();
		battleShip.gameSetup();									// Array: creates array of Ship objects										
	}

	private static void GameRules() {
		String newLine = System.lineSeparator();
		System.out.print(newLine);
		System.out.print(newLine);
			System.out.println("Welcome to Battleship");
				System.out.println("1. You have 4 ships to place.");
					System.out.println("2. Each Ship has a different number of spaces.");
						System.out.println("3. Placeable Ships:");
							System.out.println("    Battleship (4)");
							System.out.println("    Cruiser (3)");
							System.out.println("    Submarine (3)");
							System.out.println("    Destroyer (2)");
							System.out.println("");
	}
	
	private static void delay() {
		 try {
			Thread.sleep(3500);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}