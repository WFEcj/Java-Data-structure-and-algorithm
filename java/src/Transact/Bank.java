package Transact;

public class Bank {
	public void profession(Person p) {
		System.out.println(p.getName()+"��������");
		p.CallNumber();
		p.transact();
		p.leave();
	}
}
