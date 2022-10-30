package crudmanager;

import ui.MainScreenEditButton;

public class ValidationOfFields extends MainScreenEditButton {

	public static boolean isRequiredFieldsValidated(String firstName, String lastName, String age, String aadharNumber) {
	
		if (firstName.equals("")) {
	
			if (lastName.equals("")) {
	
				if (age.equals("")) {
	
					if (aadharNumber.equals("")) {
						return false;
					}
	
				}
			}
			return false;
		}
	
		else if (age.equals("")) {
	
			return false;
		}
	
		else if (lastName.equals("")) {
	
			if (age.equals("")) {
	
				return false;
			}
	
			return false;
		}
	
		else if (lastName.equals("")) {
	
			if (aadharNumber.equals("")) {
	
				return false;
			}
	
			return false;
		}
	
		else {
	
			return true;
		}
	
	}

	public ValidationOfFields() {
		super();
	}

}