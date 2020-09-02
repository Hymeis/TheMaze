
public class Board {
	public static final int DEFAULT = 1;
	public static final int GENERATING = 2;
	public static final int SET = 3;
	public static final int PATH = 9;
	public static final int WALL = 8;
	public static final int INVALID = 0;
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
	
	public void setGridValue(int width, int length, int val) {
		board[width*2-1][length*2-1] = val;
	}
	
	public int getGridValue(int width, int length) {
		return board[width*2-1][length*2-1];
	}

	public void setGapValue() { //Unfinished. 不是不能编，在想怎么优化
		
	}
	
	public int getGapValue() {
		
		return 0;
	}
	
}
