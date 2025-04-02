package pl.wit.lab3.p1;

import static org.junit.jupiter.api.Assertions.*;

import java.math.BigDecimal;
import java.util.Date;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class Secretary1Test {

	 private Secretary1 secretary;
	    
	    @BeforeEach
	    void setUp() {
	        secretary = new Secretary1("Anna", "Nowak", new Date(), new Date(), new BigDecimal("4000"));
	    }
	    
	    @Test
	    void testAddAndRetrieveLanguages() {
	        secretary.addLanguage("English");
	        assertTrue(secretary.getLanguages().contains("English"));
	    }

}
