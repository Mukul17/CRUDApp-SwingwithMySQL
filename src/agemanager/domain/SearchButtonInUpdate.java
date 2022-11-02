package crudmanager;

import java.awt.GraphicsConfiguration;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JOptionPane;

public class SearchButtonInUpdate extends SaveButtonInUpdate {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	protected static String aadharNumString;
	protected static JButton backToMainMenu;

	protected static void searchButton(JButton button) throws SQLException {

		button.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				aadharNumString = aadharNumberTextField.getText();
				System.out.println(aadharNumString);

				if (aadharNumString.equals("")) {
					JOptionPane.showMessageDialog(null, "Please Enter Aadhar Number");
				}

				else {
					CreateQueryForUpdateFrame createQueryForUpdateFrame = new CreateQueryForUpdateFrame();
					boolean isAdharNumberCorrect = createQueryForUpdateFrame.createQuery(aadharNumString);

					if (isAdharNumberCorrect == true) {
						backToMainMenu.setVisible(false);
						aadharNumberTextField.setVisible(false);
						aadharNumberLabel.setVisible(false);
						aadharNumberSearchButton.setVisible(false);

						cancelButton.setVisible(true);

						saveButton.setEnabled(false);
						firstNameTextField.setVisible(true);
						lastNameTextField.setVisible(true);
						ageTextField.setVisible(true);
						firstNameLabel.setVisible(true);
						lastNameLabel.setVisible(true);
						ageLabel.setVisible(true);

						aadharNumberTextField.setText("");
					}

					else {
						JOptionPane.showMessageDialog(null, "Aadhar Number did not Match our Records");
					}

				}

			}

		});
	}

	public SearchButtonInUpdate() throws HeadlessException {
		super();
	}

	public SearchButtonInUpdate(GraphicsConfiguration gc) {
		super(gc);
	}

	public SearchButtonInUpdate(String title) throws HeadlessException {
		super(title);
	}

	public SearchButtonInUpdate(String title, GraphicsConfiguration gc) {
		super(title, gc);
	}

}