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

public class viewFrame_agent extends JFrame {

	private JPanel contentPane;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					viewFrame_agent frame = new viewFrame_agent();
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
	public viewFrame_agent() {
		
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		InsuranceAgentGUI.scrollPane = new JScrollPane();
		InsuranceAgentGUI.scrollPane.setBounds(21, 50, 1050, 360);
		getRootPane().setBorder(BorderFactory.createLineBorder(Color.BLUE,8));

		InsuranceAgentGUI.table = new JTable();
		InsuranceAgentGUI.scrollPane.setViewportView(InsuranceAgentGUI.table);
		InsuranceAgentGUI.table.setBorder(null);
		InsuranceAgentGUI.table.setModel(new DefaultTableModel(new Object[][] {},
				new String[] { "Name", "Password", "IC", "Phone Number", "Email", "Gender", "Home Address" }) {
			private static final long serialVersionUID = 1L;
			boolean[] columnEditables = new boolean[] { false, false, false, false, false, false, false };

			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1100, 490);
		
		InsuranceAgentGUI.current = InsuranceAgentGUI.head;
		DefaultTableModel model = (DefaultTableModel) InsuranceAgentGUI.table.getModel();
		clearTableData(model);
		while ((InsuranceAgentGUI.current != null)) {
			char y = InsuranceAgentGUI.current.getInfo().getAgentGender();
			String x = String.valueOf(y);
			String[] data = { InsuranceAgentGUI.current.getInfo().getAgentName(), InsuranceAgentGUI.current.getInfo().getAgentPassword(),
					InsuranceAgentGUI.current.getInfo().getAgentIC(), InsuranceAgentGUI.current.getInfo().getAgentPhoneNum(),
					InsuranceAgentGUI.current.getInfo().getAgentEmail(), x, InsuranceAgentGUI.current.getInfo().getAgentHomeAddr() };
			model.addRow(data);
			InsuranceAgentGUI.current = InsuranceAgentGUI.current.getLink();
		}
		
		InsuranceAgentGUI.table.getColumnModel().getColumn(0).setResizable(false);
		InsuranceAgentGUI.table.getColumnModel().getColumn(1).setResizable(false);
		InsuranceAgentGUI.table.getColumnModel().getColumn(2).setResizable(false);
		InsuranceAgentGUI.table.getColumnModel().getColumn(3).setResizable(false);
		InsuranceAgentGUI.table.getColumnModel().getColumn(4).setResizable(false);
		InsuranceAgentGUI.table.getColumnModel().getColumn(5).setResizable(false);
		InsuranceAgentGUI.table.getColumnModel().getColumn(6).setResizable(false);
		DefaultTableCellRenderer firstRowRenderer = new DefaultTableCellRenderer();
		firstRowRenderer.setBackground(Color.YELLOW);
		firstRowRenderer.setForeground(Color.BLUE);
		firstRowRenderer.setFont(InsuranceAgentGUI.table.getFont().deriveFont(Font.BOLD));
		for (int i = 0; i < InsuranceAgentGUI.table.getColumnCount(); i++) {
			InsuranceAgentGUI.table.getColumnModel().getColumn(i).setCellRenderer(firstRowRenderer);
		}
		JTableHeader header = InsuranceAgentGUI.table.getTableHeader();
		header.setDefaultRenderer(firstRowRenderer);
		InsuranceAgentGUI.table.setShowGrid(true);
		InsuranceAgentGUI.table.setGridColor(Color.BLACK);
		contentPane.add(InsuranceAgentGUI.scrollPane);
		setContentPane(contentPane);
		contentPane.setLayout(null);
		header.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 0, Color.BLACK));
		
		JButton btnNewButton = new JButton("Back");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				InsuranceAgentGUI x = new InsuranceAgentGUI();
				dispose();
				x.setVisible(true);
				
			}
		});
		btnNewButton.setBounds(486, 429, 89, 23);
		contentPane.add(btnNewButton);
		InsuranceAgentGUI.scrollPane.setBorder(BorderFactory.createLineBorder(Color.BLACK,2));
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
