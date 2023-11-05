package src;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;

public class viewFrame_appt extends JFrame {

	private JPanel contentPane;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					viewFrame_appt frame = new viewFrame_appt();
					frame.getRootPane().setBorder(BorderFactory.createLineBorder(Color.BLUE, 8));
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
	public viewFrame_appt() {
		
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		appointmentGUI.scrollPane = new JScrollPane();
		appointmentGUI.scrollPane.setBounds(21, 50, 1050, 360);
		getRootPane().setBorder(BorderFactory.createLineBorder(Color.BLUE,8));

		appointmentGUI.table = new JTable();
		appointmentGUI.scrollPane.setViewportView(appointmentGUI.table);
		appointmentGUI.table.setBorder(null);
		appointmentGUI.table.setModel(new DefaultTableModel(new Object[][] {}, new String[] { "Appointment ID", "Appointment Name",
				"Appointment Date", "Appointment Time", "Customer", "Insurance Agent" }) {
			private static final long serialVersionUID = 1L;
			boolean[] columnEditables = new boolean[] { false, false, false, false, false, false };

			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1100, 490);
		
		appointmentGUI.current = appointmentGUI.head;
		DefaultTableModel model = (DefaultTableModel) appointmentGUI.table.getModel();
		clearTableData(model);
		while ((appointmentGUI.current != null)) {
			String[] data = { appointmentGUI.current.getInfo().getApptID(), appointmentGUI.current.getInfo().getApptName(),
					appointmentGUI.current.getInfo().getApptDate(), appointmentGUI.current.getInfo().getApptTime(),
					(String) appointmentGUI.current.getInfo().getCustomer(), (String) appointmentGUI.current.getInfo().getAgent() };
			model.addRow(data);
			appointmentGUI.current = appointmentGUI.current.getLink();
		}
		
		appointmentGUI.table.getColumnModel().getColumn(0).setResizable(false);
		appointmentGUI.table.getColumnModel().getColumn(1).setResizable(false);
		appointmentGUI.table.getColumnModel().getColumn(2).setResizable(false);
		appointmentGUI.table.getColumnModel().getColumn(3).setResizable(false);
		appointmentGUI.table.getColumnModel().getColumn(4).setResizable(false);
		appointmentGUI.table.getColumnModel().getColumn(5).setResizable(false);
		DefaultTableCellRenderer firstRowRenderer = new DefaultTableCellRenderer();
		firstRowRenderer.setBackground(Color.YELLOW);
		firstRowRenderer.setForeground(Color.BLUE);
		firstRowRenderer.setFont(appointmentGUI.table.getFont().deriveFont(Font.BOLD));
		for (int i = 0; i < appointmentGUI.table.getColumnCount(); i++) {
			appointmentGUI.table.getColumnModel().getColumn(i).setCellRenderer(firstRowRenderer);
		}
		JTableHeader header = appointmentGUI.table.getTableHeader();
		header.setDefaultRenderer(firstRowRenderer);
		appointmentGUI.table.setShowGrid(true);
		appointmentGUI.table.setGridColor(Color.BLACK);
		contentPane.add(appointmentGUI.scrollPane);
		setContentPane(contentPane);
		contentPane.setLayout(null);
		header.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 0, Color.BLACK));
		
		JButton btnNewButton = new JButton("Back");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				appointmentGUI x = new appointmentGUI();
				dispose();
				x.setVisible(true);
				
			}
		});
		btnNewButton.setBounds(486, 429, 89, 23);
		contentPane.add(btnNewButton);
		appointmentGUI.scrollPane.setBorder(BorderFactory.createLineBorder(Color.BLACK,2));
		JLabel lblNewLabel = new JLabel("LIST VIEW");
		lblNewLabel.setFont(new Font("Verdana", Font.BOLD | Font.ITALIC, 20));
		lblNewLabel.setBounds(500, 16, 163, 23);
		contentPane.add(lblNewLabel);
		this.setUndecorated(true);
		
	}
	private static void clearTableData(DefaultTableModel model) {
		int rowCount = model.getRowCount();
		for (int i = rowCount - 1; i >= 0; i--) {
			model.removeRow(i);
		}
	}
}
