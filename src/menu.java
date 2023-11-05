package src;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyEvent;

import javax.swing.JButton;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JPanel;
import javax.swing.KeyStroke;
import javax.swing.border.EmptyBorder;

public class menu extends JFrame {

	private JPanel contentPane;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					menu frame = new menu();
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
	public menu() {
		
		setResizable(false);
		setTitle("Insurance Appointment System");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 632, 260);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBackground(new Color(255, 255, 255));
		menuBar.setFont(new Font("Segoe UI Emoji", Font.PLAIN, 16));
		setJMenuBar(menuBar);
		
		JMenu mnNewMenu = new JMenu("Appearance");
		mnNewMenu.setFont(new Font("SAS Monospace", Font.ITALIC, 14));
		menuBar.add(mnNewMenu);
	
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		JButton btnNewButton = new JButton("Insurance Agent");
		btnNewButton.setBackground(new Color(255, 255, 255));
		btnNewButton.setBounds(20, 114, 170, 49);
		btnNewButton.setFont(new Font("Consolas", Font.BOLD | Font.ITALIC, 16));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				InsuranceAgentGUI a = new InsuranceAgentGUI();
				dispose();
				a.setVisible(true);
			}
		});
		contentPane.setLayout(null);
		contentPane.add(btnNewButton);
		JButton btnNewButton_1 = new JButton("Customer");
		btnNewButton_1.setBackground(new Color(255, 255, 255));
		btnNewButton_1.setBounds(213, 114, 180, 49);
		btnNewButton_1.setFont(new Font("Consolas", Font.BOLD | Font.ITALIC, 16));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				customerGUI newProject = new customerGUI();
				dispose();
				newProject.setVisible(true);
				}
		});
		contentPane.add(btnNewButton_1);
		JButton btnNewButton_2 = new JButton("Appointment");
		btnNewButton_2.setBackground(new Color(255, 255, 255));
		btnNewButton_2.setBounds(416, 114, 180, 49);
		btnNewButton_2.setFont(new Font("Consolas", Font.BOLD | Font.ITALIC, 16));
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				appointmentGUI a = new appointmentGUI();
				dispose();
				a.setVisible(true);
			}
		});
		contentPane.add(btnNewButton_2);
		JLabel lblNewLabel = new JLabel("Main Menu");
		lblNewLabel.setFont(new Font("Symbola", Font.BOLD | Font.ITALIC, 24));
		lblNewLabel.setBounds(231, 43, 144, 36);
		contentPane.add(lblNewLabel);
		JCheckBoxMenuItem chckbxmntmNewCheckItem = new JCheckBoxMenuItem("Dark mode");
		chckbxmntmNewCheckItem.setFont(new Font("NSimSun", Font.ITALIC, 14));
		chckbxmntmNewCheckItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_BACK_SPACE, 0));
		chckbxmntmNewCheckItem.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				if(e.getStateChange()==ItemEvent.SELECTED) {
					contentPane.setBackground(Color.BLACK);
					btnNewButton.setBackground(Color.black);
					btnNewButton_1.setBackground(Color.black);
					btnNewButton_2.setBackground(Color.black);
					btnNewButton.setForeground(Color.white);
					btnNewButton_1.setForeground(Color.white);
					btnNewButton_2.setForeground(Color.white);
					lblNewLabel.setForeground(Color.white);
					menuBar.setBackground(Color.black);
					mnNewMenu.setForeground(Color.white);
					
				}else {
					contentPane.setBackground(Color.WHITE);
					btnNewButton.setBackground(Color.white);
					btnNewButton_1.setBackground(Color.white);
					btnNewButton_2.setBackground(Color.white);
					btnNewButton.setForeground(Color.black);
					btnNewButton_1.setForeground(Color.black);
					btnNewButton_2.setForeground(Color.black);
					lblNewLabel.setForeground(Color.black);
					menuBar.setBackground(Color.white);
					mnNewMenu.setForeground(Color.black);
					
				}
				}
		});
		
		mnNewMenu.add(chckbxmntmNewCheckItem);
	}
}
