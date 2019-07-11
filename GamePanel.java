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

  private boolean[][] grid = new boolean[900][600];
  private boolean[][] newGrid = new boolean[900][600];
  
  public GamePanel() {  

    setBackground(deadCellColor);
    setBorder(new LineBorder(gridColor, 1));
		setBounds(10, 10, 900+1, 600+1);
		setLayout(null);
    addMouseListener(this);  
  }
  public boolean getCell(int i, int j) {
    return grid[j][i];
  }
  
  public void setCell(int i, int j, boolean b) {
    this.grid[j][i]=b;
  }

  public boolean getNewCell(int i, int j) {
    return newGrid[j][i];
  }
  
  public void setNewCell(int i, int j, boolean b) {
    this.newGrid[j][i]=b;
  }

  public int getCellSize() {
    return cellSize;
  }

  public void setCellSize(int cellSize) {
    this.cellSize = cellSize;
  }
  
  public void cleanGamePanel() {
    for(int i = 0; i<=getWidth()/getCellSize(); i++) 
      for(int j = 0; j <= getWidth()/getCellSize(); j++)
        setCell(i,j,false);
  
    repaint(); 
  }

  public void createCell() {
      cleanGamePanel();
  }

  public void gliderGun() {
    cleanGamePanel();

    setCell(6,9,true);
    setCell(7,9,true);
    setCell(6,10,true);
    setCell(7,10,true);

    setCell(6,19,true);
    setCell(7,19,true);
    setCell(8,19,true);
    setCell(5,20,true);
    setCell(4,21,true);
    setCell(4,22,true);
    setCell(9,20,true);
    setCell(10,21,true);
    setCell(10,22,true);
    
    setCell(7,23,true);
    setCell(5,24,true);
    setCell(9,24,true);
    setCell(6,25,true);
    setCell(7,25,true);
    setCell(8,25,true);
    setCell(7,26,true);
    setCell(6,29,true);
    setCell(6,30,true);
    setCell(5,30,true);
    setCell(5,29,true);
    setCell(4,29,true);
    setCell(4,30,true);
    setCell(3,31,true);
    setCell(7,31,true);
    setCell(3,33,true);
    setCell(2,33,true);
    setCell(7,33,true);
    setCell(8,33,true);

    setCell(4,43,true);
    setCell(5,43,true);
    setCell(4,44,true);
    setCell(5,44,true);

    repaint();
  }

  public void glider() {
    cleanGamePanel();

    setCell(4,12,true);    
    setCell(5,13,true);
    setCell(6,13,true);
    setCell(6,12,true);
    setCell(6,11,true);

    repaint();    
  }

  public void lightweightSpaceship() {
    cleanGamePanel();

    setCell(14,6,true);    
    setCell(13,7,true);
    setCell(13,8,true);
    setCell(13,9,true);
    setCell(13,10,true);
    setCell(14,10,true);
    setCell(15,10,true);
    setCell(16,9,true);
    setCell(16,6,true);

    repaint();
  }

  public void tenCellRow() {
    cleanGamePanel();

    setCell(13,17,true);    
    setCell(13,18,true);    
    setCell(13,19,true);    
    setCell(13,20,true);    
    setCell(13,21,true);    
    setCell(13,22,true);    
    setCell(13,23,true);    
    setCell(13,24,true);    
    setCell(13,25,true);    
    setCell(13,26,true);    
    
    repaint();
  }

  public int neighborhood(int i, int j) {
    int count = 0;
    if(i>0 && j>0) {
      if(getCell(i-1, j-1)==true) count++;
      if(getCell(i-1, j)==true) count++;
      if(getCell(i-1, j+1)==true) count++;
      if(getCell(i, j-1)==true) count++;
      if(getCell(i, j+1)==true) count++;
      if(getCell(i+1, j-1)==true) count++;
      if(getCell(i+1, j)==true) count++;
      if(getCell(i+1, j+1)==true) count++;
    }
    return count;
  }

  public void nextGeneration() {

    for(int i = 0; i<=500; i++) {
      for(int j = 0; j <=500; j++) {
        if(getCell(i,j)) {
            if(this.neighborhood(i,j)==2 || this.neighborhood(i,j)==3) 
              setNewCell(i, j, true);
            else 
              setNewCell(i, j, false);
        }
        else {
            if(this.neighborhood(i,j)==3)
              setNewCell(i, j, true);
            else 
              setNewCell(i, j, false);
        } 
      }
    }
    for(int i = 0; i<=500; i++) 
      for(int j = 0; j <= 500; j++) 
        setCell(i, j, getNewCell(i, j));
  }

	public void paintComponent(Graphics g) {
		super.paintComponent(g);

    g.setColor(gridColor);
    // draw the rows
    for (int i = 0; i<=this.getWidth(); i++)
      g.drawLine(0, i * getCellSize(), this.getWidth(), i * getCellSize());
    
    //draw the columns
    for(int i = 0; i <= this.getHeight(); i++)
      g.drawLine(i * getCellSize(), 0, i * getCellSize(), this.getWidth());

    for (int i = 0; i<=this.getWidth()/getCellSize(); i++) {
      for (int j = 0; j <= this.getHeight()/getCellSize(); j++) {
        if(grid[i][j]==true) {
          g.setColor(aliveCellColor);
          g.fillRect(i*getCellSize()+1, j*getCellSize()+1, getCellSize()-1, getCellSize()-1);
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
		int row = ev.getY() / getCellSize();
		int col = ev.getX() / getCellSize();
		System.out.println(row + "," + col);
    grid[col][row] = !grid[col][row];
    super.repaint();
	}
}
