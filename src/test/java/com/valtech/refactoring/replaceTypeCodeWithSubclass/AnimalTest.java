package com.valtech.refactoring.replaceTypeCodeWithSubclass;

import junit.framework.Assert;

import org.junit.Test;

public class AnimalTest {
	@Test
	public void testDog() {
		Animal animal = new Animal(AnimalType.Dog);

		Assert.assertEquals("Woof!", animal.speak());
	}

	@Test
	public void testCat() {
		Animal animal = new Animal(AnimalType.Cat);

		Assert.assertEquals("Meeow!", animal.speak());
	}

	@Test
	public void testDuck() {
		Animal animal = new Animal(AnimalType.Duck);

		Assert.assertEquals("Quack!", animal.speak());
	}

}
