package Transact;

public class OldMan extends Person{
	public OldMan() {}
	public OldMan(String name) {
		this.name=name;
	}
	public void CallNumber() {
		// TODO Auto-generated method stub
		System.out.println(this.getName()+"�к�");
	}
	public void transact() {
		// TODO Auto-generated method stub
		System.out.println(this.getName()+"ȡǮ");
	}
	public void leave() {
		// TODO Auto-generated method stub
		System.out.println(this.getName()+"�뿪");
	}
}
