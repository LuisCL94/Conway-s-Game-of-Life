import javax.swing.*;
import javax.swing.event.*; 
import java.awt.*;
import java.awt.event.*;
import javax.swing.border.LineBorder;

public class GameOfLife implements ActionListener, ChangeListener, Runnable {

	private JFrame frame = new JFrame();
	private JLayeredPane layeredPane = new JLayeredPane();
	private JPanel gamePanel = new JPanel();
	private GameWindow gameWindow = new GameWindow();
	private JComboBox cellsComboBox = new JComboBox();
	private JButton nextButton = new JButton();
	private JButton play_stop_button = new JButton();
	private JButton cleanButton = new JButton();
	private JLabel speedIconLabel = new JLabel();
	private JSlider speedSlider = new JSlider(1, 6);
	private JLabel speedLabel = new JLabel();
	private JLabel sizeIconLabel = new JLabel();
	private JSlider sizeSlider = new JSlider(2, 20);
	private JLabel sizeLabel = new JLabel();
	private JLabel countGenLabel = new JLabel();
	private JButton infoButton = new JButton();
	private JPanel infoPanel = new JPanel();
	private JButton backButton = new JButton("BACK");
	private JButton invertButton = new JButton("");
	
	boolean running = false;
	
	public void switchPanels(JPanel panel) {
		layeredPane.removeAll();
		layeredPane.add(panel);
		layeredPane.repaint();
		layeredPane.revalidate();
	}

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

		frame.setTitle("Conway`s Game of Life");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(1000, 720);
		frame.getContentPane().setLayout(null);
		layeredPane.setLocation(0, 0);
		layeredPane.setSize(1000, 683);
		frame.getContentPane().add(layeredPane);
		layeredPane.setLayout(new CardLayout(0, 0));
		
		layeredPane.add(gamePanel, "name_34924502800590");
		gamePanel.setLayout(null);
		
		gameWindow.setBounds(10, 10, 901, 601);
		gameWindow.setSpeed(4);
		gameWindow.setCellSize(15);
		gameWindow.setAliveCellColor(Color.BLACK);
		gameWindow.setDeadCellColor(Color.WHITE);

		gameWindow.setBackground(gameWindow.getDeadCellColor());
		gamePanel.add(gameWindow);
	
		speedSlider.setValue(gameWindow.getSpeed());
		sizeSlider.setValue(gameWindow.getCellSize());
	
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
		speedSlider.setBounds(442, 628, 100, 16);
		speedLabel.setText("speed game = " + speedSlider.getValue());
		speedLabel.setBounds(440, 643, 140, 15);

		sizeIconLabel.setIcon(new ImageIcon("Icons/grid1.png"));
		sizeIconLabel.setBounds(627, 620, 41, 48);
		sizeSlider.setBounds(658, 628, 150, 16);
		sizeLabel.setText("cell/grid size = 15");
		sizeLabel.setBounds(668, 643, 140, 15);

		countGenLabel.setText("0"); //set initial value 
		countGenLabel.setBounds(871, 626, 70, 30);

		infoButton.setIcon(new ImageIcon("Icons/info2.png"));
		infoButton.setBounds(935, 193, 41, 60);

		cellsComboBox.addActionListener(this);
		nextButton.addActionListener(this);
		play_stop_button.addActionListener(this);
		cleanButton.addActionListener(this);
		speedSlider.addChangeListener(this);
		sizeSlider.addChangeListener(this);
		infoButton.addActionListener(this);
		backButton.addActionListener(this);
		invertButton.addActionListener(this);

		gamePanel.add(cellsComboBox);
		gamePanel.add(nextButton);
		gamePanel.add(play_stop_button);
		gamePanel.add(cleanButton);
		gamePanel.add(speedIconLabel);
		gamePanel.add(speedSlider);		
		gamePanel.add(speedLabel);
		gamePanel.add(sizeIconLabel);
		gamePanel.add(sizeSlider);
		gamePanel.add(sizeLabel);
		gamePanel.add(countGenLabel);
		gamePanel.add(infoButton);
		
		invertButton.setBounds(934, 400, 45, 48);
		invertButton.setIcon(new ImageIcon(getClass().getResource("Icons/invert1.png")));
		
		gamePanel.add(invertButton);
		
		layeredPane.add(infoPanel, "name_42708651229050");
		infoPanel.setLayout(null);
		backButton.setBounds(332, 646, 76, 25);
		
		infoPanel.add(backButton);
		
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
					gameWindow.createCell();
				}

				else if(cellsComboBox.getSelectedItem() == "Gosper Glider Gun") {
					x=0;
					countGenLabel.setText(Integer.toString(x));
					gameWindow.gliderGun();
				}

				else if(cellsComboBox.getSelectedItem() == "Glider") {
					x=0;
					countGenLabel.setText(Integer.toString(x));
					gameWindow.glider();
				}

				else if(cellsComboBox.getSelectedItem() == "Lightweight Spaceship") {
					x=0;
					countGenLabel.setText(Integer.toString(x));					
					gameWindow.lightweightSpaceship();
				}	
				else if(cellsComboBox.getSelectedItem() == "10 Cell Row") {
					x=0;
					countGenLabel.setText(Integer.toString(x));	
					gameWindow.tenCellRow();
				}
				else if(cellsComboBox.getSelectedItem() == "Tumbler") {
					x=0;
					countGenLabel.setText(Integer.toString(x));	
					gameWindow.tumbler();
				}
				
				else if(cellsComboBox.getSelectedItem() == "Diehard") {
					x=0;
					countGenLabel.setText(Integer.toString(x));	
					gameWindow.diehard();
				}		

				else if(cellsComboBox.getSelectedItem() == "Acorn") {
					x=0;
					countGenLabel.setText(Integer.toString(x));	
					gameWindow.acorn();
				}
		}

		if(e.getSource().equals(nextButton)) {
				x++;
				countGenLabel.setText(Integer.toString(x));
				gameWindow.nextGeneration();
				gameWindow.repaint();
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
				gameWindow.cleanGameWindow();		
		}
		
		if(e.getSource().equals(infoButton)) 
			switchPanels(infoPanel);
		
		if(e.getSource().equals(backButton)) 
			switchPanels(gamePanel);

		if(e.getSource().equals(invertButton)) {
			Color aliveColor = gameWindow.getAliveCellColor();
			gameWindow.setAliveCellColor(gameWindow.getDeadCellColor());
			gameWindow.setDeadCellColor(aliveColor);
			gameWindow.setBackground(aliveColor);
			gameWindow.repaint();
		}		
	}

	public void stateChanged(ChangeEvent e) {
		
		if(sizeSlider.getValueIsAdjusting()) {
			gameWindow.setCellSize(sizeSlider.getValue());
			sizeLabel.setText("cell/grid  size = " + sizeSlider.getValue());
			gameWindow.repaint();
		}
		if(speedSlider.getValueIsAdjusting()) {
			gameWindow.setSpeed(speedSlider.getValue());
			speedLabel.setText("speed game = " + speedSlider.getValue());
			gameWindow.repaint();
		}
	}

	public void run() {
		while(running == true) {
			x++;
			countGenLabel.setText(Integer.toString(x));
			gameWindow.nextGeneration();
			gameWindow.repaint();	
			try{
				Thread.sleep(gameWindow.speedGame(gameWindow.getSpeed())); 
			}catch(	Exception ex) {
				ex.printStackTrace();
			}
		}
	}
	

}
