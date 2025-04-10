package pl.wit.lab3;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Map;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.core.LoggerContext;
import org.apache.logging.log4j.core.config.Configuration;
import org.apache.logging.log4j.core.config.LoggerConfig;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;




class StudentDemoTest {
	StudentDemo example;
	@BeforeEach
	void setUp() {
		 example = new StudentDemo("Mateusz", "Wisniewski");
	}
	
	@BeforeAll
	 public static void setUpBeforeClass() throws Exception {
	 LoggerContext ctx = (LoggerContext) LogManager.getContext(false);
	 Configuration config = ctx.getConfiguration();
	 LoggerConfig loggerConfig = 
	config.getLoggerConfig(LogManager.ROOT_LOGGER_NAME); 
	loggerConfig.setLevel(Level.TRACE);
	 ctx.updateLoggers();
	 }
	
	
	
	@Test
	void addPointsTest() throws PersonException 
	{
		example.addPoints("egzamin", (byte) 90);
		example.addPoints("projekt", (byte) 85);
		example.addPoints("aktywnosc", (byte) 70);

        Map<String, Byte> points = example.getMapPoints();
        assertEquals(3, points.size());
        assertTrue(points.containsKey("egzamin"));
        assertTrue(points.containsKey("projekt"));
        assertTrue(points.containsKey("aktywnosc"));

        assertEquals(Byte.valueOf((byte) 90), points.get("egzamin"));
        assertEquals(Byte.valueOf((byte) 85), points.get("projekt"));
        assertEquals(Byte.valueOf((byte) 70), points.get("aktywnosc"));	
        
       
	}
	  @Test
	    public void testAddPointsInvalidPoints() {
	        try {
	        	example.addPoints("egzamin", (byte) -5);
	            fail("Oczekiwano PersonException dla ujemnej liczby punktów");
	        } catch (PersonException e) {
	            assertEquals("Błędne dane o punktach", e.getMessage());
	        }
	    }

	    @Test
	    public void testAddPointsInvalidKey() {
	        try {
	        	example.addPoints("", (byte) 75);
	            fail("Oczekiwano PersonException dla pustej nazwy kryterium");
	        } catch (PersonException e) {
	            assertEquals("Błędne dane o punktach", e.getMessage());
	        }

	        try {
	        	example.addPoints(null, (byte) 75);
	            fail("Oczekiwano PersonException dla null jako nazwy kryterium");
	        } catch (PersonException e) {
	            assertEquals("Błędne dane o punktach", e.getMessage());
	        }
	    }

	    @Test
	    public void testPersonTypeIsStudent() {
	        EnPersonType type = example.getPersonType();
	        assertEquals(EnPersonType.student, type);
	        assertEquals("student", type.getPlName());
	        
	      
	    }
	    
	    
	    
	

}
