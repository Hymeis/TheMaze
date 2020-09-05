
public class Maze extends Board{
	
	public Maze() {
		super();
	}
	
	public Maze(int width, int length) {
		super(width,length);
	}
	/**
	 * @pre The board is initialized.
	 * Randomly generate a maze.
	 * @param maze The maze to be generated.
	 */
	public void generateMaze() {
		nextStep(0,0);
	}
	
	/**
	 * Check whether the targeted grid has default grids around.
	 * @param width y-axis of the grid
	 * @param length x-axis of the grid
	 * @return true if there are default grids around, false otherwise.
	 */
	public boolean hasDefaultAround(int width, int length) {
		return getGridValue(width-1,length) == DEFAULT || getGridValue(width+1,length) == DEFAULT ||
			   getGridValue(width,length-1) == DEFAULT || getGridValue(width,length+1) == DEFAULT ;
	}
	/**
	 * It is the main recursive algorithm to generate the maze. It generates walls of the maze.
	 * @param width y-axis of the grid
	 * @param length x-axis of the grid
	 */
	private void nextStep(int width, int length) {
		int randomDirection = UP + (int)(4*Math.random());
		int nextDirection = INVALID;
		setGridValue(width,length,GENERATING);
		System.out.println("RandomDirection: " + randomDirection);
		while (hasDefaultAround(width,length)) {
			if (getGridValue(width,length,randomDirection) == DEFAULT) {
				nextDirection = randomDirection;
				if (nextDirection == UP) {//&& getGridValue(width-1,length) == DEFAULT) {
					nextStep(width-1,length);
				} else if (nextDirection == LEFT) { //&& getGridValue(width,length-1) == DEFAULT) {
					nextStep(width,length-1);
				} else if (nextDirection == DOWN) { //&& getGridValue(width+1,length) == DEFAULT) {
					nextStep(width+1,length);
				} else if (nextDirection == RIGHT) { //&& getGridValue(width,length+1) == DEFAULT) {
					nextStep(width,length+1);
				}
			} else {
				randomDirection = UP + (int)(4*Math.random());
				System.out.println("Direction: " + randomDirection);
			}
		}
		/* Set up walls to finalize the maze below */
		//setGapValue(width,length,UP,WALL);
		//setGapValue(width,length,LEFT,WALL);
		//setGapValue(width,length,DOWN,WALL);
		//setGapValue(width,length,RIGHT,WALL);
		if (nextDirection != INVALID) {
			setGapValue(width,length,nextDirection,PATH);
		}
		//printMaze();
		setGridValue(width,length,SET);
	}
	
	public void printMaze() {
		super.printBoard();
	}

}
