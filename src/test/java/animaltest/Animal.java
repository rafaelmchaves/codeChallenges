package animaltest;

import java.util.concurrent.atomic.AtomicInteger;

public class Animal {

	String animal = "animal";

	public String bark() {
		return "walks";
	}

	public static void main(String[] args) {
		Animal an = new Dog();
		System.out.println(an.animal + " " + an.bark());
	}
}

class Dog extends Animal {

	String animal = "dog";

	public String bark() {
		AtomicInteger x = new AtomicInteger(Integer.MAX_VALUE);

		int y = 0;

		
		return "bark";
	}
}


