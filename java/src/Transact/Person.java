package Transact;

public abstract class Person {
	protected String name;
	public String getName() {
		return this.name;
	}
	public abstract void CallNumber();
	public abstract void transact();
	public abstract void leave();
	
}
