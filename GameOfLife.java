import javax.swing.*;
import javax.swing.event.*; 
import java.awt.*;
import java.awt.event.*;

public class GameOfLife {

	private JFrame frame = new JFrame();
	private GamePanel panelGame = new GamePanel();
	private JButton play_stop_button = new JButton();
	private JComboBox cellsComboBox = new JComboBox();
	private JLabel countGenLabel = new JLabel();
	private JButton nextButton = new JButton();
	private JSlider speedSlider = new JSlider(1, 10);
	private JLabel speedLabel = new JLabel();
	private JLabel speedIconLabel = new JLabel();
	private JSlider sizeSlider = new JSlider(2, 20);
	private JLabel sizeLabel = new JLabel();
	private JLabel sizeIconLabel = new JLabel();
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
		panelGame.setCellSize(15);

		frame.setTitle("Conway`s Game of Life");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(923, 720);
		frame.getContentPane().setLayout(null);
		frame.getContentPane().add(panelGame);
		
		frame.setVisible(true);
		frame.setLocationRelativeTo(null);
		
		play_stop_button.setText("PLAY"); //set initial text 
		play_stop_button.setBounds(288, 631, 71, 25);
		frame.getContentPane().add(play_stop_button);
		
		countGenLabel.setText("0"); //set initial value 
		countGenLabel.setBounds(871, 626, 70, 30);
		frame.getContentPane().add(countGenLabel);
		
		String[] cells = {"Create Cell","Gosper Glider Gun", "Glider", 
			"Lightweight Spaceship", "Tumbler", "Diehard", "Acorn"};

		cellsComboBox.setModel(new DefaultComboBoxModel(cells));
		cellsComboBox.setBounds(10, 631, 192, 25);
		frame.getContentPane().add(cellsComboBox);
		
		nextButton.setText("NEXT");
		nextButton.setBounds(218, 631, 71, 25);
		frame.getContentPane().add(nextButton);
		
		speedIconLabel.setIcon(new ImageIcon("Icons/speed.png"));
		speedIconLabel.setBounds(400, 620, 60, 48);
		speedSlider.setBounds(435, 628, 150, 16);
		speedSlider.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent arg0) {				
				speedLabel.setText("speed game = " + speedSlider.getValue());
				panelGame.repaint();

			}
		});
		frame.getContentPane().add(speedSlider);
		speedLabel.setText("speed game = " + speedSlider.getValue());
		speedLabel.setBounds(450, 643, 140, 15);
		frame.getContentPane().add(speedLabel);
		frame.getContentPane().add(speedIconLabel);
		
		
		sizeLabel.setBounds(693, 643, 140, 15);
		sizeIconLabel.setIcon(new ImageIcon("Icons/grid.png"));
		sizeIconLabel.setBounds(652, 620, 41, 48);
		sizeSlider.setValue(panelGame.getCellSize());
		sizeLabel.setText("cell/grid  size = " + sizeSlider.getValue());
		sizeSlider.setBounds(683, 628, 150, 16);
		sizeSlider.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent arg0) {
				System.out.println(sizeSlider.getValue());
				panelGame.setCellSize(sizeSlider.getValue());
				sizeLabel.setText("cell/grid  size = " + sizeSlider.getValue());
				panelGame.repaint();

			}
		});
		frame.getContentPane().add(sizeLabel);
		frame.getContentPane().add(sizeSlider);
		frame.getContentPane().add(sizeIconLabel);
		
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
