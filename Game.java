
public class Game {
	
	String[][] cells = new String[10][10];			
	String[][] enemyCells = new String[10][10];	
	
		public Game() {
			
		}
	
		public void gameSetup() {
            Player user = new Player();
            GameBoard s = new GameBoard();
                user.setUp(s);
                System.out.println("");
                
            Computer computer = new Computer();
            GameBoard t = new GameBoard();
            	System.out.println("");
            	System.out.println("Enemy ships loading...");
            		delay();
            		computer.setUp(t);
            		
                System.out.println("");
                System.out.println("Start guessing!");
                System.out.println("$: Hit");
				System.out.println("L: Miss");
				System.out.println("");
				delay();

            while(t.endGame() == false) {
                user.attack(t);
                	System.out.println("");
                	System.out.println("");
                delay();
                
                computer.attack(s);
                	System.out.println("");
                	
                user.shipSink(t);

            }
                delay();
            System.out.println("");
            System.out.println("Game over. You win! You've succesfully commited war crimes!");
            System.out.println(""
            		+ " _______      ___      .___  ___.  _______      ______   ____    ____  _______ .______                  .______   ____    ____  _______  __  \r\n"
            		+ " /  _____|    /   \\     |   \\/   | |   ____|    /  __  \\  \\   \\  /   / |   ____||   _  \\                 |   _  \\  \\   \\  /   / |   ____||  | \r\n"
            		+ "|  |  __     /  ^  \\    |  \\  /  | |  |__      |  |  |  |  \\   \\/   /  |  |__   |  |_)  |                |  |_)  |  \\   \\/   /  |  |__   |  | \r\n"
            		+ "|  | |_ |   /  /_\\  \\   |  |\\/|  | |   __|     |  |  |  |   \\      /   |   __|  |      /                 |   _  <    \\_    _/   |   __|  |  | \r\n"
            		+ "|  |__| |  /  _____  \\  |  |  |  | |  |____    |  `--'  |    \\    /    |  |____ |  |\\  \\----.__ __ __    |  |_)  |     |  |     |  |____ |__| \r\n"
            		+ " \\______| /__/     \\__\\ |__|  |__| |_______|    \\______/      \\__/     |_______|| _| `._____(__|__|__)   |______/      |__|     |_______|(__) ");
        }
		
		private static void delay() {
			 try {
				Thread.sleep(3000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
}