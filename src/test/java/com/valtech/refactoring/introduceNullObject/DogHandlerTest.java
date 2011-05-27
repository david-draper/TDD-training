package com.valtech.refactoring.introduceNullObject;


import junit.framework.Assert;

import org.junit.Test;


public class DogHandlerTest {

	@Test
	public void dogPresent() {
		Dog dog = Dog.create(true);
		DogHandler handler = new DogHandler();
		
		Assert.assertEquals("Woof!", handler.handle(dog));
	}
	
	@Test
	public void noDog() {
		Dog dog = Dog.create(false);
		DogHandler handler = new DogHandler();
		
		Assert.assertEquals("", handler.handle(dog));
	}

}
