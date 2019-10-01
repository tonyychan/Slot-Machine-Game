
// sets up wheel spin order
public class Play {

    private String[] wheelArray0 = {"2", "4", "3", "5", "1", "1", "2", "3", "2", "4", "1"};
    private String[] wheelArray1 = {"3", "2", "1", "4", "5", "2", "5", "3", "2", "1", "4"};
    private String[] wheelArray2 = {"4", "1", "3", "5", "2", "4", "wc", "1", "3", "2", "1"};
    private int[] speedArray = {1, 2, 3};
	
    // creates wheel objects at startup
    Wheel wheel0 = new Wheel(wheelArray0, speedArray[0]);
    Wheel wheel1 = new Wheel(wheelArray1, speedArray[1]);
    Wheel wheel2 = new Wheel(wheelArray2, speedArray[2]);

    /*
     sets default gamestate values for first round of play
     playerMoney stores remaining player currency
     lockSet stores whether the second wheel needs to be spun in a given round
    */
    private int playerMoney = 100;
    private boolean lockSet = false;

    // constructor for initialization
    public Play() {
    }

    /*
     takes the amount the player spent, the current money total, and the second wheel's lock status
     to spin the wheels during a round and return the result
    */
    public String[] play(int buyIn, int money, boolean wheelLock) {
	
		if (wheelLock == true) {
	    	playerMoney = playerMoney - (buyIn + 25);
		}
		
		else {
	    	playerMoney = playerMoney - buyIn;
		}
		
		String[] wheelResult0 = {};
		String[] wheelResult1 = {};
		String[] wheelResult2 = {};
		wheelResult0 = wheel0.wheelSpin(false);
		wheelResult1 = wheel1.wheelSpin(wheelLock);
		wheelResult2 = wheel2.wheelSpin(false);
		int payoutMult = 0;
		String win = "OUTPLAYED";

		System.out.println(wheelResult0[0] + "\t" + wheelResult1[0] + "\t" + wheelResult2[0]);
		System.out.println(wheelResult0[1] + "\t" + wheelResult1[1] + "\t" + wheelResult2[1]);
		System.out.println(wheelResult0[2] + "\t" + wheelResult1[2] + "\t" + wheelResult2[2]);
		
		if ((wheelResult0[1] == wheelResult1[1]) && ((wheelResult1[1] == wheelResult2[1]) || (wheelResult2[1] == "wc"))) {
			payoutMult = payoutWin(wheelResult1[1]);
			win = "WIN";
			System.out.println("YOU WIN ON CENTER MATCH");
		}
		
		else if ((wheelResult0[0] == wheelResult1[1]) && ((wheelResult1[1] == wheelResult2[2]) || (wheelResult2[2] == "wc"))) {
			payoutMult = payoutWin(wheelResult1[1]);
			win = "WIN";
			System.out.println("YOU WIN ON TOP LEFT DIAGONAL MATCH");
		}
		
		else if ((wheelResult0[2] == wheelResult1[1]) && ((wheelResult1[1] == wheelResult2[0]) || (wheelResult2[0] == "wc"))) {
			payoutMult = payoutWin(wheelResult1[1]);
			win = "WIN";
			System.out.println("YOU WIN ON BOTTOM LEFT DIAGONAL MATCH");
		}
		
		playerMoney = playerMoney + (payoutMult * buyIn);
		String[] returns = {("" + playerMoney), wheelResult0[0], wheelResult0[1], wheelResult0[2],
				wheelResult1[0], wheelResult1[1], wheelResult1[2], wheelResult2[0], 
					wheelResult2[1], wheelResult2[2], win};
			return returns;
		}

	// method called when player wins to determine their payout
	public int payoutWin(String result){
		if (result == "1"){
			return 2;
		}
		else if (result == "2"){
			return 3;
		}	
		else if (result == "3"){
			return 4;
		}
		else if ( result == "4"){
			return 5;
		}
		else if ( result == "5") { 
			return 7;
		}
		return 1;
	}
}
