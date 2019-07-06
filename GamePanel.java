import java.awt.Graphics;
import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.border.LineBorder;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class GamePanel extends JPanel implements MouseListener {  
  private int cellSize;//cell side size
  
  // private gridColor;
  // private aliveCellColor;
  // private deadCellColor;
  public GamePanel() {  
    setBackground(Color.WHITE);
    setBorder(new LineBorder(Color.LIGHT_GRAY, 1));
		setBounds(10, 10, 900+1, 600+1);
		setLayout(null);
    addMouseListener(this);  
  }

  public int getCellSize() {
    return cellSize;
  }

  public void setCellSize(int cellSize) {
    this.cellSize = cellSize;
  }

	public void paintComponent(Graphics g) {
		super.paintComponent(g);

    g.setColor(Color.LIGHT_GRAY);
    // draw the rows
    for (int i = 0; i<=this.getWidth(); i++)
      g.drawLine(0, i * cellSize, this.getWidth(), i * cellSize);
    
    // draw the columns
    for (int i = 0; i <= this.getWidth(); i++)
      g.drawLine(i * cellSize, 0, i * cellSize, this.getWidth());


    g.setColor(Color.BLACK);
    g.fillRect (6*cellSize+1, 6*cellSize+1, cellSize-1, cellSize-1);
    g.fillRect (7*cellSize+1, 6*cellSize+1, cellSize-1, cellSize-1);
    g.fillRect (6*cellSize+1, 7*cellSize+1, cellSize-1, cellSize-1);
    g.fillRect (7*cellSize+1, 7*cellSize+1, cellSize-1, cellSize-1);

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
		// System.out.println(ev.getX() + "," + ev.getY());
		int row = ev.getY() / cellSize;
		int col = ev.getX() / cellSize;
		System.out.println(row + "," + col);
		// g.setColor(Color.BLUE);
		// g.fillRect ( row*10 , col*10 , 10, 10);

	}
}
