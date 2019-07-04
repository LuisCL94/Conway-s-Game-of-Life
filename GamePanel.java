import java.awt.Graphics;
import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.border.LineBorder;

public class GamePanel extends JPanel {  
  public GamePanel() {

    setBorder(new LineBorder(Color.BLACK, 1));
		setBounds(10, 10, 900+1, 600+1);
		setLayout(null);
  
  }
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);

    g.setColor(Color.LIGHT_GRAY);

    // 1, 2 , 3 , 4, 5, 6, 10, 12, 15  -values ​​to change cell size-
    int cellSize = 15; //cell side size

    // draw the rows
    for (int i = 0; i<=this.getWidth(); i++)
      g.drawLine(0, i * cellSize, this.getWidth(), i * cellSize);
    
    // draw the columns
    for (int i = 0; i <= this.getWidth(); i++)
      g.drawLine(i * cellSize, 0, i * cellSize, this.getWidth());
	}	                                              //600  
}
