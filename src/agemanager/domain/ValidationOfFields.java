package agemanager.domain;

import agemanager.ui.MainScreenEditButton;

public class ValidationOfFields extends MainScreenEditButton {

	public static boolean isRequiredFieldsValidated(String firstName, String lastName, String age,
			String aadharNumber) {

		if (firstName.isEmpty()) {

			if (lastName.isEmpty()) {

				if (age.isEmpty()) {

					if (aadharNumber.isEmpty()) {
						return false;
					}

				}
			}
			return false;
		}

		else if (age.isEmpty()) {
			if (lastName.isEmpty()) {
				return false;
			}

			return false;
		}

		else if (lastName.isEmpty()) {

			if (age.isEmpty()) {

				return false;
			}

			return false;
		}

		else if (lastName.isEmpty()) {

			if (aadharNumber.isEmpty()) {

				return false;
			}
			if (age.isEmpty()) {
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