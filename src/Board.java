
public class Board {
	public static final int DEFAULT = 1;
	public static final int ROAD = 9;
	//public static final int WALL = 8;
	public static final int INVALID = 0;
	int[][] board;
	
	public Board() {
		board = new int[19][19]; // Basically 10*10
		initialization();
	}
	
	public Board(int width, int length) {
		board = new int[2*width-1][2*length-1]; // It includes grids and roads (where it connects grids).
		initialization();
	}
	
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
					board[i][j] = ROAD;
				}
			}
		}
		return board;
	}
	
	public void printBoard() { // It prints out the grids and roads.
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
}
