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

public class GameOfLife extends JFrame {

	private JPanel contentPane;

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
		
		JPanel panel = new JPanel();
		panel.setBorder(new BevelBorder(BevelBorder.LOWERED, Color.BLACK, Color.BLACK, Color.BLACK, Color.BLACK));
		panel.setBounds(0, 0, 820, 509);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JButton play_stop_button = new JButton("PLAY");
		play_stop_button.setBounds(284, 521, 71, 25);
		contentPane.add(play_stop_button);
		
		JLabel lblNewLabel = new JLabel("0");
		lblNewLabel.setBounds(780, 526, 70, 15);
		contentPane.add(lblNewLabel);
		
		String[] cells = {"Gosper Glider Gun", "Glider"};
		JComboBox cellsComboBox = new JComboBox(cells);
		cellsComboBox.setModel(new DefaultComboBoxModel(new String[] {"Gosper Glider Gun", "Glider", "Lightweight Spaceship", "Tumbler", "Diehard", "Acorn"}));
		cellsComboBox.setBounds(10, 521, 192, 25);
		contentPane.add(cellsComboBox);
		
		JButton nextButton = new JButton("NEXT");
		nextButton.addActionListener(new ActionListener() {
			int x = 0;
			public void actionPerformed(ActionEvent e) {
			x++;
			lblNewLabel.setText(Integer.toString(x));

			}
		});
		nextButton.setBounds(214, 521, 71, 25);
		contentPane.add(nextButton);
		
		JSlider speedSlider = new JSlider();
		speedSlider.setBounds(400, 525, 150, 16);
		contentPane.add(speedSlider);
		
		JSlider slider = new JSlider();
		slider.setBounds(591, 525, 150, 16);
		contentPane.add(slider);
		

		
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
