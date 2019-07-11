import javax.swing.*;
import javax.swing.event.*; 
import java.awt.*;
import java.awt.event.*;

public class GameOfLife implements ActionListener {

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
	private JButton cleanButton = new JButton();
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
	
		play_stop_button.setIcon(new ImageIcon("/home/luiz/MY_PROJECTS/Conway`s Game of Life/Icons/play2.png"));
		play_stop_button.setBounds(268, 630, 35, 30);
		
		cleanButton.setIcon(new ImageIcon("/home/luiz/MY_PROJECTS/Conway`s Game of Life/Icons/clean.png"));
		cleanButton.setBounds(310, 630, 35, 30);
		
		countGenLabel.setText("0"); //set initial value 
		countGenLabel.setBounds(871, 626, 70, 30);
		
		String[] cells = {"Random","Create Cell","Gosper Glider Gun", "Glider", 
			"Lightweight Spaceship", "10 Cell Row", "Tumbler", "Diehard", "Acorn"};

		cellsComboBox.setModel(new DefaultComboBoxModel(cells));
		cellsComboBox.setBounds(10, 631, 192, 25);
		frame.getContentPane().add(cellsComboBox);
		nextButton.setIcon(new ImageIcon("Icons/next1.png"));
		nextButton.setBounds(220, 630, 41, 30);
		
		speedIconLabel.setIcon(new ImageIcon("Icons/speed1.png"));
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
		
		sizeLabel.setBounds(693, 643, 140, 15);
		sizeIconLabel.setIcon(new ImageIcon("Icons/grid1.png"));
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
		
		cellsComboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				// if(cellsComboBox.getSelectedItem() == "Random")
					// panelGame.randomCells();
				if(cellsComboBox.getSelectedItem() == "Create Cell")
					panelGame.createCell();
				else if(cellsComboBox.getSelectedItem() == "Gosper Glider Gun")
					panelGame.gliderGun();
				else if(cellsComboBox.getSelectedItem() == "Glider")
					panelGame.glider();
				else if(cellsComboBox.getSelectedItem() == "Lightweight Spaceship")
					panelGame.lightweightSpaceship();
				else if(cellsComboBox.getSelectedItem() == "10 Cell Row")
					panelGame.tenCellRow();
			}
		});

		cleanButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				panelGame.cleanGamePanel();
			}
		});

		nextButton.addActionListener(new ActionListener() {
			int x = 0;
			public void actionPerformed(ActionEvent e) {
				x++;
				countGenLabel.setText(Integer.toString(x));
				panelGame.nextGeneration();
				panelGame.repaint();
			}
		});

		play_stop_button.addActionListener(new ActionListener() {
			int x = 0;
			public void actionPerformed(ActionEvent e) {
				
				if(x%2==0)
					play_stop_button.setIcon(new ImageIcon(getClass().getResource("Icons/pause3.png")));
				else
					play_stop_button.setIcon(new ImageIcon(getClass().getResource("Icons/play2.png")));
				
				x++;
			}
		});

		frame.getContentPane().add(play_stop_button);

		frame.getContentPane().add(countGenLabel);

		frame.getContentPane().add(cleanButton);

		frame.getContentPane().add(nextButton);

		frame.getContentPane().add(speedLabel);
		frame.getContentPane().add(speedIconLabel);

		frame.getContentPane().add(sizeLabel);
		frame.getContentPane().add(sizeSlider);
		frame.getContentPane().add(sizeIconLabel);
		
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);

	}
	public void actionPerformed(ActionEvent e) {		

	}
	public void run() {

	}
}
