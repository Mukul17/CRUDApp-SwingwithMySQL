package crudmanager;

import java.awt.GraphicsConfiguration;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;

public class GoBackToMainMenuFromUpdate extends JFrame  {


	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public GoBackToMainMenuFromUpdate() throws HeadlessException {
		super();
	}

	public GoBackToMainMenuFromUpdate(GraphicsConfiguration gc) {
		super(gc);
	}

	public GoBackToMainMenuFromUpdate(String title) throws HeadlessException {
		super(title);
	}

	public GoBackToMainMenuFromUpdate(String title, GraphicsConfiguration gc) {
		super(title, gc);
	}
	
	 void backToMenuButton(JButton button) throws SQLException {
		CancelButtonInUpdate frame = new UpdateFrame();
		
		button.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				HomeScreen.main(null);
				frame.dispose();
			}

		});

	}

}