
public class Maze extends Board{
	
	//private int[][] newmaze;
	public Maze() {
		super();
	}
	
	public Maze(int width, int length) {
		super(width,length);
	}
	/**
	 * @pre The board is empty.
	 * Randomly generate a maze.
	 * @param maze The maze to be generated.
	 */
	public void generateMaze() {
		nextStep(0,0);
	}
	
	public boolean hasDefaultAround(int width, int length) {
		return (getGridValue(width-2,length) == DEFAULT || getGridValue(width+2,length) == DEFAULT||
			   getGridValue(width,length-2) == DEFAULT || getGridValue(width,length+2) == DEFAULT);
	}
	
	private void nextStep(int width, int length) {
		
		setGridValue(width,length,GENERATING);
		
		while (hasDefaultAround(width, length) == true) {
			int randomDirection = UP + (int)(4*Math.random());
			System.out.println("direction: " + randomDirection);
			if (randomDirection == UP && getGridValue(width-2,length) == DEFAULT) {
				nextStep(width-2,length);
			} else if (randomDirection == LEFT && getGridValue(width,length-2) == DEFAULT) {
				nextStep(width,length-2);
			} else if (randomDirection == DOWN && getGridValue(width+2,length) == DEFAULT) {
				nextStep(width+2,length);
			} else if (randomDirection == RIGHT && getGridValue(width,length+2) == DEFAULT) {
				nextStep(width,length+2);
			}
			// If none of the conditions is triggered, that means the grid @ randomized direction does not have default value
			/* Set up walls to finalize the maze Below */
			
		}

	}
	
	public void printMaze() {
		super.printBoard();
	}

}
