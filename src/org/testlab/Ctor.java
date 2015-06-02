package org.testlab;

class CtorA {
	public CtorA() {
		System.out.println("In CtorA");
	}	
}

class CtorB extends CtorA {
	public CtorB() {
		System.out.println("In CtorB");
	}
}

class CtorC extends CtorA {
	public CtorC(String param) {
		System.out.println("In CtorC");
	}
	@SuppressWarnings("all")
	public void CtorC() 
	{
		System.out.println("In void CtorC");
	}
}

class CtorD extends CtorA {
	public CtorD(int dummy) {
		super();
		System.out.println("In CtorD");
		return;
	}
}

public class Ctor {

	public static void main(String[] args) {
		// Below cause unreachable code compile error
		/*
		for (;;) 
		{			
		}
		*/
		new CtorB();
		System.out.println("-----");
		CtorC c = new CtorC("dummy");
		System.out.println("-----");
		c.CtorC();
		System.out.println("-----");
		new CtorD(0);
		System.out.println("-----");
	}

}
