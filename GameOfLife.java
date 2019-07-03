

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.border.BevelBorder;
import java.awt.Color;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JSlider;
import javax.swing.DefaultComboBoxModel;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;

public class GameOfLife extends JFrame {

	private JPanel contentPane;
	private JPanel panelGame;
	private JButton play_stop_button;
	private JComboBox cellsComboBox;
	private JLabel countGenLabel;
	private JButton nextButton;
	private JSlider speedSlider;
	private JSlider sizeSlider;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GameOfLife frame = new GameOfLife();
					frame.setVisible(true);
					frame.setLocationRelativeTo(null);
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
		setTitle("Conway`s Game of Life");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 820, 595);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		panelGame = new JPanel();
		panelGame.setBorder(new BevelBorder(BevelBorder.LOWERED, Color.BLACK, Color.BLACK, Color.BLACK, Color.BLACK));
		panelGame.setBounds(12, 0, 795, 509);
		contentPane.add(panelGame);
		panelGame.setLayout(null);
		
		ImageIcon grid = new ImageIcon("grid.png");
		
		play_stop_button = new JButton("PLAY");
		play_stop_button.setBounds(284, 521, 71, 25);
		contentPane.add(play_stop_button);
		
		countGenLabel = new JLabel("0");
		countGenLabel.setBounds(780, 526, 70, 15);
		contentPane.add(countGenLabel);
		
		String[] cells = {"Gosper Glider Gun", "Glider", "Lightweight Spaceship", "Tumbler", "Diehard", "Acorn"};
		cellsComboBox = new JComboBox(cells);
		cellsComboBox.setBounds(10, 521, 192, 25);
		contentPane.add(cellsComboBox);
		
		nextButton = new JButton("NEXT");
		nextButton.setBounds(214, 521, 71, 25);
		contentPane.add(nextButton);
		
		speedSlider = new JSlider();
		speedSlider.setBounds(400, 525, 150, 16);
		contentPane.add(speedSlider);
		
		sizeSlider = new JSlider();
		sizeSlider.setBounds(591, 525, 150, 16);
		contentPane.add(sizeSlider);
		
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
