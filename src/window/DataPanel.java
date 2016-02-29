package window;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTable;
import javax.swing.table.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import javax.swing.JList;
import javax.swing.AbstractListModel;
import code.*;
import java.sql.*;
import java.awt.Font;

public class DataPanel extends JDialog {
	static Logger logger = LoggerFactory.getLogger(DataPanel.class);
	private final JPanel contentPanel = new JPanel();
	private JTable table;
	private AccessDatabase acsdb;
	private ResultSet result;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			DataPanel dialog = new DataPanel();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	void clearTM(TableModel tm) {
		for (int i = 0; i < tm.getRowCount(); i++) {
			tm.setValueAt(null, i, 0);
			tm.setValueAt(null, i, 1);
		}
	}

	void selectAll() {
		int row = 0;
		try {
			result = AccessDatabase.selectAll();
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		TableModel tm = table.getModel();
		clearTM(tm);
		try {
			result.first();
			do {
				tm.setValueAt(result.getInt("id"), row, 0);
				tm.setValueAt(result.getString("name"), row, 1);
				row++;
			} while (result.next());
		} catch (SQLException e) {
			e.printStackTrace();
		}
		table.setModel(tm);
	}

	/**
	 * Create the dialog.
	 * @throws ClassNotFoundException 
	 */
	public DataPanel() throws ClassNotFoundException {
		setTitle("数据库面板");
		setBounds(100, 100, 802, 537);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		{
			table = new JTable();
			table.setFont(new Font("宋体", Font.PLAIN, 20));

			table.setCellSelectionEnabled(true);
			table.setColumnSelectionAllowed(true);
			table.setModel(new DefaultTableModel(new Object[][] { { null, null }, { null, null }, { null, null },
					{ null, null }, { null, null }, { null, null }, { null, null }, { null, null }, { null, null },
					{ null, null }, { null, null }, { null, null }, { null, null }, { null, null }, { null, null },
					{ null, null }, }, new String[] { "ID", "name" }) {
				Class[] columnTypes = new Class[] { Integer.class, String.class };

				public Class getColumnClass(int columnIndex) {
					return columnTypes[columnIndex];
				}
			});
			table.getColumnModel().getColumn(0).setPreferredWidth(160);
			table.getColumnModel().getColumn(0).setMinWidth(10);
			table.getColumnModel().getColumn(1).setPreferredWidth(160);
			contentPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
			contentPanel.add(table);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				if(AccessDatabase.isContect()){
					logger.debug("contected!");
				}else{
					logger.debug("can not contect to data model\nprogram is stoped");
					return;
				}
				selectAll();// show data when the dialog be open
				
				table.setRowHeight(25);
				
				JButton okButton = new JButton("OK");
				okButton.setFont(new Font("宋体", Font.PLAIN, 20));
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {

					}
				});
				{
					JButton btnConnectDb = new JButton("select all");
					btnConnectDb.setFont(new Font("宋体", Font.PLAIN, 20));
					buttonPane.add(btnConnectDb);
					btnConnectDb.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent arg0) {
							selectAll();
						}
					});
				}
				{
					JButton btnInsert = new JButton("insert");
					btnInsert.setFont(new Font("宋体", Font.PLAIN, 20));
					btnInsert.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent arg0) {
							InsertData insertDialog = new InsertData();
							insertDialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
							insertDialog.setVisible(true);
						}
					});
					buttonPane.add(btnInsert);
				}
				{
					JButton btnDeleteSelect = new JButton("Delete select");
					btnDeleteSelect.setFont(new Font("宋体", Font.PLAIN, 20));
					btnDeleteSelect.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent arg0) {
							TableModel tm = table.getModel();
							int id = (int) tm.getValueAt(table.getSelectedRow(), 0);
							try {
								logger.debug(acsdb.delete(id) + " row be operator");
								;
							} catch (ClassNotFoundException | SQLException e) {
								e.printStackTrace();
							}
							selectAll();
						}
					});
					buttonPane.add(btnDeleteSelect);
				}
				{
					JButton btnChangeSelect = new JButton("Change select");
					btnChangeSelect.setFont(new Font("宋体", Font.PLAIN, 20));
					btnChangeSelect.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent arg0) {
							TableModel tm = table.getModel();
							int id = (int) tm.getValueAt(table.getSelectedRow(), 0);
							String name = (String) tm.getValueAt(table.getSelectedRow(), 1);
							ChangeTerm changeDialog = new ChangeTerm(id, name);
							changeDialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
							changeDialog.setVisible(true);
						}
					});
					buttonPane.add(btnChangeSelect);
				}
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.setFont(new Font("宋体", Font.PLAIN, 20));
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}

}
