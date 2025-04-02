package pl.wit.lab2;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;
import java.time.Period;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;



class PresentationTest {

	private Presentation presentation;
	protected static final Logger log = LogManager.getLogger(PresentationTest.class.getName());


    @BeforeEach
    void setUp() throws Exception {
        presentation = new Presentation("Jan", "Kowalski", (byte) 15, (byte) 6, (short) 1990);
    }

    @Test
    void testGetFullName() {
        assertEquals("Jan Kowalski", presentation.getFullName());
    }

    @Test
    void testGetBirthdayDateAsString() {
        assertEquals("15.06.1990", presentation.getBirthdayDateAsString());
    }

    @Test
    void testGetAge() {
        int expectedAge = Period.between(LocalDate.of(1990, 6, 15), LocalDate.now()).getYears();
        assertEquals(expectedAge, presentation.getAge());
    }

    @Test
    void testAddVisitedPlace() {
        presentation.addVisitedPlace("Warszawa");
        assertArrayEquals(new String[]{"Warszawa"}, presentation.getVisitedPlaces());
        presentation.addVisitedPlace("Monaco");
        presentation.addVisitedPlace("New York");
        assertArrayEquals(new String[]{"Warszawa","Monaco","New York"}, presentation.getVisitedPlaces());
    }

    @Test
    void testGetPresentationStory() {
        presentation.setFacebookFriendsQuantity((short) 5000);
        presentation.addVisitedPlace("Berlin");
        presentation.addVisitedPlace("Londyn");
        String story = presentation.getPresentationStory();
        log.info(story);
        assertTrue(story.contains("Jan Kowalski"));
        assertTrue(story.contains("15.06.1990"));
        assertTrue(story.contains("Posiadam dużą liczbę znajomych na FB"));
        assertTrue(story.contains("Berlin"));
        assertTrue(story.contains("Londyn"));
        
    }
    @Test
    void testFacebookFriendsLow() {
        presentation.setFacebookFriendsQuantity((short) 500);
        assertTrue(presentation.getPresentationStory().contains("Mam niewielu znajomych na FB"));
    }

    @Test
    void testFacebookFriendsMedium() {
        presentation.setFacebookFriendsQuantity((short) 2000);
        assertTrue(presentation.getPresentationStory().contains("Posiadam średnią liczbę znajomych na FB"));
    }

    @Test
    void testFacebookFriendsHigh() {
        presentation.setFacebookFriendsQuantity((short) 4500);
        assertTrue(presentation.getPresentationStory().contains("Posiadam dużą liczbę znajomych na FB"));
    }
}
