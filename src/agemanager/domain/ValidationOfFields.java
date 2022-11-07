package agemanager.domain;

import agemanager.ui.MainScreenEditButton;

public class ValidationOfFields extends MainScreenEditButton {

	public static boolean isRequiredFieldsValidated(String firstName, String lastName, String age,
			String aadharNumber) {
		boolean flag = false;

		if (firstName.isEmpty()) {

			flag = false;
			return flag;
		}

		else if (lastName.isEmpty()) {

			flag = false;
			return flag;
		}

		else if (age.isEmpty()) {

			flag = false;
			return flag;
		}

		else if (aadharNumber.isEmpty()) {
			flag = false;
			return flag;
		}

		else {
			flag = true;

			return flag;
		}

	}

	public ValidationOfFields() {
		super();
	}

}