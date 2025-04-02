package pl.wit.lab3.p1;

import static org.junit.jupiter.api.Assertions.*;

import java.math.BigDecimal;
import java.util.Date;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class Employee1Test {

private Employee1 employee;
    
    @BeforeEach
    void setUp() {
        employee = new Employee1();
    }
    @Test
    void testSetAndGetFirstName() {
    	employee.setFirstName("Jan");
        assertEquals("Jan", employee.getFirstName());
    }
    
    @Test
    void testSetAndGetLastName() {
    	employee.setLastName("Kowalski");
        assertEquals("Kowalski", employee.getLastName());
    }
    @Test
    void testNullDefaultSetVariables() {
        
        assertEquals(null, employee.getFirstName());
        assertEquals(null, employee.getLastName());
        assertEquals(null, employee.getDateOfBirth());
        assertEquals(null, employee.getEmploymentDate());
        assertEquals(null, employee.getSallary());
    }
    @Test
    void testSetAndGetDateOfBirth() {
        Date date = new Date();
        employee.setDateOfBirth(date);
        assertEquals(date, employee.getDateOfBirth());
    }
    @Test
    void testSetAndGetEmploymentDate() {
        Date date = new Date();
        employee.setEmploymentDate(date);
        assertEquals(date, employee.getEmploymentDate());
    }
    
    @Test
    void testSetAndGetSallary() {
        BigDecimal salary = new BigDecimal("5000");
        employee.setSallary(salary);
        assertEquals(salary, employee.getSallary());
    }
  

}
