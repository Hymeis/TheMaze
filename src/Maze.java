
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
	
	private boolean hasDefaultAround(int width, int length) {
		return getGridValue(width-1,length) == DEFAULT || getGridValue(width+1,length) == DEFAULT ||
			   getGridValue(width,length-1) == DEFAULT || getGridValue(width,length+1) == DEFAULT ;
	}
	
	private void nextStep(int width, int length) {
		int randomDirection = UP + (int)(4*Math.random());
		int nextDirection = INVALID;
		while (hasDefaultAround(width,length) && getGridValue(width,length,randomDirection) != DEFAULT) {
			if (getGridValue(width,length,randomDirection) == DEFAULT) {
				nextDirection = randomDirection;
				break;
			} else {
				randomDirection = UP + (int)(4*Math.random());
			}
		}
		setGridValue(width,length,GENERATING);
		while (nextDirection != INVALID) {
			if (nextDirection == UP && getGridValue(width-1,length) == DEFAULT) {
				nextStep(width-1,length);
			} else if (nextDirection == LEFT && getGridValue(width,length-1) == DEFAULT) {
				nextStep(width,length-1);
			} else if (nextDirection == DOWN && getGridValue(width+1,length) == DEFAULT) {
				nextStep(width+1,length);
			} else if (nextDirection == RIGHT && getGridValue(width+1,length) == DEFAULT) {
				nextStep(width,length+1);
			}
			// If none of the conditions is triggered, that means the grid @ randomized direction does not have default value
		}
		/* Set up walls to finalize the maze below */
		
	}

}
