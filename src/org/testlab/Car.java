package org.testlab;

abstract class Engine {

	private final String _type;

	public Engine(final String type) {
		_type = type;
	}

	public String type() {
		return _type;
	}
}

public class Car {

	private final Engine _engine;

	public Car(final Engine engine) {
		_engine = engine;
	}

	public void start() {
		System.out.println("Start " + _engine.type());
	}

	public static void main(final String[] args) {
		new Car(new Engine("PowerEngine") {
		}).start();

	}

}
