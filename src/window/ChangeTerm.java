package window;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import code.AccessDatabase;

import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class ChangeTerm extends JDialog {
	static Logger logger=LoggerFactory.getLogger(ChangeTerm.class);
	private final JPanel contentPanel = new JPanel();
	private JTextField IDtext;
	private JTextField Nametext;
	private AccessDatabase acsdb;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			ChangeTerm dialog = new ChangeTerm(-1,null);
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public ChangeTerm(int id,String Name) {
		setBounds(100, 100, 307, 173);
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
				IDtext.setText(id+"");
				Nametext.setText(Name);
				JButton okButton = new JButton("OK");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						try {
							logger.debug(acsdb.change(id, Nametext.getText())+" row be operator");
						} catch (ClassNotFoundException | SQLException e) {
							// TODO Auto-generated catch block
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
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}

}
