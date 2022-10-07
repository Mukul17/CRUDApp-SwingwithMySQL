package src.test;

import static org.junit.Assert.assertEquals;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import agemanager.AgeManager;

class AgeManagerTest {

	@Test
	void testCaseForFirstNameAndLastName() {

		boolean validateRequiredFields = AgeManager.isRequiredFieldsValidated("Mk", "asd", "");
		assertEquals(false, validateRequiredFields);
	}

	@Test
	void testCaseForLastNameAndAgeField() {

		boolean validateRequiredFields = AgeManager.isRequiredFieldsValidated("", "as", "12");

		assertEquals(false, validateRequiredFields, () -> "The Test Case should fail");

	}

	@Test
	void testCaseForAgeField() {

		boolean validateRequiredFields = AgeManager.isRequiredFieldsValidated("", "", "12");
		assertEquals(false, validateRequiredFields, () -> "The Test Case should fail");
	}

	@Test
	void testCaseForNoFields() {

		boolean validateRequiredFields = AgeManager.isRequiredFieldsValidated("", "", "");
		assertEquals(false, validateRequiredFields, () -> "The Test Case should fail");

	}

	@Test
	void testCaseForFirstNameLastNameAgeFields() {

		boolean validateRequiredFields = AgeManager.isRequiredFieldsValidated("Mk", "as", "12");
		assertEquals(true, validateRequiredFields);

	}

}
