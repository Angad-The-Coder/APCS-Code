import kareltherobot.*;

public class JumpThoseHurdles {
	// This is the Robot we will use to jump the hurdles
	Robot hurdler = new Robot(1,1,Directions.East, 0);
	
	public static void main(String[] args) {
		new JumpThoseHurdles().start();
	}

	public void start() {
	loadWorld();
	int highestHurdle = 0;
	int widestGap = 0;
	for (int i = 0; i < 3; i++) {
		int w = findHurdle();
		int h = climbHurdle();
		highestHurdle = h > highestHurdle ? h : highestHurdle;
		widestGap = w > widestGap ? w : widestGap;
  		clearHurdle(h);
    }
    System.out.println("Highest Hurdle Length: " + highestHurdle);
	}

	/**
	 * This method assumes the Robot is named hurdler and is facing East
	 * This moves hurdler to the next wall (hurdle). It returns the number
	 * of moves it took to get to the hurdle
	 */
	private int findHurdle() {
    int moves = 0;
    while (hurdler.frontIsClear()) {
      hurdler.move();
      moves++;
    }
		return moves;
	}
	/**
	 * This method assumes the Robot is named hurdler, is facing East and
	 * is at the base of the hurdle. 
	 * This moves the Robot to the top of the hurdle so that it can clear
	 * the wall.  
	 * @return The number of steps to get above the hurdle (height)
	 */
	private int climbHurdle() {
    int height = 0;
    while (!hurdler.frontIsClear()) {
      hurdler.turnLeft();
      hurdler.move();
      turnRight(hurdler);
      height++;
    }
    return height;
	}

	/** 
	 * Moves the Robot (hurdler) over the wall and moves it to the ground so 
	 * that the Robot has its back to the hurdle and is facing the next one.
	 */
	private void clearHurdle(int numToDescend) {
		// TODO Auto-generated method stub
    hurdler.move();
    hurdler.move();
    turnRight(hurdler);
    for (int i = 0; i < numToDescend; i++) {
      hurdler.move();
    }	
    hurdler.turnLeft();
	}

	private void loadWorld() {
		// line below "hardcodes" this to use one specific world
		// it would be better to ask the user...
		String worldName = "worlda.wld";
		World.readWorld(worldName);
		World.setVisible(true);
		World.setDelay(5);
	}

  private void turnRight(Robot bob) {
    bob.turnLeft();
    bob.turnLeft();
    bob.turnLeft();
  }
}
