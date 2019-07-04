import java.awt.Graphics;
import javax.swing.JPanel;
import javax.swing.border.BevelBorder;
import java.awt.Color;

public class GamePanel extends JPanel {
	public GamePanel() {
		setBorder(new BevelBorder(BevelBorder.LOWERED, Color.BLACK, Color.BLACK, 
		Color.BLACK, Color.BLACK));
		setBounds(12, 0, 795, 509);
		setLayout(null);
	}
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawLine(100,200,300, 450);
	}	
}
