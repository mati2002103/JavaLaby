package pl.wit.lab3.p1;

import static org.junit.jupiter.api.Assertions.*;

import java.math.BigDecimal;
import java.util.Date;
import java.util.Set;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class Secretary1Test {

	private Secretary1 secretary;

	@BeforeEach
	void setUp() {
		secretary = new Secretary1("Anna", "Nowak", new Date(), new Date(), new BigDecimal("4000"));
	}
	@Test
    void testSetAndGetFirstName() {
    	secretary.setFirstName("Jan");
        assertEquals("Jan", secretary.getFirstName());
    }
    
    @Test
    void testSetAndGetLastName() {
    	secretary.setLastName("Kowalski");
        assertEquals("Kowalski", secretary.getLastName());
    }
    
    @Test
    void testSetAndGetDateOfBirth() {
        Date date = new Date();
        secretary.setDateOfBirth(date);
        assertEquals(date, secretary.getDateOfBirth());
    }
    @Test
    void testSetAndGetEmploymentDate() {
        Date date = new Date();
        secretary.setEmploymentDate(date);
        assertEquals(date, secretary.getEmploymentDate());
    }
    
    @Test
    void testSetAndGetSallary() {
        BigDecimal salary = new BigDecimal("5000");
        secretary.setSallary(salary);
        assertEquals(salary, secretary.getSallary());
    }

	@Test
	void testAddAndRetrieveLanguages() {
		secretary.addLanguage("English");
		assertTrue(secretary.getLanguages().contains("English"));
	}

	@Test
	void testAddMultipleLanguages() {
		secretary.addLanguage("English");
		secretary.addLanguage("French");
		secretary.addLanguage("German");
		Set<String> languages = secretary.getLanguages();
		assertEquals(3, languages.size());
		assertTrue(languages.contains("English"));
		assertTrue(languages.contains("French"));
		assertTrue(languages.contains("German"));
	}

	@Test
	void testAddDuplicateLanguage() {
		secretary.addLanguage("English");
		secretary.addLanguage("English");
		Set<String> languages = secretary.getLanguages();
		assertEquals(1, languages.size());
	}

	@Test
	void testRetrieveEmptyLanguages() {
		assertTrue(secretary.getLanguages().isEmpty());
	}

}
