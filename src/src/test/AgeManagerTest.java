package src.test;



import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import agemanager.AgeManager;

class AgeManagerTest {

	@Test
	void testCaseForFirstNameAndLastName() {

		boolean validateRequiredFields = AgeManager.isRequiredFieldsValidated("Mk", "asd", "", null);
		assertEquals(false, validateRequiredFields);
	}

	@Test
	void testCaseForLastNameAndAgeField() {

		boolean validateRequiredFields = AgeManager.isRequiredFieldsValidated("", "as", "12", null);

		assertEquals(false, validateRequiredFields, () -> "The Test Case should fail");

	}

	@Test
	void testCaseForAgeField() {

		boolean validateRequiredFields = AgeManager.isRequiredFieldsValidated("", "", "12", null);
		assertEquals(false, validateRequiredFields, () -> "The Test Case should fail");
	}

	@Test
	void testCaseForNoFields() {

		boolean validateRequiredFields = AgeManager.isRequiredFieldsValidated("", "", "", null);
		assertEquals(false, validateRequiredFields, () -> "The Test Case should fail");

	}

	@Test
	void testCaseForFirstNameLastNameAgeFields() {

		boolean validateRequiredFields = AgeManager.isRequiredFieldsValidated("Mk", "as", "12", null);
		assertEquals(true, validateRequiredFields);

	}

}
