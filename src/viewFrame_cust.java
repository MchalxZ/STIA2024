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

public class viewFrame_cust extends JFrame {

	private JPanel contentPane;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					viewFrame_cust frame = new viewFrame_cust();
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
	public viewFrame_cust() {
		
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		customerGUI.scrollPane = new JScrollPane();
		customerGUI.scrollPane.setBounds(21, 50, 1050, 360);
		getRootPane().setBorder(BorderFactory.createLineBorder(Color.BLUE,8));

		customerGUI.table = new JTable();
		customerGUI.scrollPane.setViewportView(customerGUI.table);
		customerGUI.table.setBorder(null);
		customerGUI.table.setModel(new DefaultTableModel(new Object[][] {},
				new String[] { "Name", "Password", "IC", "Phone Number", "Email", "Gender", "Home Address" }) {
			private static final long serialVersionUID = 1L;
			boolean[] columnEditables = new boolean[] { false, false, false, false, false, false, false };

			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1100, 490);
		
		customerGUI.current = customerGUI.head;
		DefaultTableModel model = (DefaultTableModel) customerGUI.table.getModel();
		clearTableData(model);
		while ((customerGUI.current != null)) {
			char y = customerGUI.current.getInfo().getGender();
			String x = String.valueOf(y);
			String[] data = { customerGUI.current.getInfo().getName(), customerGUI.current.getInfo().getPassword(),
					customerGUI.current.getInfo().getIC(), customerGUI.current.getInfo().getPhoneNum(),
					customerGUI.current.getInfo().getEmail(), x, customerGUI.current.getInfo().getHomeAddr() };
			model.addRow(data);
			customerGUI.current = customerGUI.current.getLink();
		}
		
		customerGUI.table.getColumnModel().getColumn(0).setResizable(false);
		customerGUI.table.getColumnModel().getColumn(1).setResizable(false);
		customerGUI.table.getColumnModel().getColumn(2).setResizable(false);
		customerGUI.table.getColumnModel().getColumn(3).setResizable(false);
		customerGUI.table.getColumnModel().getColumn(4).setResizable(false);
		customerGUI.table.getColumnModel().getColumn(5).setResizable(false);
		customerGUI.table.getColumnModel().getColumn(6).setResizable(false);
		DefaultTableCellRenderer firstRowRenderer = new DefaultTableCellRenderer();
		firstRowRenderer.setBackground(Color.YELLOW);
		firstRowRenderer.setForeground(Color.BLUE);
		firstRowRenderer.setFont(customerGUI.table.getFont().deriveFont(Font.BOLD));
		for (int i = 0; i < customerGUI.table.getColumnCount(); i++) {
			customerGUI.table.getColumnModel().getColumn(i).setCellRenderer(firstRowRenderer);
		}
		JTableHeader header = customerGUI.table.getTableHeader();
		header.setDefaultRenderer(firstRowRenderer);
		customerGUI.table.setShowGrid(true);
		customerGUI.table.setGridColor(Color.BLACK);
		contentPane.add(customerGUI.scrollPane);
		setContentPane(contentPane);
		contentPane.setLayout(null);
		header.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 0, Color.BLACK));
		
		JButton btnNewButton = new JButton("Back");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				customerGUI x = new customerGUI();
				dispose();
				x.setVisible(true);
				
			}
		});
		btnNewButton.setBounds(486, 429, 89, 23);
		contentPane.add(btnNewButton);
		customerGUI.scrollPane.setBorder(BorderFactory.createLineBorder(Color.BLACK,2));
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
