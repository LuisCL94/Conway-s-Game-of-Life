import java.awt.*;
import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

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
		frame.setBounds(100, 100, 820, 595);
		frame.setLayout(null);
		frame.add(panelGame);
		frame.setVisible(true);
		frame.setLocationRelativeTo(null);
		
		play_stop_button.setText("PLAY"); //set initial text 
		play_stop_button.setBounds(284, 521, 71, 25);
		frame.add(play_stop_button);
		
		countGenLabel.setText("0"); //set initial value 
		countGenLabel.setBounds(780, 526, 70, 15);
		frame.add(countGenLabel);
		
		String[] cells = {"Gosper Glider Gun", "Glider", "Lightweight Spaceship", 
    "Tumbler", "Diehard", "Acorn"};
		cellsComboBox.setModel(new DefaultComboBoxModel(cells));
		cellsComboBox.setBounds(10, 521, 192, 25);
		frame.add(cellsComboBox);
		
		nextButton.setText("NEXT");
		nextButton.setBounds(214, 521, 71, 25);
		frame.add(nextButton);
		
		speedSlider.setBounds(400, 525, 150, 16);
		frame.add(speedSlider);
		
		sizeSlider.setBounds(591, 525, 150, 16);
		frame.add(sizeSlider);
		
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
