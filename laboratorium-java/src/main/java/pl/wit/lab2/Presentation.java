package pl.wit.lab2;

import java.time.LocalDate;
import java.time.Period;
/**
 * Klasa do przechowywania danych osobowych
 * 
 * 
 * @author Mateusz Wiśniewski
 *
 */
public class Presentation {

	// imie
	private String firstName;
	// nazwisko
	private String lastName;
	// dzien i miesiac urodzenia
	private byte birthdayDay, birthdayMonth;
	// rok urodzenia
	private short birthdayYear;
	// miejsce urodzenia
	private String placeOfBirth;
	// liczba przyjacieli na fb
	private short facebookFriendsQuantity;
	// odwiedzone miejsca
	private String visitedPlaces[];

	private Presentation(String firstName, String lastName) {
		// inicjalizacja imienia i nazwiska
		this.firstName = firstName;
		this.lastName = lastName;
	}

	public Presentation(String firstName, String lastName, byte birthdayDay, byte birthdayMonth, short birthdayYear)
			throws Exception {
		// wywołanie konstruktora 2-argumentowego
		this(firstName, lastName);
		if (birthdayYear >= 1900 && 0 < birthdayMonth && birthdayMonth <= 12 && birthdayDay > 0 && birthdayDay <= 31) {
			this.birthdayYear = birthdayYear;
			this.birthdayMonth = birthdayMonth;
			this.birthdayDay = birthdayDay;
			this.visitedPlaces = new String[0];

		} else {
			throw new Exception("Błędne składowe daty");
		}

		// dalsza inicjalizacja

	}

	public String getFullName() {
		// Zwrócenie połączonej wartości imienia i nazwiska ze spacją pomiędzy
		StringBuilder sb = new StringBuilder();
		sb.append(this.firstName).append(" ").append(this.lastName);

		return sb.toString();
	}

	public String getBirthdayDateAsString() {
		// Ręczne zbudowanie Daty w formacie dd.MM.yyyy
		 return String.format("%02d.%02d.%d", birthdayDay, birthdayMonth, birthdayYear);
	}

	public byte getAge() {
	    LocalDate now = LocalDate.now();
	    LocalDate birthday = LocalDate.of(this.birthdayYear, this.birthdayMonth, this.birthdayDay);
	    int period = Period.between(birthday, now).getYears();
	    //Obliczanie aktualnego wieku
	    return (byte) period;
	}

	public void addVisitedPlace(String place) {
		
		String[] swapArray = new String[this.visitedPlaces.length+1];
		for(int i =0;i<visitedPlaces.length;++i) {
			swapArray[i] = visitedPlaces[i];
		}
		swapArray[visitedPlaces.length]= place;
		this.visitedPlaces=swapArray;
		
	}

	public String getPresentationStory() {	
		
		StringBuilder story = new StringBuilder();
        story.append("Name:  ").append(firstName).append(" ").append(lastName).append(".\n");
        story.append("Date of Birth: ").append(getBirthdayDateAsString()).append(".\n");
        if (this.facebookFriendsQuantity > 4000) {
            story.append("FB: ").append(this.facebookFriendsQuantity).append(" Posiadam dużą liczbę znajomych na FB.\n");
        } else if (this.facebookFriendsQuantity > 1000) {
            story.append("FB: ").append(this.facebookFriendsQuantity).append(" Posiadam średnią liczbę znajomych na FB.\n");
        } else {
            story.append("Mam niewielu znajomych na FB.\n");
        }
        story.append("Odwiedzilem:\n");
        for(int i=0;i<this.visitedPlaces.length;++i) {
        	story.append(i+1).append(". ").append(visitedPlaces[i]).append("\n");
        }
        return story.toString();
        
        
        
	        
		
		
		
	}
	////////////////////////////////////////////
	// gettery i settery
	////////////////////////////////////////////

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public byte getBirthdayDay() {
		return birthdayDay;
	}

	public void setBirthdayDay(byte birthdayDay) {
		this.birthdayDay = birthdayDay;
	}

	public byte getBirthdayMonth() {
		return birthdayMonth;
	}

	public void setBirthdayMonth(byte birthdayMonth) {
		this.birthdayMonth = birthdayMonth;
	}

	public short getBirthdayYear() {
		return birthdayYear;
	}

	public void setBirthdayYear(short birthdayYear) {
		this.birthdayYear = birthdayYear;
	}

	public String getPlaceOfBirth() {
		return placeOfBirth;
	}

	public void setPlaceOfBirth(String placeOfBirth) {
		this.placeOfBirth = placeOfBirth;
	}

	public short getFacebookFriendsQuantity() {
		return facebookFriendsQuantity;
	}

	public void setFacebookFriendsQuantity(short facebookFriendsQuantity) {
		this.facebookFriendsQuantity = facebookFriendsQuantity;
	}

	public String[] getVisitedPlaces() {
		return visitedPlaces;
	}

	public void setVisitedPlaces(String[] visitedPlaces) {
		this.visitedPlaces = visitedPlaces;
	}

}
