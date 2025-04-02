package pl.wit.lab3.p1;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Date;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class Person1Test {

	 private Person1 person;
	    
	    @BeforeEach
	    void setUp() {
	        person = new Person1();
	    }
	    @Test
	    void testNullDefaultSetVariables() {
	        
	        assertEquals(null, person.getFirstName());
	        assertEquals(null, person.getLastName());
	        assertEquals(null, person.getDateOfBirth());
	    }
	    
	    @Test
	    void testSetAndGetFirstName() {
	        person.setFirstName("Jan");
	        assertEquals("Jan", person.getFirstName());
	    }
	    
	    @Test
	    void testSetAndGetLastName() {
	        person.setLastName("Kowalski");
	        assertEquals("Kowalski", person.getLastName());
	    }
	    
	    @Test
	    void testSetAndGetDateOfBirth() {
	        Date date = new Date();
	        person.setDateOfBirth(date);
	        assertEquals(date, person.getDateOfBirth());
	    }

}
