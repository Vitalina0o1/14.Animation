import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.JCheckBox;
import javax.swing.JSplitPane;
import java.awt.BorderLayout;
import javax.swing.JToolBar;
import javax.swing.UIManager;
import javax.swing.JSeparator;
import java.awt.Toolkit;
import javax.swing.ImageIcon;
import java.awt.Dimension;

public class TestAnimation extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private int stateBtn = 0;
	private int statePane = 0;
	Timer timer;
	int dx = 1, dy = 1;
	boolean moveX = false, moveY = false, moveC = false;
	int alpha = 0;
	
	



	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TestAnimation frame = new TestAnimation();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public TestAnimation() {
		setTitle("Cat");
		setIconImage(Toolkit.getDefaultToolkit().getImage(TestAnimation.class.getResource("/f/Без названия.jpg")));
		TestAnimation frame = this;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));

		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);

		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(TestAnimation.class.getResource("/f/Без названия.jpg")));
		lblNewLabel.setForeground(new Color(0, 153, 0));
		lblNewLabel.setBackground(new Color(51, 0, 204));
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 24));
		lblNewLabel.setSize(new Dimension(179, 177));
		panel.add(lblNewLabel);

		JToolBar toolBar = new JToolBar();
		toolBar.setFont(new Font("Tahoma", Font.PLAIN, 24));
		contentPane.add(toolBar, BorderLayout.SOUTH);


		JButton btnNewButton = new JButton("Кнопка");
		btnNewButton.setBackground(UIManager.getColor("Button.background"));
		btnNewButton.setForeground(new Color(51, 0, 153));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				timer.start();
				switch (statePane) {
				case 0:
					contentPane.setBackground(Color.CYAN);
					statePane = 1;
					break;
				case 1:
					contentPane.setBackground(Color.GREEN);
					statePane = 2;
					break;
				case 2:
					contentPane.setBackground(Color.MAGENTA);
					statePane = 0;
					break;
				}
				if (stateBtn == 0) {
					btnNewButton.setBackground(new Color(112, 146, 190));
					btnNewButton.setBackground(Color.decode("#7092BE"));
					stateBtn = 1;

				} else {
					btnNewButton.setBackground(Color.decode("#FFCCEE"));
					stateBtn = 0;

				}

			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 24));
		toolBar.add(btnNewButton);

		JCheckBox chckbxX = new JCheckBox("по X");
		chckbxX.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				moveX = chckbxX.isSelected();
			}
		});
		
		JSeparator separator_2 = new JSeparator();
		toolBar.add(separator_2);
		chckbxX.setFont(new Font("Tahoma", Font.PLAIN, 24));
		toolBar.add(chckbxX);

		JCheckBox chckbxY = new JCheckBox("по Y");
		chckbxY.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				moveY = chckbxY.isSelected();
			}
		});
		
		JSeparator separator = new JSeparator();
		toolBar.add(separator);
		chckbxY.setFont(new Font("Tahoma", Font.PLAIN, 24));
		toolBar.add(chckbxY);
		
		JSeparator separator_1 = new JSeparator();
		toolBar.add(separator_1);
		
		JCheckBox chckbxC = new JCheckBox("по кругу");
		chckbxC.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				moveC = chckbxC.isSelected();
			}
		});
		chckbxC.setFont(new Font("Tahoma", Font.PLAIN, 24));
		toolBar.add(chckbxC);




		timer = new Timer(15, new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				int x = lblNewLabel.getX();
				int y = lblNewLabel.getY();
				int w = lblNewLabel.getPreferredSize().width;
				int h = lblNewLabel.getPreferredSize().height;
				int R = Math.min(panel.getHeight() - lblNewLabel.getHeight(),panel.getWidth() - lblNewLabel.getWidth())/2;
				int x0 = (panel.getWidth()- lblNewLabel.getWidth())/2;
				int y0 =( panel.getHeight() - lblNewLabel.getHeight())/2;
				if (moveX) {
					x+=dx;
					if (x > panel.getWidth() - lblNewLabel.getWidth()) dx = -1;
					if (x < 0) dx = 1;
				}
				if (moveY) {
					y+=dy;
					if (y > panel.getHeight() - lblNewLabel.getHeight()) dy = -1;
					if (y < 0) dy = 1;
				}
				if (moveC) {
					alpha++;
					x = x0 + (int)Math.round(Math.cos(alpha*Math.PI/180)*R);
					y = y0 + (int)Math.round(Math.sin(alpha*Math.PI/180)*R);
					
				}
				
				lblNewLabel.setBounds(x, y, w, h);
			}
		});

	}
}
