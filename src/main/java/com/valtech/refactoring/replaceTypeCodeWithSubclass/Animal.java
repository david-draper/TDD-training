package com.valtech.refactoring.replaceTypeCodeWithSubclass;

public class Animal {
	private AnimalType _animalType;

	public Animal(AnimalType animalType) {
		_animalType = animalType;
	}

	public String speak() {
		switch (_animalType) {
		case Dog:
			return "Woof!";

		case Cat:
			return "Meeow!";

		case Duck:
			return "Quack!";

		default:
			return "Der";
		}
	}
}
