package agemanager;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainScreenReadButton extends MainScreenUpdateButton {
	
	static ValidationOfFields ageManager =  new HomeScreen(); 

	public static void readButtonClicked() {
	
		HomeScreen.readButton.addActionListener(new ActionListener() {
	
			@Override
			public void actionPerformed(ActionEvent e) {
	
				System.out.println("Inside MainScreenReadButton");
				ReadButtonJFrame.main(null);
	
			}
	
		});
	}

	public MainScreenReadButton() {
		super();
	}

}