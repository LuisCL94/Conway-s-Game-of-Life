import javax.swing.*;
import javax.swing.event.*; 
import java.awt.*;
import java.awt.event.*;

public class GameOfLife implements ActionListener, ChangeListener, Runnable {

	private JFrame frame = new JFrame();
	private GamePanel panelGame = new GamePanel();
	private JComboBox cellsComboBox = new JComboBox();
	private JButton nextButton = new JButton();
	private JButton play_stop_button = new JButton();
	private JButton cleanButton = new JButton();
	private JLabel speedIconLabel = new JLabel();
	private JSlider speedSlider = new JSlider(1, 5);
	private JLabel speedLabel = new JLabel();
	private JLabel sizeIconLabel = new JLabel();
	private JSlider sizeSlider = new JSlider(2, 20);
	private JLabel sizeLabel = new JLabel();
	private JLabel countGenLabel = new JLabel();
	
	boolean running = false;

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

	public GameOfLife() {

		panelGame.setSpeed(3);
		panelGame.setCellSize(15);

		frame.setTitle("Conway`s Game of Life");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(923, 720);
		frame.getContentPane().setLayout(null);
		frame.getContentPane().add(panelGame);
	
		String[] cells = {"Random","Create Cell","Gosper Glider Gun", "Glider", 
			"Lightweight Spaceship", "10 Cell Row", "Tumbler", "Diehard", "Acorn"};
		cellsComboBox.setModel(new DefaultComboBoxModel(cells));
		cellsComboBox.setBounds(10, 631, 192, 25);

		nextButton.setIcon(new ImageIcon("Icons/next1.png"));
		nextButton.setBounds(220, 630, 41, 30);

		play_stop_button.setIcon(new ImageIcon("/home/luiz/MY_PROJECTS/Conway`s Game of Life/Icons/play2.png"));
		play_stop_button.setBounds(268, 630, 35, 30);
		
		cleanButton.setIcon(new ImageIcon("/home/luiz/MY_PROJECTS/Conway`s Game of Life/Icons/clean.png"));
		cleanButton.setBounds(310, 630, 35, 30);
		
		speedIconLabel.setIcon(new ImageIcon("Icons/speed1.png"));
		speedIconLabel.setBounds(400, 620, 60, 48);
		speedSlider.setValue(panelGame.getSpeed());
		speedSlider.setBounds(442, 628, 100, 16);
		speedLabel.setText("speed game = " + speedSlider.getValue());
		speedLabel.setBounds(440, 643, 140, 15);

		sizeIconLabel.setIcon(new ImageIcon("Icons/grid1.png"));
		sizeIconLabel.setBounds(627, 620, 41, 48);
		sizeSlider.setValue(panelGame.getCellSize());
		sizeSlider.setBounds(658, 628, 150, 16);
		sizeLabel.setText("cell/grid size = 15");
		sizeLabel.setBounds(668, 643, 140, 15);

		countGenLabel.setText("0"); //set initial value 
		countGenLabel.setBounds(871, 626, 70, 30);

		cellsComboBox.addActionListener(this);
		nextButton.addActionListener(this);
		play_stop_button.addActionListener(this);
		cleanButton.addActionListener(this);
		speedSlider.addChangeListener(this);
		sizeSlider.addChangeListener(this);

		frame.getContentPane().add(cellsComboBox);
		frame.getContentPane().add(nextButton);
		frame.getContentPane().add(play_stop_button);
		frame.getContentPane().add(cleanButton);
		frame.getContentPane().add(speedIconLabel);
		frame.getContentPane().add(speedSlider);		
		frame.getContentPane().add(speedLabel);
		frame.getContentPane().add(sizeIconLabel);
		frame.getContentPane().add(sizeSlider);
		frame.getContentPane().add(sizeLabel);
		frame.getContentPane().add(countGenLabel);
		
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
	}

	int x = 0;
	int y = 0;
	public void actionPerformed(ActionEvent e) {		
		if(e.getSource().equals(cellsComboBox)) {

				if(cellsComboBox.getSelectedItem() == "Create Cell") {
					x=0;
					countGenLabel.setText(Integer.toString(x));
					panelGame.createCell();
				}

				else if(cellsComboBox.getSelectedItem() == "Gosper Glider Gun") {
					x=0;
					countGenLabel.setText(Integer.toString(x));
					panelGame.gliderGun();
				}

				else if(cellsComboBox.getSelectedItem() == "Glider") {
					x=0;
					countGenLabel.setText(Integer.toString(x));
					panelGame.glider();
				}

				else if(cellsComboBox.getSelectedItem() == "Lightweight Spaceship") {
					x=0;
					countGenLabel.setText(Integer.toString(x));					
					panelGame.lightweightSpaceship();
				}	
				else if(cellsComboBox.getSelectedItem() == "10 Cell Row") {
					x=0;
					countGenLabel.setText(Integer.toString(x));	
					panelGame.tenCellRow();
				}
		}

		if(e.getSource().equals(nextButton)) {
				x++;
				countGenLabel.setText(Integer.toString(x));
				panelGame.nextGeneration();
				panelGame.repaint();
		}
		
		if(e.getSource().equals(play_stop_button)) {		
			if(y%2==0) {
				Thread t = new Thread(this);
				running =	true;
				play_stop_button.setIcon(new ImageIcon(getClass().getResource("Icons/pause3.png")));
				t.start();
			}
			else {
				running = false;
				play_stop_button.setIcon(new ImageIcon(getClass().getResource("Icons/play2.png")));
			}
			y++;
		}
	
		if(e.getSource().equals(cleanButton)) {
				x=0;
				countGenLabel.setText(Integer.toString(x));	
				panelGame.cleanGamePanel();		
		}
	
	}

	public void stateChanged(ChangeEvent e) {
		
		if(sizeSlider.getValueIsAdjusting()) {
			panelGame.setCellSize(sizeSlider.getValue());
			sizeLabel.setText("cell/grid  size = " + sizeSlider.getValue());
			panelGame.repaint();
		}
		if(speedSlider.getValueIsAdjusting()) {
			panelGame.setSpeed(speedSlider.getValue());
			speedLabel.setText("speed game = " + speedSlider.getValue());
			panelGame.repaint();
		}
	}

	public void run() {
		while(running == true) {
			x++;
			countGenLabel.setText(Integer.toString(x));
			panelGame.nextGeneration();
			panelGame.repaint();	
			try{
				Thread.sleep(panelGame.SpeedGame(panelGame.getSpeed())); //15, 40, 65, 79, 101, 123, 150, 172, 194, 216 
			}catch(	Exception ex) {
				ex.printStackTrace();
			}
		}
	}

}
