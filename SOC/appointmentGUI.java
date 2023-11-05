package SOC;


import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.Random;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SpinnerListModel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;



public class appointmentGUI extends JFrame {
	public static NodeAppt head;
	public static NodeAppt current;
	public static NodeAppt before;
	private JPanel contentPane;
	static JSpinner spinner_1;
	private JTextField textField;
	private JTextField txtDdmmyyyy;
	static String dateFormatPattern = "dd/MM/yyyy";
	static SimpleDateFormat dateFormat = new SimpleDateFormat(dateFormatPattern);
	public static JTextField textField_3;
	public static JTable table;
	static int count;
	public static int apptID;
	static JComboBox<String> comboBox;
	private static JComboBox<String> comboBox_1;
	public static JScrollPane scrollPane;
	private JComboBox<String> comboBox_1_1;
	public static ArrayList<Integer> numbers = new ArrayList<>();
	public static JSpinner spinner;
	static JSpinner spinner_2;
	static JSpinner spinner_1_1;
	private JTextField textField_1;

	/**
	 * Launch the application.
	 */

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					appointmentGUI frame = new appointmentGUI();
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
	public appointmentGUI() {
		dateFormat.setLenient(false);

		addWindowListener(new WindowAdapter() {
			@Override
			public void windowOpened(WindowEvent e) {
				DefaultTableModel model = (DefaultTableModel) table.getModel();
				current = head;

				while (current != null) {
					String[] data = { current.getInfo().getApptID(), current.getInfo().getApptName(),
							current.getInfo().getApptDate(), current.getInfo().getApptTime(),
							(String) current.getInfo().getCustomer(), (String) current.getInfo().getAgent() };
					model.addRow(data);
					current = current.getLink();
				}
				comboBox.removeAllItems();
				current = head;
				while (current != null) {
					comboBox.addItem(current.getInfo().getApptID());
					current = current.getLink();
				}
			}
		});
		Random rand = new Random();
		textField_3 = new JTextField();
		textField_3.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				apptID = rand.nextInt(899999) + 100000;

				if (!numbers.contains(apptID)) {
					String Ga = String.valueOf(apptID);
					textField_3.setText(Ga);

				} else {
					while (numbers.contains(apptID)) {
						apptID = rand.nextInt(2) + 1;

					}
					String Ga = String.valueOf(apptID);
					textField_3.setText(Ga);

				}

			}

			@Override
			public void focusLost(FocusEvent e) {
				apptID = rand.nextInt(899999) + 100000;

				if (!numbers.contains(apptID)) {
					String Ga = String.valueOf(apptID);
					textField_3.setText(Ga);

				} else {
					while (numbers.contains(apptID)) {
						apptID = rand.nextInt(2) + 1;

					}
					String Ga = String.valueOf(apptID);
					textField_3.setText(Ga);

				}

			}
		});

		apptID = rand.nextInt(899999) + 100000;

		if (!numbers.contains(apptID)) {
			String Ga = String.valueOf(apptID);
			textField_3.setText(Ga);

		} else {
			while (numbers.contains(apptID)) {
				apptID = rand.nextInt(2) + 1;

			}
			String Ga = String.valueOf(apptID);
			textField_3.setText(Ga);

		}

		setResizable(false);
		setTitle("Appointment");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 734, 281);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 255, 0));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JButton btnNewButton = new JButton("Add");

		btnNewButton.setBounds(568, 11, 89, 23);
		contentPane.add(btnNewButton);

		JPanel panel = new JPanel();
		panel.setBorder(null);
		panel.setBackground(new Color(0, 255, 0));
		panel.setBounds(27, 11, 482, 222);
		contentPane.add(panel);
		panel.setLayout(null);

		JLabel lblNewLabel = new JLabel("Appointment Name");
		lblNewLabel.setBounds(31, 50, 152, 14);
		panel.add(lblNewLabel);

		textField = new JTextField();
		textField.setBounds(211, 43, 204, 20);
		panel.add(textField);
		textField.setColumns(10);

		txtDdmmyyyy = new JTextField();
		txtDdmmyyyy.setBounds(211, 77, 204, 20);
		panel.add(txtDdmmyyyy);
		txtDdmmyyyy.setColumns(10);

		JLabel lblNewLabel_1 = new JLabel("Appointment Date");
		lblNewLabel_1.setBounds(31, 84, 152, 14);
		panel.add(lblNewLabel_1);

		JLabel lblNewLabel_2 = new JLabel("Appointment Time");
		lblNewLabel_2.setBounds(31, 121, 105, 14);
		panel.add(lblNewLabel_2);

		textField_3.setEditable(false);
		textField_3.setBounds(211, 7, 204, 20);
		panel.add(textField_3);
		textField_3.setColumns(10);

		JLabel lblNewLabel_2_1 = new JLabel("Appointment ID");
		lblNewLabel_2_1.setBounds(31, 14, 152, 14);
		panel.add(lblNewLabel_2_1);

		JLabel lblNewLabel_2_2 = new JLabel("Customer");
		lblNewLabel_2_2.setBounds(31, 155, 152, 14);
		panel.add(lblNewLabel_2_2);

		JLabel lblNewLabel_2_3 = new JLabel("Insurance Agent");
		lblNewLabel_2_3.setBounds(31, 189, 152, 14);
		panel.add(lblNewLabel_2_3);

		comboBox_1 = new JComboBox();
		comboBox_1.setBounds(211, 147, 204, 22);
		panel.add(comboBox_1);

		comboBox_1_1 = new JComboBox();
		comboBox_1_1.setBounds(211, 181, 204, 22);
		panel.add(comboBox_1_1);

		JComboBox comboBox_2 = new JComboBox();
		comboBox_2.setModel(new DefaultComboBoxModel(new String[] { "AM", "PM" }));
		comboBox_2.setBounds(235, 114, 54, 22);
		panel.add(comboBox_2);

		JComboBox comboBox_2_1 = new JComboBox();
		comboBox_2_1.setModel(new DefaultComboBoxModel(new String[] { "AM", "PM" }));
		comboBox_2_1.setBounds(410, 114, 57, 22);
		panel.add(comboBox_2_1);

		spinner = new JSpinner();
		spinner.setModel(new SpinnerListModel(
				new String[] { "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12" }));
		spinner.setBounds(141, 115, 40, 20);
		panel.add(spinner);

		spinner_1 = new JSpinner();
		spinner_1.setModel(new SpinnerListModel(
				new String[] { "00", "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13", "14",
						"15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30",
						"31", "32", "33", "34", "35", "36", "37", "38", "39", "40", "41", "42", "43", "44", "45", "46",
						"47", "48", "49", "50", "51", "52", "53", "54", "55", "56", "57", "58", "59" }));
		spinner_1.setBounds(189, 115, 40, 20);
		panel.add(spinner_1);

		spinner_2 = new JSpinner();
		spinner_2.setModel(new SpinnerListModel(
				new String[] { "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12" }));
		spinner_2.setBounds(315, 115, 40, 20);
		panel.add(spinner_2);

		spinner_1_1 = new JSpinner();
		spinner_1_1.setModel(new SpinnerListModel(
				new String[] { "00", "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13", "14",
						"15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30",
						"31", "32", "33", "34", "35", "36", "37", "38", "39", "40", "41", "42", "43", "44", "45", "46",
						"47", "48", "49", "50", "51", "52", "53", "54", "55", "56", "57", "58", "59" }));
		spinner_1_1.setBounds(365, 115, 40, 20);
		panel.add(spinner_1_1);

		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String n = textField.getText();
					String d = txtDdmmyyyy.getText();
					String a = (String) spinner.getValue();
					String p = (String) spinner_1.getValue();
					String r = (String) spinner_2.getValue();
					String f = (String) spinner_1_1.getValue();
					int startHour = Integer.parseInt(a);
					int startMinute = Integer.parseInt(p);
					LocalTime starttime = LocalTime.of(startHour, startMinute);
					int endHour = Integer.parseInt(r);
					int endMinute = Integer.parseInt(f);
					LocalTime endTime = LocalTime.of(endHour, endMinute);
					String ID = textField_3.getText();
					Date date = null;
					String das = "";
					if ((comboBox_2.getSelectedItem() == "AM") && (comboBox_2_1.getSelectedItem() == "PM")) {
						endTime = endTime.plusHours(12);
					} else if ((comboBox_2.getSelectedItem() == "PM") && (comboBox_2_1.getSelectedItem() == "AM")) {
						starttime = starttime.plusHours(12);
					} else if ((comboBox_2.getSelectedItem() == "AM") && (comboBox_2_1.getSelectedItem() == "AM")) {

					} else if ((comboBox_2.getSelectedItem() == "PM") && (comboBox_2_1.getSelectedItem() == "PM")) {
						starttime = starttime.plusHours(12);
						endTime = endTime.plusHours(12);
					}
					LocalTime difference = endTime.minusHours(starttime.getHour());
					difference = difference.minusMinutes(starttime.getMinute());
					try {
						date = dateFormat.parse(d);
						das = txtDdmmyyyy.getText();
						SimpleDateFormat yearFormat = new SimpleDateFormat("yyyy");
						SimpleDateFormat monthFormat = new SimpleDateFormat("MM");
						int year = Integer.parseInt(yearFormat.format(date));
						int month = Integer.parseInt(monthFormat.format(date));
						if (difference.getHour() < 1.0) {
							JOptionPane.showMessageDialog(null, "Appointment Time at least 1 hour");
							return;
						}
						if ((year < 2023) || (year > 2024)) {
							JOptionPane.showMessageDialog(null, "Booking allowed only 2023 and 2024");
							return;
						}
						if ((year == 2023) && (month < 7)) {
							JOptionPane.showMessageDialog(null, "Booking allowed only from July to December in 2023");
							return;
						}
					} catch (ParseException es) {
						JOptionPane.showMessageDialog(null, "Date format should be DD/MM/YYYY");
						return;
					}
					Object C = comboBox_1.getSelectedItem();
					Object A = comboBox_1_1.getSelectedItem();
					String x = String.valueOf(startHour);
					String y = String.valueOf(startMinute);
					String h = String.valueOf(endHour);
					String i = String.valueOf(endMinute);
					String v = (String) comboBox_2.getSelectedItem();
					String b = (String) comboBox_2_1.getSelectedItem();
					String at = "";
					String SfrontVal = "";
					String EfrontVal = "";
					String SendVal = "";
					String EendVal = "";

					if (x.length() == 1) {
						SfrontVal = "0";
					}
					if (h.length() == 1) {
						SendVal = "0";
					}
					if (y.length() == 1) {
						EfrontVal = "0";
					}
					if (i.length() == 1) {
						EendVal = "0";
					}

					at = SfrontVal + x + ":" + EfrontVal + y + v + " to " + SendVal + h + ":" + EendVal + i + b;
					Appointment pd = new Appointment(n, das, at, ID, starttime, endTime, C, A);
					NodeAppt newNode = new NodeAppt(pd);
					numbers.add(apptID);

					current = head;

					while (current != null) {
						try {
							if ((((current.getInfo().getApptST().isBefore(starttime))
									|| (current.getInfo().getApptST().equals(starttime)))
									&& (((current.getInfo().getApptET().isAfter(starttime))
											|| (current.getInfo().getApptET().equals(starttime)))))
									&& ((current.getInfo().getCustomer() == C) && (current.getInfo().getAgent() == A))
									&& (current.getInfo().getApptDate().equals(das))) {
								JOptionPane.showMessageDialog(null, "The selected session is not available");
								return;
							} else if ((((current.getInfo().getApptST().isBefore(endTime))
									|| (current.getInfo().getApptST().equals(endTime)))
									&& (((current.getInfo().getApptET().isAfter(endTime))
											|| (current.getInfo().getApptET().equals(endTime)))))
									&& ((current.getInfo().getCustomer() == C) && (current.getInfo().getAgent() == A))
									&& (current.getInfo().getApptDate().equals(das))) {
								JOptionPane.showMessageDialog(null, "The selected session is not available");
								return;
							}
						} catch (Exception js) {
							JOptionPane.showMessageDialog(null, "Customer is null");
							return;
						}
						boolean test1 = current.getInfo().getApptST().isBefore(starttime);
						boolean test9 = current.getInfo().getApptET().isAfter(starttime);
						current = current.getLink();
					}

					
					  if (A == null || C == null) {
						  JOptionPane.showMessageDialog(null,"Select customer or insurance agent"); 
						  return; 
					  }
					 

					if (head == null) {
						head = newNode;
						count++;
						JOptionPane.showMessageDialog(null, "Add successful");
						comboBox.addItem(newNode.getInfo().getApptID());

					} else {
						current = head;
						while (current.getLink() != null) {
							current = current.getLink();
						}
						current.setLink(newNode);
						JOptionPane.showMessageDialog(null, "Add successful");
						comboBox.addItem(newNode.getInfo().getApptID());
						count++;

					}

					current = head;
					String[] data = { ID, n, d, at, (String) C, (String) A };
					DefaultTableModel model = (DefaultTableModel) table.getModel();
					while (current != null) {
						current = current.getLink();
					}
					model.addRow(data);
				} catch (Exception d) {
					d.printStackTrace();
					JOptionPane.showMessageDialog(null, "Do not leave blank");
				}

				textField.setText("");
				txtDdmmyyyy.setText("");
				textField_3.setText("");
				textField.grabFocus();
				int counts = 0;

				if (!numbers.contains(apptID)) {
					String Ga = String.valueOf(apptID);
					textField_3.setText(Ga);
					counts++;
				} else {
					while (numbers.contains(apptID)) {
						apptID = rand.nextInt(899999) + 100000;

					}
					String Ga = String.valueOf(apptID);
					textField_3.setText(Ga);

					counts++;
				}

			}

		});
		JLabel lblNewLabel_3 = new JLabel(":");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_3.setBounds(357, 117, 46, 14);
		panel.add(lblNewLabel_3);

		JLabel lblNewLabel_3_1 = new JLabel(":");
		lblNewLabel_3_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_3_1.setBounds(182, 118, 46, 14);
		panel.add(lblNewLabel_3_1);

		JLabel lblNewLabel_4 = new JLabel("To");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_4.setBounds(295, 118, 46, 14);
		panel.add(lblNewLabel_4);
		comboBox = new JComboBox();
		comboBox.setBounds(555, 47, 127, 22);
		contentPane.add(comboBox);

		JButton btnUpdate = new JButton("Update");

		btnUpdate.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				String n = textField.getText();
				String d = txtDdmmyyyy.getText();
				String a = (String) spinner.getValue();
				String p = (String) spinner_1.getValue();
				String r = (String) spinner_2.getValue();
				String f = (String) spinner_1_1.getValue();
				int startHour = Integer.parseInt(a);
				int startMinute = Integer.parseInt(p);
				LocalTime starttime = LocalTime.of(startHour, startMinute);
				int endHour = Integer.parseInt(r);
				int endMinute = Integer.parseInt(f);
				LocalTime endTime = LocalTime.of(endHour, endMinute);
				String ID = textField_3.getText();
				Date date = null;
				String das = "";

				if ((comboBox_2.getSelectedItem() == "AM") && (comboBox_2_1.getSelectedItem() == "PM")) {
					endTime = endTime.plusHours(12);
				} else if ((comboBox_2.getSelectedItem() == "PM") && (comboBox_2_1.getSelectedItem() == "AM")) {
					starttime = starttime.plusHours(12);
				} else if ((comboBox_2.getSelectedItem() == "AM") && (comboBox_2_1.getSelectedItem() == "AM")) {

				} else if ((comboBox_2.getSelectedItem() == "PM") && (comboBox_2_1.getSelectedItem() == "PM")) {
					starttime = starttime.plusHours(12);
					endTime = endTime.plusHours(12);
				}
				LocalTime difference = endTime.minusHours(starttime.getHour());
				difference = difference.minusMinutes(starttime.getMinute());
				try {
					date = dateFormat.parse(d);
					das = txtDdmmyyyy.getText();
					SimpleDateFormat yearFormat = new SimpleDateFormat("yyyy");
					SimpleDateFormat monthFormat = new SimpleDateFormat("MM");
					int year = Integer.parseInt(yearFormat.format(date));
					int month = Integer.parseInt(monthFormat.format(date));
					if (difference.getHour() < 1.0) {
						JOptionPane.showMessageDialog(null, "Appointment Time at least 1 hour");
						return;
					}
					if ((year < 2023) || (year > 2024)) {
						JOptionPane.showMessageDialog(null, "Booking allowed only 2023 and 2024");
						return;
					}
					if ((year == 2023) && (month < 7)) {
						JOptionPane.showMessageDialog(null, "Booking allowed only from July to December in 2023");
						return;
					}
				} catch (ParseException es) {
					es.printStackTrace();
					JOptionPane.showMessageDialog(null, "Date format should be DD/MM/YYYY");
					return;
				}
				Object C = comboBox_1.getSelectedItem();
				Object A = comboBox_1_1.getSelectedItem();
				String x = String.valueOf(startHour);
				String y = String.valueOf(startMinute);
				String h = String.valueOf(endHour);
				String i = String.valueOf(endMinute);
				String v = (String) comboBox_2.getSelectedItem();
				String b = (String) comboBox_2_1.getSelectedItem();
				String at = "";
				String SfrontVal = "";
				String EfrontVal = "";
				String SendVal = "";
				String EendVal = "";

				if (x.length() == 1) {
					SfrontVal = "0";
				}
				if (h.length() == 1) {
					SendVal = "0";
				}
				if (y.length() == 1) {
					EfrontVal = "0";
				}
				if (i.length() == 1) {
					EendVal = "0";
				}

				at = SfrontVal + x + ":" + EfrontVal + y + v + " to " + SendVal + h + ":" + EendVal + i + b;
				Appointment pd = new Appointment(n, das, at, ID, starttime, endTime, C, A);
				NodeAppt newNode = new NodeAppt(pd);
				numbers.add(apptID);

				current = head;

				while (current != null) {
					try {
						if ((((current.getInfo().getApptST().isBefore(starttime))
								|| (current.getInfo().getApptST().equals(starttime)))
								&& (((current.getInfo().getApptET().isAfter(starttime))
										|| (current.getInfo().getApptET().equals(starttime)))))
								&& ((current.getInfo().getCustomer() == C) && (current.getInfo().getAgent() == A))
								&& (current.getInfo().getApptDate().equals(das))) {
							JOptionPane.showMessageDialog(null, "The selected session is not available");
							return;
						} else if ((((current.getInfo().getApptST().isBefore(endTime))
								|| (current.getInfo().getApptST().equals(endTime)))
								&& (((current.getInfo().getApptET().isAfter(endTime))
										|| (current.getInfo().getApptET().equals(endTime)))))
								&& ((current.getInfo().getCustomer() == C) && (current.getInfo().getAgent() == A))
								&& (current.getInfo().getApptDate().equals(das))) {
							JOptionPane.showMessageDialog(null, "The selected session is not available");
							return;
						}
					} catch (Exception js) {
						JOptionPane.showMessageDialog(null, "Customer is null");
						return;
					}
					boolean test1 = current.getInfo().getApptST().isBefore(starttime);
					boolean test9 = current.getInfo().getApptET().isAfter(starttime);
					current = current.getLink();
				}
				current = head;
				while ((current.getLink() != null) && (current.getInfo().getApptID() != comboBox.getSelectedItem())) {
					current = current.link;
				}
				current.getInfo().setApptID(ID);
				current.getInfo().setAgent(A);
				current.getInfo().setCustomer(C);
				current.getInfo().setApptDate(das);
				current.getInfo().setApptET(endTime);
				current.getInfo().setApptST(starttime);
				current.getInfo().setApptTime(at);
				current.getInfo().setApptName(n);
				JOptionPane.showMessageDialog(null, "Update successful!");
				current = head;
				DefaultTableModel model = (DefaultTableModel) table.getModel();
				clearTableData(model);
				while ((current != null)) {

					String[] data = { current.getInfo().getApptID(), current.getInfo().getApptName(),
							current.getInfo().getApptDate(), current.getInfo().getApptTime(),
							(String) current.getInfo().getCustomer(), (String) current.getInfo().getAgent() };
					model.addRow(data);
					current = current.getLink();
				}

				apptID = rand.nextInt(899999) + 100000;
				if (!numbers.contains(apptID)) {
					String Ga = String.valueOf(apptID);
					textField_3.setText(Ga);

				} else {
					while (numbers.contains(apptID)) {
						apptID = rand.nextInt(2) + 1;

					}
					String Ga = String.valueOf(apptID);
					textField_3.setText(Ga);

				}
				comboBox.removeAllItems();
				current = head;
				while (current != null) {
					comboBox.addItem(current.getInfo().getApptID());
					current = current.getLink();
				}
			}

		}

		);
		btnUpdate.setBounds(521, 81, 89, 23);
		contentPane.add(btnUpdate);

		JButton btnDelete = new JButton("Delete");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					current = head;
					if (current.getInfo().getApptID() == comboBox.getSelectedItem()) {
						head = head.getLink();
					} else {
						current = head;
						while (current.getInfo().getApptID() != comboBox.getSelectedItem()) {
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
						String[] data = { current.getInfo().getApptID(), current.getInfo().getApptName(),
								current.getInfo().getApptDate(), current.getInfo().getApptTime(),
								(String) current.getInfo().getCustomer(), (String) current.getInfo().getAgent() };
						model.addRow(data);
						current = current.getLink();
					}
					comboBox.removeAllItems();
					current = head;
					while (current != null) {
						comboBox.addItem(current.getInfo().getApptID());
						current = current.getLink();
					}
				} catch (NullPointerException r) {
					
				}

			}
		});
		btnDelete.setBounds(617, 81, 89, 23);
		contentPane.add(btnDelete);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(12, 293, 692, 190);
		//contentPane.add(scrollPane);

		table = new JTable();
		scrollPane.setViewportView(table);
		table.setBorder(null);
		table.setModel(new DefaultTableModel(new Object[][] {}, new String[] { "Appointment ID", "Appointment Name",
				"Appointment Date", "Appointment Time", "Customer", "Insurance Agent" }));
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
		JButton btnNewButton_1 = new JButton("Return");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				menu x = new menu();
				dispose();
				x.setVisible(true);
			}
		});
		btnNewButton_1.setBounds(568, 116, 89, 23);
		contentPane.add(btnNewButton_1);

		JButton btnNewButton_2 = new JButton("View");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				viewFrame_appt x = new viewFrame_appt();
				dispose();
				x.setVisible(true);
			}
		});
		btnNewButton_2.setBounds(559, 151, 110, 26);
		contentPane.add(btnNewButton_2);

		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 0), 3), "Search", TitledBorder.LEADING,
				TitledBorder.TOP, null, new Color(51, 51, 51)));
		panel_1.setBounds(532, 183, 161, 50);
		contentPane.add(panel_1);
		panel_1.setLayout(null);

		textField_1 = new JTextField();
		textField_1.setBounds(12, 17, 137, 21);
		panel_1.add(textField_1);
		textField_1.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyChar() == KeyEvent.VK_ENTER) {
					current = head;
					String texter = textField_1.getText();
					try {
						while (!current.getInfo().getApptID().equals(texter)) {
							current = current.getLink();
						}
						JOptionPane.showMessageDialog(null, "Target found");
						JOptionPane.showMessageDialog(null,
								"The appointment ID is " + current.getInfo().getApptID() + "\n"
										+ "The appointment name is " + current.getInfo().getApptName() + "\n"
										+ "The appointment date is " + current.getInfo().getApptDate() + "\n"
										+ "The appointment time is " + current.getInfo().getApptTime() + "\n"
										+ "The customer is " + current.getInfo().getCustomer() + "\n" + "The agent is "
										+ current.getInfo().getAgent(),"Appointment Details",JOptionPane.PLAIN_MESSAGE);
					} catch (NullPointerException f) {
						JOptionPane.showMessageDialog(null, "Target Not FOUND!");
						txtDdmmyyyy.setText("");
						textField.setText("");
						textField_1.setText("");
						textField_3.setText("");

					}
				}
			}

		});
		textField_1.setColumns(10);

		header.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 0, Color.BLACK));
		table.getTableHeader().setReorderingAllowed(false);
		comboBox_1.removeAllItems();
		customerGUI.current = customerGUI.head;
		while (customerGUI.current != null) {
			comboBox_1.addItem(customerGUI.current.getInfo().getIC());
			customerGUI.current = customerGUI.current.getLink();
		}
		comboBox_1_1.removeAllItems();
		InsuranceAgentGUI.current = InsuranceAgentGUI.head;
		while (InsuranceAgentGUI.current != null) {
			comboBox_1_1.addItem(InsuranceAgentGUI.current.getInfo().getAgentIC());
			InsuranceAgentGUI.current = InsuranceAgentGUI.current.getLink();
		}

		comboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				current = head;
				while ((current.getLink() != null) && (current.getInfo().getApptID() != comboBox.getSelectedItem())) {
					current = current.getLink();
				}
				textField.setText(current.getInfo().getApptName());
				txtDdmmyyyy.setText(current.getInfo().getApptDate());
				textField_3.setText(current.getInfo().getApptID());
				comboBox_1.setSelectedItem(current.getInfo().getCustomer());
				comboBox_1_1.setSelectedItem(current.getInfo().getAgent());
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