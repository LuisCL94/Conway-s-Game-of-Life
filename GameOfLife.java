import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

// 
public class GameOfLife {

	private JFrame frame = new JFrame();
	private GamePanel panelGame = new GamePanel();
	private JButton play_stop_button = new JButton();
	private JComboBox cellsComboBox = new JComboBox();
	private JLabel countGenLabel = new JLabel();
	private JButton nextButton = new JButton();
	private JSlider speedSlider = new JSlider();
	private JSlider sizeSlider = new JSlider();
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GameOfLife frame = new GameOfLife();

				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public GameOfLife() {
		
		frame.setTitle("Conway`s Game of Life");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(923, 697);
		frame.setLayout(null);
		// panelGame.addMouseListener(this);
		frame.add(panelGame);
		frame.setVisible(true);
		frame.setLocationRelativeTo(null);
		
		play_stop_button.setText("PLAY"); //set initial text 
		play_stop_button.setBounds(284, 623, 71, 25);
		frame.getContentPane().add(play_stop_button);
		
		countGenLabel.setText("0"); //set initial value 
		countGenLabel.setBounds(780, 626, 70, 15);
		frame.getContentPane().add(countGenLabel);
		
		String[] cells = {"Create Cell","Gosper Glider Gun", "Glider", "Lightweight Spaceship", "Tumbler", "Diehard", "Acorn"};
		cellsComboBox.setModel(new DefaultComboBoxModel(cells));
		cellsComboBox.setBounds(10, 623, 192, 25);
		frame.getContentPane().add(cellsComboBox);
		
		nextButton.setText("NEXT");
		nextButton.setBounds(214, 623, 71, 25);
		frame.getContentPane().add(nextButton);
		
		speedSlider.setBounds(400, 626, 150, 16);
		frame.getContentPane().add(speedSlider);
		
		sizeSlider.setBounds(591, 626, 150, 16);
		frame.getContentPane().add(sizeSlider);
		
		nextButton.addActionListener(new ActionListener() {
			int x = 0;
			public void actionPerformed(ActionEvent e) {
				x++;
				countGenLabel.setText(Integer.toString(x));
			}
		});
		
		play_stop_button.addActionListener(new ActionListener() {
			int x = 0;
			public void actionPerformed(ActionEvent e) {
				
				if(x%2==0)
					play_stop_button.setText("STOP");
				else
					play_stop_button.setText("PLAY");
				
				x++;
			}
		});
	
	}
}
