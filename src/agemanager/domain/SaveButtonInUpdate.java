package agemanager.domain;

import java.awt.GraphicsConfiguration;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JOptionPane;

public class SaveButtonInUpdate extends CancelButtonInUpdate {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	protected static JButton saveButton;
	static IQueryHandler handler = new UpdateQueryHandlerImpl();

	protected static void saveButon(JButton jButton) throws SQLException {
	
		jButton.addActionListener(new ActionListener() {
	
			@Override
			public void actionPerformed(ActionEvent arg0) {
	
				System.out.println(firstNameTextField.getText());
				System.out.println(lastNameTextField.getText());
				System.out.println(ageTextField.getText());
				System.out.println (SearchButtonInUpdate.aadharNumString);
				String queryString = String.format(
	
						"UPDATE PEOPLE SET first_name ='%s', last_name ='%s', age ='%s' WHERE adhar_num ='%s' ",
						firstNameTextField.getText(), lastNameTextField.getText(), ageTextField.getText(),
					SearchButtonInUpdate.aadharNumString);
				try {
					handler.updateQueriesHandler(queryString);
				} catch (SQLException e) {
					e.printStackTrace();
					JOptionPane.showMessageDialog(null, e.getMessage());
				}
			}
	
		});
	
	}

	public SaveButtonInUpdate() throws HeadlessException {
		super();
	}

	public SaveButtonInUpdate(GraphicsConfiguration gc) {
		super(gc);
	}

	public SaveButtonInUpdate(String title) throws HeadlessException {
		super(title);
	}

	public SaveButtonInUpdate(String title, GraphicsConfiguration gc) {
		super(title, gc);
	}

}