package Transact;

public class OldMan extends Person{
	public OldMan() {}
	public OldMan(String name) {
		this.name=name;
	}
	public void CallNumber() {
		// TODO Auto-generated method stub
		System.out.println(this.getName()+"½ÐºÅ");
	}
	public void transact() {
		// TODO Auto-generated method stub
		System.out.println(this.getName()+"È¡Ç®");
	}
	public void leave() {
		// TODO Auto-generated method stub
		System.out.println(this.getName()+"Àë¿ª");
	}
}
