package crudmanager;

import java.awt.GraphicsConfiguration;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class CancelButtonInUpdate extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	protected static JTextField aadharNumberTextField;
	protected static JTextField firstNameTextField;
	protected static JTextField lastNameTextField;
	protected static JTextField ageTextField;
	protected static JLabel aadharNumberLabel;
	protected static JButton aadharNumberSearchButton;
	protected static JLabel firstNameLabel;
	protected static JLabel lastNameLabel;
	protected static JLabel ageLabel;
	protected static JButton cancelButton;

	protected static void cancelButon(JButton button) {
	
		button.addActionListener(new ActionListener() {
	
			@Override
			public void actionPerformed(ActionEvent arg0) {
				firstNameTextField.setVisible(false);
				firstNameLabel.setVisible(false);
				lastNameLabel.setVisible(false);
				lastNameTextField.setVisible(false);
				ageTextField.setVisible(false);
				ageLabel.setVisible(false);
				aadharNumberLabel.setVisible(true);
				aadharNumberTextField.setVisible(true);
				aadharNumberSearchButton.setVisible(true);
				button.setVisible(false);
				firstNameTextField.setText("");
				lastNameTextField.setText("");
				ageTextField.setText("");
				SearchButtonInUpdate.backToMainMenu.setVisible(true);
			}
	
		});
	}

	public CancelButtonInUpdate() throws HeadlessException {
		super();
	}

	public CancelButtonInUpdate(GraphicsConfiguration gc) {
		super(gc);
	}

	public CancelButtonInUpdate(String title) throws HeadlessException {
		super(title);
	}

	public CancelButtonInUpdate(String title, GraphicsConfiguration gc) {
		super(title, gc);
	}

}