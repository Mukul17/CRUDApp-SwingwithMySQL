package src.test;



import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import startingpoint.HomeScreen;

class AgeManagerTest {

	@Test
	void testCaseForFirstNameAndLastName() {

		boolean validateRequiredFields = HomeScreen.isRequiredFieldsValidated("Mk", "asd", "", null);
		assertEquals(false, validateRequiredFields);
	}

	@Test
	void testCaseForLastNameAndAgeField() {

		boolean validateRequiredFields = HomeScreen.isRequiredFieldsValidated("", "as", "12", null);

		assertEquals(false, validateRequiredFields, () -> "The Test Case should fail");

	}

	@Test
	void testCaseForAgeField() {

		boolean validateRequiredFields = HomeScreen.isRequiredFieldsValidated("", "", "12", null);
		assertEquals(false, validateRequiredFields, () -> "The Test Case should fail");
	}

	@Test
	void testCaseForNoFields() {

		boolean validateRequiredFields = HomeScreen.isRequiredFieldsValidated("", "", "", null);
		assertEquals(false, validateRequiredFields, () -> "The Test Case should fail");

	}

	@Test
	void testCaseForFirstNameLastNameAgeFields() {

		boolean validateRequiredFields = HomeScreen.isRequiredFieldsValidated("Mk", "as", "12", null);
		assertEquals(true, validateRequiredFields);

	}

}
