package pl.wit.lab3;

public class PersonException extends Exception {
	public PersonException(String msg) {
		super(msg);
	}
	public PersonException(String msg, Exception ex) {
		super(msg,ex);
	}
}
