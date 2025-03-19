package pl.wit.jj.lab2;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class Lab2ArraysExampleTest {

	@Test
	public void addElementTest() {
		Lab2ArraysExample arrEx = new Lab2ArraysExample(1);
		Assertions.assertArrayEquals(new int[] { 1 }, arrEx.getIntNumbers());
		arrEx.addElement(true);
		Assertions.assertEquals(Arrays.toString(new boolean[] { true }), Arrays.toString(arrEx.getBoolElements()));
		arrEx.addElement("Test");
		Assertions.assertArrayEquals(new String[] { "Test" }, arrEx.getStringElements());
	}

	@Test
	public void getArraySizeTest() {
		Lab2ArraysExample arrEx = new Lab2ArraysExample(1);
		arrEx.addElement(2);
		arrEx.addElement(3);
		arrEx.addElement(4);
		assertEquals(4, arrEx.getIntArraySize());
		
		Lab2ArraysExample arrEx2 = new Lab2ArraysExample("Test");
		arrEx2.addElement("Test1");
		arrEx2.addElement("Test2");
		arrEx2.addElement("Test3");
		assertEquals(4, arrEx2.getStringArraySize());
		
		Lab2ArraysExample arrEx3 = new Lab2ArraysExample(false);
		arrEx3.addElement(true);
		arrEx3.addElement(true);
		arrEx3.addElement(false);
		assertEquals(4, arrEx3.getBooleanArraySize());

	}

	@Test
	public void getArrayElementTest() {
		Lab2ArraysExample arrEx = new Lab2ArraysExample(1);
		arrEx.addElement(2);
		arrEx.addElement(3);
		arrEx.addElement(4);
		assertEquals(3, arrEx.getIntArrayElement(2));
		
		Lab2ArraysExample arrEx2 = new Lab2ArraysExample("Test");
		arrEx2.addElement("Test1");
		arrEx2.addElement("Test2");
		arrEx2.addElement("Test3");
		assertEquals("Test2", arrEx2.getStringArrayElement(2));
		
		Lab2ArraysExample arrEx3 = new Lab2ArraysExample(false);
		arrEx3.addElement(true);
		arrEx3.addElement(true);
		arrEx3.addElement(false);
		assertEquals(true, arrEx3.getBooleanArrayElement(2));
		
		
	}

}
