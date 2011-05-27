package com.valtech.refactoring.introduceNullObject;


public class DogHandler {
	public String handle(Dog dog) {
		if (dog != null) {
			return dog.speak();
		} else {
			return "";
		}
	}
}
