package ui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import crudmanager.HomeScreen;
import crudmanager.ReadButtonFrame;
import crudmanager.ValidationOfFields;

public class MainScreenReadButton extends MainScreenUpdateButton {
	
	static ValidationOfFields ageManager =  new HomeScreen(); 

	public static void readButtonClicked() {
	
		HomeScreen.readButton.addActionListener(new ActionListener() {
	
			@Override
			public void actionPerformed(ActionEvent e) {
	
				System.out.println("Inside MainScreenReadButton");
				ReadButtonFrame.main(null);
			}

		});
	}

	public MainScreenReadButton() {
		super();
	}

}