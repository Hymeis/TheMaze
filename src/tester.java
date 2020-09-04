import java.util.*;
import java.awt.*;
import javax.swing.*;

public class tester extends JPanel{
	  private static final int RECT_X = 100;
	  private static final int RECT_Y = RECT_X;
	  private static final int RECT_WIDTH = 100;
	  private static final int RECT_HEIGHT = RECT_WIDTH;
	  
	  @Override
	   protected void paintComponent(Graphics g) {
	      super.paintComponent(g);
	      // draw the rectangle here
	      g.drawRect(RECT_X, RECT_Y, RECT_WIDTH, RECT_HEIGHT);
	      g.setColor(java.awt.Color.blue);
	      g.fillRect(RECT_X, RECT_Y, RECT_WIDTH, RECT_HEIGHT);
	   }

	   @Override
	   public Dimension getPreferredSize() {
	      // so that our GUI is big enough
	      return new Dimension(RECT_WIDTH + 2 * RECT_X, RECT_HEIGHT + 2 * RECT_Y);
	   }
	   
	   private static void createAndShowGui() {
		   tester mainPanel = new tester();

		   JFrame frame = new JFrame("DrawRect");
		   frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		   frame.getContentPane().add(mainPanel);
		   frame.pack();
		   frame.setLocationByPlatform(true);
		   frame.setVisible(true);
		   
		   }

	   public static void main(String[] args) {
		// TODO Auto-generated method stub
		Board a = new Board();
		Maze b = new Maze(4,4);
		b.generateMaze();
		int path = a.getGridValue(0 - 2,0);
		boolean hasdefault = b.hasDefaultAround(6,0);
		//createAndShowGui();
		a.printBoard();
		System.out.println();
		System.out.println(path);
		System.out.println(hasdefault);
		System.out.println();
		b.printMaze();
		
	}

}
