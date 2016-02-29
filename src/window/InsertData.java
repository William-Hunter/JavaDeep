package window;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import code.*;
import javax.swing.*;
import java.sql.*;
import java.util.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class InsertData extends JDialog {
	static Logger logger=LoggerFactory.getLogger(InsertData.class);
	private final JPanel contentPanel = new JPanel();
	private JTextField IDtext;
	private JTextField Nametext;
	private AccessDatabase acsdb;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			InsertData dialog = new InsertData();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public InsertData() {
		setBounds(100, 100, 247, 176);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setLayout(new FlowLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		{
			JLabel lblId = new JLabel("ID");
			contentPanel.add(lblId);
		}
		{
			IDtext = new JTextField();
			contentPanel.add(IDtext);
			IDtext.setColumns(20);
		}
		{
			JLabel lblName = new JLabel("Name");
			contentPanel.add(lblName);
		}
		{
			Nametext = new JTextField();
			contentPanel.add(Nametext);
			Nametext.setColumns(20);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						try {
							logger.debug(acsdb.insert(Integer.parseInt(IDtext.getText()), Nametext.getText())+" row be operator");
						} catch (ClassNotFoundException | SQLException e) {
							e.printStackTrace();
						}
					}
				});
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						
					}
				});
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}

}
