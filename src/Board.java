
public class Board {
	//gridSignal
	public static final int DEFAULT = 1;
	public static final int GENERATING = 2;
	public static final int SET = 3;
	//gapSignal
	public static final int PATH = 9;
	public static final int WALL = 8;
	//invalid. No algorithms should ever use this other than checking exceptions.
	public static final int INVALID = 0;
	//positions
	public static final int UP = 10;
	public static final int LEFT = 11;
	public static final int DOWN = 12;
	public static final int RIGHT = 13;
	
	private int[][] board;
	
	public Board() {
		board = new int[19][19]; // Basically 10*10. It writes 19*19 since the lines/gaps between two adjacent grids count
		initialization();
	}
	
	public Board(int width, int length) {
		board = new int[2*width-1][2*length-1]; // It includes grids and gaps/lines between two adjacent grids.
		initialization();
	}
	
	/**
	 * Set all values inside the grids as default, gaps/lines as paths, and positions other than grids and paths invalid.
	 * @return an initialized board.
	 */
	private int[][] initialization() { 
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[0].length; j++) {
				if (i % 2 == 0 && j % 2 == 0) {
					board[i][j] = DEFAULT;
				}
				else if (i % 2 == 1 && j % 2 == 1) {
					board[i][j] = INVALID;
				}
				else {
					board[i][j] = PATH;
				}
			}
		}
		return board;
	}
	
	public void printBoard() { // It prints out the grids and paths.
		for (int i = 0; i < board.length; i++) {
			for (int j =0; j < board[0].length; j++) {
				System.out.print(board[i][j] + " ");
			}
			System.out.println();
		}
	}
	
	public void printGrid() { // it prints out grids only.
		for (int i = 0; i < board.length; i+= 2) {
			for (int j =0; j < board[0].length; j+= 2) {
				System.out.print(board[i][j] + " ");
			}
			System.out.println();
		}
	}
	
	public int getBoardWidth() {
		return board.length;
	}
	
	public int getBoardLength() {
		return board[0].length;
	}
	
	public int getGridWidth() {
		return (board.length + 1) / 2;
	}
	
	public int getGridLength() {
		return (board[0].length + 1) / 2;
	}
	
	public void setGridValue(int width, int length, int gridSignal) {
		board[width*2-1][length*2-1] = gridSignal;
	}
	
	public int getGridValue(int width, int length) {
		return board[width*2-1][length*2-1];
	}

	public void setGapValue(int width, int length, int direction, int gapSignal) { 
		if (direction == UP && width != 0) {
			board[width*2-2][length*2-1] = gapSignal;
		} else if (direction == LEFT && length != 0) {
			board[width*2-1][length*2-2] = gapSignal;
		} else if (direction == DOWN && width != board.length - 1) {
			board[width*2][length*2-1] = gapSignal;
		} else if (direction == RIGHT && length != board[0].length - 1){
			board[width*2-1][length*2] = gapSignal;
		}
	}
	
	public int getGapValue(int width, int length, int direction) {
		if (direction == UP && width != 0) {
			return board[width*2-2][length*2-1];
		} else if (direction == LEFT && length != 0) {
			return board[width*2-1][length*2-2];
		} else if (direction == DOWN && width != board.length - 1) {
			return board[width*2][length*2-1];
		} else if (direction == RIGHT && length != board[0].length - 1){
			return board[width*2-1][length*2];
		}
		return INVALID; // OutOfBound
	}
	
}
