package com.sample.methodrefs;

import java.util.function.Consumer;

public class ExistingObjectMR {
	public static void main(String[] args) {
		Mechanic mechanic = new Mechanic();
		Car car = new Car();
		//Using Inner Class
		new ExistingObjectMR().execute(car, new Consumer<Car>() {
			@Override
			public void accept(Car t) {
				mechanic.fix(car);
			}
		});
		
		//Using Lambdas
		new ExistingObjectMR().execute(car, c -> mechanic.fix(c));
		
		//Using Method Ref
		new ExistingObjectMR().execute(car, mechanic::fix);
	}
	
	public void execute(Car car, Consumer<Car> c) {
		c.accept(car);
	}
}

class Car {
	  private int id;
	  public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	private String color;
	  // More properties
	  // And getter and setters
}

class Mechanic {
  public void fix(Car c) {
    System.out.println("Fixing car " + c.getId());
  }
}

