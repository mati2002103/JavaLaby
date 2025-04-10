package pl.wit.lab3;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
/**
 * Klasa abstrakcyjna demonstracyjna
 * @author Łukasz
 *
 */
public abstract class AbstractDemo implements IDemoLogger{
	protected static final Logger log = LogManager.getLogger(AbstractDemo.class.getName());
	//imię
	private String firstName=null;
	//nazwisko
	private String lastName=null;
	/**
	 * Typ osoby
	 * @return
	 */
	protected abstract EnPersonType getPersonType();
	
	public AbstractDemo(String firstName, String lastName) {
		this.firstName=firstName;
		this.lastName=lastName;
	}
	public String getFullName() {
		return this.firstName.concat(" ").concat(lastName);
	}
	
	public void printData() {
		EnPersonType personType = getPersonType();
		
		log.info((firstName!=null?firstName:"")
				.concat(" ")
				.concat(lastName!=null?lastName:"")
				.concat(" - ")
				.concat(personType!=null?personType.getPlName():""));
	}
	public String getAdditionalInfo() {
		return getPersonType().getPlName().concat(" ").concat(getFullName());
	}
	
}
