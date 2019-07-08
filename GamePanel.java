import java.awt.Graphics;
import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.border.LineBorder;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class GamePanel extends JPanel implements MouseListener {  
  
  private int cellSize;//cell side size

  private Color gridColor = Color.LIGHT_GRAY;
  private Color aliveCellColor = Color.WHITE;
  private Color deadCellColor = Color.BLACK;

  boolean[][] grid = new boolean[900][600];
  public GamePanel() {  
    
    // grid[10][10]=true;
    // grid[10][11]=true;
    // grid[10][12]=true;
    // grid[10][13]=true;

    setBackground(deadCellColor);
    setBorder(new LineBorder(gridColor, 1));
		setBounds(10, 10, 900+1, 600+1);
		setLayout(null);
    addMouseListener(this);  
  }

  public void cleanPanel() {
    for(int i = 0; i<=this.getWidth()/cellSize; i++) 
      for(int j = 0; j <= this.getWidth()/cellSize; j++) 
        grid[i][j]=false;
    this.repaint(); 
  }

  public int getCellSize() {
    return cellSize;
  }

  public void setCellSize(int cellSize) {
    this.cellSize = cellSize;
  }

	public void paintComponent(Graphics g) {
		super.paintComponent(g);

    g.setColor(gridColor);
    // draw the rows
    for (int i = 0; i<=this.getWidth(); i++)
      g.drawLine(0, i * cellSize, this.getWidth(), i * cellSize);
    
    //draw the columns
    for (int i = 0; i <= this.getWidth(); i++)
      g.drawLine(i * cellSize, 0, i * cellSize, this.getWidth());

    for (int i = 0; i<=this.getWidth()/cellSize; i++) {
      for (int j = 0; j <= this.getWidth()/cellSize; j++) {
        if(grid[i][j]==true) {
          g.setColor(aliveCellColor);
          g.fillRect(i*cellSize+1, j*cellSize+1, cellSize-1, cellSize-1);
        }
      }
    }
    
	}	
  
   
	public void mouseClicked(MouseEvent ev) {
	}

	@Override
	public void mouseEntered(MouseEvent ef) {
		
	}

	@Override
	public void mouseExited(MouseEvent ev) {
	}

	@Override
	public void mousePressed(MouseEvent ev) {
		
	}

	@Override
	public void mouseReleased(MouseEvent ev) {
		int row = ev.getY() / cellSize;
		int col = ev.getX() / cellSize;
		System.out.println(row + "," + col);
    grid[col][row] = !grid[col][row];
    super.repaint();
	}
}
