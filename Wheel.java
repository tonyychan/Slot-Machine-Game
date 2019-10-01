import java.util.Random;

/*
 sets default wheel values for initialization
 wheelArray handles wheel display order
 wheelResult stores result from previous spin in case of locking
 wheelSpeed stores the wheel's rotation speed
*/
public class Wheel {
    
    private String[] wheelArray = new String[11];
    private String[] wheelResult = {"n0", "n1", "n2"};
    private int wheelSpeed = 1;

	
    //constructor taking a wheel array and a speed for creation using non-default values
    public Wheel (String[] setArray, int speed) {
	//String[] wheelArray = new String[setArray.length];
	for (int i = 0; i < setArray.length; i++) {
	    wheelArray[i] = setArray[i];
	}
	wheelSpeed = speed;
    }

    // spins the wheel and returns the result
    public String[] wheelSpin(boolean wheelLock) {
	if (wheelLock == false) {
	    int randInt = new Random().nextInt(wheelArray.length);
	    if (randInt > 0) {
		wheelResult[0] = wheelArray[randInt-1];
	    }
	    
	    else {
		wheelResult[0] = wheelArray[wheelArray.length - 1];
	    }
	    wheelResult[1] = wheelArray[randInt];
	    
	    if (randInt < (wheelArray.length - 1)) {
		wheelResult[2] = wheelArray[randInt+1];
	    }
	    
	    else {
		wheelResult[2] = wheelArray[0];
	    }
	    return wheelResult;
	}

	else {
	    return wheelResult;
	}
    }

    public String[] getArray () {
	return wheelArray;
    }

    public int getSpeed () {
	return wheelSpeed;
    }

    public void setSpeed (int speed) {
	wheelSpeed = speed;
    }

    public void setArray (String[] array) {
	for (int i = 0; i < array.length; i++) {
	    wheelArray[i] = array[i];
	}
    }
			  
}
