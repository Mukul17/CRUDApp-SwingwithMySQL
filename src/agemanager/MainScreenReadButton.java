package agemanager;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainScreenReadButton extends MainScreenUpdateButton {
	
	static ValidationOfFields ageManager =  new AgeManager(); 

	public static void readButtonClicked() {
	
		AgeManager.readButton.addActionListener(new ActionListener() {
	
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