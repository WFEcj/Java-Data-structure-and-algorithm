package Transact;

public class Test {
	public static void main(String[] args) {
		Bank b=new Bank();
		Person p=new OldMan("老人");
		b.profession(p);
		Person p1=new YoungMan("年轻人");
		b.profession(p1);
		Person p2=new YoungMan("土豪");
		b.profession(p2);
	}
}
