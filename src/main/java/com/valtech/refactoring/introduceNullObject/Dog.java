package com.valtech.refactoring.introduceNullObject;


public class Dog {
	public String speak() {
		return "Woof!";
	}
	
	public static Dog create(boolean dogPresent) {
		if (dogPresent) {
			return new Dog();
		} else {
			return null;
		}
	}
}
