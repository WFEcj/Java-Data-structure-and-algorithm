package Transact;

public class Bank {
	public void profession(Person p) {
		System.out.println(p.getName()+"进入银行");
		p.CallNumber();
		p.transact();
		p.leave();
	}
}
