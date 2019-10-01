import java.util.Scanner;

//Project class handles startup, initilization, user input handling and variable storage

/*
money is your initial starting money 
wheel2lock exists so we can lock the second wheel in console
lock is for gui to lock the second wheel 
gamestate initializes the Play class
first play is there to see if the game has results on screen yet 
results handles passing the result of spins to the gui
*/

public class Project {
    
    private int money = 100;
    private boolean wheel2lock = false;
    private boolean lock;
    private Play gameState = new Play();
    private boolean firstplay = true;
    private String[] results = new String[11];
    private String chooseLock = "n";

	//Game is for printing to console and console input when enabled
	public void Game(boolean textGame){
        
        Scanner keyboardint = new Scanner(System.in);
        while (money >= 10){ 
            System.out.println("You Have " + money + " coins"); // prints how much money you have every round
            System.out.println ("Insert 10, 20, OR 30 coins"); // asking user for how much they would like to put in
            //int amount = keyboardint.nextInt();
            
            userInput(keyboardint.nextInt(), getFirst(), getLock(), textGame);
        }
    }

    public boolean getFirst(){
	return firstplay;
    }

    public void setFirst(boolean first) {
	firstplay = first;
    }

    public boolean getLock(){
	return wheel2lock;
    }

    public void setLock(boolean lock) {
	wheel2lock = lock;
    }

    //guiInput handles takes the input from the gui and passes it to play 
    public void guiInput(int amount){
	if (money >= 10) {
	    userInput(amount, getFirst(), getLock(), false);
	}

	else {
	    results[10] = "POVERTY";
	    System.out.println("Out of money");
	}
    }
    
		
    // main user input handling checks how much was inserted and calls methods accordingly
    public void userInput(int amount, boolean firstplay, boolean wheel2lock, boolean textBased){	
	if (amount == 10 && money - amount > 0) {
	    System.out.println("You Have Inserted 10 coins");
	    wheel2lock = wheelLock(firstplay, wheel2lock, textBased);
	    //wheel2lock = lock; 
	    results = gameState.play(amount, money, wheel2lock);
	    money = Integer.parseInt(results[0]);
	    setFirst(false);
	}
        
	else if (amount == 20 && money - amount > 0) {
	    System.out.println("You Have Inserted 20 coins"); // the more the user puts in, the more money they can win
	    wheel2lock = wheelLock(firstplay, wheel2lock, textBased); 
	    //wheel2lock = lock;
	    results = gameState.play(amount, money, wheel2lock);
	    money = Integer.parseInt(results[0]);
	    setFirst(false);
	}

	else if (amount == 30 && money - amount > 0) {
	    System.out.println("You Have Inserted 30 coins");
	    wheel2lock = wheelLock(firstplay, wheel2lock, textBased);     
	    //wheel2lock = lock;
	    results = gameState.play(amount, money, wheel2lock);
	    money = Integer.parseInt(results[0]);
	    setFirst(false);
	}
			
	else {
	    System.out.println("Not valid ammount inserted or Not Enough Money"); // for cases where user inputs a string or large negative numbers
	}

	//System.out.println("You Have " + money + " coins"); // prints how much money you have every round
            
    }       

    /*
    locking of the wheel for text based 
    keyboardstr handles all string input through console
    y is for string comparison purposes 
    */
    public boolean wheelLock(boolean firstplay, boolean wheel2lock, boolean text){
		Scanner keyboardstr = new Scanner(System.in); // keyboard input for strings
        String y = "y";
	
		if (firstplay == false){    
			System.out.println("Would you like to add an additinal 25 coins to lock the second wheel (y/n)");
			if (text == true) {
			    chooseLock = keyboardstr.nextLine();
			}
			if ((wheel2lock == true) || (chooseLock.equals("y"))) {
			    System.out.println("You Have locked the second wheel");
			    return true;
			}
			else {
			    return false;
			}		
		}
		else {
			firstplay = false;
		}
        return false;	
    }
    
	/*
	method that is called in gui when the second wheel is locked 
	on the gui 
	*/
	public boolean guiLock(boolean firstplay){
	    if ((firstplay == false) && ((money - 25) > 0)){
		//setLock(true);
		return true;
	    }
	    else {
		//setLock(false);
		return false;
	    }
	}
    
    public String[] getResults() {
	return results;
    }
}
