package SOC;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.TextArea;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JComboBox;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableColumnModel;
import javax.swing.JButton;
import javax.swing.border.EtchedBorder;
import java.awt.Color;
import javax.swing.border.LineBorder;
import javax.swing.JTable;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.awt.event.ActionEvent;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.border.MatteBorder;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class InsuranceAgentGUI extends JFrame {
	private static final long serialVersionUID = 1L;
	static int put;
	public static NodeInsAgent head;
	public static NodeInsAgent current;
	public static NodeInsAgent before;
	public static int count;
	private static JPanel contentPane;
	private static JTextField textField;
	private static JTextField textField_1;
	private static JTextField textField_2;
	private static JTextField textField_3;
	private static JTextField textField_4;
	private static JTextField textField_5;
	private static JTextField textField_6;
	private static JTextField textField_7;
	public static JTable table;
	private static JComboBox<String> comboBox_1;
	public static JScrollPane scrollPane;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					InsuranceAgentGUI frame = new InsuranceAgentGUI();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public InsuranceAgentGUI() {
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowOpened(WindowEvent e) {
				DefaultTableModel model = (DefaultTableModel) table.getModel();
				current = head;
				while ((current != null)) {
					char y = current.getInfo().getAgentGender();
					String x = String.valueOf(y);
					String[] data = { current.getInfo().getAgentName(), current.getInfo().getAgentPassword(),
							current.getInfo().getAgentIC(), current.getInfo().getAgentPhoneNum(), current.getInfo().getAgentEmail(), x,
							current.getInfo().getAgentHomeAddr() };
					model.addRow(data);
					current = current.getLink();
				}
				comboBox_1.removeAllItems();
				current = head;
				while (current != null) {
					comboBox_1.addItem(current.getInfo().getAgentIC());
					current = current.getLink();
				}
			}
		});
		setResizable(false);
		setTitle("insuranceAgent");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 676, 323);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 255, 0));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		textField = new JTextField();
		textField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_1) {
					textField.setText("Automatically fill");
					textField_1.setText("Automatically fill");
					textField_2.setText("12345678900" + put);
					textField_3.setText("12345678900" + put);
					textField_4.setText(put + "email@gmail.com");
					textField_5.setText("f");
					textField_6.setText("Automatically fill");
					put++;
				}
			}
		});
		textField.setBounds(176, 26, 162, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(176, 57, 162, 20);
		contentPane.add(textField_1);
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(176, 88, 162, 20);
		contentPane.add(textField_2);
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(176, 119, 162, 20);
		contentPane.add(textField_3);
		JLabel lblNewLabel = new JLabel("Name");
		lblNewLabel.setBounds(21, 26, 125, 14);
		contentPane.add(lblNewLabel);
		JLabel lblNewLabel_1 = new JLabel("Password");
		lblNewLabel_1.setBounds(21, 58, 125, 14);
		contentPane.add(lblNewLabel_1);
		JLabel lblNewLabel_2 = new JLabel("IC");
		lblNewLabel_2.setBounds(21, 91, 125, 14);
		contentPane.add(lblNewLabel_2);
		JLabel lblNewLabel_3 = new JLabel("Phone number");
		lblNewLabel_3.setBounds(21, 126, 125, 14);
		contentPane.add(lblNewLabel_3);
		JPanel panel = new JPanel();
		panel.setBorder(new LineBorder(new Color(0, 0, 0), 2, true));
		panel.setBounds(449, 32, 137, 45);
		contentPane.add(panel);
		panel.setLayout(null);
		JButton btnNewButton = new JButton("Add ");
		btnNewButton.setBounds(29, 11, 80, 23);
		panel.add(btnNewButton);
		btnNewButton.setToolTipText("");
		JLabel lblNewLabel_4 = new JLabel("Email");
		lblNewLabel_4.setBounds(21, 153, 125, 14);
		contentPane.add(lblNewLabel_4);
		JLabel lblNewLabel_4_1 = new JLabel("Gender");
		lblNewLabel_4_1.setBounds(21, 184, 125, 14);
		contentPane.add(lblNewLabel_4_1);
		JLabel lblNewLabel_4_2 = new JLabel("Home address");
		lblNewLabel_4_2.setBounds(21, 215, 125, 14);
		contentPane.add(lblNewLabel_4_2);
		JPanel panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		panel_1.setBounds(409, 93, 238, 74);
		contentPane.add(panel_1);
		comboBox_1 = new JComboBox<String>();
		comboBox_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				current = head;
				while ((current.getLink() != null) && (current.getInfo().getAgentIC() != comboBox_1.getSelectedItem())) {
					current = current.getLink();
				}
				textField.setText(current.getInfo().getAgentName());
				textField_1.setText(current.getInfo().getAgentPassword());
				;
				textField_2.setText(current.getInfo().getAgentIC());
				textField_3.setText(current.getInfo().getAgentPhoneNum());
				textField_4.setText(current.getInfo().getAgentEmail());
				char gender = current.getInfo().getAgentGender();
				String genders = String.valueOf(gender);
				textField_5.setText(genders);
				textField_6.setText(current.getInfo().getAgentHomeAddr());
			}
		});
		comboBox_1.setBounds(10, 11, 215, 22);
		panel_1.add(comboBox_1);
		JButton btnUpdate = new JButton("Update");
		btnUpdate.setIcon(null);
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String name = textField.getText();
					String password = textField_1.getText();
					String ic = textField_2.getText();
					String phoneNum = textField_3.getText();
					String email = textField_4.getText();
					String gender = textField_5.getText();
					char genders = gender.charAt(0);
					String homeAddress = textField_6.getText();

					// Get the currently selected IC from the combo box
					String selectedIC = comboBox_1.getSelectedItem().toString();

					if (!ic.matches("\\d+")) {
						JOptionPane.showMessageDialog(null, "IC should only contain numeric data");
						return;
					}

					if ((ic.length() < 12) || (ic.length() > 12)) {
						JOptionPane.showMessageDialog(null, "12 digits for IC number");
						return;
					}

					if (name.matches("\\d+")) {
						JOptionPane.showMessageDialog(null, "Name should not only contain numeric data");
						return;
					}

					if (!phoneNum.matches("\\d+")) {
						JOptionPane.showMessageDialog(null, "Phone Number should only contain numeric data");
						return;
					}

					if (phoneNum.length() < 10) {
						JOptionPane.showMessageDialog(null, "Minimum 10 digits for phone number");
						return;
					}

					if ((((!email.contains("@gmail")) && (!email.contains("@hotmail")) && (!email.contains("@yahoo")))
							|| (!email.contains(".co")))) {
						JOptionPane.showMessageDialog(null, "Invalid email address format");
						return;
					}

					if ((name.equals("")) || (password.equals("")) || (ic.equals("")) || (phoneNum.equals(""))
							|| (email.equals("")) || (gender.equals("")) || (homeAddress.equals(""))) {
						JOptionPane.showMessageDialog(null, "Cannot leave blank");
						return;
					}

					if ((genders != 'm') && (genders != 'M') && (genders != 'F') && (genders != 'f')) {
						JOptionPane.showMessageDialog(null, "Input only F or M for genders");
						return;
					}

					// Check for repetitive IC, email, and phone number excluding the current item being updated
					current = head;
					List<String> repetitiveItems = new ArrayList<>();

					while (current != null) {
						if (!current.getInfo().getAgentIC().equals(selectedIC)) {
							if (current.getInfo().getAgentIC().equals(ic)) {
								repetitiveItems.add("IC");
							}

							if (current.getInfo().getAgentEmail().equals(email)) {
								repetitiveItems.add("Email");
							}

							if (current.getInfo().getAgentPhoneNum().equals(phoneNum)) {
								repetitiveItems.add("Phone Number");
							}
						}
						current = current.getLink();
					}

					if (!repetitiveItems.isEmpty()) {
						StringBuilder errorMessage = new StringBuilder("Repetitive item(s):");
						for (String item : repetitiveItems) {
							errorMessage.append("\n- ").append(item);
						}
						JOptionPane.showMessageDialog(null, errorMessage.toString());
						return;
					}

					// Update the selected item
					current = head;
					while (current != null && !current.getInfo().getAgentIC().equals(selectedIC)) {
						current = current.getLink();
					}

					if (current != null) {
						current.getInfo().setAgentName(name);
						current.getInfo().setAgentIC(ic);
						current.getInfo().setAgentPassword(password);
						current.getInfo().setAgentEmail(email);
						current.getInfo().setAgentHomeAddr(homeAddress);
						current.getInfo().setAgentPhoneNum(phoneNum);
						current.getInfo().setAgentGender(genders);
						JOptionPane.showMessageDialog(null, "Update successful!");

						// Refresh the table and combo box
						DefaultTableModel model = (DefaultTableModel) table.getModel();
						clearTableData(model);
						current = head;
						while (current != null) {
							char y = current.getInfo().getAgentGender();
							String x = String.valueOf(y);
							String[] data = { current.getInfo().getAgentName(), current.getInfo().getAgentPassword(),
									current.getInfo().getAgentIC(), current.getInfo().getAgentPhoneNum(),
									current.getInfo().getAgentEmail(), x, current.getInfo().getAgentHomeAddr() };
							model.addRow(data);
							current = current.getLink();
						}
						comboBox_1.removeAllItems();
						current = head;
						while (current != null) {
							comboBox_1.addItem(current.getInfo().getAgentIC());
							current = current.getLink();
						}
					} else {
						JOptionPane.showMessageDialog(null, "Selected item not found!");
					}
				} catch (StringIndexOutOfBoundsException p) {
					JOptionPane.showMessageDialog(null, "The head is null");
				}
			}
		});


		btnUpdate.setToolTipText("");
		btnUpdate.setBounds(30, 41, 80, 23);
		panel_1.add(btnUpdate);
		JButton btnNewButton_1 = new JButton("Delete");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					current = head;
					if (current.getInfo().getAgentIC() == comboBox_1.getSelectedItem()) {
						head = head.getLink();
					} else {
						current = head;
						while (current.getInfo().getAgentIC() != comboBox_1.getSelectedItem()) {
							before = current;
							current = current.getLink();
						}
						before.setLink(current.getLink());
					}
					JOptionPane.showMessageDialog(null, "Delete successful!");
					current = head;
					DefaultTableModel model = (DefaultTableModel) table.getModel();
					clearTableData(model);
					while ((current != null)) {
						char y = current.getInfo().getAgentGender();
						String x = String.valueOf(y);
						String[] data = { current.getInfo().getAgentName(), current.getInfo().getAgentPassword(),
								current.getInfo().getAgentIC(), current.getInfo().getAgentPhoneNum(),
								current.getInfo().getAgentEmail(), x, current.getInfo().getAgentHomeAddr() };
						model.addRow(data);
						current = current.getLink();
					}
					comboBox_1.removeAllItems();
					current = head;
					while (current != null) {
						comboBox_1.addItem(current.getInfo().getAgentIC());
						current = current.getLink();
					}
				} catch (NullPointerException r) {
					
				}
			}
		});

		btnNewButton_1.setBounds(120, 41, 89, 23);
		panel_1.add(btnNewButton_1);
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(176, 150, 162, 20);
		contentPane.add(textField_4);
		textField_5 = new JTextField();
		textField_5.setColumns(10);
		textField_5.setBounds(176, 181, 162, 20);
		contentPane.add(textField_5);
		textField_6 = new JTextField();
		textField_6.setColumns(10);
		textField_6.setBounds(176, 212, 162, 20);
		contentPane.add(textField_6);
		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 0), 3), "Search", TitledBorder.LEADING,
				TitledBorder.TOP, null, null));
		panel_2.setBounds(449, 178, 172, 45);
		contentPane.add(panel_2);
		panel_2.setLayout(null);
		textField_7 = new JTextField();
		textField_7.addKeyListener(new KeyAdapter() {
			@Override
			
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_ENTER) {
					current = head;
					String texter = textField_7.getText();
					try {
						while (!current.getInfo().getAgentIC().equals(texter)) {
							current = current.getLink();
						}
						JOptionPane.showMessageDialog(null, "Target found");
						JOptionPane.showMessageDialog(null,
								"The name is " + current.getInfo().getAgentName() + "\n" + "The password is "
										+ current.getInfo().getAgentIC() + "\n" + "The IC is " + current.getInfo().getAgentIC()
										+ "\n" + "The Phone Number is " + current.getInfo().getAgentPhoneNum() + "\n"
										+ "The Email is " + current.getInfo().getAgentEmail() + "\n" + "The Gender is "
										+ current.getInfo().getAgentGender() + "\n" + "The Home Address is "
										+ current.getInfo().getAgentHomeAddr(),"Insurance agent details",JOptionPane.PLAIN_MESSAGE);
					} catch (NullPointerException f) {
						JOptionPane.showMessageDialog(null, "Target Not FOUND!");
						textField_7.setText("");
						textField.setText("");
						textField_1.setText("");
						textField_2.setText("");
						textField_3.setText("");
						textField_4.setText("");
						textField_5.setText("");
						textField_6.setText("");
					}
				}
			}
		});
		textField_7.setBounds(10, 14, 152, 20);
		panel_2.add(textField_7);
		textField_7.setColumns(10);

		scrollPane = new JScrollPane();
		scrollPane.setBounds(21, 268, 694, 136);
		//contentPane.add(scrollPane);

		table = new JTable();
		scrollPane.setViewportView(table);
		table.setBorder(null);
		table.setModel(new DefaultTableModel(new Object[][] {},
				new String[] { "Name", "Password", "IC", "Phone Number", "Email", "Gender", "Home Address" }) {
			private static final long serialVersionUID = 1L;
			boolean[] columnEditables = new boolean[] { false, false, false, false, false, false, false };

			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		table.getColumnModel().getColumn(0).setResizable(false);
		table.getColumnModel().getColumn(1).setResizable(false);
		table.getColumnModel().getColumn(2).setResizable(false);
		table.getColumnModel().getColumn(3).setResizable(false);
		table.getColumnModel().getColumn(4).setResizable(false);
		table.getColumnModel().getColumn(5).setResizable(false);
		table.getColumnModel().getColumn(6).setResizable(false);
		DefaultTableCellRenderer firstRowRenderer = new DefaultTableCellRenderer();
		firstRowRenderer.setBackground(Color.YELLOW);
		firstRowRenderer.setForeground(Color.BLUE);
		firstRowRenderer.setFont(table.getFont().deriveFont(Font.BOLD));
		for (int i = 0; i < table.getColumnCount(); i++) {
			table.getColumnModel().getColumn(i).setCellRenderer(firstRowRenderer);
		}
		JTableHeader header = table.getTableHeader();
		header.setDefaultRenderer(firstRowRenderer);
		table.setShowGrid(true);
		table.setGridColor(Color.BLACK);

		JButton btnNewButton_2 = new JButton("Return");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				menu x = new menu();
				dispose();
				x.setVisible(true);
			}
		});
		btnNewButton_2.setBounds(532, 234, 89, 23);
		contentPane.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("View");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				viewFrame_agent x = new viewFrame_agent();
				dispose();
				x.setVisible(true);
				
			}
		});
		btnNewButton_3.setBounds(433, 234, 89, 23);
		contentPane.add(btnNewButton_3);
		header.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 0, Color.BLACK));
		table.getTableHeader().setReorderingAllowed(false);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String name = textField.getText();
					String password = textField_1.getText();
					String ic = textField_2.getText();
					String phoneNum = textField_3.getText();
					String email = textField_4.getText();
					String gender = textField_5.getText();
					char genders = gender.charAt(0);
					String homeAddress = textField_6.getText();
					insuranceAgent a = new insuranceAgent(name, password, ic, phoneNum, email, genders, homeAddress);
					NodeInsAgent newNode = new NodeInsAgent(a);
					if (!ic.matches("\\d+")) {
						JOptionPane.showMessageDialog(null, "IC should only contains numeric data");
						return;
					}
					if ((ic.length() < 12) || (ic.length() > 12)) {
						JOptionPane.showMessageDialog(null, " 12 digits for IC number");
						return;
					}
					if (name.matches("\\d+")) {
						JOptionPane.showMessageDialog(null, "Name should not only contains numeric data");
						return;
					}
					if (!phoneNum.matches("\\d+")) {
						JOptionPane.showMessageDialog(null, "Phone Number should only contains numeric data");
						return;
					}
					if (phoneNum.length() < 10) {
						JOptionPane.showMessageDialog(null, "Minimum 10 digits for phone number");
						return;
					}
					if ((((!email.contains("@gmail")) && (!email.contains("@hotmail")) && (!email.contains("@yahoo")))
							|| (!email.contains(".co")))) {
						JOptionPane.showMessageDialog(null, "Invalid email address format");
						return;
					}
					if ((name.equals("")) || (password.equals("")) || (ic.equals("")) || (phoneNum.equals(""))
							|| (email.equals("")) || (gender.equals("")) || (homeAddress.equals(""))) {
						JOptionPane.showMessageDialog(null, "Cannot leave blank");
						return;
					}
					if ((genders != 'm') && (genders != 'M') && (genders != 'F') && (genders != 'f')) {
						JOptionPane.showMessageDialog(null, "Input only F or M for genders");
						return;
					}
					if (head != null) {// Checking for IC repetition
						current = head;		
						while ((!current.getInfo().getAgentIC().equals(ic)) && (current.getLink() != null)) {
							current = current.getLink();
						}
						if (current.getInfo().getAgentIC().equals(ic)) {
							JOptionPane.showMessageDialog(null, "IC Repetitive");
							return;
						}
					}
					if (head != null) {// Checking for email repetition
						current = head;
						while ((!current.getInfo().getAgentEmail().equals(email)) && (current.getLink() != null)) {
							current = current.getLink();
						}
						if (current.getInfo().getAgentEmail().equals(email)) {
							JOptionPane.showMessageDialog(null, "Email Repetitive");
							return;
						}
					}
					if (head != null) {// Checking for phoneNumber repetition
						current = head;
						while ((!current.getInfo().getAgentPhoneNum().equals(phoneNum)) && (current.getLink() != null)) {
							current = current.getLink();
						}
						if (current.getInfo().getAgentPhoneNum().equals(phoneNum)) {
							JOptionPane.showMessageDialog(null, "Phone Number Repetitive");
							return;
						}
					}
					if (head == null) {
						head = newNode;
						count++;
						JOptionPane.showMessageDialog(null, "Add successful");
						comboBox_1.addItem(newNode.getInfo().getAgentIC());

					} else {
						current = head;
						while (current.getLink() != null) {
							current = current.getLink();
						}
						current.setLink(newNode);
						JOptionPane.showMessageDialog(null, "Add successful");
						count++;
						comboBox_1.addItem(newNode.getInfo().getAgentIC());
					}
					current = head;
					String[] data = { name, password, ic, phoneNum, email, gender, homeAddress};
					DefaultTableModel model = (DefaultTableModel) table.getModel();
					while (current != null) {
						current = current.getLink();
					}
					model.addRow(data);
				} catch (Exception d) {
					JOptionPane.showMessageDialog(null, "Fill in all the textfield");
				}
				textField.setText("");
				textField_1.setText("");
				textField_2.setText("");
				textField_3.setText("");
				textField_4.setText("");
				textField_5.setText("");
				textField_6.setText("");
				textField.grabFocus();

			}
		});

	}

	private static void clearTableData(DefaultTableModel model) {
		int rowCount = model.getRowCount();
		for (int i = rowCount - 1; i >= 0; i--) {
			model.removeRow(i);
		}
	}
}