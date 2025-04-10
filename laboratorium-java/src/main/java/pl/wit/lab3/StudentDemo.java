package pl.wit.lab3;

import java.util.LinkedHashMap;

import java.util.Map;

import org.apache.logging.log4j.LogManager;

import org.apache.logging.log4j.Logger;

/**
 * 
 * Klasa pochodna - Student
 * 
 * @author Łukasz
 *
 * 
 * 
 */

public class StudentDemo extends AbstractDemo {

	protected static final Logger log =

			LogManager.getLogger(StudentDemo.class.getName());

	private Map<String, Byte> mapPoints = null;

	public StudentDemo(String firstName, String lastName) {

		super(firstName, lastName);

		this.mapPoints = new LinkedHashMap<>();

	}

	@Override

	protected EnPersonType getPersonType() {

		return EnPersonType.student;

	}

	public void addPoints(String criteria, byte points) throws PersonException {

		if (criteria == null || criteria.equals("") || points < 0) {

			throw new PersonException("Błędne dane o punktach");

		}

		else {

			this.mapPoints.put(criteria, points);

		}

	}

	public Map<String, Byte> getMapPoints() {

		return mapPoints;

	}

	public Logger getLogger() {

		return log;

	}

}
