package pl.wit.lab2;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class Lab2SetAndMapExampleTest {

	private Lab2SetAndMapExample example;

	@BeforeEach
	void setUp() {
		example = new Lab2SetAndMapExample();
	}

	@Test
	void testAddElementToSet() {
		example.addElement("Toyota");
		assertTrue(example.isSetContains("Toyota"));
	}

	@Test
	void testAddMultipleElementsToSet() {
		example.addElement("BMW");
		example.addElement("Audi");
		assertTrue(example.isSetContains("BMW"));
		assertTrue(example.isSetContains("Audi"));
	}

	@Test
	void testSetDoesNotContainElement() {
		assertFalse(example.isSetContains("Mercedes"));
	}

	@Test
	void testAddElementToMap() {
		example.addElement("Ford", 150);
		assertEquals(150, example.getMapValue("Ford"));
	}

	@Test
	void testAddMultipleElementsToMap() {
		example.addElement("Honda", 200);
		example.addElement("Tesla", 300);
		assertEquals(200, example.getMapValue("Honda"));
		assertEquals(300, example.getMapValue("Tesla"));
	}

	@Test
	void testGetMapValueForNonExistentKey() {
		assertNull(example.getMapValue("Ferrari"));
	}

	@Test
	void testPrintSetToLog() {
		example.addElement("Volvo");
		example.printSetToLog();
	}

	@Test
	void testPrintMapToLog() {
		example.addElement("Porsche", 500);
		example.printMapToLog();
	}
}
