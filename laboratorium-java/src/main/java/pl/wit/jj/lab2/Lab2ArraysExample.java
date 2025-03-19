package pl.wit.jj.lab2;

import java.util.Arrays;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Lab2ArraysExample {

	/*
	 * 
	 * @author Mateusz Wiśniewski
	 * 
	 * Klasa z przykladami metod operującymi na tablicach
	 * 
	 * 
	 */

	/**
	 * Tablica Domyślnie ustawiona na null, inicjalizowana w konstruktorze.
	 */
	private int intNumbers[] = null;
	private String stringElements[] = null;
	private boolean boolElements[] = null;

	/*
	 * Gettery i Settery
	 */
	public int[] getIntNumbers() {
		return intNumbers;
	}

	public void setIntNumbers(int[] intNumbers) {
		this.intNumbers = intNumbers;
	}

	public String[] getStringElements() {
		return stringElements;
	}

	public void setStringElements(String[] stringElements) {
		this.stringElements = stringElements;
	}

	public boolean[] getBoolElements() {
		return boolElements;
	}

	public void setBoolElements(boolean[] boolElements) {
		this.boolElements = boolElements;
	}

	/**
	 * Logger do rejestrowania informacji o działaniu klasy.
	 */
	protected static final Logger log = LogManager.getLogger(Lab2ArraysExample.class.getName());

	/**
	 * Konstruktor bezparametrowy inicjalizujący puste tablice.
	 */
	private Lab2ArraysExample() {
		// ciało konstruktora
		intNumbers = new int[0];
		stringElements = new String[0];
		boolElements = new boolean[0];

	}

	/**
	 * Konstruktor inicjalizujący tablicę int z pojedynczym elementem.
	 * 
	 * @param intValue wartość do dodania do tablicy int
	 */
	public Lab2ArraysExample(int intValue) {
		this();
		intNumbers = Arrays.copyOf(intNumbers, 1);
		intNumbers[0] = intValue;
	}

	/**
	 * Konstruktor inicjalizujący tablicę String z pojedynczym elementem.
	 * 
	 * @param stringValue wartość do dodania do tablicy String
	 */
	public Lab2ArraysExample(String stringValue) {
		this();
		stringElements = Arrays.copyOf(stringElements, 1);
		stringElements[0] = stringValue;
	}

	/**
	 * Konstruktor inicjalizujący tablicę boolean z pojedynczym elementem.
	 * 
	 * @param boolValue wartość do dodania do tablicy boolean
	 */
	public Lab2ArraysExample(boolean boolValue) {
		this();
		boolElements = Arrays.copyOf(boolElements, 1);
		boolElements[0] = boolValue;
	}

	/**
	 * Metoda wyświetlająca zawartość tablic w logu.
	 */
	public void printArraysToLog() {

		if (intNumbers != null) {
			for (int el : intNumbers)
				log.info("" + el + ", ");
		}
		if (stringElements != null) {
			for (String el : stringElements)
				log.info("" + el + ", ");
		}
		if (boolElements != null) {
			for (boolean el : boolElements)
				log.info("" + el + ", ");
		}

	}

	/**
	 * Dodaje element do tablicy int.
	 * 
	 * @param element wartość do dodania
	 */
	public void addElement(int element) {
		intNumbers = Arrays.copyOf(intNumbers, intNumbers.length + 1);
		intNumbers[intNumbers.length - 1] = element;
	}

	/**
	 * Dodaje element do tablicy String.
	 * 
	 * @param element wartość do dodania
	 */
	public void addElement(String element) {
		stringElements = Arrays.copyOf(stringElements, stringElements.length + 1);
		stringElements[stringElements.length - 1] = element;
	}

	/**
	 * Dodaje element do tablicy boolean.
	 * 
	 * @param element wartość do dodania
	 */
	public void addElement(boolean element) {
		boolElements = Arrays.copyOf(boolElements, boolElements.length + 1);
		boolElements[boolElements.length - 1] = element;
	}

	/**
	 * Zwraca rozmiar tablicy int.
	 * 
	 * @return długość tablicy lub -1, jeśli tablica nie istnieje
	 */
	public int getIntArraySize() {
		if (intNumbers != null)
			return intNumbers.length;
		else
			return -1;
	}

	/**
	 * Zwraca rozmiar tablicy String.
	 * 
	 * @return długość tablicy lub -1, jeśli tablica nie istnieje
	 */
	public int getStringArraySize() {
		if (stringElements != null)
			return stringElements.length;
		else
			return -1;
	}

	/**
	 * Zwraca rozmiar tablicy boolean.
	 * 
	 * @return długość tablicy lub -1, jeśli tablica nie istnieje
	 */
	public int getBooleanArraySize() {
		if (boolElements != null)
			return boolElements.length;
		else
			return -1;
	}

	/**
	 * Pobiera element z tablicy int.
	 * 
	 * @param index indeks elementu
	 * @return wartość elementu lub -1, jeśli indeks jest niepoprawny
	 */
	public int getIntArrayElement(int index) {
		if (intNumbers != null && index < intNumbers.length && index >= 0) {
			return intNumbers[index];
		} else {
			return -1;
		}
	}

	/**
	 * Pobiera element z tablicy String.
	 * 
	 * @param index indeks elementu
	 * @return wartość elementu lub null, jeśli indeks jest niepoprawny
	 */
	public String getStringArrayElement(int index) {
		if (stringElements != null && index < stringElements.length && index >= 0) {
			return stringElements[index];
		} else {
			return null;
		}
	}

	/**
	 * Pobiera element z tablicy boolean.
	 * 
	 * @param index indeks elementu
	 * @return wartość elementu lub false, jeśli indeks jest niepoprawny
	 */
	public boolean getBooleanArrayElement(int index) {
		if (boolElements != null && index < boolElements.length && index >= 0) {
			return boolElements[index];
		} else {
			return false;
		}
	}

}
