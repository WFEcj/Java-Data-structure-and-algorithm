package Transact;

public class Test {
	public static void main(String[] args) {
		Bank b=new Bank();
		Person p=new OldMan("����");
		b.profession(p);
		Person p1=new YoungMan("������");
		b.profession(p1);
		Person p2=new YoungMan("����");
		b.profession(p2);
	}
}
