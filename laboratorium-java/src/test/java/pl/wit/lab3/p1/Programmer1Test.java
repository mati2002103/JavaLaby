package pl.wit.lab3.p1;

import static org.junit.jupiter.api.Assertions.*;

import java.math.BigDecimal;
import java.util.Date;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class Programmer1Test {

private Programmer1 programmer;
    
    @BeforeEach
    void setUp() {
        programmer = new Programmer1("Piotr", "Zalewski", new Date(), new Date(), new BigDecimal("7000"));
    }
    @Test
    void testSetAndGetFirstName() {
    	programmer.setFirstName("Jan");
        assertEquals("Jan", programmer.getFirstName());
    }
    
    @Test
    void testSetAndGetLastName() {
    	programmer.setLastName("Kowalski");
        assertEquals("Kowalski", programmer.getLastName());
    }
    @Test
    void testNullDefaultSetVariables() {
        
        assertEquals(null, programmer.getFirstName());
        assertEquals(null, programmer.getLastName());
        assertEquals(null, programmer.getDateOfBirth());
        assertEquals(null, programmer.getEmploymentDate());
        assertEquals(null, programmer.getSallary());
    }
    @Test
    void testSetAndGetDateOfBirth() {
        Date date = new Date();
        programmer.setDateOfBirth(date);
        assertEquals(date, programmer.getDateOfBirth());
    }
    @Test
    void testSetAndGetEmploymentDate() {
        Date date = new Date();
        programmer.setEmploymentDate(date);
        assertEquals(date, programmer.getEmploymentDate());
    }
    
    @Test
    void testSetAndGetSallary() {
        BigDecimal salary = new BigDecimal("5000");
        programmer.setSallary(salary);
        assertEquals(salary, programmer.getSallary());
    }
  
    @Test
    void testAddAndCheckProgrammingLanguages() {
        programmer.addProgrammingLanguage("Java", (short)5);
        assertTrue(programmer.getProgrammingLanguageInfo("Java").contains("5"));
    }
    @Test
    void testAddMultipleAndCheckProgrammingLanguages() {
        programmer.addProgrammingLanguage("Java", (short)5);
        programmer.addProgrammingLanguage("C++", (short)4);
        programmer.addProgrammingLanguage("Python", (short)2);
        programmer.addProgrammingLanguage("C#", (short)5);
        assertEquals("Java 5", programmer.getProgrammingLanguageInfo("Java"));
        assertEquals("C++ 4", programmer.getProgrammingLanguageInfo("C++"));
        assertEquals("Python 2", programmer.getProgrammingLanguageInfo("Python"));
        assertEquals("C# 5", programmer.getProgrammingLanguageInfo("C#"));
    }
    
    @Test
    void testRetrieveUnknownProgrammingLanguage() {
        assertNotNull(programmer.getProgrammingLanguageInfo("Python"));
    }
    
    @Test
    void testCheckNullProgrammingLanguage() {
        assertThrows(NullPointerException.class, () -> programmer.getProgrammingLanguageInfo(null));
    }


}
